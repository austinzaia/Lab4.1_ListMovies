import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListMoviesApp {

	private static Scanner scnr;

	public static void main(String[] args) {
		scnr = new Scanner(System.in);
		ArrayList<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Kill Bill: Vol. 1", "action"));
		movies.add(new Movie("Kill Bill: Vol. 2", "action"));
		movies.add(new Movie("Perfect Blue", "anime"));
		movies.add(new Movie("Spirited Away", "anime"));
		movies.add(new Movie("Belladonna of Sadness", "anime"));
		movies.add(new Movie("Everything Everywhere All at Once", "sci-fi"));
		movies.add(new Movie("The Babadook", "horror"));
		movies.add(new Movie("The Platform", "horror"));
		movies.add(new Movie("The Thing", "sci-fi"));
		movies.add(new Movie("Mad Max", "sci-fi"));
		movies.add(new Movie("The Cabin in the Woods", "horror"));
		System.out.println("Welcome to the Movie List Application!");
		String category = "";
		boolean loop = true;

		while (loop) {
			category = getInput(movies.size());
			getCategory(movies, category);
			loop = keepGoing();
		}

		scnr.close();
	}

	public static String getInput(int num) {
		String input = "";
		System.out.println("\nThere are " + num + " movies in this list.");
		System.out.println("What genre would you like to browse? ");
		System.out.print("1. action\n2. anime\n3. sci-fi\n4. horror\nPlease enter a number: ");

		while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
			try {
				input = scnr.nextLine().toLowerCase().trim();
			} catch (Exception e) {
				System.out.print("Invalid input, please enter \"action\", \"anime\", \"sci-fi\", or \"horror\": ");
			}

			if (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4")) {
				System.out.print("Invalid input, please enter a number (1-4): ");
			}
		}

		int selection = Integer.parseInt(input);
		switch (selection) {
		case 1:
			input = "action";
			break;
		case 2:
			input = "anime";
			break;
		case 3:
			input = "sci-fi";
			break;
		case 4:
			input = "horror";
			break;
		}
		return input;
	}

	public static boolean keepGoing() {
		String in = "";
		System.out.print("\nContinue? (yes/no): ");

		while (!in.equals("yes") && !in.equals("no")) {
			try {
				in = scnr.nextLine().toLowerCase().trim();
			} catch (Exception e) {
				System.out.print("Invalid input, please enter \"yes\" or \"no\": ");
			}

			if (!in.equals("yes") && !in.equals("no")) {
				System.out.print("Invalid input, please enter \"yes\" or \"no\": ");
			}
		}

		if (in.equals("yes")) {
			return true;
		}
		return false;
	}

	public static void getCategory(ArrayList<Movie> movies, String category) {
		Collections.sort(movies);
		for (Movie movie : movies) {
			if (movie.movieCategory().equals(category)) {
				System.out.println(movie.movieTitle());
			}
		}
	}
}
