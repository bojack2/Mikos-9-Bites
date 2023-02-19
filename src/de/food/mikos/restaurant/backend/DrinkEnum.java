package de.food.mikos.restaurant.backend;

public enum DrinkEnum {
	COKE("Coca-Cola 0,5l", 2.99,"file:resources/icons/drink_cola.png"),
	
	SPRITE("Sprite 0,5l", 2.99,"file:resources/icons/drink_sprite.png"),
	
	FANTA("Fanta 0,5l", 2.99,"file:resources/icons/drink_fanta.png"),
	
	ICE_TEA("Ice-Tea 0,5l", 2.99,"file:resources/icons/drink_icetea.png"),
	
	SPEZI("Spezi 0,5l", 3.99,"file:resources/icons/drink_spezi.png"),
	
	MILKSHAKE("Milkshake 0,5l", 3.99,"file:resources/icons/drink_milkshake.png"),
	
	ENERGY_DRINK("Energy Drink 0,33l", 3.99,"file:resources/icons/drink_energy.png"),
	
	COFFEE("Coffee", 3.99,"file:resources/icons/drink_coffee.png"),
	
	TEA("Tea", 3.99,"file:resources/icons/drink_tea.png");
	
	
	private final String name;
	private final double price;
	private final String imagePath;
	
	/**
	 * @param name
	 * @param price
	 */
	private DrinkEnum(String name, double price, String imagePath) {
		this.name = name;
		this.price = price;
		this.imagePath = imagePath;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
	
}
