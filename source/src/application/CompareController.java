package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CompareController {
	// Initialize JavaFX objects here
	@FXML
	Label BesteStyrkeLabel;
	
	@FXML
	Label BesteStyrkeVarighetLabel;

	@FXML
	Label BesteUtholdenhetLabel;
	
	@FXML
	Label BesteUtholdenhetVarighetLabel;
	
	@FXML
	Label BesteUtholdenhetLengdeLabel;

	// Need to have, don't touch
	public CompareController(){
	}
	
	// Need to have, don't touch
	@FXML
	private void initialize(){
//		Hnete ut form (?) fra databasen (MAX(FORM) fra de siste sju dagene 
//		og fra b�de utholdenhet og styrke (2 sp�rringer)
//		Lagre disse som strings, og sende de inn i setText() under.
//		Kanskje ogs� hente ut Datoen til �kta .. :) 
		BesteStyrkeLabel.setText("This is the text that will be put in here or something... ");
		BesteUtholdenhetLabel.setText("This is also text ... You get the point");
//		Gj�res for alle ... 
	}
	
}
