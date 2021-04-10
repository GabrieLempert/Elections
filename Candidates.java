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
		super.setChosenParty(chosenParty);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public Candidates(Citizen copyCandidate) {
		super(copyCandidate);

	}

	@Override
	public String toString() {
		if (this.partyHeIsRunningFor != null) {
			return super.toString() + "\nhis political opinion is:\n " + getPartyHeIsRunningFor().PoliticalOpinion
					+ "\nHis place in the party is:\n " + (hisPlaceInTheParty + 1);
		} else {
			return super.toString() + "\nHe is a Candidate";
		}
	}

	public Party getPartyHeIsRunningFor() {
		return partyHeIsRunningFor;
	}

	public void setPartyHeIsRunningFor(Party partyHeIsRunningFor) {
		this.partyHeIsRunningFor = partyHeIsRunningFor;
	}


}
