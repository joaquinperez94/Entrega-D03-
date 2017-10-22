/*
 * Customer.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@Access(AccessType.PROPERTY)
public class Customer extends Role {

	// Constructors -----------------------------------------------------------

	public Customer() {
	}


	// Attributes -------------------------------------------------------------

	private int	numberOfOrdersPaid;


	@Min(0)
	public int getNumberOfOrdersPaid() {
		return this.numberOfOrdersPaid;
	}

	public void setNumberOfOrdersPaid(final int numberOfOrdersPaid) {
		this.numberOfOrdersPaid = numberOfOrdersPaid;
	}

	// Relationships ----------------------------------------------------------

}
