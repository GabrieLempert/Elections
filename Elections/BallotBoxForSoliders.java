package Elections;

public class BallotBoxForSoliders extends BallotBox {

	public BallotBoxForSoliders(String address) {
		super(address);
	}

	public BallotBoxForSoliders(BallotBox b) {
		super(b);
	}

	@Override
	public boolean addCitizen(Citizen newCitizen) {
		if (newCitizen instanceof Soliders) {
			super.addCitizen(newCitizen);
			return true;
		}
		return false;
	}
}
