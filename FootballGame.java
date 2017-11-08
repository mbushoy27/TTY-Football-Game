import java.util.Scanner;
import java.util.Random;

public abstract class FootballGame {
	protected static FootballTeam team1;
	protected static FootballTeam team2;
	protected static int position;
	protected static int newPosition;
	protected static int kick;
	protected static int receive;
	protected static int offense;
	protected static String coinTossAnswer;

	static Random random = new Random();

	public FootballGame(FootballTeam team1, FootballTeam team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public static int Kick(int position) {
		position = 35;
		kick = random.nextInt(41) + 40; // kicking is defense
		int positionKick = kick + position;
		return positionKick;
	}

	public static int Receive(int position) {
		newPosition = Kick(position);
		receive = random.nextInt(20); // receiving is offense
		int positionReceive = newPosition - receive;
		return positionReceive;

	}
	
	

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a name for your team: ");
		String team1 = scanner.nextLine();
		System.out.println("Enter a name for my team: ");
		String team2 = scanner.nextLine();
		System.out.println("Great! It's " + team1 + " against " + team2 + ". Good luck!");

		System.out.println("How long would you like the quarter to be?");
		int quarter = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Great! Your quarter is " + quarter + " minutes long.");

		System.out.println("Heads or tails for the coin toss?");
		coinTossAnswer = scanner.nextLine();
		if (coinTossAnswer.equals("heads") || coinTossAnswer.equals("Heads")) {
			System.out.println(
					"Great! heads means that " + team1 + " is the kicking team and " + team2 + " is receiving.");
			System.out.println(team1 + " will kick off from their own 35-yard line.");
		} else {
			System.out.println(
					"Great! tails means that " + team2 + " is the kicking team and " + team1 + " is receiving");
			System.out.println(team2 + " will kick off from their own 35-yard line.");
		}

		if (coinTossAnswer.equals("heads") || coinTossAnswer.equals("Heads")) {
			System.out.println(team1 + " kicked the ball to " + team2 + "'s " + Kick(position) + " yard line." + kick);
			System.out.println(
					team2 + " returned the ball to " + team2 + "'s" + Receive(newPosition) + " yard line" + receive);

		} else {
			System.out.println(team2 + " kicked the ball to " + team1 + "'s " + Kick(position) + " yard line.");
			System.out.println(team1 + " returned the ball to " + team2 + "'s " + Receive(newPosition) + " yard line");

		}
	}
}
