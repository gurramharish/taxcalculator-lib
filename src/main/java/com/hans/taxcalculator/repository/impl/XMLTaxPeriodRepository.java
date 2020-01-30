package com.hans.taxcalculator.repository.impl;

import com.hans.taxcalculator.TaxPeriod;
import com.hans.taxcalculator.conditions.XMLType;
import com.hans.taxcalculator.repository.ITaxPeriodRepository;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional(XMLType.class)
public class XMLTaxPeriodRepository implements ITaxPeriodRepository {

    @Override
    public TaxPeriod getTaxPeriodByCountry(String countryCode, String period) {
        System.out.println("Tax period from xml file, country code :: " + countryCode + " Period :: " + period );
        return null;
    }
}
