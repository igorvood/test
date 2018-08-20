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

}