package Elections;

import java.util.Scanner;

public class Elections {
	Scanner sc = new Scanner(System.in);
	private int monthOfElection;
	private int yearOfElection;
	private Citizen[] voters;
	private Party[] parties;
	private BallotBox[] ballotBoxes;
	private int citizenCounter;
	private int ballotBoxCounter;
	private int partyCounter;

	public Elections(int yearOfElection, int monthOfElection) {
		this.monthOfElection = monthOfElection;
		this.yearOfElection = yearOfElection;
		this.voters = new Citizen[20];
		this.ballotBoxes = new BallotBox[20];
		this.parties = new Party[10];
	}

	public void copyAndMultiplyParty() {
		Party[] temp = new Party[this.getParties().length * 2];
		for (int i = 0; i < this.getParties().length; i++) {
			temp[i] = this.getParties()[i];
		}
		this.parties = temp;
		System.out.println("the array is doubled");
	}

	public void copyAndMultiplyVoters() {
		Citizen[] temp = new Citizen[this.getVoters().length * 2];
		for (int i = 0; i < this.getVoters().length; i++) {
			temp[i] = this.getVoters()[i];
		}
		this.voters = temp;
		System.out.println("the array is doubled");
	}

	public void copyAndMultiplyBallotBox() {
		BallotBox[] temp = new BallotBox[this.getBallotBoxes().length * 2];
		for (int i = 0; i < this.getBallotBoxes().length; i++) {
			temp[i] = this.getBallotBoxes()[i];
		}
		this.ballotBoxes = temp;
		System.out.println("the array is doubled");
	}

	public boolean addCitizens(Citizen c) {
		if (this.getYearOfElection() - c.yearOfBirth >= 18) {
			if (citizenCounter == getVoters().length) {
				copyAndMultiplyVoters();
			}
			for (int i = 0; i < citizenCounter; i++) {
				if (c.equals(getVoters()[i])) {
					System.out.println("This citizen already exists");
					return false;
				}
			}
			if (this.getYearOfElection() - c.yearOfBirth <= 21) {
				getVoters()[citizenCounter++] = new Soliders(c);
				System.out.println("You added a citizen that is a soldier");
				return true;
			} else {
				getVoters()[citizenCounter++] = new Citizen(c);
			}

		} else {
			System.out.println("Error!,you are not at the age to vote");
		}
		return false;

	}

	public boolean addParty(Party p) {
		for (int i = 0; i < getPartyCounter(); i++) {
			if (p.equals(getParties()[i])) {
				return false;
			}
		}
		if (getPartyCounter() == getParties().length) {
			copyAndMultiplyParty();
		}
		getParties()[partyCounter++] = p;
		return true;
	}

	public Party parrtySelector(int numberOfParty) {
		for (int i = 0; i < getPartyCounter(); i++) {
			if (getParties()[numberOfParty - 1].equals(getParties()[i])) {
				getParties()[numberOfParty - 1].numOfVoters = +1;
				return getParties()[numberOfParty - 1];
			}

		}
		return null;
	}

	public void results() {
		System.out.println("The results are: ");
		int selectedIndex = 0;
		for (int i = 0; i < ballotBoxCounter; i++) {
			System.out.println("This ballotbox results are: " + getBallotBoxes()[i]);
			for (int j = 0; j < partyCounter; j++) {
				System.out.println(getBallotBoxes()[i].voteCounter(getParties()[j]) + "" + getParties()[j].name);
			}
		}
		for (int i = 0; i < partyCounter; i++) {
			System.out.println("The party- " + parties[i]);
			if (parties[i].numOfVoters > parties[selectedIndex].numOfVoters) {
				selectedIndex = i;
			}
			System.out.println("The party that won is: " + parties[selectedIndex]);
		}

	}

	public void showPartiesForElection() {
		for (int i = 0; i < partyCounter; i++) {
			System.out.println("Party number " + (i + 1) + " is: " + getParties()[i].name);
		}

	}

	public int getMonthOfElection() {
		return monthOfElection;
	}

	public int getYearOfElection() {
		return yearOfElection;
	}

	public int getCitizenCounter() {
		return citizenCounter;
	}

