/*
 * Person.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Access(AccessType.PROPERTY)
public class Person extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Person() {
	}


	// Attributes -------------------------------------------------------------

	private String	name;
	private Date	birthDate;


	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(final Date birthDate) {
		this.birthDate = birthDate;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Role>	roles;


	@NotEmpty
	@Valid
	@OneToMany(cascade = CascadeType.ALL)
	public Collection<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(final Collection<Role> roles) {
		this.roles = roles;
	}

}
