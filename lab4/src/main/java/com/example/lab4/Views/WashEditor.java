package com.example.lab4.Views;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.Entity.Carwashes;
import com.example.lab4.editors.CarEditor;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringComponent
@UIScope
@RolesAllowed("ADMIN")
public class WashEditor extends VerticalLayout implements KeyNotifier {
    private final CarService carService;
    private final Car_washesService car_washesService;
    private final BoxService boxService;

    /**
     * The currently edited customer
     */
    private Carwashes carwashes;

    /* Fields to edit properties in Customer entity */

    ComboBox<Box> boxes = new ComboBox<>("Боксы");
    DatePicker date = new DatePicker();
    /* Action buttons */
    // TODO why more code?
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Carwashes> binder = new Binder<>();
    private WashEditor.ChangeHandler changeHandler;

    @Autowired
    public WashEditor(CarService carService, Car_washesService car_washesService, BoxService boxService) {
        this.carService = carService;
        this.car_washesService = car_washesService;
        this.boxService = boxService;
        VerticalLayout vl = new VerticalLayout(boxes,date, actions);
        VerticalLayout vlW = new VerticalLayout();
        HorizontalLayout hl = new HorizontalLayout(vl);
        add(hl);
        boxes.setItems(boxService.getAllBox());
        boxes.setItemLabelGenerator(Box::getName);
        // bind using naming convention
        binder.forField(boxes).bind(Carwashes::getPlace,Carwashes::setPlace);
        binder.forField(date).bind(Carwashes::getLocDate, Carwashes::setLocDate);
        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(carwashes));
        setVisible(false);
    }

    void delete() {
        carwashes.setDate(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        car_washesService.deleteWashById(carwashes.getId());
        changeHandler.onChange();
    }

    void save() {
        carwashes.setDate(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        carwashes.setPlace(boxes.getOptionalValue().get());
        car_washesService.saveWash(carwashes);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editCustomer(Carwashes c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
           //carwashes.setDate(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

            carwashes = car_washesService.getWashById(c.getId());
            //date.setValue(carwashes.getLocDate());
        }
        else {
            carwashes = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(carwashes);

        setVisible(true);

        // Focus first name initially
        boxes.focus();
    }

    public void setChangeHandler(WashEditor.ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }

}
