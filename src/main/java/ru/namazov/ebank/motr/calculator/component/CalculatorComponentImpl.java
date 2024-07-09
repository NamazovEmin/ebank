package ru.namazov.ebank.motr.calculator.component;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

public class CalculatorComponentImpl extends FormLayout implements CalculatorComponent {

    private final List<CalculatorViewListener> listeners = new ArrayList<>();
    private final ComboBox<Integer> strength;
    private final ComboBox<Integer> agility;
    private final ComboBox<Integer> vitality;
    private final ComboBox<Integer> intellect;
    private final ComboBox<Integer> dexterity;
    private final ComboBox<Integer> luck;
    private final TextField statusPoint;


    public CalculatorComponentImpl() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        strength = new ComboBox<>("STR");
        strength.setMaxWidth("75px");
        strength.addValueChangeListener(select -> listeners.forEach(listener -> listener.buttonClick(select.getValue(), select.getSource().getLabel())));


        agility = new ComboBox<>("AGI");
        agility.setMaxWidth("75px");
        agility.addValueChangeListener(select -> listeners.forEach(listener -> listener.buttonClick(select.getValue(), select.getSource().getLabel())));


        vitality = new ComboBox<>("VIT");
        vitality.setMaxWidth("75px");
        vitality.addValueChangeListener(select -> listeners.forEach(listener -> listener.buttonClick(select.getValue(), select.getSource().getLabel())));


        intellect = new ComboBox<>("INT");
        intellect.setMaxWidth("75px");
        intellect.addValueChangeListener(select -> listeners.forEach(listener -> listener.buttonClick(select.getValue(), select.getSource().getLabel())));


        dexterity = new ComboBox<>("DEX");
        dexterity.setMaxWidth("75px");
        dexterity.addValueChangeListener(select -> listeners.forEach(listener -> listener.buttonClick(select.getValue(), select.getSource().getLabel())));


        luck = new ComboBox<>("LUC");
        luck.setMaxWidth("75px");
        luck.addValueChangeListener(select -> listeners.forEach(listener -> listener.buttonClick(select.getValue(), select.getSource().getLabel())));


        statusPoint = new TextField("Очки характеристик");
        statusPoint.setReadOnly(true);
        statusPoint.setMaxWidth("150px");
        statusPoint.addThemeVariants(TextFieldVariant.LUMO_ALIGN_CENTER);


        horizontalLayout.add(strength, agility, vitality, intellect, dexterity, luck, statusPoint);
        add(horizontalLayout);
    }

    @Override
    public void setDisplay(int point) {
        statusPoint.setValue(String.valueOf(point));
    }

    @Override
    public void init(List<Integer> range, int point) {
        strength.setItems(range);
        agility.setItems(range);
        vitality.setItems(range);
        intellect.setItems(range);
        dexterity.setItems(range);
        luck.setItems(range);
        statusPoint.setValue(String.valueOf(point));
    }

    public void addListener(CalculatorViewListener listener) {
        listeners.add(listener);
    }
}
