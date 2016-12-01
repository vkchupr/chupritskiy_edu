package com.education.task1_2;


import java.util.Random;

public class ArrayOfStringGenerator {
    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static Random rnd = new Random();
    private static String prefix = null;

    public static String[] generateArray(int prefixLength, int arrayLength, int averageLength, int deltaLength) {

        if (prefixLength < 0) {
            throw new IllegalArgumentException("prefixLength less then zero!");
        }
        if (arrayLength < 0) {
            throw new IllegalArgumentException("arrayLength less then zero!");
        }
        if (averageLength < 0) {
            throw new IllegalArgumentException("averageLength less then zero!");
        }
        if (deltaLength < 0) {
            throw new IllegalArgumentException("deltaLength less then zero!");
        }

        if (averageLength < deltaLength) {
            throw new IllegalArgumentException("averageLength cannot be less then deltaLength!");
        }

        prefix = getPrefix(prefixLength);
        return getArray(prefix, arrayLength, averageLength, deltaLength);
    }

    public static String[] generateTask1Array(Scenario scenario) {
        int[] vars = scenario.getVars();
        return generateArray(vars[0], vars[1], vars[2], vars[3]);
    }

    public static String getPrefix() {
        return prefix;
    }

    private static String getPrefix(int prefixLength) {
        return randomString(prefixLength);
    }

    private static String[] getArray(String prefix, int arrayLength, int averageLength, int deltaLength) {
        String[] result = new String[arrayLength];
        for (int k = 0; k < arrayLength; k++) {
            int ran = (int) Math.round((Math.random() - 0.5) * deltaLength * 2);
            int length = averageLength + ran;
            result[k] = prefix + randomString(length);
        }
        return result;
    }

    public static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomWithCommonPart(String common, int length) {
        int round = (int) Math.round(Math.random() * length);
        String s = randomString(round);
        String s1 = randomString(length - round);
        return s + common + s1;
    }

    public static String[] generateTask2Array(Scenario scenario) {
        int[] vars = scenario.getVars();
        prefix = getPrefix(vars[0]);
        String[] strings = new String[vars[1]];
        for (int i = 0; i < strings.length; i++) {
            int ran = (int) Math.round((Math.random() - 0.5) * vars[3] * 2);
            int length = vars[2] + ran;
            strings[i] = getRandomWithCommonPart(prefix, length);
        }
        return strings;
    }
}
