package parasol;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create a simulation depicting the order-taking process in a restaurant.
 * 
 * @author RocancourtM
 */

public class Menu {
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

	public static ArrayList<String> defineMenu() {
		String nothing = "AUCUN";
		String[] stepsCommand = { "entrée", "plat", "accompagnement", "boisson", "dessert" };
		String[] appetizers = { "SALADE", "SOUPE", "QUICHE", nothing + 'E' };
		String[] mainCourse = { "POULET", "BOEUF", "POISSON", "VÉGÉTARIEN", "VEGAN", nothing };
		String[] sideDish = { "RIZ", "PÂTES", "FRITES", "LÉGUMES", nothing };
		String[] drink = { "EAU PLATE", "EAU GAZEUSE", "SODA", "VIN", nothing };
		String[] dessert = { "TARTE NORMANDE", "MOUSSE AU CHOCOLAT", "TIRAMISU", nothing };

		String[][] menu = { appetizers, mainCourse, sideDish, drink, dessert };
		Scanner sc = new Scanner(System.in);
		ArrayList<String> menuUser = new ArrayList<String>();

		for (int step = 0; step < stepsCommand.length; step++) {
			System.out.println("choix " + stepsCommand[step] + " :");

			for (int index = 0; index < menu[step].length; index++) {
				System.out.print("[" + (index + 1) + " - " + menu[step][index] + "]");
			}

			System.out.println(
					"\nQue souhaitez-vous comme " + stepsCommand[step] + " ? [saisir le chiffre correspondant]");

			String inputUser = sc.nextLine();
			while (!validCommandUser(inputUser, menu[step].length)) {
				System.out.println("Veuillez saisir une valeur entre 1 et " + menu[step].length + ".");
				inputUser = sc.nextLine();
			}

			int choiceUser = Integer.parseInt(inputUser);

			if (choiceUser != menu[step].length) {
				menuUser.add(menu[step][Integer.parseInt(inputUser) - 1].toLowerCase());
			}
		}

		return menuUser;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isNumberAndPos = false;
		int nbCustomer = 0;

		while (!isNumberAndPos) {
			System.out.print("Bonjour ! Combien de manu(s) souhaitez-vous ?");
			if (sc.hasNextInt()) {
				nbCustomer = sc.nextInt();
				if (nbCustomer > 0) {
					isNumberAndPos = true;
				} else {
					System.err.println("La valeur doit être positif");

				}
			} else {
				System.err.println("La valeur a saisir doit être un entier positif.");
			}
		}

		ArrayList<ArrayList<String>> allMenu = new ArrayList<ArrayList<String>>();
		for (int person = 1; person <= nbCustomer; person++) {
			System.out.println("Commande numéro " + person);
			ArrayList<String> menu = defineMenu();
			System.out.println("Résumé de la commande " + person);
			System.out.println(menu + "\n");
			allMenu.add(menu);
		}

		System.out.println("----------------Voici le récapitulatifs des menus-----------------");
		int nbPerson = 0;
		for (ArrayList<String> menu : allMenu) {
			nbPerson += 1;
			System.out.println("Menu " + nbPerson + ": " + menu);
		}
		sc.close();
	}

}