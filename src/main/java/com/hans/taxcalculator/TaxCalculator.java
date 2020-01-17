package com.hans.taxcalculator;

import java.math.BigDecimal;

public interface TaxCalculator {

    /**
     *
     * @param income
     * @method calculateTax takes taxable income as input
     * and returns calculated tax based on the default tax period
     * @return
     */
    BigDecimal calculateTax(BigDecimal income);

    /**
     *
     * @param income
     * @param taxPeriod
     * @method calculateTax takes taxable income and tax period
     * and returns calculated tax
     * @throws TaxException if the give @param taxPeriod is invalid
     * Tax Period eg: 2018-2019, 2019-2020 etc..
     * @return
     */
    BigDecimal calculateTax(BigDecimal income, String taxPeriod) throws TaxException;
}
