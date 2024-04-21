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
@Entity
@Data
@Table (name="SUPPLIERS")
public class fournisseur {
  @Id
  @GeneratedValue (strategy=GenerationType.IDENTITY)
  @Column (name="supplier_id", nullable=false)
  private Long id_fournisseur;
  @Column (name="supplier_lastname", nullable=false)
  private String nom_fournisseur;
  @Column (name="supplier_firstname", nullable=false)
  private String prenom_fournisseur;
  @Column (name="phone_number", nullable=false)
  private String telephone;
  @Column (name="Email", nullable=false)
  private String email;
  @Column (name="Adress", nullable=false)
  private String adresse_fournisseur;
  @OneToMany (mappedBy="supplier")
  private List<produit> products;
  
  public List<produit> getProducts() {
	return products;
}
public void setProducts(List<produit> products) {
	this.products = products;
}
public fournisseur() {}
public String getNom_fournisseur() {
	return nom_fournisseur;
}
public void setNom_fournisseur(String nom_fournisseur) {
	this.nom_fournisseur = nom_fournisseur;
}
public String getPrenom_fournisseur() {
	return prenom_fournisseur;
}
public void setPrenom_fournisseur(String prenom_fournisseur) {
	this.prenom_fournisseur = prenom_fournisseur;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAdresse_fournisseur() {
	return adresse_fournisseur;
}
public void setAdresse_fournisseur(String adresse_fournisseur) {
	this.adresse_fournisseur = adresse_fournisseur;
}
public fournisseur(String nom_fournisseur, String prenom_fournisseur, String telephone, String email,
      String adresse_fournisseur) {
    super();
    this.nom_fournisseur = nom_fournisseur;
    this.prenom_fournisseur = prenom_fournisseur;
    this.telephone = telephone;
    this.email = email;
    this.adresse_fournisseur = adresse_fournisseur;
  }
  @Override
  public String toString() {
    return "fournisseur [id_fournisseur=" + id_fournisseur + ", nom_fournisseur=" + nom_fournisseur
        + ", prenom_fournisseur=" + prenom_fournisseur + ", telephone=" + telephone + ", email=" + email
        + ", adresse_fournisseur=" + adresse_fournisseur + "]";
  }
  


}
