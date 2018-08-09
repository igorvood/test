package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeCustomer {
    @Id
    @GeneratedValue
    //@ViewColumn(displayName = "id_1")
    private Long id;

    @ViewColumn(displayName = "Код")
    private String code;

    public TypeCustomer() {
    }

    public TypeCustomer(String code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "TypeCustomer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
