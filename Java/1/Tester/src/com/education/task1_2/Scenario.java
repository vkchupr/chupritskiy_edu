package com.education.task1_2;

public class Scenario {
    private int prefixLength;
    private int arrayLength;
    private int averageLength;
    private int deltaLength;

    public int getDeltaLength() {
        return deltaLength;
    }

    public int getPrefixLength() {
        return prefixLength;
    }

    public int getArrayLength() {
        return arrayLength;
    }

    public int getAverageLength() {
        return averageLength;
    }

    public int[] getVars() {
        return new int[]{prefixLength, arrayLength, averageLength, deltaLength};
    }

    public Scenario(int prefixLength, int arrayLength, int averageLength, int deltaLength) {
        this.prefixLength = prefixLength;
        this.arrayLength = arrayLength;
        this.averageLength = averageLength;
        this.deltaLength = deltaLength;
    }


}
