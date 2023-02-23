package de.mikosninebites.backend;

/**
 * DrinkEnum that represents various types of drinks, each with a name, price,
 * and image path. Each type of drink is defined as a constant in all-caps with
 * the corresponding values for its name, price and image path passed as
 * parameters to the constructor. The constructor sets the values of the
 * instance variables for each constant. The enum also provides getter methods
 * for the name, price and image path of each drink.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public enum DrinkEnum {

	COKE("Coca-Cola 0,5l", 2.99, "file:resources/icons/drink_cola.png"),

	SPRITE("Sprite 0,5l", 2.99, "file:resources/icons/drink_sprite.png"),

	FANTA("Fanta 0,5l", 2.99, "file:resources/icons/drink_fanta.png"),

	ICE_TEA("Ice-Tea 0,5l", 2.99, "file:resources/icons/drink_icetea.png"),

	SPEZI("Spezi 0,5l", 3.99, "file:resources/icons/drink_spezi.png"),

	MILKSHAKE("Milkshake 0,5l", 3.99, "file:resources/icons/drink_milkshake.png"),

	ENERGY_DRINK("Energy Drink 0,33l", 3.99, "file:resources/icons/drink_energy.png"),

	COFFEE("Coffee", 3.99, "file:resources/icons/drink_coffee.png"),

	TEA("Tea", 3.99, "file:resources/icons/drink_tea.png");

	/* Each drink's name */
	private final String name;

	/* Each drink's price */
	private final double price;

	/* Each drink's image path */
	private final String imagePath;

	/**
	 * @param name      - each drink's name
	 * @param price     - each drink's price
	 * @param imagePath - each drink's image path
	 */
	private DrinkEnum(String name, double price, String imagePath) {
		this.name = name;
		this.price = price;
		this.imagePath = imagePath;
	}

	/**
	 * Returns drink's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns drink's price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns drink's image path.
	 * 
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

}
