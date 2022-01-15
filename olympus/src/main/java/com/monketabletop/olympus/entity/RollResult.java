package com.monketabletop.olympus.entity;

public class RollResult {

    private String successLevel;

    private int diceResult;

    public RollResult(String successLevel, int diceResult) {
        this.successLevel = successLevel;
        this.diceResult = diceResult;
    }

    public String getSuccessLevel() {
        return successLevel;
    }

    public void setSuccessLevel(String successLevel) {
        this.successLevel = successLevel;
    }

    public int getDiceResult() {
        return diceResult;
    }

    public void setDiceResult(int diceResult) {
        this.diceResult = diceResult;
    }
}
