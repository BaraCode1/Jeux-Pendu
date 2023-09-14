package application;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class InscriptionController 
{
	

	



	    @FXML
	    private Button btnInscription;

	    @FXML
	    private Label confirmationSouscription;

	    @FXML
	    private PasswordField txtMotDePasse;

	    @FXML
	    private TextField txtNomDutilisateur;

	    @FXML
	    private TextField txtPrenom;
	    
	    @FXML
	    private Button btnRetour;

	   

	    @FXML
	    void Inscription(ActionEvent event) 
	    {
	    	 
	    		  
	    		  try 
		  	  	    {
		    		    String nomutilisateur=txtNomDutilisateur.getText();
		    		    String motdepasse=txtMotDePasse.getText();
		    		    String prenom=txtPrenom.getText();
		  	    		
		  	  	    	Class.forName("com.mysql.cj.jdbc.Driver");
		  	  	 		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jeux_pendu","root","Karma1234");
		  	  	 		Statement stmt= conn.createStatement();
		  	  	 		String sql="INSERT INTO joueurs(nom,nomutilisateur,motdepasse) VALUES ('"+prenom+"','"+nomutilisateur+"','"+motdepasse+"')";
		  	  	 		stmt.executeUpdate(sql);
		  	  	 		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		  	  	 		alert.setHeaderText("L'enregistrement a bien ete effectue");
		  	  	 		alert.setTitle("Bienvenue");
		  	  	 		alert.showAndWait();
		  	  	 	
		  	  	 	txtNomDutilisateur.clear();
		  	  	    txtPrenom.clear();
		  	  	    txtMotDePasse.clear();
		  	  	 		
		  	  	 		
		  	  	 	stmt.close();
		  	  	 	conn.close();
		  	  	  
		  	  	    }
		  	  	    catch(Exception e) 
		  	  	    {
		  	  	    
		  	  	    }
	    	  }
	    		
	    @FXML
	    void Retour(ActionEvent event) throws IOException 
	    {
          Stage stage= (Stage) btnRetour.getScene().getWindow();
          stage.close();
          Main m = new Main();
          m.changeScene("Login.fxml");
	    }


}
