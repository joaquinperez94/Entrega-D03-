
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Explorer extends Actor {

	// Attributes -------------------------------------------------------------

	// Relationships ----------------------------------------------------------
	private Collection<Class>				classes;
	private Collection<Story>				stories;
	private Collection<ApplicationFor>		applicationsFor;
	private Collection<ContactEmergency>	contactsEmergency;


	@NotNull
	@ManyToMany
	public Collection<Class> getClasses() {
		return this.classes;
	}

	public void setClasses(final Collection<Class> classes) {
		this.classes = classes;
	}

	@NotNull
	@OneToMany(mappedBy = "explorer")
	public Collection<Story> getStories() {
		return this.stories;
	}

	public void setStories(final Collection<Story> stories) {
		this.stories = stories;
	}

	@NotNull
	@OneToMany(mappedBy = "explorer")
	public Collection<ApplicationFor> getApplicationsFor() {
		return this.applicationsFor;
	}

	public void setApplicationsFor(final Collection<ApplicationFor> applicationsFor) {
		this.applicationsFor = applicationsFor;
	}

	@NotNull
	@ManyToMany
	public Collection<ContactEmergency> getContactsEmergency() {
		return this.contactsEmergency;
	}

	public void setContactsEmergency(final Collection<ContactEmergency> contactsEmergency) {
		this.contactsEmergency = contactsEmergency;
	}
}
