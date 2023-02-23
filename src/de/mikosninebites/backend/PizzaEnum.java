package de.mikosninebites.backend;

/**
 * PizzaEnum that represents various types of pizzas, each with a name, price,
 * content and image path. Each type of pizza is defined as a constant in
 * all-caps with the corresponding values for its name, price, content and image
 * path passed as parameters to the constructor. The constructor sets the values
 * of the instance variables for each constant. The enum also provides getter
 * methods for the name, price, content and image path of each pizza.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public enum PizzaEnum {

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

	PIZZA_FOUR_CHEESE("Four Cheese Pizza", 13.99,
			"tomato sauce, mozzarella cheese, gouda cheese, cheddar cheese, parmesan cheese",
			"file:resources/icons/pizza_four_cheese.png"),

	PIZZA_SEAFOOD("Seafood Pizza", 17.99, "tomato sauce, mozzarella cheese, shrimps and calamari",
			"file:resources/icons/pizza_seafood.png"),

	PIZZA_SUPREME("Supreme Pizza", 17.99,
			"tomato sauce, mozzarella cheese, pepperoni, ham, bacon, sausage, onion, pepper, mushrooms and olives",
			"file:resources/icons/pizza_supreme.png");

	/* Each pizza's name */
	private final String name;

	/* Each pizza's price */
	private final double price;

	/* Each pizza's content */
	private final String content;

	/* Each pizza's image path */
	private final String imagePath;

	/**
	 * @param name      - each pizza's name
	 * @param price     - each pizza's price
	 * @param content   - each pizza's content
	 * @param imagePath - each pizza's image path
	 */
	private PizzaEnum(String name, double price, String content, String imagePath) {
		this.name = name;
		this.price = price;
		this.content = content;
		this.imagePath = imagePath;
	}

	/**
	 * Returns pizza's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns pizza's price
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Returns pizza's content
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Returns pizza's image path.
	 * 
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}
}
