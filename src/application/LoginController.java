package application;
import java.io.IOException;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.DriverManager;




public class LoginController {

    @FXML
    private Button buttonConnectez;

    @FXML
    private Label txtMauvaiseInfo;
    
    @FXML
    private Button btnSinscrire;

    @FXML
    private PasswordField txtMotDePasse;
    
    @FXML
    private PasswordField txtMotDePasse2;

    @FXML
    private TextField txtNomDutilisateur;
    
    @FXML
    private Button buttonConnectez2;
    
    @FXML
    private Label txtMauvaiseInfo2;
    
    @FXML
    private TextField txtNomDutilisateur2;
    
    @FXML
    private String nomJoueur1;
    
    @FXML
    private String nomJoueur2;

    @FXML
    void SeConnectez(ActionEvent event) throws IOException, ClassNotFoundException
    {
    	
      
		try {
			loginJoueur1();
			
		    } 
		
		catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		/*catch (IOException e1) 
		{
			e1.printStackTrace();
		} */
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
         
	
		
	

    }
    
    @FXML
    void SeConnectez2(ActionEvent event) throws ClassNotFoundException, SQLException, IOException
    {
    	
    	try 
    	{
    		String nomjoueur2=txtNomDutilisateur2.getText();
    		String motdepasse2=txtMotDePasse2.getText();
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jeux_pendu","root","Karma1234");
    		Statement stmt= conn.createStatement();
    	    String sql= "select * from joueurs where nomutilisateur ='"+nomjoueur2+"' and motdepasse='"+motdepasse2+"'";
    	    ResultSet rs2= stmt.executeQuery(sql);
    	   
    	    if(rs2.next()) 
    	    {
    	    	FXMLLoader loader= new FXMLLoader();
    	    	loader.setLocation(getClass().getResource("FXMLDocument.fxml"));
     			Parent pane= loader.load();
     			Scene ecran= new Scene(pane);
     			FXMLDocumentController controller= loader.getController();
     			Stage affichage= new Stage();
     			affichage.setScene(ecran);
     			affichage.show();
     			nomJoueur2=rs2.getString("nom");
     			controller.lblJoueur2.setText(nomJoueur2);
     			controller.lblJoueur1.setText(nomJoueur1);
     			
     			Stage stage= (Stage) buttonConnectez2.getScene().getWindow();
     			stage.close();
    	    	
     			
    	    }
    	    
    	    else 
    	    {
    	    	txtMauvaiseInfo2.setText("Le nom d'utilisateur ou le mot de passe est incorrect");
    	    }
    	 
    	 stmt.close();
   	 	 rs2.close();
   	 	 conn.close();	
   	 	checkinguserinput();
    	}
    	
    	catch (ClassNotFoundException e1) 
		{
			e1.printStackTrace();
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	
    }
    	
    
    private void loginJoueur1() throws /*IOException,*/ ClassNotFoundException, SQLException 
    {
      

    	  String nomutilisateur1=txtNomDutilisateur.getText();
    	  String motdepasse1=txtMotDePasse.getText();
    	  
    	   	Class.forName("com.mysql.jdbc.Driver");
    		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jeux_pendu","root","Karma1234");
    		Statement stmt= conn.createStatement();
    	    String sql= "select * from joueurs where nomutilisateur ='"+nomutilisateur1+"' and motdepasse='"+motdepasse1+"'";
    	    ResultSet rs= stmt.executeQuery(sql);
    	   
    	  
    	  
    	 	 
    	 	 if(rs.next())
    	 	  {
    	 		 
    	 		 
    	 			nomJoueur1= rs.getString("nom");
    	 			
    	 			 
    	 			 txtMauvaiseInfo.setText("Joueur 1 connectez");
    	 			 //txtNomDutilisateur.clear();
    	 			 //txtMotDePasse.clear();
    	 			 txtNomDutilisateur.setDisable(true);
    	 			 txtMotDePasse.setDisable(true);
    	 			 buttonConnectez.setDisable(true);
    	 			 
    	 		 
    	 		 
    	 			 
    	    	}
    	 	 
    	 	 else 
    		  {
    			  txtMauvaiseInfo.setText("Le nom d'utilisateur ou le mot de passe est incorrect");
    		  }
    	 	 stmt.close();
    	 	 rs.close();
    	 	 conn.close();
      
    	 	checkfirstuserinput();
      
    }
    

    @FXML
    void Sinscrire(ActionEvent event) {
    	
    	try 
    	{
    		Main m= new Main();
    		m.changeScene("Souscription.fxml");
    		
    		Stage stage= (Stage) btnSinscrire.getScene().getWindow();
    		stage.close();
    		
    	}
    	catch(Exception e) 
    	{
    		
    	}
    	

    }
    
    void checkinguserinput() 
    {
    	
    	if(txtNomDutilisateur.getText().isEmpty() || txtMotDePasse.getText().isEmpty()
    			||txtNomDutilisateur2.getText().isEmpty() || txtMotDePasse.getText().isEmpty() ) 
    	{
    		
    		Alert alert= new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText("Un nom d'utilisateur ou un mot de passe ne peut pas etre vide");
	  	    alert.setTitle("Attention");
	  	    alert.showAndWait();
    	}
    }
    
    void checkfirstuserinput() 
    {
    	if(txtNomDutilisateur.getText().isEmpty() && txtMotDePasse.getText().isEmpty()) 
    	{
    		Alert alert= new Alert(Alert.AlertType.ERROR);
    		alert.setHeaderText("Un nom d'utilisateur ou un mot de passe ne peut pas etre vide");
	  	    alert.setTitle("Attention");
	  	    alert.showAndWait();
    	}
    }

}



