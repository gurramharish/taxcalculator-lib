package com.hans.taxcalculator.impl;

import com.hans.taxcalculator.*;
import com.hans.taxcalculator.TaxPeriod;
import com.hans.taxcalculator.TaxSlab;
import com.hans.taxcalculator.utils.TaxUtils;
import com.hans.taxcalculator.validators.ITaxRequestValidator;
import com.hans.taxcalculator.validators.ITaxValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component("taxcalculator-in")
public class IndiaTaxCalculator implements ITaxCalculator {

    private ITaxPeriodFinder taxPeriodFinder;
    private ITaxValidator taxValidator;

    public TaxResponse calculateTax(TaxRequest taxRequest) throws TaxException {
        TaxResponse response = new TaxResponse();
        String taxPeriod = taxRequest.getTaxPeriod();
        if(taxPeriod == null || taxPeriod.trim().equals("")) {
            taxPeriod = TaxUtils.getDefaultTaxPeriod();
            taxRequest.setTaxPeriod(taxPeriod);
        }
        List<TaxError> errors = taxValidator.validate(taxRequest);
        if(errors.size() == 0) {
            BigDecimal income = taxRequest.getIncome();
            TaxPeriod period = taxPeriodFinder.getTaxSlabsByPeriod("IN", taxPeriod);
            BigDecimal tax = BigDecimal.ZERO;
            if(period == null) {
                StringBuilder messageBuilder = new StringBuilder("Invalid tax period : ").append(taxPeriod);
                TaxError error = new TaxError("taxPeriod", messageBuilder.toString());
                errors.add(error);
            } else {
                List<TaxSlab> taxSlabs = period.getTaxSlabs();
                BigDecimal amount = BigDecimal.ZERO;
                for(TaxSlab taxSlab : taxSlabs) {
                    amount = taxSlab.getTo() == null ? BigDecimal.valueOf(Long.MAX_VALUE).subtract(taxSlab.getFrom())
                            : taxSlab.getTo().subtract(taxSlab.getFrom());
                    if(income.compareTo(amount) < 0) {
                        amount = income;
                    }
                    BigDecimal intermidateTax = amount.multiply(taxSlab.getTaxPercentage()).divide(BigDecimal.valueOf(100));
                    tax = tax.add(intermidateTax);
                    income = income.subtract(amount);
                    if(income.compareTo(BigDecimal.ZERO) > 0) {
                        continue;
                    }
                    break;
                }
                tax = tax.add(tax.multiply(period.getCess()).divide(BigDecimal.valueOf(100)));
                response.setTax(tax);
            }
        }
        response.setErrors(errors);
        return response;
    }

    @Autowired
    public void setTaxPeriodFinder(ITaxPeriodFinder taxPeriodFinder) {
        this.taxPeriodFinder = taxPeriodFinder;
    }

    @Autowired
    public void setTaxValidator(ITaxValidator taxValidator) {
        this.taxValidator = taxValidator;
    }
}
