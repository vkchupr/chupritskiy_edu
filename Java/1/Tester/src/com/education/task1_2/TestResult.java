package com.education.task1_2;


public class TestResult {

    private long time;
    private boolean result;
    private int[] vars;

    public TestResult(long time, int[] vars, boolean result) {
        this.time = time;
        this.vars = vars;
        this.result = result;
    }

    public int[] getVars() {
        return vars;
    }

    public void setVars(int[] vars) {
        this.vars = vars;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String toString() {
        return new StringBuffer("result: ").append(result).append("\n")
                .append("time: ").append(time).append("\n")
                .append("args: ")
                .append(vars[0]).append(",")
                .append(vars[1]).append(",")
                .append(vars[2]).append(",")
                .append(vars[3])
                .toString();
    }

}
