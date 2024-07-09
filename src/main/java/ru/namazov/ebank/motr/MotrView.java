/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.ebank.motr;

import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;

import ru.namazov.ebank.main.view.MainView;
import ru.namazov.ebank.motr.calculator.CalculatorView;
import ru.namazov.ebank.motr.menu.component.MenuComponent;

import jakarta.annotation.security.RolesAllowed;


@Route(value = "/admin/motr", layout = MainView.class)
@RolesAllowed("ADMIN")
public class MotrView extends VerticalLayout {

    public MotrView() {
        add(new MenuComponent());
    }
}
