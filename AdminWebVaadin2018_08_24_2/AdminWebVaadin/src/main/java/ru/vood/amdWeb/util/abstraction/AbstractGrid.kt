package ru.vood.amdWeb.util.abstraction

import com.vaadin.flow.component.button.Button
import com.vaadin.flow.component.grid.Grid
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.textfield.TextField
import com.vaadin.flow.data.provider.ListDataProvider
import com.vaadin.flow.data.value.ValueChangeMode
import com.vaadin.flow.function.ValueProvider
import org.apache.commons.lang3.StringUtils
import org.springframework.data.jpa.repository.JpaRepository
import ru.vood.amdWeb.util.FieldForView
import java.math.BigDecimal
import java.util.ArrayList
import kotlin.collections.HashMap


abstract class AbstractGrid<T /*: Customer*/, R : JpaRepository<T, BigDecimal>> : VerticalLayout {


    lateinit var grid: com.vaadin.flow.component.grid.Grid<T>

    lateinit var repo: R
    lateinit var addNewBtn: Button
    lateinit var type: Class<T>
    //lateinit var editor: AbstractEditor<T, R>


    constructor(repo: R, type: Class<T>/*, editor: AbstractEditor<T, R>*/) : super() {
        this.repo = repo
        this.type = type
        //this.editor = editor

        this.addNewBtn = Button("New Entity - add here name of Entity", VaadinIcon.PLUS.create())


        // если этот метод не перекрыт. то надо вернуть стандартный набор колонок
        if (getListColumns().size == 0) {
            val tFieldForView = FieldForView<T>(type)
            val mapFields = tFieldForView.getFields()
            val fieldsList = mapFields.keys
            val fields = fieldsList.toTypedArray()

            // грид создается с указанием класса. от туда ваадин вычитает все поля.
            this.grid = Grid<T>(type)

            grid.setColumns(*fields)

            fieldsList.asSequence().forEach { field ->
                val column = grid.getColumnByKey(field)
                column.isSortable = true
                column.setHeader(mapFields.get(field)?.displayName)
            }
            grid.setItems(repo.findAll())
        } else {
            // поля заданы надо их использовать
            this.grid = Grid<T>()
            val dataProvider = ListDataProvider<T>(repo.findAll())
            grid.dataProvider = dataProvider
            val columns: HashMap<String, FieldPropertyForView<T>> = getListColumns()
            val valueProviders = ArrayList<ValueProvider<T, String>>()
            val filterRow = grid.appendHeaderRow()
            columns.asSequence()
                    .forEach { entry ->
                        valueProviders.add(entry.value.getterForView)
                        val column: Grid.Column<T> = grid.addColumn(entry.value.getterForView)
                                .setSortable(true)
                                .setHeader(entry.value.displayName)
                        val field = TextField()
                        field.addValueChangeListener { event ->
                            dataProvider.addFilter { entity ->
                                StringUtils.containsIgnoreCase(entry.value.getterForView.apply(entity), field.value)
                            }
                        }
                        field.valueChangeMode = ValueChangeMode.EAGER

                        filterRow.getCell(column).setComponent(field)
                        field.setSizeFull()
                        field.placeholder = "Filter"
                    }
        }
        val actions = HorizontalLayout(addNewBtn)
        add(actions, grid/*, editor*/)
        grid.height = "500px"

    }

    open fun getListColumns() = HashMap<String, FieldPropertyForView<T>>()

    class FieldPropertyForView<T>(var displayName: String = ""
            //, var fieldName: String = ""
                                  , var getterForView: ValueProvider<T, String>
    )
}


