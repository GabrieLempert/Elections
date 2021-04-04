package Elections;

public class Citizen {
	protected String name;
	protected String id;
	protected boolean isQuarentied;
	private boolean isDressed;
	protected int yearOfBirth;
	protected BallotBox ballotBox;
	private Party chosenParty;

	public Citizen(String name, String id, boolean isQuarentied, int yearOfBirth) {
		this.name = name;
		this.id = setId(id);
		this.isQuarentied = isQuarentied;
		this.yearOfBirth = yearOfBirth;
		this.ballotBox = null;
		this.chosenParty=null;
	}

	public String setId(String id) {
		if (id.length() == 9) {
			return id;
		} else {
			System.out.println("id is not correct");
		}
		return null;

	}

	public Citizen(Citizen copyCitizen) {
		this.name = copyCitizen.name;
		this.id = setId(copyCitizen.id);
		this.isQuarentied = copyCitizen.isQuarentied;
		this.yearOfBirth = copyCitizen.yearOfBirth;
		this.ballotBox = copyCitizen.ballotBox;
	}

	@Override
	public boolean equals(Object obj) {
		if (getClass().equals(obj.getClass())) {
			Citizen temp = (Citizen) obj;
			return temp.id == this.id;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Citizen name is : " + name + ", is id :" + id + ", is he quarentied: " + isQuarentied
				+ ", is he dressed proparly " + isDressed() + ", he was born in:  " + yearOfBirth + ", he votes in: "
				+ ballotBox;
	}

	public boolean isDressed() {
		return isDressed;
	}

	public void setDressed(boolean isDressed) {
		this.isDressed = isDressed;
	}

	public Party getChosenParty() {
		return chosenParty;
	}

	public void setChosenParty(Party chosenParty) {
		this.chosenParty = chosenParty;
	}

}
