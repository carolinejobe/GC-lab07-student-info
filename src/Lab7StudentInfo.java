import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Caroline
 *
 *         Lab Number 7: Write a program that will recognize invalid inputs when
 *         the user requests information about students in a class.
 *
 *         What will the application do? -Provide info about students in a
 *         class. -Prompt the user to ask about a particular student. -Give
 *         proper responses according to user-submitted information. -Ask if
 *         user would like to learn about another student.
 *
 *         Build Specifications: 1. Account for invalid user input with
 *         exceptions. 2. Try to incorporate IndexOutOfBoundsException and
 *         IllegalArgumentException.
 *
 *         Hints: -Make it easy for the user - tell them what info is available
 *         -Murach's Beginning Java- Chapters 6 & 16
 *
 *         Extended Challenges: -Create other exceptions and catch those too!
 *
 */

public class Lab7StudentInfo {

	static Scanner input = new Scanner(System.in);
	static String play;
	static String words;
	static String[] classList;

	public static void main(String[] args) {

		System.out.println("Wecome to our Java class!");
		play = "y"; // initialize object to enter while loop
		int name = 0;
		String choice;

		String[] classList = { "Mark", "Austin", "Tenzin", "Caroline", "Luke", "Kamel", "Andy" };
		String[] pronounList = { "him", "him", "her", "her", "him", "him", "him" };
		String[] favoriteShow = { "\"The X-Files\"", "\"The Wire\"", "\"Stargate: SG1\"",
				"\"It's Always Sunny in Philadelphia\"", "\"Game of Thrones\"", "\"The Tonight Show\"",
				"\"The IT Crowd\"" };
		String[] leastFavoriteFood = {
				"anything his mother-in-law makes, cilantro, and red onions, which he calls \"purple onions\"",
				"broccoli", "Brussels sprouts", "water chestnuts", "Brussels sprouts", "fish", "holodets" };

		while (play.equalsIgnoreCase("y")) {

			System.out.println("Enter a number 1-7 or enter \"list\" to see the list: ");
			choice = input.next();

			if (choice.equalsIgnoreCase("list")) {
				for (int i = 0; i < classList.length; i++) {
					System.out.println(i + 1 + ". " + classList[i]);
					continue;
				}
				continue;
				//input.nextLine();
			}
			name = Integer.parseInt(choice);
			if (name>=1 && name<=7) {

				input.nextLine();

				try {
					System.out.println("You selected " + classList[name - 1] + ".");
						System.out.println(classList[name - 1] + " loves " + favoriteShow[name - 1] + ".");
						System.out.println(
								"Would you like to learn even more about " + pronounList[name - 1] + "? (y/n)");
						continueOrQuit(input);
						if (play.equalsIgnoreCase("y")) {
							System.out.println(classList[name - 1] + " hates " + leastFavoriteFood[name - 1] + "!");
							decideToLearnMore(input);
							continue;
						} else {
							decideToLearnMore(input);
							continue;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid input");
					input.nextLine();
					continue;
				}
				catch (InputMismatchException e) {
					System.out.println("Invalid input. Please enter a number 1-7.");
					input.nextLine();
					continue;
				}
			}
			}
			System.out.println("Good-bye");
		}
	// prompt user to continue or not. initialized to "y"
	private static void continueOrQuit(Scanner input) {
		play = input.next();
		try {
			play.matches("^[yYnN]$");
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid input. Please enter y or n: ");
		}
	}

	private static void decideToLearnMore(Scanner input) {
		System.out.println("Do you want to learn about someone else? (y/n) ");
		continueOrQuit(input);
	}
}
