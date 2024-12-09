package com.tracking.generate;

import org.apache.commons.lang3.RandomStringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static String generateTrackingNumber() {
        int length = 16;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers).toUpperCase();
    }

    public static String createdRFC3339FormatDate() {

        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(new Date());
    }

    public static void main(String[] args) throws ParseException {

        String createdAt = "2024-12-07T23:55:07 05:30";

    }
}
