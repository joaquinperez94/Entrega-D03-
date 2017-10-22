
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Class extends DomainEntity {

	// Attributes -------------------------------------------------------------
	private String	title;
	private String	description;
	private Date	organisedMoment;
	private GPS		location;


	@NotNull
	@NotBlank
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	@NotNull
	@NotBlank
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getOrganisedMoment() {
		return this.organisedMoment;
	}

	public void setOrganisedMoment(final Date organisedMoment) {
		this.organisedMoment = organisedMoment;
	}

	@NotNull
	@NotBlank
	public GPS getLocation() {
		return this.location;
	}

	public void setLocation(final GPS location) {
		this.location = location;
	}


	// Relationships ----------------------------------------------------------

	private Manager					manager;
	private Trip					trip;
	private Collection<Explorer>	explorers;


	@ManyToMany
	public Collection<Explorer> getExplorers() {
		return this.explorers;
	}

	public void setExplorers(final Collection<Explorer> explorers) {
		this.explorers = explorers;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(final Manager manager) {
		this.manager = manager;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(final Trip trip) {
		this.trip = trip;
	}

}
