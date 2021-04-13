package id_206215311_id_207497561;

import java.util.Scanner;

import id_206215311_id_207497561.Party.PoliticalOpinion;

public class ElectionsSave {
	protected Elections[] electionSaver;
	int numberOfElections;

	ElectionsSave() {
		this.electionSaver = new Elections[20];
		this.numberOfElections = 0;
	}

	public void copyAndMultiplyElections() {
		Elections[] temp = new Elections[this.numberOfElections * 2];
		for (int i = 0; i < this.numberOfElections; i++) {
			temp[i] = this.electionSaver[i];
		}
		this.electionSaver = temp;
		System.out.println("the array is doubled");
	}

	public boolean addElections(Elections newElections) {
		for (int i = 0; i < numberOfElections; i++) {
			if (newElections.equals(electionSaver[i])) {
				return false;
			}
		}
		if (numberOfElections == electionSaver.length) {
			copyAndMultiplyElections();
		}
		electionSaver[numberOfElections] = newElections;
		numberOfElections++;
		return true;
	}

	static Scanner sc = new Scanner(System.in);

	// addPartyCase
	public Party addPartyCase() {
		System.out.println("Your party name: ");
		String name = sc.nextLine();
		System.out.println("Choose your political opinion: ");
		System.out.println("1.RIGHT");
		System.out.println("2.CENTER");
		System.out.println("3.LEFT");
		PoliticalOpinion temp = null;
		int key = sc.nextInt();
		while (key > 3 || key < 1) {
			System.out.println("There is no such option Enter again between 1-3: ");
			key = sc.nextInt();
		}
		switch (key) {
		case 1:
			temp = PoliticalOpinion.RIGHT;
			break;
		case 2:
			temp = PoliticalOpinion.CENTER;
			break;
		case 3:
			temp = PoliticalOpinion.LEFT;
			break;

		default:
			System.out.println("There is no such option choose again: ");
			key = sc.nextInt();
			break;
		}
		Party newParty = new Party(name, temp);
		return newParty;

	}

	// addBallotBoxCase
	public int Choice() {
		System.out.println("Choose which ballot you want to add: ");
		System.out.println("Number 1: Regular ballotbox");
		System.out.println("Number 2: Covid ballotbox");
		System.out.println("Number 3: Soldiers ballotbox");
		System.out.println("Enter your choice must be between 1-3: ");
		int choice = sc.nextInt();
		while (choice > 3 || choice < 1) {
			System.out.println("choose again number between 1-3: ");
			choice = sc.nextInt();
		}
		return choice;
	}

	public BallotBox addBallotBoxCase() {
		System.out.println("Input address:");
		String address = sc.nextLine();
		BallotBox b = new BallotBox(address);
		return b;
	}

	// addCitizenCase-2
	public Citizen addCitizenCase() {
		System.out.println("Add your name: ");
		String name = sc.nextLine();
		System.out.println("Add your id: ");
		String id = sc.next();
		checkId(id);
		sc.nextLine();
		System.out.println("Add if you are ill with corona: ");
		boolean isQuarineted = sc.nextBoolean();
		System.out.println("Add you year of birth: ");
		int yearOfBirth = sc.nextInt();
		Citizen newCitizen = new Citizen(name, id, isQuarineted, yearOfBirth);
		if (isQuarineted == true) {
			System.out.println("If you are quarinted you have to be dressed right-Do you have a protective outfit?: ");
			System.out.println("Choose '1' if you have, choose '2' if you don't: ");
			int temp = sc.nextInt();
			boolean isDressed;
			while (temp > 2 || temp < 1) {
				System.out.println("wrong option choose again: ");
				temp = sc.nextInt();
			}
			switch (temp) {
			case 1:
				isDressed = true;
				newCitizen.setDressed(isDressed);
				break;
			case 2:
				isDressed = false;
				newCitizen.setDressed(isDressed);
				break;
			}
		}
		return newCitizen;

	}

	// idChecker(for user input);
	public static void checkId(String id) {
		boolean checkId = true;
		int counter = 0;
		for (int i = 0; i < id.length(); i++) {
			if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
				counter++;
			}
		}
		if (counter != 9) {
			checkId = false;
		}

