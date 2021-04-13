package id_206215311_id_207497561;

import java.util.Scanner;

public class ElectionsRunner {
	static Scanner sc = new Scanner(System.in);

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
		System.out.println("11.start new elections");
		System.out.println("Enter your choice: ");

	}

	public static void main(String[] args) {
		ElectionsSave e = new ElectionsSave();
		// Elections
		System.out.println("Add the election year: ");
		int electionYear = sc.nextInt();
		while (electionYear < 2021) {
			System.out.println("You can only add years that start from 2021 and on");
			electionYear = sc.nextInt();
		}
		System.out.println("Add the election month: ");
		int electionMonth = sc.nextInt();
		while (electionMonth > 12 || electionMonth < 1) {
			System.out.println("There are only 12 months in a year choose again");
			electionMonth = sc.nextInt();
		}
		Elections e1 = new Elections(electionYear, electionMonth);
		e.addElections(e1);
		e.addHardCoded();
		int choice;
		do {
			printMenu();
			switch (choice = sc.nextInt()) {
			case 1: {
				System.out.println("You chose to add a ballotbox");
				BallotBox b = e.addBallotBoxCase();
				int choice1 = e.Choice();
				for (int i = 0; i < e.numberOfElections; i++) {
					boolean addBallotBox = e.electionSaver[i].addBallotBox(b, choice1);
					while (addBallotBox == false) {
						b = e.addBallotBoxCase();
						choice1 = e.Choice();
						addBallotBox = e.electionSaver[i].addBallotBox(b, choice1);
					}
				}
				break;

			}
			case 2: {
				System.out.println("You chose to add a citizen");
				Citizen newCitizen = e.addCitizenCase();
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e.electionSaver[i].equals(e1)) {
						boolean addCitizen = e.electionSaver[i].addCitizens(newCitizen);
						while (addCitizen == false) {
							if (e.electionSaver[i].checkAge(newCitizen) == false) {
								System.out.println("You are not in the age to vote");
								addCitizen = true;
							} else {
								newCitizen = e.addCitizenCase();
								addCitizen = e1.addCitizens(newCitizen);
							}

						}
						if (addCitizen == true && e1.checkAge(newCitizen) == true) {
							e.electionSaver[i].addBallotBoxToCitizens(newCitizen);
							e.electionSaver[i].votersToEachBallotBox();
						}

					}
				}
				break;

			}
			case 3: {
				System.out.println("You chose to add a party");
				Party newParty = e.addPartyCase();
				for (int i = 0; i < e.numberOfElections; i++) {
					boolean addParty = e.electionSaver[i].addParty(newParty);
					while (addParty == false) {
						newParty = e.addPartyCase();
						addParty = e.electionSaver[i].addParty(newParty);
					}
					if (addParty == true) {
						System.out.println("You added a new party");
					}

				}
				break;
			}
			case 4: {
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e.electionSaver[i].equals(e1)) {
						Candidates newCandidate = e.addCandidateCase(e1);
						boolean addCandidate = e.electionSaver[i].addCandidate(newCandidate,
								newCandidate.getPartyHeIsRunningFor());
						if (addCandidate == true && e.electionSaver[i].checkAge(newCandidate) == true) {
							e.electionSaver[i].addBallotBoxToCitizens(newCandidate);
							System.out.println("You added a candidate");
							System.out.println("his place in the party is: " + (newCandidate.hisPlaceInTheParty + 1));
							e.electionSaver[i].votersToEachBallotBox();
						}
					}
				}
				break;
			}
			case 5: {
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e1.equals(e.electionSaver[i])) {
						e.electionSaver[i].showBallotBoxes();
					}
				}
				break;

			}
			case 6: {
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e1.equals(e.electionSaver[i])) {
						e.electionSaver[i].showCitizens();

					}
				}
				break;
			}
			case 7: {
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e1.equals(e.electionSaver[i])) {

						e.electionSaver[i].showParties();
					}
				}
				break;

			}
			case 8: {
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e1.equals(e.electionSaver[i])) {
						e.electionsConducter(e.electionSaver[i]);
					}
				}
				break;
			}
			case 9: {
				for (int i = 0; i < e.numberOfElections; i++) {
					if (e1.equals(e.electionSaver[i])) {
						e.electionSaver[i].results();
					}
				}
				break;

			}
			case 10: {
				System.out.println("GoodBye, and thank you see in the next election");
				sc.close();
				break;

			}
			case 11:
				System.out.println("You chose to add a new elections");
				System.out.println("Add the election year: ");
				electionYear = sc.nextInt();
				while (electionYear < 2021) {
					System.out.println("You can only add years that start from 2021 and on");
					electionYear = sc.nextInt();
				}
				System.out.println("Add the election month: ");
				electionMonth = sc.nextInt();
				while (electionMonth > 12 || electionMonth < 1) {
					System.out.println("There are only 12 months in a year choose again");
					electionMonth = sc.nextInt();
				}
				e1 = new Elections(electionYear, electionMonth);
				e.addElections(e1);
				e.addHardCoded();
				break;
			default:
				System.out.println("Error!invalid option, Choose again");
				break;

			}

		} while (choice != 10);

	}
}
