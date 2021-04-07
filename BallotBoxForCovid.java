package Elections;

public class BallotBoxForCovid extends BallotBox {
	public BallotBoxForCovid(String address) {
		super(address);
	}

	public BallotBoxForCovid(BallotBox b) {
		super(b);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public void copyAndMultiplyVoters() {
		// TODO Auto-generated method stub
		super.copyAndMultiplyVoters();
	}
	@Override
	public int voteCounter(Party electionParty) {
		return super.voteCounter(electionParty);
	}
	@Override
	public boolean addCitizen(Citizen newCitizen) {
		for (int i = 0; i < numberOfVoters; i++) {
			if (newCitizen.equals(ballotBoxVoters[i])) {
				return false;
			}
		}
			if (newCitizen.isQuarentied && newCitizen.isDressed() == true) {
				if (equals(newCitizen.ballotBox)) {
					if (votesCounter == ballotBoxVoters.length) {
						copyAndMultiplyVoters();
					}
					this.ballotBoxVoters[numberOfVoters] = newCitizen;
				this.numberOfVoters++;
					return true;
				}
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\nThis ballot is for citizens that are quarinted";
	}
}
