package hello;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "gg")
public class ConcreteGrid extends AbstractGrid<Customer, CustomerRepository> {

    public ConcreteGrid(CustomerRepository repo, ConcreteEditor editor) {
        super(repo, editor, Customer.class);
    }

/*
    @SpringComponent
    @UIScope
    public static class ConcreteEditor extends AbstractEditor<Customer, CustomerRepository> {

        public ConcreteEditor(CustomerRepository repository) {
            super(Customer.class, repository);
        }
    }
*/
}
