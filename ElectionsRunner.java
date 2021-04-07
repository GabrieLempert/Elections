package Elections;

import java.util.Scanner;

import Elections.Party.PoliticalOpinion;

public class ElectionsRunner {
	public static void printMenu() {
		System.out.println("Choose between the options: ");
		System.out.println("1.add a ballot box");
		System.out.println("2.add a citizen");
		System.out.println("3.add a party");
		System.out.println("4.add a candidate to a party");
		System.out.println("5.show all the ballotboxes");
		System.out.println("6.show all the citizens");
		System.out.println("7.show all the parites");
		System.out.println("8.start the elections");
		System.out.println("9.show election results");
		System.out.println("10.exit the programm");
		System.out.println("Enter your choice: ");

	}

	public static void main(String[] args) {
		// Elections
		Elections e1 = new Elections(2021, 3);
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
		Citizen h1 = new Citizen("Bar", "123456789", true, 1990);
		h1.setDressed(true);
		Citizen h2 = new Citizen("Galya", "123456788", false, 1990);
		Citizen h3 = new Citizen("Batman", "123456787", false, 1990);
		Citizen h4 = new Citizen("Superman", "123456786", false, 1990);
		Citizen h5 = new Citizen("BugsBunny", "123456785", false, 1990);
		// HardCodded addition to elections;
		e1.addParty(p3);
		e1.addParty(p2);
		e1.addParty(p1);
		e1.addBallotBox(b1, 1);
		e1.addBallotBox(b2, 2);
		e1.addBallotBoxToCitizen(h1);
		e1.addBallotBoxToCitizen(h2);
		e1.addBallotBoxToCitizen(h3);
		e1.addBallotBoxToCitizen(h4);
		e1.addBallotBoxToCitizen(h5);
		e1.addBallotBoxToCitizen(c1);
		e1.addBallotBoxToCitizen(c2);
		e1.addBallotBoxToCitizen(c3);
		e1.addBallotBoxToCitizen(c4);
		e1.addBallotBoxToCitizen(c5);
		e1.addBallotBoxToCitizen(c6);
		e1.addCitizens(h1);
		e1.addCitizens(h2);
		e1.addCitizens(h3);
		e1.addCitizens(h4);
		e1.addCitizens(h5);
		e1.addCandidate(c1, c1.getPartyHeIsRunningFor());
		e1.addCandidate(c2, c2.getPartyHeIsRunningFor());
		e1.addCandidate(c3, c3.getPartyHeIsRunningFor());
		e1.addCandidate(c4, c4.getPartyHeIsRunningFor());
		e1.addCandidate(c5, c5.getPartyHeIsRunningFor());
		e1.addCandidate(c6, c6.getPartyHeIsRunningFor());
		e1.votersToEachBallotBox();
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			printMenu();
			switch (choice = sc.nextInt()) {
			case 1: {
				System.out.println("You chose to add a ballotbox");
				System.out.println("Input address:");
				String address = sc.next();
				sc.nextLine();
				BallotBox b = new BallotBox(address);
				System.out.println("Choose which ballot you want to add: ");
				System.out.println("Number 1: Regular ballotbox");
				System.out.println("Number 2: Covid ballotbox");
				System.out.println("Number 3: Soldiers ballotbox");
				System.out.println("Enter your choice must be between 1-3: ");
				int choice1 = sc.nextInt();
				while (choice1 > 3 || choice < 1) {
					System.out.println("choose again number between 1-3: ");
					choice1 = sc.nextInt();
				}
				e1.addBallotBox(b, choice1);

				break;

			}
			case 2: {

				System.out.println("You chose to add a citizen");
				System.out.println("Add your name: ");
				String name = sc.next();
				sc.nextLine();
				System.out.println("Add your id: ");
				String id = sc.next();
				while (id.length() != 9) {
					if (id.length() < 9) {
						System.out.println("You didn't enter enough numbers" + (9 - id.length()));
					} else {
						System.out.println("You entered to much numbers" + (id.length()));
					}
					id = sc.next();

				}
				sc.nextLine();
				System.out.println("Add if you are ill with corona: ");
				boolean isQuarineted = sc.nextBoolean();
				System.out.println("Add you year of birth: ");
				int yearOfBirth = sc.nextInt();
				Citizen newCitizen = new Citizen(name, id, isQuarineted, yearOfBirth);
				if (isQuarineted == true) {
					System.out.println(
							"If you are quarinted you have to be dressed right-Do you have a protective outfit?: ");
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
				e1.addBallotBoxToCitizen(newCitizen);
				e1.addCitizens(newCitizen);
				e1.votersToEachBallotBox();
				break;

			}
			case 3: {
				System.out.println("You chose to add a party");
				System.out.println("Your party name: ");
				String name = sc.next();
				sc.nextLine();
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
				e1.addParty(newParty);
				break;
			}
			case 4: {
				System.out.println("You chose to add a candidate to a party");
				System.out.println("Add your name: ");
				String name = sc.next();
				sc.nextLine();
				System.out.println("Add your id: ");
				String id = sc.next();
				while (id.length() != 9) {
					if (id.length() < 9) {
						System.out.println("You didn't enter enough numbers" + (9 - id.length()));
					} else {
						System.out.println("You entered to much numbers" + (id.length()));
					}
					id = sc.next();

				}
				sc.nextLine();
				System.out.println("Add if you are ill with corona: ");
				boolean isQuarineted = sc.nextBoolean();
				if (isQuarineted == true) {
					System.out.println("If you are quarinted you have to be dressed right");

				}
				System.out.println("Add your year of birth: ");
				int yearOfBirth = sc.nextInt();
				e1.showPartiesForElection();
				System.out.println("Choose party number: ");
				int candidatePartyNumber = sc.nextInt();
				while (candidatePartyNumber > e1.getPartyCounter() || candidatePartyNumber < 0) {
					System.out.println("There is no such option choose again please: ");
					candidatePartyNumber = sc.nextInt();
				}
				Candidates newCandidate = new Candidates(name, id, isQuarineted, yearOfBirth,
						e1.getParties()[candidatePartyNumber - 1]);
				if (isQuarineted == true) {
					newCandidate.setDressed(true);
				}
				e1.addCandidate(newCandidate, newCandidate.getPartyHeIsRunningFor());
				e1.addBallotBoxToCitizen(newCandidate);
				System.out.println("You added a candidate");
				System.out.println("his place in the party is: " + (newCandidate.hisPlaceInTheParty + 1));
				e1.votersToEachBallotBox();

			}
			case 5: {
				e1.showBallotBoxes();
				break;

			}
			case 6: {
				e1.showCitizens();
				break;

			}
			case 7: {
				e1.showParties();
				break;

			}
			case 8: {
				e1.votersToEachBallotBox();
				for (int i = 0; i < e1.getCitizenCounter(); i++) {
					System.out.println(e1.getVoters()[i].name + "- id -" + e1.getVoters()[i].id);
					System.out.println("Do you want to vote?");
					System.out.println("Choose Yes/No");
					String temp = sc.next();
					while ((!temp.equalsIgnoreCase("yes")) && (!temp.equalsIgnoreCase("no"))) {
						System.out.println("There is no such option choose again YES/NO");
						temp = sc.next();
					}
					if (temp.equalsIgnoreCase("no")) {
						Party blankParty = new Party("Blank", PoliticalOpinion.CENTER);
						e1.getVoters()[i].setChosenParty(blankParty);
						System.out.println("Thank you goodbye!");


					}
					if (temp.equalsIgnoreCase("yes")) {
						e1.showPartiesForElection();
						e1.voteToBallotBox(i);
						int temp1 = sc.nextInt();
						while (temp1 > e1.getPartyCounter() || temp1 < 0) {
							System.out.println("There is no such option choose again: ");
							temp1 = sc.nextInt();
						}
						e1.getVoters()[i].setChosenParty(e1.parrtySelector(temp1));
						System.out.println("Thanks for your vote!");

					}
				}
				break;
			}
			case 9: {
				e1.results();
				break;

			}
			case 10: {
				System.out.println("GoodBye, and thank you see in the next election");
				sc.close();
				break;

			}

			default:
				System.out.println("Error!invalid option, Choose again");
				choice = sc.nextInt();
				break;

			}

		} while (choice != 10);

	}
}
