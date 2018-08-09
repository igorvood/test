package hello;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@Route(value = "gg2")
public class ConcreteGridSecond extends AbstractGrid<CustomerSecond, CustomerSecondRepository> {

    public ConcreteGridSecond(CustomerSecondRepository repo, ConcreteEditorSecond editor) {
        super(repo, editor, CustomerSecond.class);
    }

/*
    @SpringComponent
    @UIScope
    public class ConcreteEditorSecond extends AbstractEditor<CustomerSecond, CustomerSecondRepository>{

        public ConcreteEditorSecond(CustomerSecondRepository repository) {
            super(CustomerSecond.class, repository);
        }
    }
*/
}