package com.example.lab4.Views;

import com.example.lab4.Entity.Car;
import com.example.lab4.editors.CarEditor;
import com.example.lab4.security.SecurityService;
import com.example.lab4.service.CarService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

@Route(value = "cars", layout = MainView.class)
@PermitAll
public class EntityEdit extends VerticalLayout {

    private final CarService carService;


    final Grid<Car> grid;
    private final CarEditor carEditor;
    private final SecurityService securityService;
    private final Button addNewBtn;

    public EntityEdit(CarService carService, CarEditor carEditor,SecurityService securityService) {
        this.carService = carService;
        this.carEditor = carEditor;
        this.securityService = securityService;
        this.grid = new Grid<>();
        grid.addColumn(Car::getId).setHeader("ID");
        grid.addColumn(Car::getNumber).setHeader("Гос.номер");
        grid.addColumn(Car::getBrand).setHeader("Модель");
        grid.addColumn(Car::getStatus).setHeader("Статус");
        this.addNewBtn = new Button("Новый автомобиль", VaadinIcon.PLUS.create());

        // build layout
        HorizontalLayout actions = new HorizontalLayout(addNewBtn);
        if(securityService.getAuthenticatedUser().getUsername() == "admin")
        add(actions, grid,carEditor);
        else
            add( grid);





        grid.setHeight("500px");
        grid.getColumnByKey("id");



        // Hook logic to components


        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e -> {
            carEditor.editCustomer(e.getValue());
        });

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> {carEditor.editCustomer(new Car());
        });

        // Listen changes made by the editor, refresh data from backend
        carEditor.setChangeHandler(() -> {
            carEditor.setVisible(false);
            listCustomers();
        });

        // Initialize listing
        listCustomers();
    }

    public void listCustomers() {

            grid.setItems(carService.getAllCars());

    }

}