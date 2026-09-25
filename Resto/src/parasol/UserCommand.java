/**
 * 
 */
package parasol;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class UserCommand {
	private static int counter = 0;

	private final int id;
	private List<MenuOption> menuUser = new ArrayList<MenuOption>();
	private float totalCommand = 0f;

	/**
	 * Create a UserCommand where id is equal to the number of instantiate before
	 * him.
	 */
	public UserCommand() {
		this.id = ++counter;
	}

	/**
	 * Get the UserCommand id.
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get the menu user choices.
	 * 
	 * @return Menu user
	 */
	public List<MenuOption> getMenuUser() {
		return menuUser;
	}

	/**
	 * Get the price command total by user.
	 * 
	 * @return Price command total
	 */
	public float getTotalCommand() {
		return Float.parseFloat(String.format("%.02f", this.totalCommand));
	}

	/**
	 * Add the customer's selection to the customer menu.
	 * 
	 * @param option The customer selection
	 */
	public void addMenuOption(MenuOption option) {
		if (!option.getOption().startsWith("AUCUN")) {
			this.menuUser.add(option);
			this.totalCommand += option.getPrice();
		}
	}

	@Override
	public String toString() {
		StringBuilder resume = new StringBuilder("Menu n°" + this.id + ":");
		for (MenuOption option : this.menuUser) {
			if (!option.getOption().startsWith("AUCUN")) {
				resume.append(option.getOption().toLowerCase());
				resume.append(", ");
			}
		}
		String strTotalCommand = String.format("%.02f", this.totalCommand);
		resume.append("Prix total: " + strTotalCommand + "€.");

		return resume.toString();
	}
}
