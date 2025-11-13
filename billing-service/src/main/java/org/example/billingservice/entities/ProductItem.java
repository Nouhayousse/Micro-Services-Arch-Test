package org.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.example.billingservice.model.Product;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class ProductItem {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long productId;
    private int quantity;
    private double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Bill bill;

    @Transient
    private Product product;
}
