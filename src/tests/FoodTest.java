package tests;

import de.food.mikos.restaurant.backend.Burger;
import de.food.mikos.restaurant.backend.Drink;
import de.food.mikos.restaurant.backend.Hotdog;
import de.food.mikos.restaurant.backend.Pizza;

public class FoodTest {

	public static void main(String[] args) {
		Burger classicBurger = new Burger("The Classic Burger", 8.99);
		Burger bbqBurger = new Burger("BBQ Bacon Burger", 10.99);
		Burger mushroomBurger = new Burger("Mushroom Swiss Burger", 11.99);
		Burger bigCheesyBurger = new Burger("The Big Cheesy Burger", 13.99);
		Burger spicyBurger = new Burger("Spicy Jalapeno Burger", 13.99);
		Burger veganBurger = new Burger("The Vegan Delight Burger", 15.99);
		Burger mexicanBurger = new Burger("The Mexican Burger", 16.99);
		Burger westernBurger = new Burger("The Western Burger", 17.99);
		Burger monsterBurger = new Burger("The Monster Burger", 21.99);

		Pizza margheritaPizza = new Pizza("Margherita Pizza", 8.99);
		Pizza pepperoniPizza = new Pizza("Pepperoni Pizza", 9.99);
		Pizza bbqPizza = new Pizza("BBQ Chicken Pizza", 11.99);
		Pizza veggiePizza = new Pizza("Veggie Deluxe Pizza", 11.99);
		Pizza hawaiianPizza = new Pizza("Hawaiian Pizza", 11.99);
		Pizza meatPizza = new Pizza("Meat Lovers Pizza", 12.99);
		Pizza fourCheesePizza = new Pizza("Four Cheese Pizza", 13.99);
		Pizza seaFoodPizza = new Pizza("Seafood Pizza", 17.99);
		Pizza supremePizza = new Pizza("Supreme Pizza", 17.99);

		Hotdog classicHotDog = new Hotdog("Classic Hot Dog", 2.99);
		Hotdog chiliCheeseHotDog = new Hotdog("Chili Cheese Hot Dog", 3.99);
		Hotdog newYorkHotDog = new Hotdog("New York Style Hot Dog", 4.99);
		Hotdog chicagoHotDog = new Hotdog("Chicago Style Hot Dog", 5.99);
		Hotdog baconHotDog = new Hotdog("Bacon Wrapped Hot Dog", 5.99);
		Hotdog jalapenoHotDog = new Hotdog("Jalapeno Cheddar Hot Dog", 5.99);
		Hotdog hawaiianHotDog = new Hotdog("Hawaiian Hot Dog", 6.99);
		Hotdog southwestHotDog = new Hotdog("Southwestern Hot Dog", 6.99);
		Hotdog bajaHotDog = new Hotdog("Baja Hot Dog", 7.99);

		Drink coke = new Drink("Coca-Cola 0,5l", 2.99);
		Drink sprite = new Drink("Sprite 0,5l", 2.99);
		Drink fanta = new Drink("Fanta 0,5l", 2.99);
		Drink iceTea = new Drink("Ice-Tea 0,5l", 2.99);
		Drink spezi = new Drink("Spezi 0,5l", 3.99);
		Drink milkshake = new Drink("Milkshake 0,5l", 3.99);
		Drink energyDrink = new Drink("Energy Drink 0,33l", 3.99);
		Drink coffee = new Drink("Coffee", 3.99);
		Drink tea = new Drink("Tea", 3.99);

		classicBurger.setContent("bun, beef cutlet, cheese, lettuce, tomato, onion and sauce");
		bbqBurger.setContent("bun, beef cutlet, bacon, cheese, lettuce, tomato, onion, BBQ sauce and mustard");
		mushroomBurger.setContent("bun, beef cutlet, mushrooms, cheese, lettuce, tomato, onion and garlic sauce");
		bigCheesyBurger.setContent("bun, beef cutlet, cheese, lettuce, tomato, onion, pickled cucumber, sauce, and two extra pieces of cheese");
		spicyBurger.setContent("bun, beef cutlet, jalapenos, cheese, lettuce, tomato, onion, sauce and mustard");
		veganBurger.setContent("bun, vegan cutlet, lettuce, tomato, onion, pickled cucumber, vegan sauce and guacamole");
		mexicanBurger.setContent("bun, beef cutlet, guacamole, cheese, lettuce, tomato, onion, jalapenos, and chili sauce");
		westernBurger.setContent("bun, beef cutlet, bacon, onion rings, cheese, lettuce, tomato, BBQ sauce, and mustard");
		monsterBurger.setContent("bun, two beef cutlets, bacon, cheese, lettuce, tomato, onion, pickled cucumber, sauce and mustard");

		margheritaPizza.setContent("tomatoes, mozzarella cheese, basil");
		pepperoniPizza.setContent("tomato sauce, mozzarella cheese, pepperoni");
		bbqPizza.setContent("BBQ sauce, mozzarella cheese, sliced chicken, onion and pepper");
		veggiePizza.setContent("tomato sauce, mozzarella, mushrooms, onions, peppers, olives and corn");
		hawaiianPizza.setContent("tomato sauce, mozzarella cheese, ham, pineapple, and onion");
		meatPizza.setContent("tomato sauce, mozzarella cheese, pepperoni, ham, bacon and sausage");
		seaFoodPizza.setContent("tomato sauce, mozzarella cheese, shrimps and calamari");
		fourCheesePizza.setContent("tomato sauce, mozzarella cheese, gouda cheese, cheddar cheese, parmesan cheese");
		supremePizza.setContent("tomato sauce, mozzarella cheese, pepperoni, ham, bacon, sausage, onion, pepper, mushrooms and olives");

		classicHotDog.setContent("hot sausage, bun, mustard and ketchup");
		chiliCheeseHotDog.setContent("hot sausage, bun, chili con carne, cheddar cheese and onion");
		newYorkHotDog.setContent("hot sausage, bun, onion salad, mustard and ketchup");
		chicagoHotDog.setContent("hot sausage, bun, onion salad, tomatoes, pickles, mustard and ketchup");
		baconHotDog.setContent("hot sausage wrapped in bacon, bun, mustard and ketchup");
		jalapenoHotDog.setContent("hot sausage, bun, cheddar cheese, jalapenos and onions");
		hawaiianHotDog.setContent("hot sausage, bun, pineapple, onion and ketchup");
		southwestHotDog.setContent("hot sausage, bun, chili beans, cheddar cheese, jalapenos and guacamole");
		bajaHotDog.setContent("hot sausage, bun, chili con carne, cheddar cheese, salsa and guacamole");

		Burger[] allBurgers = { classicBurger, bbqBurger, mushroomBurger, bigCheesyBurger, spicyBurger, veganBurger,
				mexicanBurger, westernBurger, monsterBurger };

		Pizza[] allPizzas = { margheritaPizza, pepperoniPizza, bbqPizza, veggiePizza, hawaiianPizza, meatPizza,
				seaFoodPizza, fourCheesePizza, supremePizza };

		Hotdog[] allHotDogs = { classicHotDog, chiliCheeseHotDog, newYorkHotDog, chicagoHotDog, baconHotDog,
				jalapenoHotDog, hawaiianHotDog, southwestHotDog, bajaHotDog };

		Drink[] allDrinks = { coke, sprite, fanta, iceTea, spezi, milkshake, energyDrink, coffee, tea };

		int helper = 0;
		System.out.println("That's our Menu:");
		System.out.println("\nBurgers:\n");
		for (Burger burgersFromRestaurant : allBurgers) {
			helper++;
			System.out.println(helper + ". " + burgersFromRestaurant.getName() + " costs "
					+ burgersFromRestaurant.getPrice() + "€ and contents: \n\t" + burgersFromRestaurant.getContent());
			System.out.println();
		}
		System.out.println("\nPizzas:\n");
		for (Pizza pizzasFromRestaurant : allPizzas) {
			helper++;
			System.out.println(helper + ". " + pizzasFromRestaurant.getName() + " costs "
					+ pizzasFromRestaurant.getPrice() + "€ and contents: \n\t" + pizzasFromRestaurant.getContent());
			System.out.println();
		}
		System.out.println("\nHot Dogs:\n");
		for (Hotdog hotDogsFromRestaurant : allHotDogs) {
			helper++;
			System.out.println(helper + ". " + hotDogsFromRestaurant.getName() + " costs "
					+ hotDogsFromRestaurant.getPrice() + "€ and contents: \n\t" + hotDogsFromRestaurant.getContent());
			System.out.println();
		}
		System.out.println("\nDrinks:\n");
		for (Drink drinksFromRestaurant : allDrinks) {
			helper++;
			System.out.println(helper + ". " + drinksFromRestaurant.getName() + " costs "
					+ drinksFromRestaurant.getPrice() + "€");
			System.out.println();
		}
	}
}
