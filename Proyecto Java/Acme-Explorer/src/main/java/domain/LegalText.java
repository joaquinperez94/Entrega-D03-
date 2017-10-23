
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class LegalText extends DomainEntity {

	// Attributes -------------------------------------------------------------

	private String	title;
	private String	body;
	private int		lawsNumber;
	private Date	moment;
	private boolean	draftMode;


	@NotBlank
	@NotNull
	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		//if (this.draftMode == true)
		this.title = title;
	}

	@NotBlank
	@NotNull
	public String getBody() {
		return this.body;
	}

	public void setBody(final String body) {
		//if (this.draftMode == true)
		this.body = body;
	}

	public int getLawsNumber() {
		return this.lawsNumber;
	}

	public void setLawsNumber(final int lawsNumber) {
		//if (this.draftMode == true)
		this.lawsNumber = lawsNumber;
	}
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		//if (this.draftMode == true)
		this.moment = moment;
	}

	public boolean isDraftMode() {
		return this.draftMode;
	}

	public void setDraftMode(final boolean draftMode) {
		this.draftMode = draftMode;
	}

	// Relationships ----------------------------------------------------------

}
