package ru.vood.test

import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.function.ValueProvider
import com.vaadin.flow.router.Route
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import ru.vood.amdWeb.util.abstraction.AbstractGrid


@HtmlImport("styles.html")
@Theme(Lumo::class)
@Route(value = "mainView9")
class Gridccccccccc(repo: CustomerRepository) : AbstractGrid<Customer, CustomerRepository>(repo, Customer::class.java) {
    override fun getListColumns(): HashMap<String, AbstractGrid.FieldPropertyForView<Customer>> {
        val listColumns = super.getListColumns()
        listColumns.put("first val", AbstractGrid.FieldPropertyForView("first val display", ValueProvider { Customer::getFirstName.toString() }))
        return listColumns
    }
}