package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.fournisseur;

@Repository
public interface supplierRepository extends JpaRepository<fournisseur , Long> {

}