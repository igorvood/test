package hello;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private Long id;

    @ViewColumn(displayName = "firstName_1")
    private String firstName;

    @ViewColumn(displayName = "lastName_колонка")
    private String lastName;

    @ViewColumn(displayName = "salary_колонка")
    private Integer salary;

    @ViewColumn(displayName = "salary_колонка")
    private Date deteBirth;

    @ViewColumn(displayName = "Тип колонка")
    @ManyToOne
    private TypeCustomer typeCustomer;

    @ViewColumn(displayName = "Женат")
    private boolean married;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getDeteBirth() {
        return deteBirth;
    }

    public void setDeteBirth(Date deteBirth) {
        this.deteBirth = deteBirth;
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }
}