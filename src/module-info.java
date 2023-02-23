module restaurant {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	requires java.sql;
	opens de.mikosninebites.backend;
	opens de.mikosninebites.frontend;
}