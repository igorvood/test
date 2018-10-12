package ru.vood.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vood.amdWeb.util.EntityInterface;
import ru.vood.amdWeb.util.annotation.ViewColumn;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer implements EntityInterface {
    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private BigDecimal id;


    @ViewColumn(displayName = "Код")
    private String code;

}
