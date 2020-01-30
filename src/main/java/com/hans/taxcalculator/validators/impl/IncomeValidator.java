package com.hans.taxcalculator.validators.impl;

import com.hans.taxcalculator.TaxError;
import com.hans.taxcalculator.TaxRequest;
import com.hans.taxcalculator.validators.ITaxRequestValidator;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IncomeValidator implements ITaxRequestValidator {

    @Override
    public TaxError validate(TaxRequest request) {
        BigDecimal income = request.getIncome();
        String field = "income";
        TaxError error = null;
        StringBuilder messageBuilder = new StringBuilder("Invalid income :").append(income);
        if(income == null
                || income.compareTo(BigDecimal.ZERO) == 0
                || income.compareTo(BigDecimal.ZERO) < 0) {
            error = new TaxError(field, messageBuilder.toString());
        }
        return error;
    }
}
