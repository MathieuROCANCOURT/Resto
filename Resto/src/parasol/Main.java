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
	public static void main(String[] args) throws SecurityException, IOException {
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
		List<UserCommand> listUsersCommands = new ArrayList<UserCommand>();
		
		for (int person = 1; person <= nbCustomer; person++) {
			System.out.println("Commande numéro " + person);
			UserCommand userCommand = menuCard.defineMenu(sc);
			System.out.println("Résumé de la commande " + person);
			System.out.println(userCommand + "\n");
			listUsersCommands.add(userCommand);
		}

		System.out.println("----------------Voici le récapitulatifs des menus-----------------");
		for (UserCommand userCommand : listUsersCommands) {
			System.out.println(userCommand);
		}
		sc.close();
		
		try (FileOutputStream fos = new FileOutputStream(new File("order.txt"))) {
			int nbMenu = 1;
			float totalCommands = 0.f;
			
			for (UserCommand uc : listUsersCommands) {
				String header = "*******************Résumé de la commande n°" + nbMenu + " *******************\n";
				fos.write(header.getBytes());
				
				for (MenuOption choice: uc.getMenuUser()) {
					String lineChoice = choice.getOption().toLowerCase() + "\t" + choice.getPrice() + "\n";
					fos.write(lineChoice.getBytes());
				}
				totalCommands += uc.getTotalCommand();
				String totalPrice = "Prix total: " + uc.getTotalCommand() + "€.\n\n";
				fos.write(totalPrice.getBytes());
				nbMenu++;
			}
			
			String strTotalCommands = "Prix total des commandes: " + totalCommands + "€.";
			fos.write(strTotalCommands.getBytes());
			
		} catch (SecurityException | IOException e) {
			Logger logger = Logger.getAnonymousLogger();
			logger.log(Level.SEVERE, e.getLocalizedMessage());
		}
	}
}
