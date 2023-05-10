package com.example.lab4.Views;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.editors.CarEditor;
import com.example.lab4.security.SecurityService;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
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
@Route(value = "boxes", layout = MainView.class)
public class BoxView extends VerticalLayout {
    private final BoxService boxService;
    private final SecurityService securityService;

    final Grid<Box> grid;
    private final BoxEditor boxEditor;

    private final Button addNewBtn;

    public BoxView(BoxService boxService, BoxEditor boxEditor, SecurityService securityService) {
        this.boxService = boxService;
        this.securityService = securityService;
        this.boxEditor = boxEditor;
        this.grid = new Grid<>();
        grid.addColumn(Box::getId).setHeader("ID");
        grid.addColumn(Box::getName).setHeader("Название");
        grid.addColumn(Box::getType).setHeader("Тип");
        this.addNewBtn = new Button("Новый бокс", VaadinIcon.PLUS.create());

        // build layout
        HorizontalLayout actions = new HorizontalLayout(addNewBtn);
        if(securityService.getAuthenticatedUser().getUsername() == "admin")
            add(actions, grid,boxEditor);
        else
            add( grid);

        grid.setHeight("500px");
        grid.getColumnByKey("id");



        // Hook logic to components


        // Connect selected Customer to editor or hide if none is selected
        grid.asSingleSelect().addValueChangeListener(e ->
            boxEditor.editCustomer(e.getValue())
        );

        // Instantiate and edit new Customer the new button is clicked
        addNewBtn.addClickListener(e -> {boxEditor.editCustomer(new Box());
        });

        // Listen changes made by the editor, refresh data from backend
        boxEditor.setChangeHandler(() -> {
            boxEditor.setVisible(false);
            listCustomers();
        });

        // Initialize listing
        listCustomers();
    }

    public void listCustomers() {

        grid.setItems(boxService.getAllBox());

    }
}
