package ru.namazov.ebank.motr.calculator.presenter;

import ru.namazov.ebank.motr.calculator.component.CalculatorComponent;
import ru.namazov.ebank.motr.calculator.model.CalculatorModel;

public class CalculatorPresenter implements CalculatorComponent.CalculatorViewListener {

    private final CalculatorModel calculatorModel;
    private final CalculatorComponent calculatorComponent;

    public CalculatorPresenter(CalculatorModel calculatorModel, CalculatorComponent calculatorComponent) {
        this.calculatorModel = calculatorModel;
        this.calculatorComponent = calculatorComponent;

        calculatorComponent.init(calculatorModel.getRange(), calculatorModel.recalculateStatusPoint());
        calculatorComponent.addListener(this);
    }

    @Override
    public void buttonClick(int value, String label) {
        switch (label) {
            case "STR" -> {
                calculatorModel.setStrength(value);
            }
            case "AGI" -> {
                calculatorModel.setAgility(value);
            }
            case "VIT" -> {
                calculatorModel.setVitality(value);
            }
            case "INT" -> {
                calculatorModel.setIntellect(value);
            }
            case "DEX" -> {
                calculatorModel.setDexterity(value);
            }
            case "LUC" -> {
                calculatorModel.setLuck(value);
            }
        }
        calculatorComponent.setDisplay(calculatorModel.recalculateStatusPoint());
    }
}
