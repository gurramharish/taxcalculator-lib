package com.hans.taxcalculator.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hans.taxcalculator.TaxPeriod;
import com.hans.taxcalculator.conditions.JSONType;
import com.hans.taxcalculator.repository.ITaxPeriodRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Component
@Conditional(JSONType.class)
public class JSONTaxPeriodRepository implements ITaxPeriodRepository {

    @Value( "${input.file.path}" )
    private String filePath;

    @Override
    public TaxPeriod getTaxPeriodByCountry(String countryCode, String period) {
        System.out.println("JSON Repo");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println("File Path from properties :: " + filePath);
        TaxPeriod taxPeriod = null;
        try {
            File file = new File(filePath+"/"+countryCode+"_Tax_Period.json");
            List<TaxPeriod> taxPeriods = mapper.readValue(file, new TypeReference<List<TaxPeriod>>() {});
            taxPeriod = taxPeriods.stream().filter(p -> p.getPeriod().equals(period)).findFirst().get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taxPeriod;
    }
}
