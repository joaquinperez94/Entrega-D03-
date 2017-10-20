
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
public class Manager extends Actor {

	private boolean	suspicious;


	public boolean isSuspicious() {
		return this.suspicious;
	}

	public void setSuspicious(final boolean suspicious) {
		this.suspicious = suspicious;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Class>			clas;
	private Collection<Trip>			trip;
	private Collection<ApplicationFor>	applicationFor;


	@ManyToMany(mappedBy = "manager")
	public Collection<Class> getClas() {
		return this.clas;
	}

	public void setClas(final Collection<Class> clas) {
		this.clas = clas;
	}

	@ManyToMany(mappedBy = "manager")
	public Collection<Trip> getTrip() {
		return this.trip;
	}

	public void setTrip(final Collection<Trip> trip) {
		this.trip = trip;
	}

	@NotNull
	@OneToMany(mappedBy = "manager")
	public Collection<ApplicationFor> getApplicationFor() {
		return this.applicationFor;
	}

	public void setApplicationFor(final Collection<ApplicationFor> applicationFor) {
		this.applicationFor = applicationFor;
	}

}
