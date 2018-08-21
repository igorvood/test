package hello;

import com.vaadin.flow.router.Route;
import hello.viewAbstract.AbstractGridNew;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

@Route(value = "mainView8")
public class Grid2 extends AbstractGridNew<Customer, CustomerRepository> {
    public Grid2(@NotNull CustomerRepository repo) {
        super(repo, Customer.class);
    }

/*
    @NotNull
    @Override
    public HashMap<String, FieldPropertyForView<Customer>> getListColumns() {
        final HashMap<String, FieldPropertyForView<Customer>> mapColumns = super.getListColumns();
        mapColumns.put("first val"
                , new FieldPropertyForView<>("first val display", customer ->
                        customer.getLastName()
                ));
        mapColumns.put("first val2"
                , new FieldPropertyForView<>("first val display2", customer ->
                        customer.getFirstName()
                ));

        //listColumns.put("first val", FieldPropertyForView("first val display", ValueProvider { Customer::getFirstName.toString() }))
        return mapColumns;
    }
*/
}
