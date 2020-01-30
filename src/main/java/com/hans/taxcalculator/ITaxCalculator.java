package com.hans.taxcalculator;

import java.math.BigDecimal;

public interface ITaxCalculator {


    /**
     *
     * @param taxRequest
     * @method calculateTax takes taxRequest
     * and returns taxResponse
     * @throws TaxException if the give @param taxPeriod is invalid
     * Tax Period eg: 2018-2019, 2019-2020 etc..
     * @return
     */
    TaxResponse calculateTax(TaxRequest taxRequest) throws TaxException;
}
