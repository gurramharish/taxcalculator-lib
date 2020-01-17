package com.hans.taxcalculator.utils;

import java.math.BigDecimal;

public class TaxSlab {

    private BigDecimal from;
    private BigDecimal to;
    private BigDecimal taxPercentage;

    public TaxSlab(BigDecimal from, BigDecimal to, BigDecimal taxPercentage) {
        this.from = from;
        this.to = to;
        this.taxPercentage = taxPercentage;
    }

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
