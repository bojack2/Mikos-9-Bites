package de.food.mikos.restaurant.frontend;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.food.mikos.restaurant.backend.FoodEnum;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Application {

	private Button[] menuButtons = { new Button("FAVS ♥"), new Button("BURGERS"), new Button("PIZZAS"),
										new Button("HOT DOGS"), new Button("DRINKS") };
	
	private Button[] productButtons = { new Button(""), new Button(""), new Button(""), new Button(""), new Button(""),
										new Button(""), new Button(""), new Button(""), new Button("") };
	private Button cancelButton = new Button("CANCEL");
	private Button toOrderButton = new Button("TO ORDER");
	private HBox[] productRows = { new HBox(20), new HBox(20), new HBox(20) };
	public static HBox payBox = new HBox(20);
	public static Label bill = new Label("");
	private BorderPane borderPaneForMainWindow = new BorderPane();
	private List<Integer> drawnNumbersForFavourites = new ArrayList<>();
	ButtonEvents buttonEvents = new ButtonEvents();
	public static List<Integer> amountOfSelectedProductList = new ArrayList<>();
	public static List<Double> entirePriceOfSelectedProductList = new ArrayList<>();
	public static double endPriceOfOrder;
	public static int amountOfProducts;
	public static List<Double> priceOfSelectedProductList = new ArrayList<>();
	public static List<String> nameOfSelectedProductList = new ArrayList<>();
	private Stage primaryStage;
	private Scene restaurantMainScene = new Scene(borderPaneForMainWindow, 600, 900);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		drawnNumbersForFavourites = createFavouritesNumberList();
		createMenuBar();
		createMiddlePanel();
		createBottomPanel();
		
		
		primaryStage.setTitle("Miko's 9 Bites");
		primaryStage.setResizable(false);
		
		restaurantMainScene.getStylesheets().add("file:resources/style.css");
		restaurantMainScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");
		primaryStage.setScene(restaurantMainScene);
		primaryStage.show();
	}
	
	public List<Integer> createFavouritesNumberList() {
		FoodEnum[] favouriteFood = FoodEnum.values();
		int numOfFavourites = 9;
		List<Integer> drawnNumbers = new ArrayList<>();
		Random randomGenerator = new Random();
		while (drawnNumbers.size() < numOfFavourites) {
			int random = randomGenerator.nextInt(favouriteFood.length - 1);
			if (!drawnNumbers.contains(random)) {
				drawnNumbers.add(random);
			}
		}
		return drawnNumbers;
	}
	public void createMenuBar () {
		
		HBox menuBar = new HBox(10);
		for (Button menuButton : menuButtons) {
			menuButton.setPrefSize(120, 50);
		}
		for (Button product : productButtons) {
			product.setPrefSize(180, 120);
			product.setMaxSize(180, 120);
			product.setMinSize(180, 120);
		}
		menuBar.setPadding(new Insets(10, 10, 20, 10));
		menuBar.getChildren().addAll(menuButtons);
		menuBar.getStyleClass().add("menubuttons");

		borderPaneForMainWindow.setTop(menuBar);

		for (HBox allProductRows : productRows) {
			allProductRows.setAlignment(Pos.CENTER);

		buttonEvents.addEventToMenuBarButtons(menuButtons, borderPaneForMainWindow, productButtons, productRows, drawnNumbersForFavourites);
		}
	}
	public void createMiddlePanel() {
		
		CentralPanel centralPanel = new CentralPanel();
		VBox centralPanelVbox = centralPanel.createPanelWithFavourites(productButtons, productRows, drawnNumbersForFavourites);

		buttonEvents.addEventToProductButtonsForFavourites(productButtons, drawnNumbersForFavourites);
		
		borderPaneForMainWindow.setCenter(centralPanelVbox);
	}	
	public void createBottomPanel() {
		
		HBox logoBox = new HBox();
		VBox bottomBox = new VBox();
		
		logoBox.setAlignment(Pos.BOTTOM_RIGHT);
		logoBox.setPadding(new Insets(20, 0, 0, 0));
		payBox.setAlignment(Pos.CENTER);
		payBox.setPadding(new Insets(10, 10, 0, 10));
		
		Image companyLogo = new Image("file:resources/icons/company_logo_small.png", 139, 71, false, false);
		ImageView showCompanyLogo = new ImageView(companyLogo);
	
		cancelButton.setPrefSize(120, 50);
		toOrderButton.setPrefSize(120, 50);
		cancelButton.setId("redButton");
		toOrderButton.setId("greenButton");
		
		addEventToButtons();

		payBox.getChildren().addAll(bill, cancelButton, toOrderButton);

		logoBox.getChildren().addAll(showCompanyLogo);
		bottomBox.getChildren().addAll(payBox, logoBox);
		payBox.getStyleClass().add("menubuttons");
		payBox.setVisible(false);
		borderPaneForMainWindow.setBottom(bottomBox);
	} 
	
	public void addEventToButtons() {
		cancelButton.setOnAction(click -> {
			amountOfSelectedProductList.clear();
			entirePriceOfSelectedProductList.clear();
			priceOfSelectedProductList.clear();
			nameOfSelectedProductList.clear();
			payBox.setVisible(false);
		});
		
		toOrderButton.setOnAction(click -> {
	
			BorderPane payScreenBorderPane = new BorderPane();
			
			Image companyLogo = new Image("file:resources/icons/company_logo_small.png");
			ImageView showCompanyLogo = new ImageView(companyLogo);
			Label order = new Label("Your order: ");
			Button[] navigationButtons = { new Button("CANCEL"), new Button("BACK"), new Button("ORDER") };
			
			HBox logoHbox = new HBox();
			HBox orderBox = new HBox();
			HBox buttonBox = new HBox(20);
			
			logoHbox.setAlignment(Pos.TOP_CENTER);
			logoHbox.setPadding(new Insets(10, 0, 0, 0));
			logoHbox.getChildren().addAll(showCompanyLogo);
			payScreenBorderPane.setTop(logoHbox);

			
			for(int i = 0; i < amountOfSelectedProductList.size(); i++) {
				order.setText(order.getText() + "\n" + amountOfSelectedProductList.get(i) + " x (" + priceOfSelectedProductList.get(i) + "€) " 
						+ nameOfSelectedProductList.get(i) + "\n\t\t\t\t\t\t\t\t" + entirePriceOfSelectedProductList.get(i) + "€");
			}
			order.setText(order.getText() + "\n-------------------------------------\nTo be paid: " + (double) Math.round(endPriceOfOrder * 100) / 100 + "€");
			logoHbox.setAlignment(Pos.CENTER);
			orderBox.setPadding(new Insets(0, 20, 0, 20));

			order.setPrefWidth(270);
			
			ScrollPane scrollBar = new ScrollPane();
			scrollBar.setContent(order);
			scrollBar.setHbarPolicy(ScrollBarPolicy.NEVER);
			scrollBar.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
			
			orderBox.getChildren().addAll(scrollBar);
			orderBox.setAlignment(Pos.CENTER);
			payScreenBorderPane.setCenter(orderBox);

			for (Button navigationButton : navigationButtons) {
				navigationButton.setPrefSize(120, 50);
				navigationButton.setMaxSize(120, 50);
				navigationButton.setMinSize(120, 50);
			}
			navigationButtons[0].setId("redButton");
			navigationButtons[1].setId("redButton");
			navigationButtons[2].setId("greenButton");
			
			navigationButtons[0].setOnAction(event -> {
				amountOfSelectedProductList.clear();
				entirePriceOfSelectedProductList.clear();
				priceOfSelectedProductList.clear();
				nameOfSelectedProductList.clear();
				payBox.setVisible(false);
				primaryStage.setScene(restaurantMainScene);
				
			});
			navigationButtons[1].setOnAction(event -> {
				primaryStage.setScene(restaurantMainScene);
				payBox.setVisible(true);
			});
			
			buttonBox.setAlignment(Pos.BOTTOM_CENTER);
			buttonBox.setPadding(new Insets(10, 0, 91, 0));
			buttonBox.getChildren().addAll(navigationButtons);
			payScreenBorderPane.setBottom(buttonBox);

			Scene payScene = new Scene(payScreenBorderPane,600,900);
			payScene.getStylesheets().add("file:resources/style.css");
			payScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");
			primaryStage.setScene(payScene);
			

		});
	}


}