package com.hans.taxcalculator;

public interface ITaxPeriodFinder {

    TaxPeriod getTaxSlabsByPeriod(String countryCode, String taxPeriod);
}
