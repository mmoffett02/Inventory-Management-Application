package com.example.demo.service;

import com.example.demo.domain.Part;

import java.util.List;

public interface PartService {
    List<Part> findAll();

    List<Part> listAll(String keyword);

    Part findById(long theId);

    void save(Part thePart);

    void deleteById(long theId);  // Ensure this method signature matches
}
