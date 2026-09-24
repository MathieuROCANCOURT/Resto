/**
 * 
 */
package parasol;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 */
public class Main {

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

		Menu menuCard = new Menu();
		
		ArrayList<List<MenuOption>> allMenu = new ArrayList<List<MenuOption>>();
		for (int person = 1; person <= nbCustomer; person++) {
			System.out.println("Commande numéro " + person);
			List<MenuOption> menu = menuCard.defineMenu();
			System.out.println("Résumé de la commande " + person);
			System.out.println(menu + "\n");
			allMenu.add(menu);
		}

		System.out.println("----------------Voici le récapitulatifs des menus-----------------");
		int nbPerson = 0;
		for (List<MenuOption> menu : allMenu) {
			nbPerson += 1;
			System.out.println("Menu " + nbPerson + ": " + menu);
		}
		sc.close();
		
		try (FileOutputStream fos = new FileOutputStream(new File("order.txt"))) {
			int nbMenu = 1;
			
			for (List<MenuOption> menu : allMenu) {
				String header = "*******************Résumé de la commande n°" + nbMenu + " *******************\n";
				fos.write(header.getBytes());
				
				for (MenuOption choice: menu) {
					fos.write(choice.getOption().getBytes());
					fos.write("\n".getBytes());
				}
				fos.write("\n\n".getBytes());
				nbMenu++;
			}			
		} catch (SecurityException | IOException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
		}
	}
}
