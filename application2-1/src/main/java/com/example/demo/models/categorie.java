package com.example.demo.models;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table (name="CATEGORY")
public class categorie {
  @Id
  @GeneratedValue (strategy=GenerationType.IDENTITY)
  @Column (name="category_id", nullable=false)
  private Long id_categorie;
  @Column (name="category_name", nullable=false)
  private String nom;
  @Column (name="category_descrription", nullable=false)
  private String description;
 @OneToMany (mappedBy="category")
 private List<produit> products;
public List<produit> getProducts() {
	return products;
}
public void setProducts(List<produit> products) {
	this.products = products;
}
public categorie() {}
public categorie(Long id_categorie, String nom, String description) {
	super();
	this.id_categorie = id_categorie;
	this.nom = nom;
	this.description = description;
}
public Long getId_categorie() {
	return id_categorie;
}
public void setId_categorie(Long id_categorie) {
	this.id_categorie = id_categorie;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}