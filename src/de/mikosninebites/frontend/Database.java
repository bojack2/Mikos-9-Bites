package de.mikosninebites.frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A class that handles the communication between the application and the
 * database.
 * 
 * @author mikolaj korzeniewski (github: bojack2)
 */
public class Database {

	/*
	 * This is the URL used to connect to a MySQL database server located on the
	 * same machine (localhost) with port number 3306. The name of the database
	 * being connected to is "mikos_9_bites". If the database does not exist, it
	 * will be created.
	 */
	private final static String URL = "jdbc:mysql://localhost:3306/mikos_9_bites?createDatabaseIfNotExist=true";

	/* The username used to access the database */
	private final static String USER = "root";

	/* The password used to access the database */
	private final static String PASSWORD = "";

	/**
	 * Adds an Order object to the database.
	 * 
	 * @param order The Order object to be added.
	 * @throws RuntimeException if the order number already exists.
	 */
	public void sendOrder(Order order) {

		// Check if the order already has a key assigned to it
		// Throw an exception if the order already exists
		if (order.getKey() != 0) {
			throw new RuntimeException("Your meal has the same order number!");
		}

		// SQL statement to insert a new order into the database
		String sqlInput = "INSERT INTO Orders VALUE (null,?,?)";

		try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement conventer = connection.prepareStatement(sqlInput, Statement.RETURN_GENERATED_KEYS)) {

			// Create a string that contains the list of meals and quantities
			String orderedMeal = "";
			for (int i = 0; i < order.getMeal().size(); i++) {
				orderedMeal = orderedMeal + order.getQuantity().get(i) + "x " + order.getMeal().get(i) + "\n";
			}

			// Set the values for the SQL statement
			conventer.setString(1, orderedMeal);
			conventer.setDouble(2, order.getPrice());
			conventer.execute();

			// Get the generated key for the new order and assign it to the order object
			ResultSet answer = conventer.getGeneratedKeys();
			answer.next();
			int newKey = answer.getInt(1);
			order.setKey(newKey);

		} catch (SQLException exception) {
			exception.printStackTrace();
		}
	}
}