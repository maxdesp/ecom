package sopra.ecom.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
public class Produit {
	
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public List<ProduitCommande> getProduitCommandes() {
		return produitCommandes;
	}

	public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
		this.produitCommandes = produitCommandes;
	}


	@OneToMany(mappedBy = "produit")
	@JsonView(Views.ProduitCommande.class)
	private List<ProduitCommande> produitCommandes; 
	
	@Id
	@GeneratedValue
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	@Column(name = "designation", length = 100)
	@JsonView(Views.Common.class)
	private String designation;
	
	@Column(name = "stock")
	@JsonView(Views.Common.class)
	private Long stock;
	
	@Column(name = "prix")
	@JsonView(Views.Common.class)
	private Double prix;

	@Column(name = "description")
	@JsonView(Views.Common.class)
	private String description;
	
	@Column(name = "image")
	@JsonView(Views.Common.class)
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	@JsonView(Views.Common.class)
	private Categorie categorie;
	
//	
//	@ManyToMany
//	@JoinTable(name = "module_student", joinColumns = @JoinColumn(name = "module_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
//	private List<Eleve> eleves = new ArrayList<>();
//	
//	@OneToMany(mappedBy = "module")
//	@JsonView({Views.ModuleWithFormations.class})
//	private List<ModuleFormation> formations = new ArrayList<>();

	public Produit() {
		super();
	}

	public Produit(String nom, Long stock) {
		super();
		this.designation = nom;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}



}
