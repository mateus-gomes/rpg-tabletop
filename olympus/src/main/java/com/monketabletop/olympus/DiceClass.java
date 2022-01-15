package com.monketabletop.olympus;

import java.util.Random;

public class DiceClass {

    public int rollDice(int type){
        Random random = new Random();
        return random.nextInt(type) + 1;
    }

//    diceClass.rollDamage("00;00;03;00;00;00;03")
    public int rollDamage(String damage){
        String[] listDices = damage.split(";");
        int totalDamage = 0;

        totalDamage += translateDamage(listDices[0], 4);
        totalDamage += translateDamage(listDices[1], 6);
        totalDamage += translateDamage(listDices[2], 8);
        totalDamage += translateDamage(listDices[3], 10);
        totalDamage += translateDamage(listDices[4], 12);
        totalDamage += translateDamage(listDices[5], 20);
        totalDamage += Integer.parseInt(listDices[6]);

        return totalDamage;
    }

    private int translateDamage(String amountDiceString, int type){
        int totalDamage = 0;
        int amountDice = Integer.parseInt(amountDiceString);

        for(int i = 0; i < amountDice; i++){
            totalDamage += rollDice(type);
        }

        return totalDamage;
    }
}
