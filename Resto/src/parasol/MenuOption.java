/**
 * 
 */
package parasol;

/**
 * 
 */
public class MenuOption {
	private String option;
	private float price;
	
	/**
	 * @param option
	 * @param price
	 */
	protected MenuOption(String option, float price) {
		this.option = option;
		this.price = price;
	}

	public String getOption() {
		return option;
	}


	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		if(option.startsWith("aucun")) {
			return "";
		}
		return option + ", prix=" + price + "€";
	}
}
