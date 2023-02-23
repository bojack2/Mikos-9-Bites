package de.mikosninebites.backend;

/**
 * HotdogEnum that represents various types of hotdogs, each with a name, price,
 * content, and image path. Each type of hotdog is defined as a constant in
 * all-caps with the corresponding values for its name, price, content, and
 * image path passed as parameters to the constructor. The constructor sets the
 * values of the instance variables for each constant. The class also provides
 * getter methods for the name, price, content, and image path of each hotdog.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public enum HotdogEnum {
	HOTDOG_CLASSIC("Classic Hot Dog", 2.99, "hot sausage, bun, mustard and ketchup",
			"file:resources/icons/hotdog_classic.png"),

	HOTDOG_CHILI_CHEESE("Chili Cheese Hot Dog", 3.99, "hot sausage, bun, chili con carne, cheddar cheese and onion",
			"file:resources/icons/hotdog_chili_cheese.png"),

	HOTDOG_NEWYORK("New York Style Hot Dog", 4.99, "hot sausage, bun, onion salad, mustard and ketchup",
			"file:resources/icons/hotdog_newyork.png"),

	HOTDOG_CHICAGO("Chicago Style Hot Dog", 5.99,
			"hot sausage, bun, onion salad, tomatoes, pickles, mustard and ketchup",
			"file:resources/icons/hotdog_chicago.png"),

	HOTDOG_BACON("Bacon Wrapped Hot Dog", 5.99, "hot sausage wrapped in bacon, bun, mustard and ketchup",
			"file:resources/icons/hotdog_bacon.png"),

	HOTDOG_JALAPENO("Jalapeno Cheddar Hot Dog", 5.99, "hot sausage, bun, cheddar cheese, jalapenos and onions",
			"file:resources/icons/hotdog_jalapeno.png"),

	HOTDOG_HAWAIIAN("Hawaiian Hot Dog", 6.99, "hot sausage, bun, pineapple, onion and ketchup",
			"file:resources/icons/hotdog_hawaiian.png"),

	HOTDOG_SOUTHWEST("Southwestern Hot Dog", 6.99,
			"hot sausage, bun, chili beans, cheddar cheese, jalapenos and guacamole",
			"file:resources/icons/hotdog_southwest.png"),

	HOTDOG_BAJA("Baja Hot Dog", 7.99, "hot sausage, bun, chili con carne, cheddar cheese, salsa and guacamole",
			"file:resources/icons/hotdog_baja.png");

	/* each hotdog's name */
	private final String name;

	/* each hotdog's price */
	private final double price;

	/* each hotdog's content */
	private final String content;

	/* each hotdog's image path */
	private final String imagePath;

	/**
	 * @param name      - each hotdog's name
	 * @param price     - each hotdog's price
	 * @param content   - each hotdog's content
	 * @param imagePath - each hotdog's image path
	 */
	private HotdogEnum(String name, double price, String content, String imagePath) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.imagePath = imagePath;
	}

	/**
	 * Returns hotdog's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns hotdog's price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns hotdog's content
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Returns hotdog's image path.
	 * 
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
}
