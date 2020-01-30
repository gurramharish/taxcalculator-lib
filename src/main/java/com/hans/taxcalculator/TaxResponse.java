package com.hans.taxcalculator;

import java.math.BigDecimal;
import java.util.List;

public class TaxResponse {

    private BigDecimal tax;
    private List<TaxError> errors;

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public List<TaxError> getErrors() {
        return errors;
    }

    public void setErrors(List<TaxError> errors) {
        this.errors = errors;
    }
}
