package sopra.ecom.trash;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "module_classroom", uniqueConstraints = @UniqueConstraint(columnNames = { "module_id", "classroom_id" }))
public class ModuleFormation {
	@Id
	@GeneratedValue
	@JsonView(Views.Common.class)
	private Long id;
	@Version
	@JsonView(Views.Common.class)
	private int version;
	@ManyToOne
	@JoinColumn(name = "module_id")
	@JsonView({ Views.Formation.class, Views.ModuleFormation.class })
	private Module module;
	@ManyToOne
	@JoinColumn(name = "classroom_id")
	@JsonView({ Views.Module.class, Views.ModuleFormation.class })
	private Formation formation;

	public ModuleFormation() {
		super();
	}

	public ModuleFormation(Module module, Formation formation) {
		super();
		this.module = module;
		this.formation = formation;
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

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
