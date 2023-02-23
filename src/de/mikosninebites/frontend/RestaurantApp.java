package de.mikosninebites.frontend;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class of the RestaurantApp application that launches the program by
 * creating a new MainWindow object and calling its start() method.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class RestaurantApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		MainWindow mainWindow = new MainWindow();
		mainWindow.start(primaryStage);

	}

}
