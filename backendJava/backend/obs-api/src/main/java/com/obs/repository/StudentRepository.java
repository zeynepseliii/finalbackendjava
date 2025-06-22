package com.obs.repository;

import com.obs.entity.EntityStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<EntityStudent, Long> {
}
