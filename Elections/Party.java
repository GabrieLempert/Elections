package Elections;

import java.time.LocalDate;

public class Party {
	protected enum PoliticalOpinion {
		RIGHT, LEFT, CENTER;
	}

	protected String name;
	protected PoliticalOpinion PoliticalOpinion;
	protected LocalDate dateOfEstablishment;
	protected Candidates[] candidates;
	protected int numOfCandidates;
	protected int numOfVoters;

	public Party(String name, PoliticalOpinion politicalOpinion) {
		this.name = name;
		this.PoliticalOpinion = politicalOpinion;
		this.dateOfEstablishment = LocalDate.now();
		this.candidates = new Candidates[20];
		this.numOfCandidates = 0;
		this.numOfVoters = 0;
	}

	public void copyAndMultiplyCandidate() {
		Candidates[] temp = new Candidates[this.candidates.length * 2];
		for (int i = 0; i < this.candidates.length; i++) {
			temp[i] = this.candidates[i];
		}
		this.candidates = temp;
		System.out.println("the array is doubled");
	}

	public boolean addCandidate(Candidates newCandidate) {
		if (numOfCandidates == candidates.length) {
			copyAndMultiplyCandidate();
		}
		for (int i = 0; i < numOfCandidates; i++) {
			if (newCandidate.equals(candidates[i])) {
				return false;
			}
		}
		if (this.getClass().getName().equalsIgnoreCase(newCandidate.getPartyHeIsRunningFor().name)) {
			numOfCandidates++;
			newCandidate.hisPlaceInTheParty = (int) (Math.random() * numOfCandidates);
			candidates[newCandidate.hisPlaceInTheParty] = newCandidate;
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass().equals(obj.getClass())) {
			Party temp = (Party) obj;
			return temp.name == this.name;
		}
		return false;
	}

	@Override
	public String toString() {

		return "The political opinion of the party is: " + PoliticalOpinion + "The number of votes:\n " + numOfVoters;
	}

}
