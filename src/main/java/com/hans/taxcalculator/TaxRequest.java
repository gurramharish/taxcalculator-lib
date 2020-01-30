package com.hans.taxcalculator;

import java.math.BigDecimal;

public class TaxRequest {

    private BigDecimal income;
    private String taxPeriod;

    public TaxRequest(BigDecimal income, String taxPeriod) {
        this.income = income;
        this.taxPeriod = taxPeriod;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public String getTaxPeriod() {
        return taxPeriod;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public void setTaxPeriod(String taxPeriod) {
        this.taxPeriod = taxPeriod;
    }
}
