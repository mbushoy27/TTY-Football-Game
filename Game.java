
/*Michelle Bushoy
 * Project 2
 * Tuesday and Thursday, 6:15-7:15
 * Omar Masood
 *“I affirm that I have not given or received any unauthorized help on this assignment, and that this work is my own.”
 */

/*
 * This class represents a football game. A football game is played by two teams, the user versus the computer. 
 * The user is making all of the main decisions, and the decisions of the computer are formed through randomly
 * generated numbers. 
 */

import java.util.Scanner;
import java.util.Random;

public class Game {
	protected static FootballTeam team1; // taken from FootballTeam class
	protected static FootballTeam team2;
	protected FootballTeam offenseTeam;
	protected FootballTeam defenseTeam;
	protected static int quarter;
	protected static int secondsRemaining;
	protected static int team1Score;
	protected static int team2Score;
	protected static int startingYardLine; // starts at 35 because kickoff
	protected static int kick; // random number
	protected static int position;
	protected static int receive; // random number
	protected static String OffenseDefense; // representing user's team, and
											// whether it's on offense or
											// defense
	protected int seconds;
	protected int downs;
	protected static int fieldPosition;

	public Game(FootballTeam awayTeam, FootballTeam homeTeam) { // constructor
		this.team1 = team1;
		this.team2 = team2;
	}

	public static void play() {
		CoinToss(); // coin toss uses kick off
		PlayingAPlay(); // playing a play uses score

	}

	public static void time() {
		secondsRemaining = quarter * 60; // mins *60 = sec
		if (secondsRemaining < 0) { // no time left in quarter
			System.out.println("The quarter is over.");
		} else {
			System.out.println("You still have " + secondsRemaining + " seconds remaining.");
		}

	}

	public static void score() {
		System.out.println("The score is " + team1Score + " to " + team2Score);
		if (team1Score == team2Score) {
			System.out.println("It's a tie");
		} else if (team1Score > team2Score) { // users score is greater than
												// computer
			System.out.println("Your team wins.");
		} else if (team2Score > team2Score) { // computers score is greater than
												// user
			System.out.println("My team wins.");
		}
	}

	public static void switchPossession() {
		String offense = Offense();
		String defense = Defense();
		// setting the method as a string to compare a string to a string
		if (OffenseDefense == offense) {
			OffenseDefense = defense;
			System.out.println("You are on defense.");
		} else if (OffenseDefense == defense) {
			OffenseDefense = offense;
			System.out.println("You are on offense.");
		}
	}

	public static void Position() {
		Random random = new Random();
		// this.fieldPosition = yards;
		if (fieldPosition <= 100) {
			position = fieldPosition;
			System.out.println("The ball is on the " + position + " yard line.");
		} else if (fieldPosition >= 100) {
			String Offense = Offense();
			String Defense = Defense();
			if (OffenseDefense.equals(Offense)) { // touchdown scores 7 points
													// for offense
				team1Score = team1Score + 7;
				KickOff();
				switchPossession();
			} else if (OffenseDefense.equals(Defense)) { // touchdown scores 7
															// points for
															// defense
				team2Score = team2Score + 7;
				KickOff();
				switchPossession();

			}

		}
	}

	public static String Defense() {
		Random random = new Random();
		int defense = random.nextInt(4);
		String bushoy = null;
		if (defense == 0) {
			bushoy = "run";
			return bushoy;
		}
		if (defense == 1) {
			bushoy = "pass";
			return bushoy;
		}
		if (defense == 2) {
			bushoy = "blitz";
			return bushoy;
		}
		if (defense == 3) {
			bushoy = "kick return";
			return bushoy;
		}
		return bushoy;

	}

	public static String Offense() {
		Random random = new Random();
		int offense = random.nextInt(4);
		String michelle = null;
		if (offense == 0) {
			michelle = "run";
			return michelle;
		}
		if (offense == 1) {
			michelle = "pass";
			return michelle;

		}
		if (offense == 2) {
			michelle = "punt";
			return michelle;
		}
		if (offense == 3) {
			michelle = "field goal";
			return michelle;

		}
		return michelle;
	}

