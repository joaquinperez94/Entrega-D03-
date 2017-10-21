
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Access(AccessType.PROPERTY)
public class Curricula extends DomainEntity {

	// Attributes -------------------------------------------------------------

	private String	ticker;


	@Column(unique = true)
	@NotNull
	@Pattern(regexp = "^[0-9]{2}(0[1-9]{1}|1[0-2]{1})((0|1|2)[0-9]{1}|3[0-1]{1})\\-[A-Z]{4}$")
	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(final String ticker) {
		this.ticker = ticker;
	}


	// Relationships ----------------------------------------------------------

	private PersonalRecord					personalRecord;
	private Collection<EducationRecord>		educationRecords;
	private Collection<ProfessionalRecord>	profesionalRecords;
	private Collection<EndorserRecord>		endorseRecords;
	private Collection<MiscellaneousRecord>	miscellaneousRecords;


	@OneToOne(optional = false)
	@NotNull
	@Valid
	public PersonalRecord getPersonalRecord() {
		return this.personalRecord;
	}

	public void setPersonalRecord(final PersonalRecord personalRecord) {
		this.personalRecord = personalRecord;
	}
	@NotNull
	@OneToMany
	public Collection<EducationRecord> getEducationRecords() {
		return this.educationRecords;
	}

	public void setEducationRecords(final Collection<EducationRecord> educationRecords) {
		this.educationRecords = educationRecords;
	}
	@NotNull
	@OneToMany
	public Collection<ProfessionalRecord> getProfesionalRecords() {
		return this.profesionalRecords;
	}

	public void setProfesionalRecords(final Collection<ProfessionalRecord> profesionalRecords) {
		this.profesionalRecords = profesionalRecords;
	}
	@NotNull
	@OneToMany
	public Collection<EndorserRecord> getEndorseRecords() {
		return this.endorseRecords;
	}

	public void setEndorseRecords(final Collection<EndorserRecord> endorseRecords) {
		this.endorseRecords = endorseRecords;
	}
	@NotNull
	@OneToMany
	public Collection<MiscellaneousRecord> getMiscellaneousRecords() {
		return this.miscellaneousRecords;
	}

	public void setMiscellaneousRecords(final Collection<MiscellaneousRecord> miscellaneousRecords) {
		this.miscellaneousRecords = miscellaneousRecords;
	}

}
