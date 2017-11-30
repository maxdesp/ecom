package sopra.ecom.trash;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Module {
	@Id
	@GeneratedValue
	@JsonView(Views.Common.class)
	private Long id;
	@Version
	@JsonView(Views.Common.class)
	private int version;
	@Column(name = "name", length = 100)
	@JsonView(Views.Common.class)
	private String nom;
	@Column(name = "duration")
	@JsonView(Views.Common.class)
	private Integer duree;
	@ManyToMany
	@JoinTable(name = "module_student", joinColumns = @JoinColumn(name = "module_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	private List<Eleve> eleves = new ArrayList<>();
	@OneToMany(mappedBy = "module")
	@JsonView({Views.ModuleWithFormations.class})
	private List<ModuleFormation> formations = new ArrayList<>();

	public Module() {
		super();
	}

	public Module(String nom, Integer duree) {
		super();
		this.nom = nom;
		this.duree = duree;
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

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public List<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}

	public void addEleve(Eleve eleve) {
		this.eleves.add(eleve);
	}

	public void removeEleve(Eleve eleve) {
		this.eleves.remove(eleve);
	}

	public List<ModuleFormation> getFormations() {
		return formations;
	}

	public void setFormations(List<ModuleFormation> formations) {
		this.formations = formations;
	}

}
