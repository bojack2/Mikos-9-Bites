module restaurant {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	opens de.food.mikos.restaurant.backend;
	opens de.food.mikos.restaurant.frontend;
}