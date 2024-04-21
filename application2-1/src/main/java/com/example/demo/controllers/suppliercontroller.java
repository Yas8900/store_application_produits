package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ResourceNotFoundException;
import com.example.demo.models.fournisseur;
import com.example.demo.repositories.supplierRepository;

@RestController
@RequestMapping("/fournisseurs") 
public class suppliercontroller {

    @Autowired
    private supplierRepository supplierRepository;

    @GetMapping("/all")
    public List<fournisseur> getAllFournisseurs() {
        return supplierRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<fournisseur> getFournisseurById(@PathVariable Long id) throws ResourceNotFoundException {
        fournisseur fournisseur = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur introuvable pour l'ID : " + id));
        return ResponseEntity.ok(fournisseur);
    }

    @PostMapping("/create")
    public ResponseEntity<fournisseur> createFournisseur( @RequestBody fournisseur fournisseur) {
        fournisseur savedFournisseur = supplierRepository.save(fournisseur);
        return new ResponseEntity<>(savedFournisseur, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long id) {
        supplierRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<fournisseur> updateFournisseur(@PathVariable Long id, @RequestBody fournisseur fournisseur) throws ResourceNotFoundException {
        fournisseur existingFournisseur = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fournisseur introuvable pour l'ID : " + id));

        existingFournisseur.setNom_fournisseur(fournisseur.getNom_fournisseur());
        existingFournisseur.setPrenom_fournisseur(fournisseur.getPrenom_fournisseur());
        existingFournisseur.setTelephone(fournisseur.getTelephone());
        existingFournisseur.setEmail(fournisseur.getEmail());
        existingFournisseur.setAdresse_fournisseur(fournisseur.getAdresse_fournisseur());
        fournisseur updatedFournisseur = supplierRepository.save(existingFournisseur);
        return ResponseEntity.ok(updatedFournisseur);
    }
}
