package com.hans.taxcalculator.validators.impl;

import com.hans.taxcalculator.TaxError;
import com.hans.taxcalculator.validators.ITaxRequestValidator;
import com.hans.taxcalculator.TaxRequest;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TaxPeriodValidator implements ITaxRequestValidator {

    @Override
    public TaxError validate(TaxRequest request) {
        String taxPeriod = request.getTaxPeriod();
        TaxError error = null;
        if(taxPeriod != null && !taxPeriod.trim().equals("")) {
            taxPeriod = taxPeriod.trim();
            Pattern periodPattern = Pattern.compile("^\\d{4}-\\d{4}$");
            Matcher m = periodPattern.matcher(taxPeriod);
            if(!m.matches()) {
                StringBuilder messageBuilder = new StringBuilder("Invalid tax period : ").append(taxPeriod);
                error = new TaxError("taxPeriod", messageBuilder.toString());
            }
        }
        return error;
    }
}
