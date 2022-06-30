package com.czh.service;

import com.czh.entity.JiFen;
import com.czh.repository.JiFenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JiFenService {

    public JiFenRepository jiFenRepository;

    public JiFenService(JiFenRepository jiFenRepository) {
        this.jiFenRepository = jiFenRepository;
    }

    public JiFen save(JiFen jiFen) {
        return jiFenRepository.save(jiFen);
    }

    public JiFen getJiFenById(Long id) {
        return jiFenRepository.getById(id);
    }

    public void delById(Long id) {
        jiFenRepository.deleteById(id);
    }

    public List<JiFen> findAll() {
        return jiFenRepository.findAll();
    }
}
