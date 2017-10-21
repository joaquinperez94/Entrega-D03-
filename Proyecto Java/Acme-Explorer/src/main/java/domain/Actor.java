
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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

	public void setName(String name) {
		this.name = name;
	}

	@NotBlank
	@NotNull
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActivated() {
		return this.activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Message>		messagesSend;
	private Collection<Message>		messagesRecieve;
	private Collection<UserAccount>	usersAccounts;


	@NotNull
	@ManyToMany
	public Collection<Message> getMessagesSend() {
		return this.messagesSend;
	}

	public void setMessagesSend(Collection<Message> messagesSend) {
		this.messagesSend = messagesSend;
	}

	@NotNull
	@ManyToMany
	public Collection<Message> getMessagesRecieve() {
		return this.messagesRecieve;
	}

	public void setMessagesRecieve(Collection<Message> messagesRecieve) {
		this.messagesRecieve = messagesRecieve;
	}

	@NotNull
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<UserAccount> getUsersAccounts() {
		return this.usersAccounts;
	}

	public void setUsersAccounts(Collection<UserAccount> usersAccounts) {
		this.usersAccounts = usersAccounts;
	}
}
