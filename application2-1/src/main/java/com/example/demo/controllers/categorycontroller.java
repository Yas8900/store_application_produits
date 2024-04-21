package com.example.demo.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ResourceNotFoundException;
import  com.example.demo.models.categorie;
import com.example.demo.repositories.categoryRepository;

@RestController
@RequestMapping("/categories")
public class categorycontroller {
@Autowired
private categoryRepository catrepo;
@GetMapping("/all")
public List<categorie> getAllcategorie(){
	return catrepo.findAll();
}
@GetMapping("/{id}")
public categorie getcategorietById (@PathVariable Long id ) throws ResourceNotFoundException{
	return catrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("categorie ne se trouve pas pour l'id:"+id));
}
@PostMapping("/create")
public categorie createproduct (@RequestBody categorie cat) {
	return catrepo.save(cat);
}
@DeleteMapping ("/{id}")
public void deleteproduct  (@PathVariable Long id) {
	catrepo.deleteById(id);
}
@PutMapping("/{id}")
public categorie updateProduit(@PathVariable Long id, @RequestBody categorie cat) throws ResourceNotFoundException {
    categorie existingcategorie = catrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("categorie  ne se trouve pas pour l'id:"+id));
    existingcategorie.setNom(cat.getNom());
    existingcategorie.setDescription(cat.getDescription());
    return catrepo.save(existingcategorie);
}
}
