package Elections;

public class BallotBoxForSoliders extends BallotBox {

	public BallotBoxForSoliders(String address) {
		super(address);
	}

	public BallotBoxForSoliders(BallotBox b) {
		super(b);
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int voteCounter(Party electionParty) {
		return super.voteCounter(electionParty);
	}

	@Override
	public boolean addCitizen(Citizen newCitizen) {
		if (newCitizen instanceof Soliders) {
			super.addCitizen(newCitizen);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + "\nThis ballot is for cizitens that are soldiers";
	}
}
