package com.upc.tp_yapay.Repository;

import com.upc.tp_yapay.Entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {
}
