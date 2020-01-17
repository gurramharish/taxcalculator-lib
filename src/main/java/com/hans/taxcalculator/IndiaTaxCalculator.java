package com.hans.taxcalculator;

import com.hans.taxcalculator.utils.TaxPeriod;
import com.hans.taxcalculator.utils.TaxSlab;
import com.hans.taxcalculator.utils.TaxUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component("taxcalculator-in")
public class IndiaTaxCalculator implements TaxCalculator {

    public BigDecimal calculateTax(BigDecimal income) {
        String defaultTaxPeriod = TaxUtils.getDefaultTaxPeriod();
        return calculateTax(income, defaultTaxPeriod);
    }

    public BigDecimal calculateTax(BigDecimal income, String taxPeriod) throws TaxException {
        TaxPeriod period = TaxUtils.getTaxPeriodByCountyAndPeriod("IN", taxPeriod);
        BigDecimal tax = BigDecimal.ZERO;
        if(TaxPeriod.UNKOWN.equals(period)) {
            StringBuilder messageBuilder = new StringBuilder("Invalid period : ").append(taxPeriod);
            throw new TaxException(messageBuilder.toString());
        } else {
            List<TaxSlab> taxSlabs = period.getTaxSlabs();
            BigDecimal amount = BigDecimal.ZERO;
            for(TaxSlab taxSlab : taxSlabs) {
                if(income.compareTo(taxSlab.getTo()) >= 0) {
                    amount = taxSlab.getTo().subtract(amount);
                } else {
                    amount = income;
                }
                tax = tax.add(amount.multiply(taxSlab.getTaxPercentage()).divide(BigDecimal.valueOf(100)));
                income = income.subtract(amount);
                if(income.compareTo(BigDecimal.ZERO) > 0) {
                    continue;
                }
                break;
            }
        }
        tax = tax.add(tax.multiply(period.getCess()).divide(BigDecimal.valueOf(100)));
        return tax;
    }


}
