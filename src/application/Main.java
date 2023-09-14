package application;

	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;




public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) 
	{
		try {
			
		
			primaryStage.resizableProperty();
			Parent root= FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene= new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Jeux de pendu");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeScene(String fxml) throws IOException
	{
		Parent pane= FXMLLoader.load(getClass().getResource(fxml));
		Scene ecran= new Scene(pane);
		Stage affichage= new Stage();
		affichage.setScene(ecran);
		affichage.show();
		
	}
	
	public static void main(String[] args) 
	{
	
		launch(args);
		
	}
	
	
}
			
	  

