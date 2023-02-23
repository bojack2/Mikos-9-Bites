package de.mikosninebites.backend;

/**
 * This is a class named "Burger" that defines a drink's attributes such as
 * name, price and content of burger.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class Burger implements FoodInterface {

	/* variable that stores the name of the burger */
	private String name;

	/* variable that stores the price of the burger */
	private double price;

	/* variable that stores the content of the burger */
	private String content;

	/**
	 * @param name  - each burger's name
	 * @param price - each burger's price
	 */
	public Burger(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Returns burger's name
	 * 
	 * @return burger's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets burger's name
	 * 
	 * @param name - burger's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns burger's price
	 * 
	 * @return burger's price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets burger's price
	 * 
	 * @param price - burger's price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns burger's content
	 * 
	 * @return burger's content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets burger's content
	 * 
	 * @param content - burger's content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * This is a method that checks if a food item contains gluten by examining its
	 * name. If the name contains the words "vegan" or "veggie", the method assumes
	 * that the food item is free from gluten and returns false. Otherwise, it
	 * returns true indicating that the food item may contain gluten.
	 */
	@Override
	public boolean isGlutenfree() {
		if (getName().contains("Vegan") || getName().contains("Veggie")) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Burger [name=" + name + ", price=" + price + ", content=" + content + "]";
	}
}