package com.upc.tp_yapay.Repository;

import com.upc.tp_yapay.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
