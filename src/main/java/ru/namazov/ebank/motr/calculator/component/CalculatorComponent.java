

/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.ebank.motr.calculator.component;

import java.util.List;

public interface CalculatorComponent {
    void setDisplay(int point);
    void init(List<Integer> range, int point);

    interface CalculatorViewListener {
        void buttonClick(int value, String label);
    }
    public void addListener(CalculatorViewListener listener);
}
