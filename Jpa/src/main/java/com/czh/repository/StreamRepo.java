package com.czh.repository;

import com.czh.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamRepo extends JpaRepository<Student, Long> {
}
