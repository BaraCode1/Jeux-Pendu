package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javafx.scene.layout.Pane;


 public class FXMLDocumentController   {
	 
	    @FXML
	    private Pane ZoneDessin;
	   
	    @FXML
	    private Label lblInfo;
	    
	    @FXML
	    private Label lblInfo2;
	    
	    @FXML
	    private Button btnQuitter;
   
	    @FXML
	    private Button button;
	    @FXML
	    public Label lblJoueur1;

	    @FXML
	    public Label lblJoueur2;
	   
	    @FXML
	    private Pane pane2;
	    
	    @FXML
	    private Pane pane3;

	    @FXML
	    private TextField textScore;

	    @FXML
	    private TextField txtMot;

	    @FXML
	    private TextField txtMotTrouver;
	    @FXML
        public Character motAjouter; 
	    @FXML
	    public Character motAjouter2;
	    @FXML
	    public String wordJoueur1;
	    @FXML
	    public String wordJoueur2;
	    @FXML
	    public StringBuilder sbJoueur1;
	    @FXML
	    public StringBuilder sbJoueur2;
	    @FXML
	    Integer errorJoueur1=0;
	    @FXML
	    Integer errorJoueur2=0;
	   
	    @FXML
	    Integer countJoueur1=0;
	    @FXML
	    Integer countJoueur2=0;
	  
	    @FXML
	    Integer NumberofPoints=1;
	
	    @FXML
	    private Button button2;

 
	    @FXML
	    private TextField textScore2;

	    @FXML
	    private TextField txtMotJoueur2;

	    @FXML
	    private TextField txtMotTrouver2;

	    @FXML
	    private Button indice1;

	    @FXML
	    private Button indice2;
	  
	    @FXML
	    private Boolean clickIndice1=false;
	    @FXML
	    private Boolean clickIndice2=false;
	    
	    @FXML
	    private Label txtMauvaiseInfo2;
	   
	  
	   @FXML
	    void getText(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, SQLException 
	    {
	    	 try {
				gettingUserInput1(event);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
	    	
	    }

	    
	    @FXML
	    void getText2(ActionEvent event) 
	    {
	       gettingUserInput2(event);    
	    	

	    }



	    	         
	    
	   @FXML
	    void quitter(ActionEvent event) throws IOException {
		   javafx.application.Platform.exit();
		    
		    Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("Login.fxml"));
				Scene scene= new Scene(root);
				Stage stage= new Stage();
				stage.setScene(scene);
				stage.setTitle("Jeux de pendu");
				stage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
	    }
	 
	    
	    

	    public void LecturePremierFichier( ) 
	    {
	        
			    String ligne;
				BufferedReader data;
				try {
					data = new BufferedReader( new FileReader("C:/Users/bdiou/OneDrive/Bureau/JeuxPendu/WORDS_1.txt"));
			      List <String> words= new ArrayList<>();
				
					do 
					{
							ligne=data.readLine();
							words.add(ligne);
					}
					while(ligne!=null);
					Random rand= new Random();
					wordJoueur1=words.get(rand.nextInt(words.size()));
					sbJoueur1= new StringBuilder();
				    
				    
				 
					for(int i=0;i<wordJoueur1.length();i++) 
					{
					
							txtMotTrouver.setText(String.valueOf(sbJoueur1.append('*')));

					}
					
					
					
				}
				
				
				       catch (FileNotFoundException e) 
						
						{
							
							e.printStackTrace();
						}
				catch (IOException e) 
				
				{
					
				}
				
				
	    }

	    public void LectureDeuxiemeFichier( ) 
	    {
	        
			    String ligne;
				BufferedReader data;
				try {
					data = new BufferedReader( new FileReader("C:/Users/bdiou/OneDrive/Bureau/JeuxPendu/WORDS_2.txt"));
						
			      List <String> words= new ArrayList<>();
				
					do 
					{
							ligne=data.readLine();
							words.add(ligne);
					}
					while(ligne!=null);
					Random rand= new Random();
					wordJoueur2=words.get(rand.nextInt(words.size()));
					sbJoueur2= new StringBuilder();
				    
				    
				 
					for(int i=0;i<wordJoueur2.length();i++) 
					{
					
							txtMotTrouver2.setText(String.valueOf(sbJoueur2.append('*')));

					}
					
					
					
				}
				
				
				       catch (FileNotFoundException e) 
						
						{
							
							e.printStackTrace();
						}
				catch (IOException e) 
				
				{
					
				}
				
				
	    }



	    @FXML
	    void Demarrez(ActionEvent event) 
	    {
	    	LecturePremierFichier();
	    	LectureDeuxiemeFichier();
	    	
	    }

	  

	   
	 
	    
	    
	    @FXML
	    void IndiceJoueur1(ActionEvent event)
	    {
	    	clickIndice1=true;
	    	if(event.getSource()==indice1) 
	    	{
	    	int numero =wordJoueur1.length();
	    	 switch(numero) 
	    	 {
	    	 case 5:
	    		 lblInfo.setText("Capital du Senegal");
	    		
	    		 break;
	    	 case 6:
	    		 lblInfo.setText("Capital du Royaume-Uni");
	    		 
	    		 break;
	    	 case 7:
	    		 lblInfo.setText("Ville de la Thailande");
	    		
	    		 break; 
	    	 case 8 :
	    		 lblInfo.setText("Ville du Maroc commencant par un M");
	    		 
	    		 break;
	    	 case 9:
	    		 lblInfo.setText("Ville de l'espagne commencant par un B");
	    		
	    		 break;
	     
	    	 }
	    	 
	    	}
	     }
	

	    @FXML
	    void IndiceJoueur2(ActionEvent event) 
	    {
	    	clickIndice2=true;
	    	if(event.getSource()==indice2) 
	    	{
	    		
	    	int numero =wordJoueur2.length();
	    	 switch(numero) 
	    	 {
	    	 case 4:
	    		 lblInfo2.setText("Pays de Fidel Castro");
	    		
	    		 break;
	    	 case 5:
	    		 lblInfo2.setText("Pays du Nagasaki");
	    		 
	    		 break;
	    	 case 6:
	    		 lblInfo2.setText("Pays de L'Afrique commencant par A");
	    		
	    		 break; 
	    	 case 7 :
	    		 lblInfo2.setText("Pays du Paella");
	    		 
	    		 break;
	    	 case 8:
	    		 lblInfo2.setText("Pays d'europe commencant par un D");
	    		
	    		 break;
	     
	    	 }
	    	 
	    	}

	    }
	    
	     
	    
	    
	    private void gettingUserInput1(ActionEvent event) throws FileNotFoundException, ClassNotFoundException, SQLException {
			List <Character>playerGuesses= new ArrayList<>();
			 int nbrePointsJoueur1 =0;
					
			 if(event.getSource()==button) 
			 {
				 
					motAjouter=Character.valueOf(txtMot.getText().charAt(0));
					
					
					 playerGuesses.add(motAjouter);
					 txtMot.clear();
					 
					 
					  for(int i=0;i<wordJoueur1.length();i++) 
			          {
						 
			     		 if(playerGuesses.contains(wordJoueur1.charAt(i)))
						    {
			     			sbJoueur1.setCharAt(i,wordJoueur1.charAt(i));
							      txtMotTrouver.setText(sbJoueur1.toString());
							      
							     
						    }   
			     		 if(txtMotTrouver.getText().contains(wordJoueur1) || errorJoueur2==5) 
			     		 {
			     			 
			     			 if(clickIndice1==true) 
			     			 {
			     				nbrePointsJoueur1=countJoueur1*NumberofPoints-1;
			     				System.out.println(nbrePointsJoueur1);
			     				
			     			
			     			 }
			     			if(clickIndice1==false)
			     				 
			     			 {
			     				nbrePointsJoueur1=countJoueur1*NumberofPoints;
			     				System.out.println(nbrePointsJoueur1);
			     			 }
			     		 
			     			 
			     			 
			     			 txtMotJoueur2.setDisable(true);
			     			 txtMotJoueur2.setStyle("-fx-border-color: red");
			     			 String nomJoueur= lblJoueur1.getText();
			        		  Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
			        		  alert.setHeaderText("Bravo "+" "+nomJoueur+" "+"vous avez"+" "+nbrePointsJoueur1+"");
				  	  	 	  alert.setTitle("Victoire !");
				  	  	 	  alert.setContentText("Est ce que vous voulez sauvegarder vos points");
				  	  	 	  Optional<ButtonType> result=alert.showAndWait();
				  	  	 	  if(result.get()==ButtonType.OK) 
				  	  	 	  {
				  	  	 		  try 
				  	  	 		  {
				  	  	 			Class.forName("com.mysql.cj.jdbc.Driver");
					  	    		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jeux_pendu","root","Karma1234");
					  	    		Statement stmt= conn.createStatement();
					  	    	    String sql= "select * from joueurs where nom ='"+nomJoueur+"'";
					  	    	    ResultSet rs2= stmt.executeQuery(sql);
					  	    	    
					  	    	    if(rs2.next()) 
					  	    	    {
					  	    	    	int id=rs2.getInt("idjoueur");
					  	    	    	String insPoints="INSERT INTO score(idjoueur,scoremax) VALUES ('"+id+"','"+nbrePointsJoueur1+"')";
					  	    	    	stmt.executeUpdate(insPoints);
					  	    	    	Alert message = new Alert(Alert.AlertType.INFORMATION);
						  	  	 		message.setHeaderText("L'enregistrement a bien ete effectue");
						  	  	 		message.setTitle("Nice");
						  	  	 		message.showAndWait();
						  	  	 	    NettoyageDesBoites();
						  	  	 		
						  	  	 	stmt.close();
						  	  	 	conn.close();
					  	    	    }
				  	  	 		  }
				  	  	 		  catch(Exception e) 
				  	  	 		  {
				  	  	 			  
				  	  	 		  }
				  	  	 		
				  	  	 		 
				  	  	 	  }
				  	  	 	  else 
				  	  	 	  {
				  	  	 		  if(result.get()==ButtonType.CANCEL) 
				  	  	 		  {
				  	  	 			NettoyageDesBoites();
				  	  	 		  }
				  	  	 		  
				  	  	 	  }
			     		 }
					  
					 
			          }
					 
					
					 			 
					  if(!wordJoueur1.contains(String.valueOf(motAjouter))) 
					  {
						   		         			 
			         			 switch(errorJoueur1++)
			         			 {
			         			
			         			 case 0 : 
			         				 
									ImageView image= new ImageView("image1.jpg");
									image.setFitHeight(200);
									image.setFitWidth(300);
									pane2.getChildren().add(image);
									txtMot.setDisable(true);
									txtMotJoueur2.requestFocus();
									txtMotJoueur2.setDisable(false);
				    	        	break;
			         			 case 1:
			         				ImageView image2= new ImageView("image2.jpg");
			         				image2.setFitHeight(200);
									image2.setFitWidth(300);
									pane2.getChildren().add(image2);
									txtMotJoueur2.requestFocus();
									txtMot.setDisable(true);
									txtMotJoueur2.setDisable(false);
			 	         				break;
				    	        			
			         			 case 2:
			         				 

			         				ImageView image3= new ImageView("image3.jpg");
			         				image3.setFitHeight(200);
									image3.setFitWidth(300);
									pane2.getChildren().add(image3);
									txtMotJoueur2.requestFocus();
									txtMot.setDisable(true);
									txtMotJoueur2.setDisable(false);
			         				break;
			         				
			         			 case 3:
			         				 
			         				ImageView image4= new ImageView("image4.jpg");
			         				image4.setFitHeight(200);
									image4.setFitWidth(300);
									pane2.getChildren().add(image4);
									txtMotJoueur2.requestFocus();
									txtMot.setDisable(true);
									txtMotJoueur2.setDisable(false);
			         				break;
			         				
			         			 case 4:
			         				ImageView image5= new ImageView("image5.jpg");
			         				image5.setFitHeight(200);
									image5.setFitWidth(300);
									pane2.getChildren().add(image5);
									txtMotJoueur2.requestFocus();
									txtMot.setDisable(true);
									txtMotJoueur2.setDisable(false);
			         				break;
			         				 
			         			 case 5:
			         				ImageView image6= new ImageView("image6.jpg");
			         				image6.setFitHeight(200);
									image6.setFitWidth(300);
									pane2.getChildren().add(image6);
									txtMotJoueur2.requestFocus();
									txtMot.setDisable(true);
									txtMotJoueur2.setDisable(false);
			         				break;
			         			
				    	        			
			         			 }
			         				
					  }
					  
					  if(wordJoueur1.contains(String.valueOf(motAjouter))) 
					  {
						  
						  for(int i=0;i<wordJoueur1.length();i++) 
						  {
							  if(wordJoueur1.charAt(i) == motAjouter)
								  countJoueur1++;
							 
						  }
						  
						  textScore.setText(Integer.toString(countJoueur1*NumberofPoints ) +" "+ "points");
						 
					  }
					 
			  }
		}


		private void NettoyageDesBoites() {
			   txtMot.clear();
			   textScore.clear();
			   txtMotTrouver.clear();
			   txtMotJoueur2.clear();
			   textScore2.clear();
			   txtMotTrouver2.clear();
			   lblInfo.setText("");
			   lblInfo2.setText("");
			   
		}
	    
	    private void gettingUserInput2(ActionEvent event) {
	    	int nbrePointsJoueur2 =0;
		    
				List <Character>playerGuesses= new ArrayList<>();
					
					 if(event.getSource()==button2) 
					 {
						 
			  	  	 	  
							motAjouter2=Character.valueOf(txtMotJoueur2.getText().charAt(0));
							 playerGuesses.add(motAjouter2);
							 txtMotJoueur2.clear();
				    		 
				    		 
				    		  for(int i=0;i<wordJoueur2.length();i++) 
					          {
				    			 
				         		 
				         		if(playerGuesses.contains(wordJoueur2.charAt(i)))
							    {
			         			sbJoueur2.setCharAt(i,wordJoueur2.charAt(i));
								      txtMotTrouver2.setText(sbJoueur2.toString());
								      
								     
							    }    
				         		
				         		 if(txtMotTrouver2.getText().contains(wordJoueur2) || errorJoueur1==5) 
					     		 {
				         			 
				         			 if(clickIndice2==true) 
					     			 {
					     				nbrePointsJoueur2=countJoueur2*NumberofPoints-1;
					     				
					     				
					     			
					     			 }
					     			if(clickIndice2==false)
					     				 
					     			 {
					     				nbrePointsJoueur2=countJoueur1*NumberofPoints;
					     				
					     			 }
				         			txtMot.setDisable(true);
				         			txtMot.setStyle("-fx-border-color: red");
					     			 String nomJoueur2= lblJoueur2.getText();
					        		  Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
					        		  alert.setHeaderText("Bravo "+" "+nomJoueur2+" "+"vous avez"+" "+nbrePointsJoueur2+"");
						  	  	 	  alert.setTitle("Victoire !");
						  	  	 	  alert.setContentText("Est ce que vous voulez sauvegarder vos points");
						  	  	 	  Optional<ButtonType> result=alert.showAndWait();
						  	  	 	  if(result.get()==ButtonType.OK) 
						  	  	 	  {
						  	  	 	  try 
					  	  	 		  {
					  	  	 			Class.forName("com.mysql.cj.jdbc.Driver");
						  	    		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jeux_pendu","root","Karma1234");
						  	    		Statement stmt= conn.createStatement();
						  	    	    String sql= "select * from joueurs where nom ='"+nomJoueur2+"'";
						  	    	    ResultSet rs2= stmt.executeQuery(sql);
						  	    	    
						  	    	    if(rs2.next()) 
						  	    	    {
						  	    	    	int id=rs2.getInt("idjoueur");
						  	    	    	String insPoints="INSERT INTO score(idjoueur,scoremax) VALUES ('"+id+"','"+nbrePointsJoueur2+"')";
						  	    	    	stmt.executeUpdate(insPoints);
						  	    	    	Alert message = new Alert(Alert.AlertType.INFORMATION);
							  	  	 		message.setHeaderText("L'enregistrement a bien ete effectue");
							  	  	 		message.setTitle("Nice");
							  	  	 		message.showAndWait();
							  	  	 	    NettoyageDesBoites();
							  	  	 		
							  	  	 	stmt.close();
							  	  	 	conn.close();
						  	    	    }
					  	  	 		  }
					  	  	 		  catch(Exception e) 
					  	  	 		  {
					  	  	 			  
					  	  	 		  }
						  	  	 	  }
						  	  	 	  else 
						  	  	 	  {
						  	  	 		  if(result.get()==ButtonType.CANCEL) 
						  	  	 		  {
						  	  	 			NettoyageDesBoites();
						  	  	 		  }
						  	  	 		  
						  	  	 	  }
					     		 }
				         		
					          }
				    		  if(!wordJoueur2.contains(String.valueOf(motAjouter2))) 
				    		  {
				    			   
				    			  
					         			 
					         			 switch(errorJoueur2++)
					         			 {
					         			
					         			 case 0 : 
					         			
					         				ImageView image= new ImageView("image1.jpg");
											image.setFitHeight(200);
											image.setFitWidth(300);
											pane3.getChildren().add(image);
											txtMot.requestFocus();
											txtMotJoueur2.setDisable(true);
											txtMot.setDisable(false);
											
											
											break;
					         			 case 1:
				                                                    
					         				ImageView image2= new ImageView("image2.jpg");
											image2.setFitHeight(200);
											image2.setFitWidth(300);
											pane3.getChildren().add(image2);
											txtMot.requestFocus();
											txtMotJoueur2.setDisable(true);
											txtMot.setDisable(false);
											break;
					         			 case 2:
					         				 

					         				ImageView image3= new ImageView("image3.jpg");
											image3.setFitHeight(200);
											image3.setFitWidth(300);
											pane3.getChildren().add(image3);
											txtMot.requestFocus();
											txtMotJoueur2.setDisable(true);
											txtMot.setDisable(false);
				 	         				break;
				 	         				
					         			 case 3:
					         				 
					         				ImageView image4= new ImageView("image4.jpg");
											image4.setFitHeight(200);
											image4.setFitWidth(300);
											pane3.getChildren().add(image4);
											txtMot.requestFocus();
											txtMotJoueur2.setDisable(true);
											txtMot.setDisable(false);
				 	         				break;
				 	         				
					         			 case 4:
					         				ImageView image5= new ImageView("image5.jpg");
											image5.setFitHeight(200);
											image5.setFitWidth(300);
											pane3.getChildren().add(image5);
											txtMot.requestFocus();
											txtMotJoueur2.setDisable(true);
											txtMot.setDisable(false);
				 	         				break;
					         				 
					         			 case 5:
					         				ImageView image6= new ImageView("image6.jpg");
											image6.setFitHeight(200);
											image6.setFitWidth(300);
											pane3.getChildren().add(image6);
				 	         				System.out.println("Game is Over");
				 	         				txtMot.requestFocus();
				 	         				txtMotJoueur2.setDisable(true);
				 	         				txtMot.setDisable(false);
				 	         				break;
				 	         							
					         			 }
					         			 
				    		         
					         		 
				    		  }
				    		  
				    		  if(wordJoueur2.contains(String.valueOf(motAjouter2))) 
				    		  {
				    			  
				    			  for(int i=0;i<wordJoueur2.length();i++) 
				    			  {
				    				  if(wordJoueur2.charAt(i) == motAjouter2)
				    					  countJoueur2++;
				    				 
				    			  }
				    			  
				    			  textScore2.setText(Integer.toString(countJoueur2*NumberofPoints ) +" "+ "points");
				    			 
				    		  }
				    	
				    		 
					        	
					  }
			}
		    
	    
 }










	
	
	
		
		   
	







	
			
	
	

	




	
	
	





