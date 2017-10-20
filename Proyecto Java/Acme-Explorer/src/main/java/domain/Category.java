
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Category extends DomainEntity {

	// Attributes -------------------------------------------------------------

	private String	name;


	@NotBlank
	@NotNull
	@Column(unique = true)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//-----------------------------Relationships-----------------------------

	private Collection<Category>	childrens;
	private Collection<Trip>		trips;


	@ManyToMany
	@Valid
	public Collection<Category> getChildrens() {
		return this.childrens;
	}

	public void setChildrens(Collection<Category> childrens) {
		this.childrens = childrens;
	}

	@ManyToMany
	@Valid
	public Collection<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(Collection<Trip> trips) {
		this.trips = trips;
	}

}