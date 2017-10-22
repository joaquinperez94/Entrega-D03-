
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
import javax.validation.constraints.Pattern;

@Entity
@Access(AccessType.PROPERTY)
public class Message extends DomainEntity {

	// Attributes -------------------------------------------------------------

	private Date	moment;
	private String	subject;
	private String	body;
	private String	priority;


	@Past
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@NotNull
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	@NotNull
	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@NotNull
	@Pattern(regexp = "^((HIGH)|(NEUTRAL)|(LOW))$")
	public String getPriority() {
		return this.priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}


	// Relationships ----------------------------------------------------------

	private MessageFolder	messageFolder;
	private Actor			sender;
	private Actor			recipient;


	@NotNull
	@ManyToOne(optional = false)
	@Valid
	public MessageFolder getMessageFolder() {
		return this.messageFolder;
	}

	public void setMessageFolder(MessageFolder messageFolder) {
		this.messageFolder = messageFolder;
	}

	@NotNull
	@ManyToOne(optional = false)
	@Valid
	public Actor getSender() {
		return this.sender;
	}

	public void setSender(Actor sender) {
		this.sender = sender;
	}

	@NotNull
	@ManyToOne(optional = false)
	@Valid
	public Actor getRecipient() {
		return this.recipient;
	}

	public void setRecipient(Actor recipient) {
		this.recipient = recipient;
	}

}
