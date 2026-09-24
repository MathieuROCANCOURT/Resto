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
	private List<MenuOption> menuUser = new ArrayList<MenuOption>();
	private float totalCommand = 0f;
	
	public List<MenuOption> getMenuUser() {
		return menuUser;
	}

	public float getTotalCommand() {
		return totalCommand;
	}

	public void addMenuOption(MenuOption option) {
		this.menuUser.add(option);
		this.totalCommand += option.getPrice();
	}
}
