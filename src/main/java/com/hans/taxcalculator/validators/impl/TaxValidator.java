package com.hans.taxcalculator.validators.impl;

import com.hans.taxcalculator.TaxError;
import com.hans.taxcalculator.TaxRequest;
import com.hans.taxcalculator.validators.ITaxRequestValidator;
import com.hans.taxcalculator.validators.ITaxValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaxValidator implements ITaxValidator {

    private List<ITaxRequestValidator> validators;

    @Override
    public List<TaxError> validate(TaxRequest request) {
        List<TaxError> errors = new ArrayList<>();
        if(validators != null && validators.size() > 0) {
            for(ITaxRequestValidator validator : validators) {
                TaxError error = validator.validate(request);
                if(error != null) {
                    errors.add(error);
                }
            }
        }
        return errors;
    }

    @Autowired(required = false)
    public void setValidators(List<ITaxRequestValidator> validators) {
        this.validators = validators;
    }
}
