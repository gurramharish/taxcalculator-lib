package com.hans.taxcalculator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class MainApp {

    public static void main(String[] args) {
        if(args.length > 0) {
            try {
                BigDecimal income = BigDecimal.valueOf(Double.valueOf(args[0]));
                String taxPeriod = null;
                if(args.length > 1) {
                    taxPeriod = args[1];
                }
                System.out.println("Income :: " + income + " Period :: " + taxPeriod);
                TaxRequest request = new TaxRequest(income, taxPeriod);
                AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
                ctx.register(AppConfig.class);
                ctx.refresh();
                ITaxCalculator calculator = (ITaxCalculator) ctx.getBean("taxcalculator-in");
                TaxResponse response = calculator.calculateTax(request);
                System.out.println("Tax :: " + response.getTax());
                if(response.getErrors().size() > 0) {
                    for(TaxError error : response.getErrors()) {
                        System.out.println(error.getMessage());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }
}
