package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.categorie;

@Repository
public interface categoryRepository extends JpaRepository<categorie , Long> {

}
