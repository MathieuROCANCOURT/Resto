package parasol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Create a simulation depicting the order-taking process in a restaurant.
 * 
 * @author RocancourtM
 */

public class Menu {
	private static final String[] stepsCommand = { "entrée", "plat", "accompagnement", "boisson", "dessert" };

	String nothing = "AUCUN";
	private Appetizer[] appetizer = { new Appetizer("SALADE", 7.86f), new Appetizer("SOUPE", 5.64f),
			new Appetizer("QUICHE", 9.45f), new Appetizer(nothing + 'E', 0) };
	private MainCourse[] mainCourse = { new MainCourse("POULET", 5.6f), new MainCourse("BOEUF", 7.92f),
			new MainCourse("POISSON", 9.99f), new MainCourse("VÉGÉTARIEN", 6.50f), new MainCourse("VEGAN", 8.23f),
			new MainCourse(nothing, 0) };
	private SideDish[] sideDish = { new SideDish("RIZ", 2f), new SideDish("PÂTES", 1.5f), new SideDish("FRITES", 3.67f),
			new SideDish("LÉGUMES", 0.99f), new SideDish(nothing, 0) };
	private Drink[] drink = { new Drink("EAU PLATE", 1), new Drink("EAU GAZEUSE", 1.25f), new Drink("SODA", 2),
			new Drink("VIN", 4.5f), new Drink(nothing, 0) };
	private Dessert[] dessert = { new Dessert("TARTE NORMANDE", 3.5f), new Dessert("MOUSSE AU CHOCOLAT", 4.5f),
			new Dessert("TIRAMISU", 4.95f), new Dessert(nothing, 0) };

	private MenuOption[][] allMenu = { appetizer, mainCourse, sideDish, drink, dessert }; 

	/**
	 * Checks whether the value entered by the user is an integer between 1 and the
	 * number of options.
	 * 
	 * @param inputUser The entered by the user.
	 * @param sizeArray The list of options.
	 * @return true if respects conditions, else false.
	 */
	public static boolean validCommandUser(String inputUser, int sizeArray) {
		int choiceUser;
		try {
			choiceUser = Integer.parseInt(inputUser);
		} catch (Exception e) {
			return false;
		}
		return 0 < choiceUser && choiceUser <= sizeArray;
	}

	public List<MenuOption> defineMenu() {
		Scanner sc = new Scanner(System.in);
		List<MenuOption> menuUser = new ArrayList<MenuOption>();

		for (int step = 0; step < stepsCommand.length; step++) {
			System.out.println("choix " + stepsCommand[step] + " :");

			for (int index = 0; index < this.allMenu[step].length; index++) {
				System.out.print("[" + (index + 1) + " - " + this.allMenu[step][index] + "]");
			}

			System.out.println(
					"\nQue souhaitez-vous comme " + stepsCommand[step] + " ? [saisir le chiffre correspondant]");

			String inputUser = sc.nextLine();
			while (!validCommandUser(inputUser, this.allMenu[step].length)) {
				System.out.println("Veuillez saisir une valeur entre 1 et " + this.allMenu[step].length + ".");
				inputUser = sc.nextLine();
			}

			int choiceUser = Integer.parseInt(inputUser);

			if (choiceUser != this.allMenu[step].length) {
				menuUser.add(this.allMenu[step][Integer.parseInt(inputUser) - 1]);
			}
		}

		return menuUser;
	}
}