package sopra.ecom.trash;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "resource")
// @IdClass(RessourceId.class)
public class Ressource {
	// @Id
	// private String type;
	// @Id
	// private String code;
	@EmbeddedId
	@JsonView(Views.Common.class)
	private RessourceId id;
	@Version
	@JsonView(Views.Common.class)
	private int version;
	@JsonView(Views.Common.class)
	private boolean electrique;
	@JsonView(Views.Common.class)
	private Float poids;
	@OneToOne
	@JoinColumn(name="student_id")
	@JsonView(Views.Ressource.class)
	private Eleve eleve;

	public Ressource() {
		super();
	}

	public Ressource(Type type, String code) {
		super();
		this.id = new RessourceId(type, code);
	}

	// public String getType() {
	// return type;
	// }
	//
	// public void setType(String type) {
	// this.type = type;
	// }
	//
	// public String getCode() {
	// return code;
	// }
	//
	// public void setCode(String code) {
	// this.code = code;
	// }

	public RessourceId getId() {
		return id;
	}

	public void setId(RessourceId id) {
		this.id = id;
	}
	
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public boolean isElectrique() {
		return electrique;
	}

	public void setElectrique(boolean electrique) {
		this.electrique = electrique;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

}
