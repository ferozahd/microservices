package com.microservices.payments.repositories;

import com.microservices.payments.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByUserName(String username);
}
