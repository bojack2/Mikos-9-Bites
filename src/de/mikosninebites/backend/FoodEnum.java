package de.mikosninebites.backend;

/**
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public enum FoodEnum {
	BURGER_CLASSIC("The Classic Burger", 8.99,"bun, beef patty, cheese, lettuce, tomato, onion and sauce",
			"file:resources/icons/burger_classic.png"),
	
	BURGER_BBQ("BBQ Bacon Burger", 10.99,"bun, beef patty, bacon, cheese, lettuce, tomato, onion, BBQ sauce and mustard",
			"file:resources/icons/burger_bbq.png"),
	
	BURGER_MUSHROOM("Mushroom Swiss Burger", 11.99,"bun, beef patty, mushrooms, cheese, lettuce, tomato, onion and garlic sauce", 
			"file:resources/icons/burger_mushroom.png"),
	
	BURGER_BIG_CHEESY("The Big Cheesy Burger", 13.99,"bun, beef patty, cheese, lettuce, tomato, onion, pickled cucumber, sauce, and two extra pieces of cheese",
			"file:resources/icons/burger_big_cheesy.png"),
	
	BURGER_SPICY("Spicy Jalapeno Burger", 13.99, "bun, beef patty, jalapenos, cheese, lettuce, tomato, onion, sauce and mustard",
			"file:resources/icons/burger_spicy.png"),
	
	BURGER_VEGAN("The Vegan Delight Burger", 15.99,"bun, vegan patty, lettuce, tomato, onion, pickled cucumber, vegan sauce and guacamole",
			"file:resources/icons/burger_vegan.png"),
	
	BURGER_MEXICAN("The Mexican Burger", 16.99, "bun, beef patty, guacamole, cheese, lettuce, tomato, onion, jalapenos, and chili sauce",
			"file:resources/icons/burger_mexican.png"),
	
	BURGER_WESTERN("The Western Burger", 17.99, "bun, beef patty, bacon, onion rings, cheese, lettuce, tomato, BBQ sauce, and mustard",
			"file:resources/icons/burger_western.png"),
	
	BURGER_MONSTER("The Monster Burger", 21.99, "bun, two beef cutlets, bacon, cheese, lettuce, tomato, onion, pickled cucumber, sauce and mustard",
			"file:resources/icons/burger_monster.png"),
	
	
	
	
	PIZZA_MARGHERITA("Margherita Pizza", 8.99, "tomatoes, mozzarella cheese, basil",
			"file:resources/icons/pizza_margherita.png"),
	
	PIZZA_PEPPERONI("Pepperoni Pizza", 9.99, "tomato sauce, mozzarella cheese, pepperoni",
			"file:resources/icons/pizza_pepperoni.png"),
	
	PIZZA_BBQ("BBQ Chicken Pizza", 11.99, "BBQ sauce, mozzarella cheese, sliced chicken, onion and pepper",
			"file:resources/icons/pizza_bbq.png"),
	
	PIZZA_VEGIE("Veggie Deluxe Pizza", 11.99, "tomato sauce, mozzarella, mushrooms, onions, peppers, olives and corn",
			"file:resources/icons/pizza_veggie.png"),
	
	PIZZA_HAWAIIAN("Hawaiian Pizza", 11.99, "tomato sauce, mozzarella cheese, ham, pineapple, and onion",
			"file:resources/icons/pizza_hawaiian.png"),
	
	PIZZA_MEAT("Meat Lovers Pizza", 12.99, "tomato sauce, mozzarella cheese, pepperoni, ham, bacon and sausage",
			"file:resources/icons/pizza_meat.png"),
	
	PIZZA_FOUR_CHEESE("Four Cheese Pizza", 13.99, "tomato sauce, mozzarella cheese, gouda cheese, cheddar cheese, parmesan cheese",
			"file:resources/icons/pizza_four_cheese.png"),
	
	PIZZA_SEAFOOD("Seafood Pizza", 17.99, "tomato sauce, mozzarella cheese, shrimps and calamari",
			"file:resources/icons/pizza_seafood.png"),
	
	PIZZA_SUPREME("Supreme Pizza", 17.99, "tomato sauce, mozzarella cheese, pepperoni, ham, bacon, sausage, onion, pepper, mushrooms and olives",
			"file:resources/icons/pizza_supreme.png"),
	
	
	
	
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
	private FoodEnum(String name, double price, String content,String imagePath) {
		this.name = name;
		this.price = price;
		this.content = content;
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
