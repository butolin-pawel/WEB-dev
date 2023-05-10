package com.example.lab4.Views;

import com.example.lab4.Entity.Box;
import com.example.lab4.Entity.Car;
import com.example.lab4.editors.CarEditor;
import com.example.lab4.service.BoxService;
import com.example.lab4.service.CarService;
import com.example.lab4.service.Car_washesService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
@RolesAllowed("ADMIN")
public class BoxEditor extends VerticalLayout implements KeyNotifier {
    private final BoxService boxService;

    /**
     * The currently edited customer
     */
    private Box box;

    /* Fields to edit properties in Customer entity */
    TextField name = new TextField("Название");

    ComboBox<String> type = new ComboBox<>("Тип");
    /* Action buttons */
    // TODO why more code?
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    Button wash = new Button("Помыть", VaadinIcon.CAR.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<Box> binder = new Binder<>();
    private BoxEditor.ChangeHandler changeHandler;

    @Autowired
    public BoxEditor( BoxService boxService) {

        this.boxService = boxService;
        VerticalLayout vl = new VerticalLayout(name,type, actions);
        add(vl);
        type.setItems(new String[]{"Легковой", "Грузовой"});
        // bind using naming convention
        binder.forField(name).bind(Box::getName,Box::setName);
        binder.forField(type).bind(Box::getType,Box::setType);
        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(box));
        setVisible(false);
    }

    void delete() {
        boxService.deleteBoxById(box.getId());
        changeHandler.onChange();
    }

    void save() {
        boxService.saveBox(box);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editCustomer(Box c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            box = boxService.getBoxById(c.getId());
            box = boxService.getBoxById(c.getId());
        }
        else {
            box = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(box);

        setVisible(true);

        // Focus first name initially
        name.focus();
    }

    public void setChangeHandler(BoxEditor.ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }

}
