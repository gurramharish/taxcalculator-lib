package com.hans.taxcalculator;

import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new IndiaTaxCalculator();
        System.out.println(taxCalculator.calculateTax(BigDecimal.valueOf(800000), "2019-2020"));
        System.out.println(taxCalculator.calculateTax(BigDecimal.valueOf(989822), "2019-2020"));
        //System.out.println(taxCalculator.calculateTax(BigDecimal.valueOf(800000), "2030-2020"));

    }
}
