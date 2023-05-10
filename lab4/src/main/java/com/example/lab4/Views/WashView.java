package com.example.lab4.Views;

import com.example.lab4.Entity.Car;
import com.example.lab4.Entity.Carwashes;
import com.example.lab4.editors.CarEditor;
import com.example.lab4.security.SecurityService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.PermitAll;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@PermitAll
@Route(value = "washes", layout = MainView.class)
public class WashView extends VerticalLayout {
    private final Car_washesService car_washesService;
    private final SecurityService securityService;

    final Grid<Carwashes> grid;
    private final WashEditor washEditor;


    public WashView(Car_washesService car_washesService, WashEditor washEditor,SecurityService securityService) {
        this.car_washesService = car_washesService;
        this.securityService = securityService;
        this.washEditor = washEditor;
        this.grid = new Grid<>();
        grid.addColumn(Carwashes::getId).setHeader("ID");
        grid.addColumn(Carwashes::getCar).setHeader("Гос.номер");
        grid.addColumn(Carwashes::getPlace).setHeader("Модель");
        grid.addColumn(Carwashes::getDate).setHeader("Статус");

        // build layout
        if(securityService.getAuthenticatedUser().getUsername() == "admin")
            add( grid,washEditor);
        else
            add( grid);

        grid.setHeight("500px");
        grid.getColumnByKey("id");



        // Hook logic to components


        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            washEditor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked


        // Listen changes made by the editor, refresh data from backend
        washEditor.setChangeHandler(() -> {
            washEditor.setVisible(false);
            listCustomers();
        });

        // Initialize listing
        listCustomers();
    }

    public void listCustomers() {

        grid.setItems(car_washesService.getAllWash());

    }

}
