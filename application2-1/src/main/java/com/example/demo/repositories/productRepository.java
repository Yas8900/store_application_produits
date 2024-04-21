package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.produit;

@Repository
public interface productRepository extends JpaRepository <produit , Long> {

}