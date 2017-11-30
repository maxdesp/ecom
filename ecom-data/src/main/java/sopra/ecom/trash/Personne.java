package sopra.ecom.trash;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType=DiscriminatorType.STRING, length=15)
public abstract class Personne {
	private Long id;
	private int version;
	private String nom;
	private String prenom;
	
	
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

	private String numero;
	private String courriel;
	private String telephone;

	public Personne() {
		super();
	}

	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	@Id
	@GeneratedValue
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
