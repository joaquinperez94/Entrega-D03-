
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Note extends DomainEntity {

	//----------------------------Atibuttes----------------------------------------

	private Date	createdMoment;
	private int		remark;
	private String	reply;
	private Date	replyMoment;


	@NotNull
	@Past
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreatedMoment() {
		return this.createdMoment;
	}

	public int getRemark() {
		return this.remark;
	}

	@NotBlank
	public String getReply() {
		return this.reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	@Past
	@Temporal(TemporalType.TIMESTAMP)
	public Date getReplyMoment() {
		return this.replyMoment;
	}

	public void setReplyMoment(Date replyMoment) {
		this.replyMoment = replyMoment;
	}


	//---------------------------Relationships--------------------------------------------------

	private Trip	trip;
	private Auditor	auditor;


	@ManyToOne(optional = false)
	@Valid
	@NotNull
	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	@ManyToOne(optional = false)
	@Valid
	@NotNull
	public Auditor getAuditor() {
		return this.auditor;
	}

	public void setAuditor(Auditor auditor) {
		this.auditor = auditor;
	}

}
