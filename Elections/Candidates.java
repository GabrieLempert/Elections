package Elections;

public class Candidates extends Citizen {
	private Party partyHeIsRunningFor;
	protected int hisPlaceInTheParty;

	public Candidates(String name, String id, boolean isQuarentied, int yearOfBirth, Party party) {
		super(name, id, isQuarentied, yearOfBirth);
		this.setPartyHeIsRunningFor(party);
		this.hisPlaceInTheParty = 0;
	}

	@Override
	public void setChosenParty(Party chosenParty) {

	}
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return super.toString() + " his political opinion is: " + getPartyHeIsRunningFor().PoliticalOpinion;
	}

	public Party getPartyHeIsRunningFor() {
		return partyHeIsRunningFor;
	}

	public void setPartyHeIsRunningFor(Party partyHeIsRunningFor) {
		this.partyHeIsRunningFor = partyHeIsRunningFor;
	}

}
