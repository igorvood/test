package ru.vood.test.test1;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.jetbrains.annotations.NotNull;
import ru.vood.amdWeb.util.abstraction.AbstractEditorKT;
import ru.vood.test.Customer;
import ru.vood.test.CustomerRepository;

@SpringComponent
@UIScope
public class TestEditorJava1 extends AbstractEditorKT<Customer, CustomerRepository> {
    public TestEditorJava1(@NotNull CustomerRepository repository) {
        super(Customer.class, repository);
    }
}
