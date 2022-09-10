package com.sda.j113.spring.repository;

import com.sda.j113.spring.model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Paweł Recław, AmeN
 * @project j113_spring
 * @created 10.09.2022
 */
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
}
