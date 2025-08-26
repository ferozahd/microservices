package com.microservices.sales.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(
            name = "customer_seq",              // sequence generator name
            sequenceName = "customer_id_seq",   // actual database sequence name
            allocationSize = 1                  // important for postgres (avoid gaps)
    )
    private Long id;
    private String userName;
    private Long numberOfProducts;
    private String shopName;
    private String shopAddress;

}