	protected static void PlayingAPlay() {
		Position();
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String PlayersChoice;
		String Defense = Defense();
		String Offense = Offense();
		int yards;
		int fumble;
		int complete;
		int interception;
		int blocked;
		if (OffenseDefense == Offense) {
			System.out.println("Pick a play! You can pick a run, pass, punt or a field goal. "); // options
																									// when
																									// user
																									// is
																									// on
																									// offense
			PlayersChoice = scanner.nextLine();
			if (PlayersChoice == "run") {
				if (Defense == "run") {
					yards = random.nextInt(6) - 3;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line." + yards + " yard gain.");
					fumble = random.nextInt(11);
					if (fumble == 1) {
						int fumbleReturn = random.nextInt(6);
						position = position - fumbleReturn;
						System.out.println("fumble!!!! the ball is on the " + position + "yard line. ");
						switchPossession(); // position is switched after fumble
					}
					score();

				} else if (Defense == "pass") {
					yards = random.nextInt(12) + 2;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line." + yards + "yard gain.");
					fumble = random.nextInt(11);
					if (fumble == 1 || fumble == 2 || fumble == 3 || fumble == 4 || fumble == 5) { // probability
																									// 5/10
						int fumbleReturn = random.nextInt(6);
						position = position - fumbleReturn;
						System.out.println("fumble!!!! the ball is on the " + position + "yard line. ");
						switchPossession();
					}
					score();
				}
				if (Defense == "blitz") {
					yards = random.nextInt(10) + 5;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					fumble = random.nextInt(11);
					if (fumble == 1 || fumble == 2 || fumble == 3 || fumble == 4 || fumble == 5) {
						int fumbleReturn = random.nextInt(6);
						position = position - fumbleReturn;
						System.out.println("fumble!!!! the ball is on the " + position + " yard line. ");
						switchPossession();
					}
					score();
					if (Defense == "kick return") {
						yards = random.nextInt(15);
						position = position + yards;
					}
					score();

				}
			}
			if (PlayersChoice == "pass") {
				if (Defense == "run") {
					complete = random.nextInt(11);
					if (complete == 1 || complete == 2 || complete == 3 || complete == 4 || complete == 5
							|| complete == 6 || complete == 7 || complete == 8) {
						yards = random.nextInt(15) + 5;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");

					} else {
						yards = 0;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					}
					interception = random.nextInt(21);
					if (interception == 1) {
						int interceptionReturn = random.nextInt(10);
						position = position - yards;
						switchPossession();
					}
					score();
				}
				if (Defense == "pass") {
					complete = random.nextInt(11);
					if (complete == 1 || complete == 2 || complete == 3) {
						yards = random.nextInt(7) + 3;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					} else {
						yards = 0;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					}
					interception = random.nextInt(10);
					if (interception == 1) {
						int incterceptionReturn = random.nextInt(40);
						position = position - yards;
						switchPossession();
					}
					score();
				}
				if (Defense == "blitz") {
					complete = random.nextInt(10);
					if (complete == 1 || complete == 2 || complete == 3 || complete == 4 || complete == 5) {
						yards = random.nextInt(20) + 10;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					} else {
						yards = 0;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					}
					interception = random.nextInt(11);
					if (interception == 1 || interception == 2) {
						int incterceptionReturn = random.nextInt(5) + 10;
						position = position - yards;
						switchPossession();
					}
					score();
				}
				if (Defense == "kick return") {
					yards = random.nextInt(40);
					position = position + yards;
				}
				score();
			}
			if (PlayersChoice == "punt") {
				if (Defense == "run") {
					yards = random.nextInt(20) + 40;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					score();
				}
				if (Defense == "pass") {
					yards = random.nextInt(20) + 40;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					score();
				}
				if (Defense == "blitz") {
					blocked = random.nextInt(11);
					if (blocked == 1 || blocked == 2) {
						yards = random.nextInt(10) + 10;
						position = position - yards;
						System.out.println("Ball is on the " + position + "yard line. ");
						switchPossession();
					} else {
						yards = random.nextInt(20) + 30;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line.");
						yards = random.nextInt(10);
						position = position - yards;
						System.out.println("Ball is on the " + position + "yard line. ");
					}
					score();

				}
				if (Defense == "kick return") {
					blocked = random.nextInt(21);
					if (blocked == 1) {
						yards = random.nextInt(10) + 10;
						position = position - yards;
						System.out.println("Ball is on the " + position + "yard line.");
						switchPossession();
					} else {
						yards = random.nextInt(20) + 40;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line.");
						yards = random.nextInt(15) + 10;
						position = position - yards;
						System.out.println("Ball is on the " + position + "yard line.");
					}
					if (PlayersChoice == "field goal") {
					}
				}
			}
			score();

		} else if (OffenseDefense == Defense) {
			System.out.println("Pick a play! You can pick a run, pass, blitz or a kick return. ");
			PlayersChoice = scanner.nextLine();
			if (PlayersChoice == "run") {
				if (Offense == "run") {
					yards = random.nextInt(6) - 3;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line." + yards + " yard gain.");
					fumble = random.nextInt(11);
					if (fumble == 1) {
						int fumbleReturn = random.nextInt(6);
						position = position - fumbleReturn;
						System.out.println("fumble!!!! the ball is on the " + position + "yard line. ");
						switchPossession();
					}
					score();
				}
				if (Offense == "pass") {
					if (Defense == "run") {
						complete = random.nextInt(11);
						if (complete == 1 || complete == 2 || complete == 3 || complete == 4 || complete == 5
								|| complete == 6 || complete == 7 || complete == 8) {
							yards = random.nextInt(15) + 5;
							position = position + yards;
							System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
						} else {
							yards = 0;
							position = position + yards;
							System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
						}
						interception = random.nextInt(21);
						if (interception == 1) {
							int incterceptionReturn = random.nextInt(10);
							position = position - yards;
							switchPossession();
						}
						score();

					}
					if (Offense == "punt") {
						if (Defense == "run") {
							yards = random.nextInt(20) + 40;
							position = position + yards;
							System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
						}
						score();
						if (Offense == "field goal") {
							team1Score = team1Score + 3;
						}
					}

					if (PlayersChoice == "pass") {
						if (Offense == "run") {
							yards = random.nextInt(12) + 2;
							position = position + yards;
							System.out.println("Ball is on the " + position + "yard line." + yards + "yard gain.");
							fumble = random.nextInt(11);
							if (fumble == 1 || fumble == 2 || fumble == 3 || fumble == 4 || fumble == 5) {
								int fumbleReturn = random.nextInt(6);
								position = position - fumbleReturn;
								System.out.println("fumble!!!! the ball is on the " + position + "yard line. ");
								switchPossession();
								score();
							}
							if (Offense == "pass") {
								complete = random.nextInt(11);
								if (complete == 1 || complete == 2 || complete == 3) {
									yards = random.nextInt(7) + 3;
									position = position + yards;
									System.out.println(
											"Ball is on the " + position + "yard line. " + yards + " yard gain.");
								} else {
									yards = 0;
									position = position + yards;
									System.out.println(
											"Ball is on the " + position + "yard line. " + yards + " yard gain.");

								}
								interception = random.nextInt(10);
								if (interception == 1) {
									int incterceptionReturn = random.nextInt(40);
									position = position - yards;
									switchPossession();
								}
								score();
							}
							if (Offense == "punt") {
								yards = random.nextInt(20) + 40;
								position = position + yards;
								System.out
										.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
							}
							score();
						}
						if (Offense == "field goal") {
							team2Score = team2Score + 3;
						}
					}
				}
			}
			if (PlayersChoice == "blitz") {
				if (Offense == "run") {
					yards = random.nextInt(10) + 5;
					position = position + yards;
					System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					fumble = random.nextInt(11);
					if (fumble == 1 || fumble == 2 || fumble == 3 || fumble == 4 || fumble == 5) {
						int fumbleReturn = random.nextInt(6);
						position = position - fumbleReturn;
						System.out.println("fumble!!!! the ball is on the " + position + " yard line. ");
						switchPossession();

					}
				}
				if (Offense == "pass") {
					complete = random.nextInt(10);
					if (complete == 1 || complete == 2 || complete == 3 || complete == 4 || complete == 5) {
						yards = random.nextInt(20) + 10;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					} else {
						yards = 0;
						position = position + yards;
						System.out.println("Ball is on the " + position + "yard line. " + yards + " yard gain.");
					}
					interception = random.nextInt(11);
					if (interception == 1 || interception == 2) {
						int incterceptionReturn = random.nextInt(5) + 10;
						position = position - yards;
						switchPossession();
					}
					score();
				}
				if (Offense == "punt") {
					blocked = random.nextInt(11);
					if (blocked == 1 || blocked == 2) {
						yards = random.nextInt(10) + 10;
						position = position - yards;
						System.out.println("Ball is on the " + position + "yard line. ");
						switchPossession();
					} else {
						yards = random.nextInt(20) + 30;
						int yards2 = random.nextInt(10);
						position = position + yards - yards2;
						System.out.println("Ball is on the " + position + "yard line. ");
					}
					score();

				}
				if (Offense == "field goal") {

				}
			}
			if (PlayersChoice == "kick return") {
				if (Offense == "run") {

				}
				if (Offense == "pass") {

				}

				if (Offense == "punt") {
					blocked = random.nextInt(21);
					if (blocked == 1) {
						yards = random.nextInt(10) + 10;
						position = position - yards;
						System.out.println("Ball is on the " + position + "yard line.");
						switchPossession();
					} else {
						yards = random.nextInt(20) + 40;
						int yards2 = random.nextInt(15) + 10;
						position = position + yards - yards2;
						System.out.println("Ball is on the " + position + "yard line.");
					}
					score();
				}
				if (Offense == "field goal") {
					team1Score += 3;
				}
				score();

			}
		}
	}

