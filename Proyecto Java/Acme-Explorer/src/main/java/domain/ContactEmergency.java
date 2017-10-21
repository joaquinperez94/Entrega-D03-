
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class ContactEmergency extends DomainEntity {

	// Attributes -------------------------------------------------------------

	private String	name;
	private String	email;
	private String	phone;


	@NotBlank
	@NotNull
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Email
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Pattern(regexp = "(^(\\+([0-9]{1}|[0-9]{2}|[0-9]{3})\\(([0-9]{1}|[0-9]{2}|[0-9]{3})\\)([0-9]{4,100}))|(\\+([0-9]{1}|[0-9]{2}|[0-9]{3})\\s([0-9]{4,100}))|(([0-9] {4,100})))$")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	//Relationships-------------------------------------------------------------------------------------
	private Collection<Explorer>	explorers;


	@Valid
	@ManyToMany
	public Collection<Explorer> getExplorers() {
		return this.explorers;
	}

	public void setExplorers(Collection<Explorer> explorers) {
		this.explorers = explorers;
	}

}
