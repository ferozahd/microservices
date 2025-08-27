package com.microservices.payments.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    @SequenceGenerator(
            name = "payment_seq",              // sequence generator name
            sequenceName = "payment_id_seq",   // actual database sequence name
            allocationSize = 1                  // important for postgres (avoid gaps)
    )
    private Long id;
    private String userName;
    private Long amount;
    private LocalDateTime paymentAt;
    private String shopName;
    private String shopAddress;
}
