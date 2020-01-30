package com.hans.taxcalculator;

import java.math.BigDecimal;
import java.util.List;

public class TaxPeriod {

    private String period;
    List<TaxSlab> taxSlabs;
    private BigDecimal cess;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<TaxSlab> getTaxSlabs() {
        return taxSlabs;
    }

    public void setTaxSlabs(List<TaxSlab> taxSlabs) {
        this.taxSlabs = taxSlabs;
    }

    public BigDecimal getCess() {
        return cess;
    }

    public void setCess(BigDecimal cess) {
        this.cess = cess;
    }
}
