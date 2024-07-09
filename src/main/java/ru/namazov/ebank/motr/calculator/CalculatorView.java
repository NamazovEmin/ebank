/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.ebank.motr.calculator;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ru.namazov.ebank.main.view.MainView;
import ru.namazov.ebank.motr.calculator.component.CalculatorComponentImpl;
import ru.namazov.ebank.motr.calculator.model.CalculatorModel;
import ru.namazov.ebank.motr.calculator.presenter.CalculatorPresenter;
import ru.namazov.ebank.motr.menu.component.MenuComponent;

import jakarta.annotation.security.RolesAllowed;

@Route(value = "/admin/motr/calculator", layout = MainView.class)
@RolesAllowed("ADMIN")
public class CalculatorView extends HorizontalLayout {

    public CalculatorView() {
        CalculatorComponentImpl calculatorComponent = new CalculatorComponentImpl();
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorPresenter calculatorPresenter = new CalculatorPresenter(calculatorModel, calculatorComponent);

        VerticalLayout menu = new VerticalLayout(new MenuComponent());
        VerticalLayout calc = new VerticalLayout(calculatorComponent);
        add(menu,calc);

    }
}