	public int getBallotBoxCounter() {
		return ballotBoxCounter;
	}

	public int getPartyCounter() {
		return partyCounter;
	}

	public Citizen[] getVoters() {
		return voters;
	}

	public BallotBox[] getBallotBoxes() {
		return ballotBoxes;
	}

	public boolean addCandidate(Candidates newCandidate, Party candidateParty) {
		for (int i = 0; i < citizenCounter; i++) {
			if (voters[i].equals(newCandidate)) {
				System.out.println("You can not create this candidate because there is a citizen with the same id");
				return false;
			}
		}
		for (int i = 0; i < partyCounter; i++) {
			if (candidateParty.equals(getParties()[i])) {
				for (int j = 0; j < candidateParty.numOfCandidates; j++) {
					if (candidateParty.candidates[j].equals(newCandidate)) {
						System.out.println("You can not add a candidate to two parties");
						return false;
					}
				}
				getParties()[i].candidates[newCandidate.hisPlaceInTheParty] = newCandidate;
				return true;
			}

		}
		return false;
	}

	public void votersToEachBallotBox() {
		for (int i = 0; i < ballotBoxCounter; i++) {
			for (int j = 0; j < citizenCounter; j++) {
				if (getBallotBoxes()[i].equals(getVoters()[j].ballotBox)) {
					getBallotBoxes()[i].addCitizen(getVoters()[j]);
				}
			}
		}
	}

	public void voteToBallotBox(int voter) {
		for (int i = 0; i < ballotBoxCounter; i++) {
			if (getBallotBoxes()[i].equals(getVoters()[voter].ballotBox)) {
				getBallotBoxes()[i].votesCounter = +1;
			}
		}
	}

	public void addBallotBox(BallotBox b, int choice) {
		if (getBallotBoxCounter() == getBallotBoxes().length) {
			copyAndMultiplyBallotBox();
		}
		switch (choice) {
		case 1:
			getBallotBoxes()[ballotBoxCounter++] = new BallotBox(b);
			System.out.println("You added a normal ballot");
			break;
		case 2: {
			getBallotBoxes()[ballotBoxCounter++] = new BallotBoxForCovid(b);
			System.out.println("You added a Covid ballot");
			break;
		}
		case 3: {
			getBallotBoxes()[ballotBoxCounter++] = new BallotBoxForSoliders(b);
			System.out.println("You added a Soldier ballot");

			break;
		}

		default:
			System.out.println("you didn't choose any option, goodbye!");

			break;
		}
	}

	public void addBallotBoxToCitizen(Citizen voter) {

		if (this.yearOfElection - voter.yearOfBirth <= 21) {
			while (voter.ballotBox == null) {
				int random = (int) (Math.random() * ballotBoxCounter);
				if (ballotBoxes[random] instanceof BallotBoxForSoliders) {
					voter.ballotBox = ballotBoxes[random];
				}
			}
		} else if (voter.isQuarentied == true) {
			while (voter.ballotBox == null) {
				int random = (int) (Math.random() * ballotBoxCounter);
				if (ballotBoxes[random] instanceof BallotBoxForCovid) {
					voter.ballotBox = ballotBoxes[random];
				}

			}
		} else {
			while (voter.ballotBox == null) {
				int random = (int) (Math.random() * ballotBoxCounter);
				if (!(ballotBoxes[random] instanceof BallotBoxForCovid)
						&& !(ballotBoxes[random] instanceof BallotBoxForSoliders)) {
					voter.ballotBox = ballotBoxes[random];
				}
			}
		}

	}

	public Party[] getParties() {
		return parties;
	}

	public void showBallotBoxes() {
		for (int i = 0; i < ballotBoxCounter; i++) {
			System.out.println("ballot box number " + (i + 1) + " - " + ballotBoxes[i]);
		}
	}

	public void showCitizens() {
		for (int i = 0; i < this.citizenCounter; i++) {
			System.out.println("Citizen number " + (i + 1) + " - " + voters[i]);
		}

	}

	public void showParties() {
		for (int i = 0; i < partyCounter; i++) {
			System.out.println(parties[i]);
		}

	}

}
