package com.ParcialFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {
	public static ConfigurableApplicationContext context;
	public static void main(String[] args) {
		launch(args);
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		context = SpringApplication.run(Main.class);
		FXMLLoader fxmStarter = new FXMLLoader(getClass().getResource("/com/ParcialFX/starter.fxml"));
		fxmStarter.setControllerFactory(context::getBean);

		Scene starter = new Scene(fxmStarter.load());
		stage.setScene(starter);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
	}
}
