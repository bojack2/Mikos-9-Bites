package de.mikosninebites.frontend;

import javafx.application.Application;

/**
 * This is the main class that launches the JavaFX application. It contains only
 * one method, main, which calls the launch method of the Application class,
 * passing in the RestaurantApp class as a parameter. This starts the JavaFX
 * application by invoking the start method of the RestaurantApp class, which is
 * a subclass of Application.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class FxMain {

	public static void main(String[] args) {
		Application.launch(de.mikosninebites.frontend.RestaurantApp.class);
	}

}
