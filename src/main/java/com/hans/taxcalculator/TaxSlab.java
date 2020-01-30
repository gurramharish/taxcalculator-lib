package com.hans.taxcalculator;

import java.math.BigDecimal;

public class TaxSlab {

    private BigDecimal from;
    private BigDecimal to;
    private BigDecimal taxPercentage;

    public BigDecimal getFrom() {
        return from;
    }

    public BigDecimal getTo() {
        return to;
    }

    public BigDecimal getTaxPercentage() {
        return taxPercentage;
    }
}
