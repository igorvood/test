package hello

import com.vaadin.flow.function.ValueProvider
import com.vaadin.flow.router.Route
import hello.viewAbstract.AbstractGridNew


@Route(value = "mainView9")
class Gridccccccccc(repo: CustomerRepository) : AbstractGridNew<Customer, CustomerRepository>(repo, Customer::class.java) {
    override fun getListColumns(): HashMap<String, FieldPropertyForView<Customer>> {
        val listColumns = super.getListColumns()
        listColumns.put("first val", FieldPropertyForView("first val display", ValueProvider { Customer::getFirstName.toString() }))
        return listColumns
    }
}