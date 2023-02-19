package de.food.mikos.restaurant.backend;

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
	
	PIZZA_FOUR_CHEESE("Four Cheese Pizza", 13.99, "tomato sauce, mozzarella cheese, gouda cheese, cheddar cheese, parmesan cheese",
			"file:resources/icons/pizza_four_cheese.png"),
	
	PIZZA_SEAFOOD("Seafood Pizza", 17.99, "tomato sauce, mozzarella cheese, shrimps and calamari",
			"file:resources/icons/pizza_seafood.png"),
	
	PIZZA_SUPREME("Supreme Pizza", 17.99, "tomato sauce, mozzarella cheese, pepperoni, ham, bacon, sausage, onion, pepper, mushrooms and olives",
			"file:resources/icons/pizza_supreme.png");

	private final String name;
	private final double price;
	private final String content;
	private final String imagePath;

	/**
	 * @param name
	 * @param price
	 * @param content
	 */
	private PizzaEnum(String name, double price, String content, String imagePath) {
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
