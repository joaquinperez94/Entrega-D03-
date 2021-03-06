
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Tool extends DomainEntity {

	private String	name;
	private Integer	verMayor;
	private Integer	verMin;


	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}
	@Min(0)
	public Integer getVerMayor() {
		return this.verMayor;
	}

	public void setVerMayor(final Integer verMayor) {
		this.verMayor = verMayor;
	}
	@Min(0)
	public Integer getVerMin() {
		return this.verMin;
	}

	public void setVerMin(final Integer verMin) {
		this.verMin = verMin;
	}


	// Relationships ----------------------------------------------------------
	private Collection<License>	licenses;


	@OneToMany(mappedBy = "tool")
	public Collection<License> getLicenses() {
		return this.licenses;
	}

	public void setLicenses(final Collection<License> licenses) {
		this.licenses = licenses;
	}

}
