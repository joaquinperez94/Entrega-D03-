
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Manager extends Actor {

	// Attributes -------------------------------------------------------------
	private boolean	suspicious;


	public boolean isSuspicious() {
		return this.suspicious;
	}

	public void setSuspicious(final boolean suspicious) {
		this.suspicious = suspicious;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Trip>			trips;
	private Collection<ApplicationFor>	applicationsFor;


	@NotNull
	@OneToMany(mappedBy = "manager")
	public Collection<Trip> getTrips() {
		return this.trips;
	}

	public void setTrip(final Collection<Trip> trips) {
		this.trips = trips;
	}

	@NotNull
	@OneToMany(mappedBy = "manager")
	public Collection<ApplicationFor> getApplicationsFor() {
		return this.applicationsFor;
	}

	public void setApplicationFor(final Collection<ApplicationFor> applicationsFor) {
		this.applicationsFor = applicationsFor;
	}

}
