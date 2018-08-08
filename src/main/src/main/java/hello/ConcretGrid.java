package hello;

import com.vaadin.flow.router.Route;

@Route(value = "gg")
public class ConcretGrid extends AbstractGrid<Customer, CustomerRepository> {

    public ConcretGrid(CustomerRepository repo, CustomerEditor editor) {
        super(repo, editor, Customer.class);
    }
}
