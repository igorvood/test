package hello;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private Long id;

    @ViewColumn(displayName = "firstName_1")
    private String firstName;

    @ViewColumn(displayName = "lastName_колонка")
    private String lastName;

    @ViewColumn(displayName = "Тип колонка")
    @ManyToOne
    private TypeCustomer typeCustomer;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, TypeCustomer typeCustomer) {
        this(firstName,lastName );
        this.typeCustomer = typeCustomer;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }

}