package sopra.ecom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "produit_commande", uniqueConstraints = @UniqueConstraint(columnNames = { "produit_id", "commande_id" }))
@SequenceGenerator(name="sequenceProduitSpecialite",sequenceName="sequenceProduitSpecialite")
public class ProduitCommande {
	@Id @GeneratedValue(generator="sequenceProduitSpecialite")
	@Column(name="id")
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	@Column(name="version")
	@JsonView(Views.Common.class)
	private int version;
	
	@ManyToOne
	@JoinColumn(name = "produit_id")
	private Produit produit;
	
	@ManyToOne
	@JoinColumn(name = "commande_id")
	@JsonView(Views.ProduitCommande.class)
	private Commande commande;
	
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

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Long getQuantite() {
		return quantite;
	}

	public void setQuantite(Long quantite) {
		this.quantite = quantite;
	}

	public Long getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(Long prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	@Column(name="quantite")
	@JsonView(Views.Common.class)
	private Long quantite;
	
	@Column(name="prix_nitaire")
	@JsonView(Views.Common.class)
	private Long prixUnitaire;
	
	
}
