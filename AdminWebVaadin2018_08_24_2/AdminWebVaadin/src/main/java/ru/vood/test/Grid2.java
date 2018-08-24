package ru.vood.test;

import com.vaadin.flow.router.Route;
import org.jetbrains.annotations.NotNull;
import ru.vood.amdWeb.util.abstraction.AbstractGrid;

import java.util.HashMap;

@Route(value = "mainView8")
public class Grid2 extends AbstractGrid<Customer, CustomerRepository> {
    public Grid2(@NotNull CustomerRepository repo) {
        super(repo, Customer.class);
    }


    @NotNull
    @Override
    public HashMap<String, AbstractGrid.FieldPropertyForView<Customer>> getListColumns() {
        final HashMap<String, AbstractGrid.FieldPropertyForView<Customer>> mapColumns = super.getListColumns();
        mapColumns.put("first val"
                , new AbstractGrid.FieldPropertyForView<>("first val display", customer ->
                        customer.getLastName()
                ));
        mapColumns.put("first val2"
                , new AbstractGrid.FieldPropertyForView<>("first val display2", customer ->
                        customer.getFirstName()
                ));

        //listColumns.put("first val", FieldPropertyForView("first val display", ValueProvider { Customer::getFirstName.toString() }))
        return mapColumns;
    }

}
