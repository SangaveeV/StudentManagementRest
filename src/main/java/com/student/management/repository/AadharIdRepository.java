package com.student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.management.model.AadharId;

@Repository
public interface AadharIdRepository extends JpaRepository<AadharId, Integer> {

}
