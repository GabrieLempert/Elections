package Elections;

public class BallotBox {

	protected int serialNumber;
	protected static int serialCounter = 1000;
	protected String address;
	protected Citizen[] ballotBoxVoters;
	protected int numberOfVoters;
	protected int votesCounter;

	public BallotBox(BallotBox b) {
		this.serialNumber = b.getSerialNumber();
		this.address = b.address;
		this.ballotBoxVoters = b.ballotBoxVoters;
		this.votesCounter = b.votesCounter;

	}

	public BallotBox(String address) {
		this.serialNumber = serialCounter++;
		this.ballotBoxVoters = new Citizen[20];
		this.address = address;
		this.votesCounter = 0;
	}

	public void copyAndMultiplyVoters() {
		Citizen[] temp = new Citizen[this.ballotBoxVoters.length * 2];
		for (int i = 0; i < this.ballotBoxVoters.length; i++) {
			temp[i] = this.ballotBoxVoters[i];
		}
		this.ballotBoxVoters = temp;
		System.out.println("the array is doubled");
	}

	public boolean addCitizen(Citizen newCitizen) {
		for (int i = 0; i < numberOfVoters; i++) {
			if (newCitizen.equals(ballotBoxVoters[i])) {
				return false;
			}
			if (equals(newCitizen.ballotBox) && newCitizen.isQuarentied == false) {
				if (votesCounter == ballotBoxVoters.length) {
					copyAndMultiplyVoters();
				}
				ballotBoxVoters[numberOfVoters++] = newCitizen;
				return true;
			}
		}
		return false;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public int voteCounter(Party electionParty) {
		int counter = 0;
		for (int i = 0; i < votesCounter; i++) {
			if (ballotBoxVoters[i].getChosenParty().equals(electionParty)) {
				counter++;
			}
		}

		System.out.println("This party got " + counter + " votes in this ballot");
		return counter;

	}

	public double votersPracentage() {
		double votersPracentage = votesCounter / numberOfVoters;
		return votersPracentage * 100;

	}

	@Override
	public boolean equals(Object obj) {
		if (getClass().equals(obj.getClass())) {
			BallotBox temp = (BallotBox) obj;
			return temp.serialNumber == serialNumber;
		}
		return false;
	}

	@Override
	public String toString() {
		return "BallotBox serialNumber: " + serialNumber + "\nThe address is " + address
				+ "\nNumber of people that voted" + votesCounter;
	}

}
