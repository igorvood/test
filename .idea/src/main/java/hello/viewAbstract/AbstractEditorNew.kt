package hello.viewAbstract

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.KeyNotifier
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.binder.Binder
import hello.AbstractEditor
import hello.Customer
import org.springframework.data.jpa.repository.JpaRepository
import java.security.KeyStore
import java.util.*

abstract class AbstractEditorNew<T : Customer, R : JpaRepository<T, Long>> : VerticalLayout, KeyNotifier {
    private lateinit var repository: R
    /* Fields to edit properties in Customer entity */
    private var fields: HashMap<String, Component> = HashMap()
    /* Action buttons */
    private var save = Button("Save", VaadinIcon.CHECK.create())
    private var cancel = Button("Cancel")
    //    TextField firstName = new TextField("First name");
    //    TextField lastName = new TextField("Last name");
    private var delete = Button("Delete", VaadinIcon.TRASH.create())
    private var actions = HorizontalLayout(save, cancel, delete)
    lateinit var binder: Binder<T>
    private lateinit var type: Class<T>
    private lateinit var customer: T
    private lateinit var changeHandler: AbstractEditor.ChangeHandler


    constructor(type: Class<T>, repository: R) : super() {
        this.type = type
        this.repository = repository
        this.binder = Binder<T>(type)

        val fieldsForView = FieldForViewNew(type).getFields()
//        val fieldNameSet = fieldsForView.keys
        for (field in fieldsForView) {
            fields.put(field.key, field.value.mappedField)
        }
        val components = ArrayList<Component>(fields.size + 1)
        components.addAll(fields.values)
        components.add(actions)
        add(*components.toTypedArray())


    }
}