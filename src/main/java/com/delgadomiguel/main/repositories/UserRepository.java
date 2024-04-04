package com.delgadomiguel.main.repositories;

import com.delgadomiguel.main.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
