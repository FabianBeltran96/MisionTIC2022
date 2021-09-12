package reto5.SpotSound.vista;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import reto5.SpotSound.dao.DAOException;
import reto5.SpotSound.dao.mysql.MySQLArtistaDao;
import reto5.SpotSound.modelos.Artista;

public class principal extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new FXMLLoader(getClass().getResource("interfazDefinitiva.fxml"));
		BorderPane panelBorder = loader.load();

		panelBorder.getStylesheets().add(getClass().getResource("test.css").toExternalForm());

		primaryStage.setScene(new Scene(panelBorder));
		primaryStage.setTitle("SpotSound App");
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}