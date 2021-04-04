package Elections;

public class Soliders extends Citizen {

	public Soliders(String name, String id, boolean isQuarentied, int yearOfBirth, Party party,
			boolean isVoted) {
		super(name, id, isQuarentied, yearOfBirth);
	}

	public Soliders(Citizen copyCitizen) {
		super(copyCitizen);
	}
	@Override
	public String toString() {
		return super.toString() + " " + getClass().getSimpleName();

	}

}
