package hello;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.HeaderRow;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.SerializablePredicate;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.Route;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//@Route(value = "grid")
public class Grid<T extends Customer, R extends JpaRepository> extends VerticalLayout {
    private final R repo;

    private final AbstractEditor<T, R> editor;

    com.vaadin.flow.component.grid.Grid<T> grid;

    //final TextField filter;

    private final Button addNewBtn;

    public Grid(R repo, AbstractEditor<T, R> editor) {
        this.repo = repo;
        this.editor = editor;
        //this.grid = new com.vaadin.flow.component.grid.Grid<>(Customer.class);
        //createGrid();
        //this.filter = new TextField();
        this.addNewBtn = new Button("Add new ", VaadinIcon.PLUS.create());

        // build layout
        HorizontalLayout actions = new HorizontalLayout(/*filter,*/ addNewBtn);
        add(actions, grid, editor);

        //grid.setHeight("500px");
        //grid.setColumns("id", "firstName", "lastName");
        //grid.setPageSize(2);
        //grid.getColumnByKey("id").setWidth("150px").setFlexGrow(0);

        //filter.setPlaceholder("Filter by last name dsadasdasdas");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        //filter.setValueChangeMode(ValueChangeMode.EAGER);
        //filter.addValueChangeListener(e -> listCustomers(e.getValue()));

        // Connect selected Customer to editor or hide if none is selected
//        grid.asSingleSelect().addValueChangeListener(e -> {
//            editor.editCustomer(e.getValue());
//        });

        // Instantiate and edit new Customer the new button is clicked

//        addNewBtn.addClickListener(e -> editor.editCustomer(new Customer("", "")));

        // Listen changes made by the editor, refresh data from backend
/*
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            //listCustomers(filter.getValue());
        });
*/

        // Initialize listing
        listCustomers(null);
    }

    // tag::listCustomers[]
    void listCustomers(String filterText) {
        if (StringUtils.isEmpty(filterText)) {

            grid.setItems(repo.findAll());
        } else {
            //grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
            //Todo тут подумать как сделать
        }
    }

/*
    void createGrid() {
        grid = new com.vaadin.flow.component.grid.Grid<>();
        ListDataProvider<Customer> dataProvider = new ListDataProvider<>(repo.findAll());
        grid.setDataProvider(dataProvider);

        List<ValueProvider<Customer, String>> valueProviders = new ArrayList<>();
        valueProviders.add(Customer::getFirstName);
        valueProviders.add(person -> person.getLastName());
        valueProviders.add(Customer::getLastName);


        Iterator<ValueProvider<Customer, String>> iterator = valueProviders.iterator();

        grid.addColumn(iterator.next()).setHeader("FirstName");
        grid.addColumn(iterator.next()).setHeader("LastName");
        grid.addColumn(iterator.next()).setHeader("LastName еще один");
        //grid.addColumn(iterator.next()).setHeader("Postal Code");

        HeaderRow filterRow = grid.appendHeaderRow();

        Iterator<ValueProvider<Customer, String>> iterator2 = valueProviders
                .iterator();

        grid.getColumns().forEach(column -> {
            TextField field = new TextField();
            ValueProvider<Customer, String> valueProvider = iterator2.next();

            field.addValueChangeListener(event -> dataProvider
                    .addFilter(//сustomer ->                            StringUtils.containsIgnoreCase(valueProvider.apply(сustomer), field.getValue())
                            new SerializablePredicate<Customer>() {
                                @Override
                                public boolean test(Customer customer) {
                                    System.out.println("public boolean test(Customer customer) {");
                                    return StringUtils.containsIgnoreCase(valueProvider.apply(customer), field.getValue());
                                    //return false;
                                }
                            }
                    )
            );

            field.setValueChangeMode(ValueChangeMode.EAGER);

            filterRow.getCell(column).setComponent(field);
            field.setSizeFull();
            field.setPlaceholder("Filter");
        });

    }
*/

    // end::listCustomers[]

    class ValueChangeListener implements HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<TextField, String>> {
        @Override
        public void valueChanged(AbstractField.ComponentValueChangeEvent<TextField, String> textFieldStringComponentValueChangeEvent) {
            System.out.println(textFieldStringComponentValueChangeEvent.toString());
        }
    }


/*
    void createGrid1() {
        grid = new com.vaadin.flow.component.grid.Grid<>();
        ListDataProvider<Customer> dataProvider = new ListDataProvider<>(repo.findAll());
        grid.setDataProvider(dataProvider);

        List<ValueProvider<Customer, String>> valueProviders = new ArrayList<>();
        valueProviders.add(Customer::getFirstName);
        valueProviders.add(person -> person.getLastName());
        valueProviders.add(Customer::getLastName);


        Iterator<ValueProvider<Customer, String>> iterator = valueProviders.iterator();

        grid.addColumn(iterator.next()).setHeader("FirstName");
        grid.addColumn(iterator.next()).setHeader("LastName");
        grid.addColumn(iterator.next()).setHeader("LastName еще один");
        //grid.addColumn(iterator.next()).setHeader("Postal Code");

        HeaderRow filterRow = grid.appendHeaderRow();

        Iterator<ValueProvider<Customer, String>> iterator2 = valueProviders
                .iterator();

        grid.getColumns().forEach(column -> {
            TextField field = new TextField();
            ValueProvider<Customer, String> valueProvider = iterator2.next();

*/
/*
            field.addValueChangeListener(event -> dataProvider
                    .addFilter(//сustomer ->                            StringUtils.containsIgnoreCase(valueProvider.apply(сustomer), field.getValue())
                            new SerializablePredicate<Customer>() {
                                @Override
                                public boolean test(Customer customer) {
                                    System.out.println("public boolean test(Customer customer) {");
                                    return StringUtils.containsIgnoreCase(valueProvider.apply(customer), field.getValue());
                                    //return false;
                                }
                            }
                    )
            );
*//*


            field.addValueChangeListener(new HasValue.ValueChangeListener<AbstractField.ComponentValueChangeEvent<TextField, String>>() {
                @Override
                public void valueChanged(AbstractField.ComponentValueChangeEvent<TextField, String> textFieldStringComponentValueChangeEvent) {
                    System.out.println("1111" + textFieldStringComponentValueChangeEvent.toString());
                    dataProvider.addFilter(new SerializablePredicate<Customer>() {
                        @Override
                        public boolean test(Customer customer) {
                            System.out.println("public boolean test(Customer customer) {");
                            return StringUtils.containsIgnoreCase(valueProvider.apply(customer), field.getValue());
                        }
                    });
                }
            });

            field.setValueChangeMode(ValueChangeMode.EAGER);

            filterRow.getCell(column).setComponent(field);
            field.setSizeFull();
            field.setPlaceholder("Filter");
        });
    }
*/
}