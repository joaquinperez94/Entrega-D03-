
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
public abstract class Actor extends DomainEntity {

	// Attributes -------------------------------------------------------------
	private String	name;
	private String	surname;
	private String	email;
	private String	phone;
	private String	address;
	private boolean	activated;


	@NotBlank
	@NotNull
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@NotBlank
	@NotNull
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	@NotNull
	@Email
	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Pattern(regexp = "(^(\\+([0-9]{1}|[0-9]{2}|[0-9]{3})\\(([0-9]{1}|[0-9]{2}|[0-9]{3})\\)([0-9]{4,100}))|(\\+([0-9]{1}|[0-9]{2}|[0-9]{3})\\s([0-9]{4,100}))|(([0-9] {4,100})))$")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public boolean isActivated() {
		return this.activated;
	}

	public void setActivated(final boolean activated) {
		this.activated = activated;
	}


	// Relationships ----------------------------------------------------------

	private Collection<MessageFolder>	messagesFolders;
	private Collection<SocialIdentity>	socialIdentities;
	private UserAccount					userAccount;


	@OneToMany
	@NotNull
	public Collection<MessageFolder> getMessagesFolders() {
		return this.messagesFolders;
	}

	public void setMessagesFolders(final Collection<MessageFolder> messagesFolders) {
		this.messagesFolders = messagesFolders;
	}

	@OneToMany
	@NotNull
	public Collection<SocialIdentity> getSocialIdentities() {
		return this.socialIdentities;
	}

	public void setSocialIdentities(final Collection<SocialIdentity> socialIdentities) {
		this.socialIdentities = socialIdentities;
	}

	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
