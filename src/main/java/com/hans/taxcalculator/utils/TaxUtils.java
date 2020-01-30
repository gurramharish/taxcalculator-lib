package com.hans.taxcalculator.utils;

import com.hans.taxcalculator.TaxPeriod;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaxUtils {

    public static String getDefaultTaxPeriod() {
        LocalDate date = LocalDate.now();
        int currentYear = date.getYear();
        int month = date.getMonth().getValue();
        String year = month > 3 ? String.valueOf(currentYear + 1) : String.valueOf(currentYear - 1);
        String currentYearStr = String.valueOf(currentYear);
        StringBuilder sb = month > 3 ? new StringBuilder(currentYearStr).append("-").append(year)
                : new StringBuilder(year).append("-").append(currentYearStr);
        return sb.toString();
    }

    /*public static TaxPeriod getTaxPeriodByCountyAndPeriod(String countryCode, String taxPeriod) {
        TaxPeriod period = TaxPeriod.UNKOWN;
        if(taxPeriod != null && !taxPeriod.trim().equals("")) {
            taxPeriod = taxPeriod.trim();
            Pattern periodPattern = Pattern.compile("^\\d{4}-\\d{4}$");
            Matcher m = periodPattern.matcher(taxPeriod);
            if(m.matches()) {
                String[] taxPeriodParts = taxPeriod.split("-");
                StringBuilder periodBuilder = new StringBuilder(countryCode.toUpperCase()).append("_").append(taxPeriodParts[0])
                        .append("_").append(taxPeriodParts[1]);
                try {
                    period = TaxPeriod.valueOf(periodBuilder.toString());
                } catch (IllegalArgumentException e) {
                    System.out.println("Period not found :: " + periodBuilder.toString());
                }
            }
        }
        return period;
    }*/
}
