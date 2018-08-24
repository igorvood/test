package ru.vood.amdWeb.util.abstraction

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.KeyNotifier
import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.data.binder.Binder
import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.amdWeb.util.FieldForView

import java.math.BigDecimal
import java.util.ArrayList
import java.util.HashMap

abstract class AbstractEditor<T /*: Customer*/, R : JpaRepository<T, BigDecimal>> : VerticalLayout, KeyNotifier {
    private lateinit var repository: R
    /* Fields to edit properties in entity */
    private var fields: HashMap<String, Component> = HashMap()
    /* Action buttons */
    private val save = Button("Save", VaadinIcon.CHECK.create())
    private val cancel = Button("Cancel")
    private val delete = Button("Delete", VaadinIcon.TRASH.create())
    private val actions = HorizontalLayout(save, cancel, delete)

    private var binder: Binder<T>
    private var type: Class<T>
    //private lateinit var customer: T
    private lateinit var changeHandler: AbstractEditor.ChangeHandler


    constructor(type: Class<T>, repository: R) : super() {
        this.type = type
        this.repository = repository
        this.binder = Binder<T>(type)

        // получение по типу сущности type необходимой информации о полях
        val fieldsForView = FieldForView(type).getFields()
        for (field in fieldsForView) {
            //создание для каждого поля сущности соответствующего компонента для редактирования
            fields.put(field.key, field.value.mappedField)
        }
        //помещеие компонентов на экранную форму
        val components = ArrayList<Component>(fields.size + 1)
        components.addAll(fields.values)
        components.add(actions)
        add(*components.toTypedArray())
    }

    interface ChangeHandler {
        fun onChange()
    }
}