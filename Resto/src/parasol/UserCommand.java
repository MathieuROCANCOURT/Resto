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
	
	public void addMenuOption(MenuOption option) {
		this.menuUser.add(option);
	}
}
