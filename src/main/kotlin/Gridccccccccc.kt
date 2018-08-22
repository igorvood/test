package hello

import com.vaadin.flow.component.dependency.HtmlImport
import com.vaadin.flow.function.ValueProvider
import com.vaadin.flow.router.Route
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import hello.viewAbstract.AbstractGridNew

@HtmlImport("styles.html")
@Theme(Lumo::class)
@Route(value = "mainView9")
class Gridccccccccc(repo: CustomerRepository) : AbstractGridNew<Customer, CustomerRepository>(repo, Customer::class.java) {
    override fun getListColumns(): HashMap<String, FieldPropertyForView<Customer>> {
        val listColumns = super.getListColumns()
        listColumns.put("first val", FieldPropertyForView("first val display", ValueProvider { Customer::getFirstName.toString() }))
        return listColumns
    }
}