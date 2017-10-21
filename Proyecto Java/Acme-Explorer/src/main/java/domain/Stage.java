
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Stage extends DomainEntity {

	// Attributes -------------------------------------------------------------
	private String	title;
	private String	description;
	private double	price;
	private double	iva;


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

	public double getPrice() {
		return this.price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public double getIva() {
		return this.iva;
	}

	public void setIva(final double iva) {
		this.iva = iva;
	}

	@Transient
	public double getTotalPrice() {
		return this.price + (this.price * this.iva);
	}


	// Relationships ----------------------------------------------------------

	private Trip	trip;


	@ManyToOne(optional = false)
	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(final Trip trip) {
		this.trip = trip;
	}

}
