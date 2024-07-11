package com.upc.tp_yapay.Repository;

import com.upc.tp_yapay.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
