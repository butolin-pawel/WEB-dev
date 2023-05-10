package com.example.lab4.editors;
import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.Entity.Carwashes;
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

import java.time.format.DateTimeFormatter;

/**
 * A simple example to introduce building forms. As your real application is probably much
 * more complicated than this example, you could re-use this form in multiple places. This
 * example component is only used in MainView.
 * <p>
 * In a real world application you'll most likely using a common super class for all your
 * forms - less code, better UX.
 */
@SpringComponent
@UIScope
@RolesAllowed("ADMIN")
public class CarEditor extends VerticalLayout implements KeyNotifier {

    private final CarService carService;
    private final Car_washesService car_washesService;
    private final BoxService boxService;

    /**
     * The currently edited customer
     */
    private Car car;

    /* Fields to edit properties in Customer entity */
    TextField brand = new TextField("Марка");
    TextField number = new TextField("Гос. номер");
    ComboBox<String>  statuses= new ComboBox<>("Статус");

    ComboBox<Box> boxes = new ComboBox<>("Боксы");
    DatePicker date = new DatePicker();
    /* Action buttons */
    // TODO why more code?
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    Button wash = new Button("Помыть", VaadinIcon.CAR.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Car> binder = new Binder<>();
    private ChangeHandler changeHandler;

    @Autowired
    public CarEditor(CarService carService, Car_washesService car_washesService, BoxService boxService) {
        this.carService = carService;
        this.car_washesService = car_washesService;
        this.boxService = boxService;
        VerticalLayout vl = new VerticalLayout(brand,number,statuses, actions);
        VerticalLayout vlW = new VerticalLayout(boxes,date,wash);
        HorizontalLayout hl = new HorizontalLayout(vl,vlW);
        add(hl);
        boxes.setItems(boxService.getAllBox());
        boxes.setItemLabelGenerator(Box::getName);
        statuses.setItems(new String[] {"Грязная","Мытая"});
        // bind using naming convention
        binder.forField(brand).bind(Car::getBrand,Car::setBrand);
        binder.forField(number).bind(Car::getNumber,Car::setNumber);
        binder.forField(statuses).bind(Car::getStatus,Car::setStatus);
        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(car));
        wash.addClickListener(e -> wash( car));
        setVisible(false);
    }

    void delete() {
        carService.deleteCarById(car.getId());
        changeHandler.onChange();
    }
    void wash(Car car){
        Carwashes carwashes = new Carwashes();
        carwashes.setCar(car);
        carwashes.setActive(true);
        carwashes.setPlace(boxes.getOptionalValue().get());
        carwashes.setDate(date.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        car.setStatus("Мытая");
        carService.editCar(car);
        car_washesService.saveWash(carwashes);
        changeHandler.onChange();
    }
    void save() {
        carService.saveCar(car);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editCustomer(Car c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            car = carService.getCarById(c.getId());
        }
        else {
            car = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(car);

        setVisible(true);

        // Focus first name initially
        brand.focus();
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }

}