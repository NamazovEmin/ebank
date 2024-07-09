package ru.namazov.ebank.motr.menu.component;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;

import ru.namazov.ebank.motr.calculator.CalculatorView;

public class MenuComponent extends FormLayout {
    
    public MenuComponent() {
        SideNav sideNav = new SideNav();
        SideNavItem calculator = new SideNavItem("Калькулятор");
        calculator.setPath(CalculatorView.class);
        sideNav.addItem(calculator);

        SideNavItem equip = new SideNavItem("Экипировка");
        equip.setPath(CalculatorView.class);
        sideNav.addItem(equip);

        HorizontalLayout nav = new HorizontalLayout(sideNav);

        add(nav);
    }
}
