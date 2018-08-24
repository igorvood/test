package ru.vood.test;

/*
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
*/
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
public class TypeCustomer {
    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private BigDecimal id;


    @ViewColumn(displayName = "Код")
    private String code;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
