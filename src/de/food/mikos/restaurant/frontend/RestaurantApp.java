package de.food.mikos.restaurant.frontend;

import javafx.application.Application;
import javafx.stage.Stage;

public class RestaurantApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		MainWindow mainWindow = new MainWindow();
		mainWindow.start(primaryStage);

		
	}

}
