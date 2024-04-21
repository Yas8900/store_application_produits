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
import  com.example.demo.models.produit;
import com.example.demo.repositories.productRepository;

@RestController
@RequestMapping("/produits")
public class productcontroller {
@Autowired
private productRepository prodrepo;
@GetMapping("/all")
public List<produit> getAllProducts(){
	return prodrepo.findAll();
}
@GetMapping("/{id}")
public produit getProductById (@PathVariable Long id ) throws ResourceNotFoundException{
	return prodrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("produit ne se trouve pas pour l'id:"+id));
}
@PostMapping("/create")
public produit createproduct (@RequestBody produit prod) {
	return prodrepo.save(prod);
}
@DeleteMapping ("/{id}")
public void deleteproduct  (@PathVariable Long id) {
	prodrepo.deleteById(id);
}
@PutMapping("/updateproduct/{id}")
public produit updateProduit(@PathVariable Long id, @RequestBody produit produit) throws ResourceNotFoundException {
    produit existingProduit = prodrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("produit ne se trouve pas pour l'id:"+id));
    existingProduit.setNom_produit(produit. getNom_produit());
    existingProduit.setDesc_produit(produit. getDesc_produit());
    existingProduit.setPrix(produit.getPrix());
    return prodrepo.save(existingProduit);
}
}

