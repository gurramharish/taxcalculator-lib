package com.hans.taxcalculator.validators;

import com.hans.taxcalculator.TaxError;
import com.hans.taxcalculator.TaxRequest;

import java.util.List;

public interface ITaxValidator {

    List<TaxError> validate(TaxRequest request);
}
