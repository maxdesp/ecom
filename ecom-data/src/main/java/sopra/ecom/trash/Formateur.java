package sopra.ecom.trash;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends Personne {
	private Integer experience;
	private Set<Eleve> eleves = new HashSet<>();

	public Formateur() {
		super();
	}

	@JsonView(Views.Common.class)
	public Integer getExperience() {
		return experience;
	}	

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	@OneToMany(mappedBy = "formateur")
	@JsonView(Views.FormateurWithEleves.class)
	public Set<Eleve> getEleves() {
		return eleves;
	}

	public void setEleves(Set<Eleve> eleves) {
		this.eleves = eleves;
	}

}
