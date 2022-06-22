package com.czh.repository;

import com.czh.entity.JiFen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JiFenRepository extends JpaRepository<JiFen, Long> {

    JiFen save(JiFen jiFen);

    JiFen getById(Long id);

    List<JiFen> getByName(String name);

    void deleteById(Long id);

    List<JiFen> findAll();

}
