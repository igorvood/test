package hello;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.KeyNotifier;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringComponent
@UIScope
public class AbstractEditor<T extends Customer, R extends JpaRepository> extends VerticalLayout implements KeyNotifier {
    private Class<T> type;

    private final R repository;

    private T customer;

    /* Fields to edit properties in Customer entity */
    List<TextField> fields = new ArrayList<>();
//    TextField firstName = new TextField("First name");
//    TextField lastName = new TextField("Last name");

    /* Action buttons */
    Button save = new Button("Save", VaadinIcon.CHECK.create());
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete", VaadinIcon.TRASH.create());
    HorizontalLayout actions = new HorizontalLayout(save, cancel, delete);

    Binder<T> binder = new Binder<>(type);
    private AbstractEditor.ChangeHandler changeHandler;


    @Autowired
    public AbstractEditor(Class<T> type, R repository) {
        this.type = type;
        this.repository = repository;



        final Map<String, FieldForView.FieldProperty> fieldsForView = new FieldForView<>(type).getListFields();
        fieldsForView.entrySet().stream().forEach(e -> fields.add(new TextField(e.getValue().getDisplayName())));

        List<Component> components = new ArrayList<>(fields.size() + 1);
        components.addAll(fields);
        components.add(actions);
        Component[] myArray = (Component[]) components.toArray();
        add(myArray);

        // bind using naming convention
        binder.bindInstanceFields(this);

        // Configure and style components
        setSpacing(true);

        save.getElement().getThemeList().add("primary");
        delete.getElement().getThemeList().add("error");

        addKeyPressListener(Key.ENTER, e -> save());

        // wire action buttons to save, delete and reset
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
        cancel.addClickListener(e -> editCustomer(customer));
        setVisible(false);
    }

    void delete() {
        repository.delete(customer);
        changeHandler.onChange();
    }

    void save() {
        repository.save(customer);
        changeHandler.onChange();
    }

    public interface ChangeHandler {
        void onChange();
    }

    public final void editCustomer(T c) {
        if (c == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = c.getId() != null;
        if (persisted) {
            // Find fresh entity for editing
            customer = (T) repository.findById(c.getId()).get();
        } else {
            customer = c;
        }
        cancel.setVisible(persisted);

        // Bind customer properties to similarly named fields
        // Could also use annotation or "manual binding" or programmatically
        // moving values from fields to entities before saving
        binder.setBean(customer);

        setVisible(true);

        // Focus first name initially
        fields.get(0).focus();
    }

    public void setChangeHandler(AbstractEditor.ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        changeHandler = h;
    }


}
