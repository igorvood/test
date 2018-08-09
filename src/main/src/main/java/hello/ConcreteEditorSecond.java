package hello;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class ConcreteEditorSecond extends AbstractEditor<CustomerSecond, CustomerSecondRepository>{

    public ConcreteEditorSecond(CustomerSecondRepository repository) {
        super(CustomerSecond.class, repository);
    }
}