		while (id.length() != 9 || checkId == false) {
			if (checkId == false) {
				counter = 0;
				for (int i = 0; i < id.length(); i++) {
					if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
						counter++;
					}
				}
				if (counter == 9) {
					checkId = true;
				} else {
					System.out.println("You only can have digits in your id");
					System.out.println("Enter again: ");
					id = sc.next();
				}
			} else if (id.length() < 9) {
				System.out.println("You didn't enter enough numbers you miss -" + (9 - id.length()) + "numbers");
				System.out.println("Enter again: ");
				id = sc.next();
			} else if (id.length() > 9) {
				System.out.println("You entered to much numbers " + (id.length()));
				System.out.println("Enter again: ");
				id = sc.next();

			}
		}

	}

	public void electionsConducter(Elections elections) {

		elections.votersToEachBallotBox();
		elections.electionsCleaner();
		for (int i = 0; i < elections.getCitizenCounter(); i++) {
			System.out.println(elections.getVoters()[i].name + "- id -" + elections.getVoters()[i].id);
			System.out.println("Do you want to vote?");
			System.out.println("Choose Yes/No");
			String temp = sc.next();
			while ((!temp.equalsIgnoreCase("yes")) && (!temp.equalsIgnoreCase("no"))) {
				System.out.println("There is no such option choose again YES/NO");
				temp = sc.next();
			}
			if (temp.equalsIgnoreCase("no")) {
				Party blankParty = new Party("Blank", PoliticalOpinion.CENTER);
				elections.getVoters()[i].setChosenParty(blankParty);
				System.out.println("Thank you goodbye!");

			}
			if (temp.equalsIgnoreCase("yes")) {
				elections.showPartiesForElection();
				elections.voteToBallotBox(i);
				int temp1 = sc.nextInt();
				while (temp1 > elections.getPartyCounter() || temp1 < 0) {
					System.out.println("There is no such option choose again: ");
					temp1 = sc.nextInt();
				}
				elections.getVoters()[i].setChosenParty(elections.parrtySelector(temp1));
				System.out.println("You chose: " + elections.getVoters()[i].getChosenParty().name);
				System.out.println("Thank you for your vote!");

			}
		}

	}

	// BallotBoxes
	BallotBox b1 = new BallotBox("Kings Landing");
	BallotBoxForCovid b2 = new BallotBoxForCovid("Sesame Street");

	// HardCoded parties
	Party p1 = new Party("Banana", PoliticalOpinion.RIGHT);
	Party p2 = new Party("Apple", PoliticalOpinion.LEFT);
	Party p3 = new Party("Ananans", PoliticalOpinion.CENTER);

	// Candidates

	Candidates c1 = new Candidates("Ganz", "000000009", false, 1981, p1);
	Candidates c2 = new Candidates("Yehuda Levi", "000000001", false, 1984, p1);
	Candidates c3 = new Candidates("Gabi", "000000002", false, 1981, p2);
	Candidates c4 = new Candidates("Shiran", "000000003", false, 1995, p2);
	Candidates c5 = new Candidates("Yael", "000000004", false, 1983, p3);
	Candidates c6 = new Candidates("Elkoubi", "000000005", false, 1987, p3);
	// Citizens
	Citizen h1 = new Citizen("Bar", "123456789", false, 1990);
	Citizen h2 = new Citizen("Galya", "123456788", false, 1990);
	Citizen h3 = new Citizen("Batman", "123456787", false, 1990);
	Citizen h4 = new Citizen("Superman", "123456786", false, 1990);
	Citizen h5 = new Citizen("BugsBunny", "123456785", false, 1990);

	// HardCodded addition to elections;
	void addHardCoded() {
		for (int i = 0; i < numberOfElections; i++) {
			electionSaver[i].addParty(p3);
			electionSaver[i].addParty(p2);
			electionSaver[i].addParty(p1);
			electionSaver[i].addBallotBox(b1, 1);
			electionSaver[i].addBallotBox(b2, 2);
			electionSaver[i].addCitizens(h1);
			electionSaver[i].addCitizens(h2);
			electionSaver[i].addCitizens(h3);
			electionSaver[i].addCitizens(h4);
			electionSaver[i].addCitizens(h5);
			electionSaver[i].addCandidate(c1, c1.getPartyHeIsRunningFor());
			electionSaver[i].addCandidate(c2, c2.getPartyHeIsRunningFor());
			electionSaver[i].addCandidate(c3, c3.getPartyHeIsRunningFor());
			electionSaver[i].addCandidate(c4, c4.getPartyHeIsRunningFor());
			electionSaver[i].addCandidate(c5, c5.getPartyHeIsRunningFor());
			electionSaver[i].addCandidate(c6, c6.getPartyHeIsRunningFor());
			electionSaver[i].addBallotBoxToThisElections();
			electionSaver[i].votersToEachBallotBox();
		}
	}

	public Candidates addCandidateCase(Elections elections) {
		System.out.println("You chose to add a candidate to a party");
		System.out.println("Add your name: ");
		String name = sc.nextLine();
		System.out.println("Add your id: ");
		String id = sc.next();
		checkId(id);
		sc.nextLine();
		System.out.println("Add if you are ill with corona:(true\false)");
		boolean isQuarineted = sc.nextBoolean();
		if (isQuarineted == true) {
			System.out.println("If you are quarinted you have to be dressed right");

		}
		System.out.println("Add your year of birth: ");
		int yearOfBirth = sc.nextInt();
		for (int i = 0; i < numberOfElections; i++) {
			if (isQuarineted) {

			}

		}
		System.out.println("Choose party number: ");
		int candidatePartyNumber = sc.nextInt();
		for (int i = 0; i < numberOfElections; i++) {
			if (electionSaver[i].equals(elections)) {

			}
		}
		while (candidatePartyNumber > elections.getPartyCounter() || candidatePartyNumber < 0) {
			System.out.println("There is no such option choose again please: ");
			candidatePartyNumber = sc.nextInt();
		}
		Candidates newCandidate = new Candidates(name, id, isQuarineted, yearOfBirth,
				elections.getParties()[candidatePartyNumber - 1]);
		if (isQuarineted == true) {
			newCandidate.setDressed(true);
		}
		return newCandidate;

	}

}

