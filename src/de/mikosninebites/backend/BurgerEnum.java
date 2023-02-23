package de.mikosninebites.backend;

/**
 * BurgerEnum that represents various types of burgers, each with a name, price,
 * content, and image path. Each type of burger is defined as a constant in
 * all-caps with the corresponding values for its name, price, content, and
 * image path passed as parameters to the constructor. The constructor sets the
 * values of the instance variables for each constant. The enum also provides
 * getter methods for the name, price, content, and image path of each burger.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public enum BurgerEnum {
	BURGER_CLASSIC("The Classic Burger", 8.99, "bun, beef patty, cheese, lettuce, tomato, onion and sauce",
			"file:resources/icons/burger_classic.png"),

	BURGER_BBQ("BBQ Bacon Burger", 10.99,
			"bun, beef patty, bacon, cheese, lettuce, tomato, onion, BBQ sauce and mustard",
			"file:resources/icons/burger_bbq.png"),

	BURGER_MUSHROOM("Mushroom Swiss Burger", 11.99,
			"bun, beef patty, mushrooms, cheese, lettuce, tomato, onion and garlic sauce",
			"file:resources/icons/burger_mushroom.png"),

	BURGER_BIG_CHEESY("The Big Cheesy Burger", 13.99,
			"bun, beef patty, cheese, lettuce, tomato, onion, pickled cucumber, sauce, and two extra pieces of cheese",
			"file:resources/icons/burger_big_cheesy.png"),

	BURGER_SPICY("Spicy Jalapeno Burger", 13.99,
			"bun, beef patty, jalapenos, cheese, lettuce, tomato, onion, sauce and mustard",
			"file:resources/icons/burger_spicy.png"),

	BURGER_VEGAN("The Vegan Delight Burger", 15.99,
			"bun, vegan patty, lettuce, tomato, onion, pickled cucumber, vegan sauce and guacamole",
			"file:resources/icons/burger_vegan.png"),

	BURGER_MEXICAN("The Mexican Burger", 16.99,
			"bun, beef patty, guacamole, cheese, lettuce, tomato, onion, jalapenos, and chili sauce",
			"file:resources/icons/burger_mexican.png"),

	BURGER_WESTERN("The Western Burger", 17.99,
			"bun, beef patty, bacon, onion rings, cheese, lettuce, tomato, BBQ sauce, and mustard",
			"file:resources/icons/burger_western.png"),

	BURGER_MONSTER("The Monster Burger", 21.99,
			"bun, two beef cutlets, bacon, cheese, lettuce, tomato, onion, pickled cucumber, sauce and mustard",
			"file:resources/icons/burger_monster.png");

	/* each burger's name */
	private final String name;

	/* each burger's price */
	private final double price;

	/* each burger's content */
	private final String content;

	/* each burger's image path */
	private final String imagePath;

	/**
	 * @param name      - each burger's name
	 * @param price     - each burger's price
	 * @param content   - each burger's content
	 * @param imagePath - each burger's image path
	 */
	private BurgerEnum(String name, double price, String content, String imagePath) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.imagePath = imagePath;
	}

	/**
	 * Returns burger's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns burger's price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns burger's content
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Returns burger's image path.
	 * 
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
}
