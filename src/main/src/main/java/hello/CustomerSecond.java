package hello;

import javax.persistence.Entity;

@Entity
public class CustomerSecond extends Customer {

    @ViewColumn(displayName = "DateBirth колонка")
    private String dateBirth;

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }
}
