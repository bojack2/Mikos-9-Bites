package de.mikosninebites.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.mikosninebites.backend.FoodEnum;

/**
 * This class generates a list of random integers representing the indexes of
 * the user's favourite food items.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class RandomFavouriteNumbers {

	/**
	 * Creates a list of randomly generated integers that represent the indexes of
	 * the user's favourite food items.
	 *
	 * @return List of integers representing the indexes of favourite food items.
	 */
	public List<Integer> createFavouritesNumberList() {
		// Get all the food types from the enum
		FoodEnum[] favouriteFood = FoodEnum.values();

		// Set the number of favourite food items to 9
		int numOfFavourites = 9;

		// Create an empty list to hold the indexes of the user's favourite food items
		List<Integer> drawnNumbers = new ArrayList<>();
		// Create a random number generator which generates numbers until we have 9
		// unique ones
		Random randomGenerator = new Random();
		while (drawnNumbers.size() < numOfFavourites) {
			int random = randomGenerator.nextInt(favouriteFood.length - 1);
			// Add the random number to the list if it is not already in the list
			if (!drawnNumbers.contains(random)) {
				drawnNumbers.add(random);
			}
		}
		// Return the list of randomly generated integers
		return drawnNumbers;
	}
}
