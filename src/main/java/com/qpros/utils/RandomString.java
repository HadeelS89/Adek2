package com.qpros.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.util.Random;

public class RandomString {

    private static final String CHAR_LIST_SPECIAL = "$&@?<>~!%#";
    private static final String CHAR_LIST_ARABIC = "ابتثجحخدذرزسشصضطظعغفقكلمنهويأؤءةآىئ";

    //TODO add massive methods for data generator for now will be using faker

    public static int getRandomNumber() {
        double x = Math.random();
        return (int) x;
    }

    public static String getRandomInteger(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String getRandomAlphabets(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String getRandomAlphanumeric(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String getRandomArabic(int length) {
        return getRandomString(length, CHAR_LIST_ARABIC);
    }

    public static String getRandomSpecialChars(int length) {
        return getRandomString(length, CHAR_LIST_SPECIAL);
    }

    private static String getRandomString(int length, String charList) {
        SecureRandom rnd = new SecureRandom();
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int val = rnd.nextInt(charList.length());
            buf.append(charList.charAt(val));
        }
        return buf.toString();
    }

}
