package ru.vood.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vood.amdWeb.util.EntityInterface;
import ru.vood.amdWeb.util.annotation.ViewColumn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements EntityInterface {
    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private BigDecimal id;

    @ViewColumn(displayName = "firstName_1")
    private String firstName;

    @ViewColumn(displayName = "lastName_колонка")
    private String lastName;

    @ViewColumn(displayName = "salary_колонка")
    private Integer salary;

    @ViewColumn(displayName = "dateBirth колонка")
    private Date dateBirth;

    @ViewColumn(displayName = "Тип колонка")
    @ManyToOne
    private TypeCustomer typeCustomer;

    @ViewColumn(displayName = "Женат")
    private boolean married;

}