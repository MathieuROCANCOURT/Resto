/**
 * 
 */
package parasol;

/**
 * The class can implemented all choices in the menu with associated price.
 * 
 * @author RocancourtM
 */
public class MenuOption {
	private String option;
	private float price;
	
	/**
	 * @param option Food to have on the menu.
	 * @param price Food price.
	 */
	protected MenuOption(String option, float price) {
		this.option = option;
		this.price = price;
	}

	/**
	 * Get the name of the food.
	 * 
	 * @return name of the food
	 */
	public String getOption() {
		return option;
	}


	/**
	 * Get the food price.
	 * 
	 * @return Food price.
	 */
	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		if(option.startsWith("AUCUN")) {
			return option;
		}
		return option + ", prix=" + price + "€";
	}
}
