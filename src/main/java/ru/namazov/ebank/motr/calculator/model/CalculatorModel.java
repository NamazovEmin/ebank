/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.ebank.motr.calculator.model;

import java.util.List;
import java.util.stream.IntStream;

public class CalculatorModel {

    private int statusPoint = 4330;
    private int strength = 1;
    private int agility = 1;
    private int vitality = 1;
    private int intellect = 1;
    private int dexterity = 1;
    private int luck = 1;
    private List<Integer> range = IntStream.range(1, 131).boxed().toList();

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public List<Integer> getRange() {
        return range;
    }

    public int recalculateStatusPoint() {
        statusPoint = 4330
                - calculateParam(strength)
                - calculateParam(agility)
                - calculateParam(vitality)
                - calculateParam(intellect)
                - calculateParam(dexterity)
                - calculateParam(luck);
        return statusPoint;
    }

    private int calculateParam(int param) {
        if (1 < param && param <= 11) {
            return 2 * (param - 1);
        }
        if (11 < param && param <= 21) {
            return 10 * 2 + (param - 11) * 3;
        }
        if (21 < param && param <= 31) {
            return 10 * 2 + 10 * 3 + (param - 21) * 4;
        }
        if (31 < param && param <= 41) {
            return 10 * 2 + 10 * 3 + 10 * 4 + (param - 31) * 5;
        }
        if (41 < param && param <= 51) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + (param - 41) * 6;
        }
        if (51 < param && param <= 61) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + (param - 51) * 7;
        }
        if (61 < param && param <= 71) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + (param - 61) * 8;
        }
        if (71 < param && param <= 81) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + (param - 71) * 9;
        }
        if (81 < param && param <= 91) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + (param - 81) * 10;
        }
        if (91 < param && param <= 100) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + (param - 91) * 11;
        }
        if (100 < param && param <= 105) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + 9 * 11 + (param - 100) * 16;
        }
        if (105 < param && param <= 110) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + 9 * 11 + 5 * 16 + (param - 105) * 20;
        }
        if (110 < param && param <= 115) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + 9 * 11 + 5 * 16 + 5 * 20 + (param - 110) * 24;
        }
        if (115 < param && param <= 120) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + 9 * 11 + 5 * 16 + 5 * 20 + 5 * 24 + (param - 115) * 28;
        }
        if (120 < param && param <= 125) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + 9 * 11 + 5 * 16 + 5 * 20 + 5 * 24 + 5 * 28+ (param - 120) * 32;
        }
        if (125 < param && param <= 130) {
            return 10 * 2 + 10 * 3 + 10 * 4 + 10 * 5 + 10 * 6 + 10 * 7 + 10 * 8 + 10 * 9 + 10 * 10 + 9 * 11 + 5 * 16 + 5 * 20 + 5 * 24 + 5 * 28 + 5 * 32+ (param - 125) * 36;
        }
        return 0;
    }
}
