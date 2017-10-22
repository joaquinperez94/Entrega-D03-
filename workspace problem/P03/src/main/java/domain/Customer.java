
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends DomainEntity {

	private String	name;


	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}


	// Relationships ----------------------------------------------------------
	private Collection<License>	licenses;


	@OneToMany(mappedBy = "customer")
	public Collection<License> getLicenses() {
		return this.licenses;
	}

	public void setLicenses(final Collection<License> licenses) {
		this.licenses = licenses;
	}

}
