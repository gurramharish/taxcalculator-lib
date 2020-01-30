package com.hans.taxcalculator;

import com.hans.taxcalculator.impl.IndiaTaxCalculator;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

@DisplayName("India Tax Calculation Test Cases")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IndiaTaxCalculatorTest {

    ITaxCalculator calculator;

    @BeforeAll
    public void setup() {
        calculator = new IndiaTaxCalculator();
    }

    @Test
    @DisplayName("Tax zero cases")
    @Ignore
    public void taxZeroCases() {
       /* Assertions.assertEquals(BigDecimal.ZERO, calculator.calculateTax(BigDecimal.valueOf(250000)));
        Assertions.assertEquals(BigDecimal.ZERO, calculator.calculateTax(BigDecimal.ZERO));
        Assertions.assertEquals(BigDecimal.ZERO, calculator.calculateTax(BigDecimal.valueOf(250000), "2019-2020"));*/
    }

    @Test
    @DisplayName("Tax matching with calculated cases")
    @ValueSource(doubles = {})
    public void taxMatchingCases() {
       /* Assertions.assertAll(
                () -> Assertions.assertEquals(BigDecimal.valueOf(75400), calculator.calculateTax(BigDecimal.valueOf(800000), "2019-2020")),
                () ->  Assertions.assertEquals(BigDecimal.valueOf(112840), calculator.calculateTax(BigDecimal.valueOf(980000), "2019-2020")),
                () -> Assertions.assertEquals(BigDecimal.valueOf(186888), calculator.calculateTax(BigDecimal.valueOf(1224000), "2019-2020")),
                () -> Assertions.assertEquals(BigDecimal.valueOf(117354), calculator.calculateTax(BigDecimal.valueOf(1001134), "2019-2020")),
                () -> Assertions.assertEquals(BigDecimal.valueOf(120120), calculator.calculateTax(BigDecimal.valueOf(1010000), "2019-2020"))
        );*/
    }

}
