package sopra.ecom.trash;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "classroom")
public class Formation {
	@Id
	@GeneratedValue
	@JsonView(Views.Common.class)
	private Long id;
	@Version
	@JsonView(Views.Common.class)
	private int version;
	@Column(length = 100, unique = true)
	@JsonView(Views.Common.class)
	private String promotion;
	@Temporal(TemporalType.DATE)
	@Column(name = "startdate")
	@JsonView(Views.Common.class)
	private Date dtDebut;
	@OneToMany(mappedBy = "formation")
	@JsonView(Views.FormationWithModules.class)
	private List<ModuleFormation> modules = new ArrayList<>();

	public Formation() {
		super();
	}

	public Formation(String promotion, Date dtDebut) {
		super();
		this.promotion = promotion;
		this.dtDebut = dtDebut;
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

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Date getDtDebut() {
		return dtDebut;
	}

	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}

	@OneToMany(mappedBy = "formation")
	public List<ModuleFormation> getModules() {
		return modules;
	}

	public void setModules(List<ModuleFormation> modules) {
		this.modules = modules;
	}

}
