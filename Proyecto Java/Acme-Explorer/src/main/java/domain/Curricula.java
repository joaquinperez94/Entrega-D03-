
package domain;

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

	private PersonalRecord		personalRecord;
	private EducationRecord		educationRecords;
	private ProfessionalRecord	profesionalRecords;
	private EndorserRecord		endorseRecords;
	private MiscellaneousRecord	miscellaneousRecords;


	@OneToOne(optional = false)
	@NotNull
	@Valid
	public PersonalRecord getPersonalRecord() {
		return this.personalRecord;
	}

	public void setPersonalRecord(final PersonalRecord personalRecord) {
		this.personalRecord = personalRecord;
	}
	@OneToMany
	public EducationRecord getEducationRecords() {
		return this.educationRecords;
	}

	public void setEducationRecords(final EducationRecord educationRecords) {
		this.educationRecords = educationRecords;
	}

	@OneToMany
	public ProfessionalRecord getProfesionalRecords() {
		return this.profesionalRecords;
	}

	public void setProfesionalRecords(final ProfessionalRecord profesionalRecords) {
		this.profesionalRecords = profesionalRecords;
	}

	@OneToMany
	public EndorserRecord getEndorseRecords() {
		return this.endorseRecords;
	}

	public void setEndorseRecords(final EndorserRecord endorseRecords) {
		this.endorseRecords = endorseRecords;
	}

	@OneToMany
	public MiscellaneousRecord getMiscellaneousRecords() {
		return this.miscellaneousRecords;
	}

	public void setMiscellaneousRecords(final MiscellaneousRecord miscellaneousRecords) {
		this.miscellaneousRecords = miscellaneousRecords;
	}

}
