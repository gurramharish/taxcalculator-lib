package com.hans.taxcalculator.repository;

import com.hans.taxcalculator.TaxPeriod;

public interface ITaxPeriodRepository {

    TaxPeriod getTaxPeriodByCountry(String countryCode, String period);
}
