package de.mikosninebites.frontend;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 * A class representing a timer used to count down a specified number of
 * seconds.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 *
 */
public class Timer {

	/* The main window of the application */
	private MainWindow mainWindow;

	/* The label representing the clock on the user interface */
	private Label clock;

	/**
	 * Constructs a Timer with the specified main window and clock label.
	 * 
	 * @param mainWindow the main window of the application
	 * @param clock      the label representing the clock on the user interface
	 */
	public Timer(MainWindow mainWindow, Label clock) {
		this.mainWindow = mainWindow;
		this.clock = clock;
	}

	/** Creates and starts a timer which counts down from 10 seconds. */
	public void createTimer() {

		Timeline time = new Timeline();
		time.setCycleCount(Timeline.INDEFINITE);

		// Stop the timer if it is already running
		if (time != null) {
			time.stop();
		}

		KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
			Integer seconds = 10;

			@Override
			public void handle(ActionEvent arg0) {

				// Update the clock label with the current number of seconds
				clock.setText(seconds.toString());

				if (seconds <= 0) {
					// Stop the timer and clear the selected product lists
					time.stop();
					mainWindow.getAmountOfSelectedProductList().clear();
					mainWindow.getEntirePriceOfSelectedProductList().clear();
					mainWindow.getPriceOfSelectedProductList().clear();
					mainWindow.getNameOfSelectedProductList().clear();

					// Hide the pay box and switch back to the main restaurant scene
					mainWindow.getPayBox().setVisible(false);
					mainWindow.getPrimaryStage().setScene(mainWindow.getRestaurantMainScene());
				}
				seconds--;
			}
		});
		// Add the key frame to the timeline and start the timer
		time.getKeyFrames().add(frame);
		time.playFromStart();
	}
}