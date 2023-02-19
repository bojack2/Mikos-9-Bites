package de.food.mikos.restaurant.frontend;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProductWindow extends MainWindow{

	public void showWindow(String productName, double productPrice, String productContent, String productImagePath) {

		BorderPane borderPane = new BorderPane();
		Stage productStage = new Stage();
	
		VBox productsInfoVbox = new VBox();
		
		Image img = new Image(productImagePath);
		
		if (productName.contains("Burger")) {
			img = new Image(productImagePath, 188, 132, false, false);
		}
		if (productName.contains("Pizza")) {
			img = new Image(productImagePath, 98, 132, false, false);
		}
		if (productName.contains("Hot Dog")) {
			img = new Image(productImagePath, 208, 92, false, false);
		}
		if (productContent.isEmpty()) {
			img = new Image(productImagePath, 78, 132, false, false);
		}  
		if (productName.equals("Tea") || productName.equals("Coffee")) {
			img = new Image(productImagePath, 203, 132, false, false);
		}
		
		ImageView imgView = new ImageView(img);
		Label productNameLabel = new Label(productName);
		Label productPriceLabel = new Label(productPrice + " €");
		Label productContentLabel = new Label("Ingredients:\n" + productContent);
		
		VBox productsVbox = new VBox();
		
		productsVbox = new VBox(5, productNameLabel, imgView, productPriceLabel);
		productsVbox.setAlignment(Pos.CENTER);
		productsVbox.setPadding(new Insets(0,0,0,0));
		
		productContentLabel.setMaxSize(200, 200);
		productContentLabel.setWrapText(true);
		
		if(!productContent.isEmpty()) {
			productsInfoVbox.getChildren().addAll(productContentLabel);
			productsVbox.setPadding(new Insets(0,70,0,0));
		}
		productsInfoVbox.setAlignment(Pos.CENTER);
		
		HBox productAndInfo = new HBox();
		productAndInfo.getChildren().addAll(productsVbox, productsInfoVbox);
		productAndInfo.setAlignment(Pos.CENTER);
		if (productName.contains("Hot Dog")) {
			productAndInfo.setPadding(new Insets(0,0,40,0));
		}
		
		Label quantityLabel = new Label("Quantity");
		Button minusButton = new Button("-");
		TextField amountOfProducts = new TextField("1");
		Button plusButton = new Button("+");
		Button addToBasketButton = new Button("Add To Order");
		Image companyLogo = new Image("file:resources/icons/company_logo_small.png", 139, 71, false, false);
		ImageView showCompanyLogo = new ImageView(companyLogo);
		
		minusButton.setPrefSize(50, 50);
		plusButton.setPrefSize(50, 50);
		
		amountOfProducts.setMaxSize(120, 40);
		amountOfProducts.setMinSize(120, 40);

		addToBasketButton.setPrefSize(120, 50);
		addToBasketButton.setId("greenButton");
		amountOfProducts.setAlignment(Pos.CENTER);
		
		
		/**
		 * Mix of two methods from authors:
		 * -Nicolas Filotto, Oct 14, 2017 at 8:52 
		 * -Abra, Feb 17, 2021 at 12:05
		 * Stackoverflow
		 */
		amountOfProducts.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*")) {
		        	amountOfProducts.setText(newValue.replaceAll("[^\\d]", ""));	
		        }
		        if (amountOfProducts.getText().length() > 2) {
	                String s = amountOfProducts.getText().substring(0, 2);
	                amountOfProducts.setText(s);
		        }
		    }
		});

		plusButton.setOnAction(click -> {
			String textInField = amountOfProducts.getText();
			int numberInField = Integer.parseInt(textInField);
			numberInField++;
			if(numberInField >= 99) {
				numberInField = 99;
			}
			Integer objectFromNumberInField = Integer.valueOf(numberInField);
			amountOfProducts.setText(objectFromNumberInField.toString());
		});
		minusButton.setOnAction(click -> {
			String textInField = amountOfProducts.getText();
			int numberInField = Integer.parseInt(textInField);
			numberInField--;
			if(numberInField <= 0) {
				numberInField = 1;
			}
			Integer objectFromNumberInField = Integer.valueOf(numberInField);
			
			amountOfProducts.setText(objectFromNumberInField.toString());
		});
		
		addToBasketButton.setOnAction(click ->{
			String textInField = amountOfProducts.getText();
			int numberInField = Integer.parseInt(textInField);
			double priceOfproductInWindow = productPrice * numberInField;
			
			nameOfSelectedProductList.add(productName);
			priceOfSelectedProductList.add(productPrice);
			amountOfSelectedProductList.add(numberInField);
			entirePriceOfSelectedProductList.add(priceOfproductInWindow);
			int quantity = 0;
			endPriceOfOrder = 0;
			for(int i = 0; i < amountOfSelectedProductList.size(); i++) {
				quantity += amountOfSelectedProductList.get(i);
				endPriceOfOrder += entirePriceOfSelectedProductList.get(i);
			}
			
			bill.setText("To be paid: " + (double) Math.round(endPriceOfOrder * 100) / 100 + "€" + "\nNumber of ordered articles: " + quantity);
			payBox.setVisible(true);

			productStage.close();
			
		});
		
		HBox firstRow = new HBox();
		firstRow.getChildren().addAll(quantityLabel);
		firstRow.setPadding(new Insets(40,0,0,0));
		firstRow.setAlignment(Pos.CENTER);
		
		HBox secondRow = new HBox(10);
		secondRow.getChildren().addAll(minusButton, amountOfProducts, plusButton);
		secondRow.setAlignment(Pos.CENTER);
		
		HBox thirdRow = new HBox();
		thirdRow.getChildren().addAll(addToBasketButton);
		thirdRow.setPadding(new Insets(20,0,0,0));
		thirdRow.setAlignment(Pos.CENTER);
		
		VBox centralPanel = new VBox(); 
		centralPanel.getChildren().addAll(firstRow, secondRow, thirdRow);
		centralPanel.setAlignment(Pos.CENTER);
		
		HBox logoVbox = new HBox();
		logoVbox.getChildren().addAll(showCompanyLogo);
		logoVbox.setAlignment(Pos.BOTTOM_RIGHT);
		
		VBox forAll = new VBox();
		forAll.getChildren().addAll(productAndInfo, centralPanel, logoVbox);
		forAll.setPadding(new Insets(20,0,0,0));
		
		borderPane.setCenter(forAll);
	
		firstRow.getStyleClass().add("WindowButtons");
		secondRow.getStyleClass().add("WindowButtons2");
		thirdRow.getStyleClass().add("WindowButtons");
		
		Scene productScene = new Scene(borderPane, 700, 450);
		productScene.getStylesheets().add("file:resources/style.css");
		productScene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Teko:wght@300&display=swap");
		
		productStage.setTitle("Miko's 9 Bites");
		productStage.setResizable(false);
		productStage.setScene(productScene);
		productStage.setAlwaysOnTop(true);
		productStage.show();
	}
}
