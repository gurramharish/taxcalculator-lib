package com.hans.taxcalculator.validators;

import com.hans.taxcalculator.TaxError;
import com.hans.taxcalculator.TaxRequest;

public interface ITaxRequestValidator {

    TaxError validate(TaxRequest request);
}
