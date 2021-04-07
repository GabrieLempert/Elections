package Elections;

public class Soliders extends Citizen {

	public Soliders(String name, String id, boolean isQuarentied, int yearOfBirth, Party party,
			boolean isVoted) {
		super(name, id, isQuarentied, yearOfBirth);
	}

	@Override
	public void setChosenParty(Party chosenParty) {
		super.setChosenParty(chosenParty);
	}

	public Soliders(Citizen copyCitizen) {
		super(copyCitizen);
	}
	@Override
	public String toString() {
		return super.toString() + "And he is a " + getClass().getSimpleName();

	}

}
