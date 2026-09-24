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

	public UserCommand() {
		this.id = ++counter;
	}

	public int getId() {
		return id;
	}

	public List<MenuOption> getMenuUser() {
		return menuUser;
	}

	public float getTotalCommand() {
		return Float.parseFloat(String.format("%.02f", this.totalCommand));
	}

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
