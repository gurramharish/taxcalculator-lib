package com.hans.taxcalculator.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public enum TaxPeriod {

    IN_2018_2019(Arrays.asList(
            new TaxSlab(BigDecimal.ZERO, BigDecimal.valueOf(250000L), BigDecimal.ZERO),
            new TaxSlab(BigDecimal.valueOf(250001L), BigDecimal.valueOf(500000L), BigDecimal.valueOf(10)),
            new TaxSlab(BigDecimal.valueOf(500001L), BigDecimal.valueOf(1000000L), BigDecimal.valueOf(20)),
            new TaxSlab(BigDecimal.valueOf(1000001L), BigDecimal.valueOf(Long.MAX_VALUE), BigDecimal.valueOf(30))
    ), BigDecimal.valueOf(4)),
   IN_2019_2020(Arrays.asList(
           new TaxSlab(BigDecimal.ZERO, BigDecimal.valueOf(250000L), BigDecimal.ZERO),
           new TaxSlab(BigDecimal.valueOf(250001L), BigDecimal.valueOf(500000L), BigDecimal.valueOf(5)),
           new TaxSlab(BigDecimal.valueOf(500001L), BigDecimal.valueOf(1000000L), BigDecimal.valueOf(20)),
           new TaxSlab(BigDecimal.valueOf(1000001L), BigDecimal.valueOf(Long.MAX_VALUE), BigDecimal.valueOf(30))
           ), BigDecimal.valueOf(4)),
    UNKOWN(null, null);

    private final List<TaxSlab> taxSlabs;
    private final BigDecimal cess;

    TaxPeriod(List<TaxSlab> taxSlabs, BigDecimal cess) {
        this.taxSlabs = taxSlabs;
        this.cess = cess;
    }

    public List<TaxSlab> getTaxSlabs() {
        return taxSlabs;
    }

    public BigDecimal getCess() {
        return cess;
    }
}
