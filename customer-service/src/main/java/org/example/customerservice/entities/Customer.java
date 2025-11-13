package org.example.customerservice.entities;


import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity

public class Customer extends BaseEntity {

    private String name;
    private String email;
    private String phone;

    public Customer(String name, String email, String phone) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    public Customer() {
    }
}
