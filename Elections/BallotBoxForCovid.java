package Elections;

public class BallotBoxForCovid extends BallotBox {
	public BallotBoxForCovid(String address) {
		super(address);
	}

	public BallotBoxForCovid(BallotBox b) {
		super(b);
	}

	@Override
	public boolean addCitizen(Citizen newCitizen) {
		if (newCitizen.isQuarentied && newCitizen.isDressed() == true) {
			super.addCitizen(newCitizen);
			return true;
		} else {
			System.out.println("You cannot vote! in this ballot!");
			return false;
		}
	}
}
