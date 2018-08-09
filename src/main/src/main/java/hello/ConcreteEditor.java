package hello;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class ConcreteEditor extends AbstractEditor<Customer, CustomerRepository> {

    public ConcreteEditor(CustomerRepository repository) {
        super(Customer.class, repository);
    }
}
