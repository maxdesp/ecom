package sopra.ecom.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.ecom.model.Utilisateur;
import sopra.ecom.model.Views;

@Entity
@Table(name="client", catalog="ecom")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Client {
	private Long id;
	private int version;
	private String nom;
	private String prenom;
	private String numero;
	private String courriel;
	private String telephone;



	public Client(String nom, String prenom, String numero, String courriel, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numero = numero;
		this.courriel = courriel;
		this.telephone = telephone;
	}

	private Utilisateur utilisateur;
	private Adresse adrFacturation;
//	private Adresse adrExpedition;
	
	@Embedded
	@JsonView(Views.Common.class)
	public Adresse getAdrFacturation() {
		return adrFacturation;
	}


	public void setAdrFacturation(Adresse adrFacturation) {
		this.adrFacturation = adrFacturation;
	}
//
//	@Embedded
//	@JsonView(Views.Client.class)
//	public Adresse getAdrExpedition() {
//		return adrExpedition;
//	}
//
//
//	public void setAdrExpedition(Adresse adrExpedition) {
//		this.adrExpedition = adrExpedition;
//	}


	@OneToOne
	@JoinColumn(name="utilisateur_id")
	@JsonView(Views.ClientUtilisateur.class)
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	
	@Column(name="numero", length=100)
	@JsonView(Views.Common.class)
	public String getNumero() {
		return numero;
	}
	

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name="courriel", length=100)
	@JsonView(Views.Common.class)
	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}
	@Column(name="telephone", length=100)
	@JsonView(Views.Common.class)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Client() {
		super();
	}

	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	@JsonView(Views.Common.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Version
	@JsonView(Views.Common.class)
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name="lastname", length=100)
	@JsonView(Views.Common.class)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="firstname", length=100)
	@JsonView(Views.Common.class)
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
