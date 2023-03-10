package de.mikosninebites.backend;

/**
 * This is a class named "Hotdog" that defines a hotdog's attributes such as
 * name, price and content.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class Hotdog implements FoodInterface {

	/* variable that stores the name of the hotdog */
	private String name;

	/* variable that stores the price of the hotdog */
	private double price;

	/* variable that stores the content of the hotdog */
	private String content;

	/**
	 * @param name  - each hotdog's name
	 * @param price - each hotdog's price
	 */
	public Hotdog(String name, double price) {
		this.name = name;
		this.price = price;
	}

	/**
	 * Returns hotdog's name
	 * 
	 * @return hotdog's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets hotdog's name
	 * 
	 * @param name - hotdog's name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns hotdog's price
	 * 
	 * @return hotdog's price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets hotdog's price
	 * 
	 * @param price - hotdog's price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns hotdog's content
	 * 
	 * @return hotdog's content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets hotdog's content
	 * 
	 * @param content - hotdog's content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 
	 * Checks if the hotdog is gluten-free by examining its name. If the name
	 * contains "Vegan" or "Veggie", the hotdog is considered gluten-free.
	 * 
	 * @return true if the hotdog is gluten-free, false otherwise.
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
		return "Hotdog [name=" + name + ", price=" + price + ", content=" + content + "]";
	}

}