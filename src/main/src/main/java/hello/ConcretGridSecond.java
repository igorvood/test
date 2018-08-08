package hello;

import com.vaadin.flow.router.Route;

@Route(value = "gg2")
public class ConcretGridSecond extends AbstractGrid<CustomerSecond, CustomerSecondRepository> {

    public ConcretGridSecond(CustomerSecondRepository repo, CustomerEditor editor) {
        super(repo, editor, CustomerSecond.class);
    }
}