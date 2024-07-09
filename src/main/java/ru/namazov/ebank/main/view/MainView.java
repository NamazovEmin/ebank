/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

/*
 * Copyright (c) 2024, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package ru.namazov.ebank.main.view;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.LumoUtility;

import ru.namazov.ebank.motr.MotrView;

import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "")
@PermitAll
@RolesAllowed("ADMIN")
public class MainView extends AppLayout {

    private final List<Component> routerLinkList = new ArrayList<>();

    public MainView() {
        createHeader();
        createDrawer();
        createMain();
    }

    private void createMain() {

    }

    private void createHeader() {
        H1 logo = new H1("JAVA CRM");
        logo.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.MEDIUM);
        HorizontalLayout horizontalLayout = new HorizontalLayout(new DrawerToggle(), logo);
        horizontalLayout.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        horizontalLayout.expand(logo);
        horizontalLayout.setWidthFull();
        horizontalLayout.addClassNames(LumoUtility.Padding.Vertical.NONE, LumoUtility.Padding.Horizontal.MEDIUM);
        addToNavbar(horizontalLayout);
    }

    private void createDrawer() {
        RouterLink motrLing = new RouterLink("MOTR", MotrView.class);
        routerLinkList.add(motrLing);
        VerticalLayout verticalLayout = new VerticalLayout();

        TextField textField = new TextField();
        textField.setValue("Sayt");

        verticalLayout.add(textField);
        verticalLayout.add(routerLinkList);
        addToDrawer(verticalLayout);
    }
}
