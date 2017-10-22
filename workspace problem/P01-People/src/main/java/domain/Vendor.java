/*
 * Vendor.java
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
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Vendor extends Role {

	// Constructors -----------------------------------------------------------

	public Vendor() {
	}


	// Attributes -------------------------------------------------------------

	private double	discount;


	@Range(min = 0, max = 100)
	@Digits(integer = 3, fraction = 2)
	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(final double discount) {
		this.discount = discount;
	}

	// Relationships ----------------------------------------------------------

}
