package com.example.demo.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table (name="PRODUITS")
public class produit{
 
@Id
  @GeneratedValue (strategy=GenerationType.IDENTITY)
  @Column (name="product_id", nullable=false)
  private Long id_produit;
  @Column (name="product_name", nullable=false)
  private String nom_produit;
  @Column (name="desc_product", nullable=false)
  private String desc_produit;
  @Column (name="brand", nullable=false)
  private String marque;
  @Column (name="price", nullable=false)
  private float prix;
  @Column (name="Quantity", nullable=false)
  private int product_quantity;
  @ManyToOne
  private categorie category;
  @ManyToOne
  private fournisseur supplier;
  public categorie getCategory() {
	return category;
}
public void setCategory(categorie category) {
	this.category = category;
}
public fournisseur getSupplier() {
	return supplier;
}
public void setSupplier(fournisseur supplier) {
	this.supplier = supplier;
}
public produit() {
	
}

  public produit(String nom_produit, String desc_produit, String marque, float prix, int quantite_produit) {
    super();
    this.nom_produit = nom_produit;
    this.desc_produit = desc_produit;
    this.marque = marque;
    this.prix = prix;
    this.product_quantity = quantite_produit;
  }
  public Long getId_produit() {
		return id_produit;
	}
	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public String getDesc_produit() {
		return desc_produit;
	}
	public void setDesc_produit(String desc_produit) {
		this.desc_produit = desc_produit;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getProduct_quantity() {
		return product_quantity;
	}
	public void setProduct_quantity(int product_quantity) {
		this.product_quantity = product_quantity;
	}
  
}
