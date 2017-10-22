
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@Access(AccessType.PROPERTY)
public class Auditor extends Actor {

	// Attributes -------------------------------------------------------------

	//Relationships------------------------------------------------------------
	private Collection<AuditRecord>	auditRecords;
	private Collection<Note>		notes;


	@OneToMany(mappedBy = "auditor")
	public Collection<AuditRecord> getAuditRecords() {
		return this.auditRecords;
	}

	public void setAuditRecords(Collection<AuditRecord> auditRecords) {
		this.auditRecords = auditRecords;
	}

	@OneToMany(mappedBy = "auditor")
	public Collection<Note> getNotes() {
		return this.notes;
	}

	public void setNotes(Collection<Note> notes) {
		this.notes = notes;
	}
}
