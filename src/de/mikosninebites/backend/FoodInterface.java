package de.mikosninebites.backend;

/**
 * This is an interface named FoodInterface that declares a single method
 * isGlutenfree() without any implementation details. Any class that implements
 * this interface will have to provide an implementation for this method. The
 * purpose of this interface is to ensure that any class that represents a food
 * item should have a way to determine whether it is gluten-free or not.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public interface FoodInterface {

	/*
	 * Returns a value indicating whether the food item is gluten-free or not.
	 */
	boolean isGlutenfree();

}
