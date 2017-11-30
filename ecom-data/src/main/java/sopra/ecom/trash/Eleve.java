package sopra.ecom.trash;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SecondaryTable(name = "student_lazy")
@DiscriminatorValue("Eleve")
public class Eleve extends Personne {
	private Date dtNaissance;
	private String commentaires;
	private byte[] photo;
	private Ressource ressource;
	private Formateur formateur;
	private List<Module> modules = new ArrayList<>();

	public Eleve() {
		super();
	}

	public Eleve(String nom, String prenom) {
		super(nom, prenom);
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonView(Views.Common.class)
	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	@Basic
	@Column(name = "age")
	public Integer getAge() {
		if (dtNaissance == null) {
			return null;
		}
		Date dtJour = new Date();
		return dtJour.getYear() - dtNaissance.getYear();
	}

	public void setAge(Integer age) {

	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtcreate", updatable = false)
	@JsonView(Views.Common.class)
	public Date getDtCreation() {
		return new Date();
	}

	public void setDtCreation(Date dtCreation) {

	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "comments", table = "student_lazy")
	@JsonView(Views.Common.class)
	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "picture", table = "student_lazy")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@OneToOne(mappedBy = "eleve", fetch = FetchType.EAGER)
	@JsonView(Views.Eleve.class)
	public Ressource getRessource() {
		return ressource;
	}

	public void setRessource(Ressource ressource) {
		this.ressource = ressource;
	}

	@ManyToOne
	@JoinColumn(name = "trainer_id")
	@JsonView(Views.Eleve.class)
	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@ManyToMany(mappedBy = "eleves", fetch = FetchType.LAZY)
	@JsonView(Views.EleveWithModules.class)
	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

}
