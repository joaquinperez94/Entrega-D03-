
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

public class ApplicationFor extends DomainEntity {

	// Attributes -------------------------------------------------------------
	private Date				moment;
	private String				status;
	private Collection<String>	comments;
	private String				reasonWhy;
	private CreditCard			creditCard;


	@NotNull
	@Past
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	@NotNull
	@Pattern(regexp = "^((PENDING)|(REJECTED)|(DUE)|(ACCEPTED)|(CANCELLED))$")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	@ElementCollection
	public Collection<String> getComments() {
		return this.comments;
	}

	public void setComments(final Collection<String> comments) {
		this.comments = comments;
	}

	public String getReasonWhy() {
		return this.reasonWhy;
	}
	public void setReasonWhy(final String reasonWhy) {
		this.reasonWhy = reasonWhy;
	}

	@CreditCardNumber
	@Valid
	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(final CreditCard creditCard) {
		this.creditCard = creditCard;
	}


	//Relationships------------------------------------------------------------
	private Explorer	explorer;
	private Manager		manager;
	private Trip		trip;


	@Valid
	@ManyToOne(optional = false)
	public Explorer getExplorer() {
		return this.explorer;
	}

	public void setExplorer(Explorer explorer) {
		this.explorer = explorer;
	}

	@Valid
	@ManyToOne(optional = true)
	public Manager getManager() {
		return this.manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Valid
	@ManyToOne(optional = false)
	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}
