package hello;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeCustomer {
    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private Long id;


    @ViewColumn(displayName = "Код")
    private String code;

}
