package de.food.mikos.restaurant.backend;

public enum HotdogEnum {
	HOTDOG_CLASSIC("Classic Hot Dog", 2.99,"hot sausage, bun, mustard and ketchup",
			"file:resources/icons/hotdog_classic.png"),
	
	HOTDOG_CHILI_CHEESE("Chili Cheese Hot Dog", 3.99,"hot sausage, bun, chili con carne, cheddar cheese and onion",
			"file:resources/icons/hotdog_chili_cheese.png"),
	
	HOTDOG_NEWYORK("New York Style Hot Dog", 4.99,"hot sausage, bun, onion salad, mustard and ketchup",
			"file:resources/icons/hotdog_newyork.png"),
	
	HOTDOG_CHICAGO("Chicago Style Hot Dog", 5.99,"hot sausage, bun, onion salad, tomatoes, pickles, mustard and ketchup",
			"file:resources/icons/hotdog_chicago.png"),
	
	HOTDOG_BACON("Bacon Wrapped Hot Dog", 5.99,"hot sausage wrapped in bacon, bun, mustard and ketchup",
			"file:resources/icons/hotdog_bacon.png"),
	
	HOTDOG_JALAPENO("Jalapeno Cheddar Hot Dog", 5.99, "hot sausage, bun, cheddar cheese, jalapenos and onions",
			"file:resources/icons/hotdog_jalapeno.png"),
	
	HOTDOG_HAWAIIAN("Hawaiian Hot Dog", 6.99,"hot sausage, bun, pineapple, onion and ketchup",
			"file:resources/icons/hotdog_hawaiian.png"),
	
	HOTDOG_SOUTHWEST("Southwestern Hot Dog", 6.99,"hot sausage, bun, chili beans, cheddar cheese, jalapenos and guacamole",
			"file:resources/icons/hotdog_southwest.png"),
	
	HOTDOG_BAJA("Baja Hot Dog", 7.99,"hot sausage, bun, chili con carne, cheddar cheese, salsa and guacamole",
			"file:resources/icons/hotdog_baja.png");

	
	private final String name;
	private final double price;
	private final String content;
	private final String imagePath;
	
	/**
	 * @param name
	 * @param price
	 * @param content
	 */
	private HotdogEnum(String name, double price, String content, String imagePath) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.imagePath =imagePath;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
}

