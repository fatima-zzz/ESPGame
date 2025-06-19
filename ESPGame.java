import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

/*
 * Class: CMSC203
 * Instructor: Huseyin Aygun
 * Description: ESP Game that tests user's ability to guess colors the computer selects
 * Due: 06/19/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Fatima Zahid
 */

public class ESPGame {
	public static void main(String[] args) {
		String FILE_COLOR = "colors.txt";
		final String OUTPUT_FILE = "EspGameResults.txt";
		final int TOTAL_COLORS = 16;

		final String COLOR_BLACK = "black";
		final String COLOR_WHITE = "white";
		final String COLOR_GRAY = "gray";
		final String COLOR_SILVER = "silver";
		final String COLOR_MAROON = "maroon";
		final String COLOR_RED = "red";
		final String COLOR_PURPLE = "purple";
		final String COLOR_FUCHSIA = "fuchsia";
		final String COLOR_GREEN = "green";
		final String COLOR_LIME = "lime";
		final String COLOR_OLIVE = "olive";
		final String COLOR_YELLOW = "yellow";
		final String COLOR_NAVY = "navy";
		final String COLOR_BLUE = "blue";
		final String COLOR_TEAL = "teal";
		final String COLOR_AQUA = "aqua";

		Scanner input = new Scanner(System.in);
		boolean continueGame = true;

		System.out.println("Welcome to ESP - extrasensory perception!");

		while (continueGame) {
			System.out.println("\nPlease choose one of the 4 options from the menu:");
			System.out.println(
					"1. Read and display on the screen the first 16 names of colors from a file colors.txt, so the player can select one of them names of colors");
			System.out.println(
					"2. Read and display on the screen the first 10 names of colors from a file colors.txt, so the player can select one of them names of colors");
			System.out.println(
					"3. Read and display on the screen the first 5 names of colors from a file colors.txt, so the player can select one of them names of colors");
			System.out.println("4. Exit the program");

			System.out.print("Enter your option: ");
			int choice = input.nextInt();
			input.nextLine();

			int limit = 0;
			if (choice == 1) {
				limit = 16;
			} else if (choice == 2) {
				limit = 10;
			} else if (choice == 3) {
				limit = 5;
			} else if (choice == 4) {
				break;
			} else {
				System.out.println("Invalid option.");
				continue;
			}

			try {
				System.out.print("Enter the File name: ");
				FILE_COLOR = input.next();
				Scanner fileScanner = new Scanner(new File(FILE_COLOR));
				System.out.println("\nColors Available:");
				int count = 1;
				while (fileScanner.hasNextLine() && count <= limit) {
					System.out.println(count + ". " + fileScanner.nextLine());
					count++;
				}
				fileScanner.close();
			} catch (Exception e) {
				System.out.print("File not found (Hint: enter colors.txt)\n");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ignored) {
				}
				continue;
			}
			int correctGuesses = 0;
			Random random = new Random();

			for (int round = 1; round <= 3; round++) {
				int randomNum = random.nextInt(limit) + 1;
				String selectedColor = "";

				if (randomNum == 1)
					selectedColor = COLOR_BLACK;
				else if (randomNum == 2)
					selectedColor = COLOR_WHITE;
				else if (randomNum == 3)
					selectedColor = COLOR_GRAY;
				else if (randomNum == 4)
					selectedColor = COLOR_SILVER;
				else if (randomNum == 5)
					selectedColor = COLOR_MAROON;
				else if (randomNum == 6)
					selectedColor = COLOR_RED;
				else if (randomNum == 7)
					selectedColor = COLOR_PURPLE;
				else if (randomNum == 8)
					selectedColor = COLOR_FUCHSIA;
				else if (randomNum == 9)
					selectedColor = COLOR_GREEN;
				else if (randomNum == 10)
					selectedColor = COLOR_LIME;
				else if (randomNum == 11)
					selectedColor = COLOR_OLIVE;
				else if (randomNum == 12)
					selectedColor = COLOR_YELLOW;
				else if (randomNum == 13)
					selectedColor = COLOR_NAVY;
				else if (randomNum == 14)
					selectedColor = COLOR_BLUE;
				else if (randomNum == 15)
					selectedColor = COLOR_TEAL;
				else if (randomNum == 16)
					selectedColor = COLOR_AQUA;

				System.out.printf("\n------ Round %d -------", round);
				System.out.println("\nI am thinking of a color.");
				System.out.print("Enter your guess: ");
				String guess = input.next().toLowerCase();

				if (guess.equalsIgnoreCase(selectedColor)) {
					System.out.println("Correct!");
					correctGuesses++;
				} else {
					System.out.println("Incorrect. I was thinking of " + selectedColor + ".");
				}
			}

			System.out.println("\nGame Over");
			System.out.println("You guessed " + correctGuesses + " out of 3 colors correctly.");
			String again = "";
			while (!again.equalsIgnoreCase("Yes") && !again.equalsIgnoreCase("No")) {
				System.out.print("\nWould you like to continue the game? (Yes/No): ");
				again = input.next();
				input.nextLine();

				if (again.equalsIgnoreCase("No")) {
					continueGame = false;
				} else if (again.equalsIgnoreCase("Yes")) {
					
				} else {
					System.out.print("Invalid input.\n");
				}
			}
		}

		System.out.print("\nEnter your name: ");
		String userName = input.nextLine();

		System.out.print("Describe yourself: ");
		String description = input.nextLine();

		System.out.print("Enter due date (MM/DD/YY): ");
		String dueDate = input.nextLine();

		// Output final info
		String finalInfo = "Game Over\n" + "You guessed 2 out of 3 colors correctly.\n" + "Due Date: " + dueDate + "\n"
				+ "Username: " + userName + "\n" + "User Description: " + description + "\n" + "Date: " + dueDate
				+ "\n";

		System.out.println("\n" + finalInfo);
		try {
			FileWriter writer = new FileWriter(OUTPUT_FILE);
			writer.write(finalInfo);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		input.close();
	}
}
