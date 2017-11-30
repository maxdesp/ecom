package sopra.ecom.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import sopra.ecom.model.Views;



@Entity
public class Commande {
	
	@Id @GeneratedValue()
	@Column(name = "id")
	@JsonView(Views.Common.class)
	private Long id;
	
	@Version
	@JsonView(Views.Common.class)
	private int version;
	
	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	@JsonView(Views.Common.class)
	@Enumerated(EnumType.STRING)
	private Statut statut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
	@JsonView(Views.Common.class)
	private Date dtCommande;
	
	public Date getDtCommande() {
		return dtCommande;
	}

	public void setDtCommande(Date dtCommande) {
		this.dtCommande = dtCommande;
	}

	public List<ProduitCommande> getProduitCommande() {
		return produitCommande;
	}

	public void setProduitCommande(List<ProduitCommande> produitCommande) {
		this.produitCommande = produitCommande;
	}

	@OneToMany(mappedBy = "commande")
	@JsonView(Views.Commande.class)
	private List<ProduitCommande> produitCommande;
	
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}




	@JsonView(Views.Common.class)
	private String numero;
	
	@JsonView(Views.Common.class)
	private String commentaires;
	
	@JsonView(Views.Common.class)
	private double prixTotal;

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}



	}
	