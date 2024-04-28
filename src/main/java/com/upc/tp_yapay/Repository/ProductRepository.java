package com.upc.tp_yapay.Repository;

import com.upc.tp_yapay.Entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products,Long> {
}