	protected static void CoinToss() { // coin toss to see who kicks and who
										// receives
		Scanner scanner = new Scanner(System.in);
		System.out.println("Heads or Tails?");
		String userChoice = scanner.nextLine();
		String offense = Offense();
		String defense = Defense();
		if (userChoice.equals("heads") || userChoice.equals("Heads")) {
			OffenseDefense = offense;
			System.out.println("Great! heads means that your team is the kicking team and my team is receiving.");
			System.out.println("Your team will kick off from your 35-yard line.");
			KickOff();
		} else if (userChoice.equals("tails") || userChoice.equals("Tails")) {
			OffenseDefense = defense;
			System.out.println("Great! tails means that my team is the kicking team and yours is receiving.");
			System.out.println("My team will kick off from my own 35-yard line.");
			KickOff();
		}
		KickOff();
	}

	public static void KickOff() { // whoever wins coin toss kicks off
		Random random = new Random();

		startingYardLine = 35;
		kick = random.nextInt(41) + 40; // generating a random number from 40 to
										// 80
		receive = random.nextInt(20); // generating a random number from 0 to 20
		position = startingYardLine + kick - receive;
		if (position > 100) {
			position = 20;
			System.out.println("It's a touchback!!!  The ball is on the 20 yard line.");// touchback
																						// is
																						// when
																						// it
																						// goes
																						// passed
																						// the
																						// 100
																						// yard
																						// line
			switchPossession();
		} else {
			System.out.println("The ball is on the " + (100 - position) + " yard line!"); // position
																							// of
																							// ball
																							// after
																							// kick
																							// off
			switchPossession();

		}
		PlayingAPlay();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Hello, and welcome to TTY Football!! In this game, you will be playing against me, the computer.");
		System.out.println(
				"You have the choice to choose the team names, quarter length in minutes, the plays that you would like your team to make,");
		System.out.println(" and the coin toss. Otherwise, my plays are all done by me. May the better team win!");

		System.out.println("First, enter a name for your team: "); // users team
		String team1 = scanner.nextLine();
		System.out.println("Now, enter a name for my team: "); // computers team
		String team2 = scanner.nextLine();
		System.out.println("Great! It's " + team1 + " against " + team2 + ".");
		System.out.println("How long would you like the quarter to be?"); // in
																			// minutes
		quarter = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Great! Your quarter is " + quarter + " minutes long.");
		Game footballgame = new Game(new FootballTeam(team1), new FootballTeam(team2)); //
		Game.time();
		Game.play();

	}

}
