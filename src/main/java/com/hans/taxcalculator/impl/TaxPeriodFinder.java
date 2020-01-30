package com.hans.taxcalculator.impl;

import com.hans.taxcalculator.ITaxPeriodFinder;
import com.hans.taxcalculator.TaxPeriod;
import com.hans.taxcalculator.repository.ITaxPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaxPeriodFinder implements ITaxPeriodFinder {

    private ITaxPeriodRepository taxPeriodRepository;

    @Override
    public TaxPeriod getTaxSlabsByPeriod(String countryCode, String taxPeriod) {
        return taxPeriodRepository.getTaxPeriodByCountry(countryCode, taxPeriod);
    }

    @Autowired
    public void setTaxPeriodRepository(ITaxPeriodRepository taxPeriodRepository) {
        this.taxPeriodRepository = taxPeriodRepository;
    }
}
