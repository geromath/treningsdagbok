package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddActivityController {
	// Initialize JavaFX objects here
	@FXML
	TextField TidspunktStartField;
	
	@FXML
	TextField VarighetField;
	
	@FXML
	TextField KaloriforbrukField;
	
	@FXML
	TextField NotatField;
	
	@FXML
	TextField PrestasjonField;
	
	@FXML
	TextField FormField;
	
	@FXML
	TextField StyrkeOrUtholdenhet;
	
	@FXML
	TextField Exercises;
	
	@FXML
	Button SubmitButton;

	// Need to have, don't touch
	public AddActivityController(){
	}
	
	// Need to have, don't touch
	@FXML
	private void initialize(){
	}
	
	// Methods for handling events
	public void handleSubmitButton(){
		String tidspunktStart, varighet, kaloriforbruk, notat, prestasjon, form, styrkeOrUtholdenhet;
		String[] exercises = Exercises.getText().split(", ");
		for (String ex : exercises) {
			// Hent ut en og en string
		}
		tidspunktStart = TidspunktStartField.getText();
		varighet = VarighetField.getText();
		kaloriforbruk = KaloriforbrukField.getText();
		notat = NotatField.getText();
		prestasjon = PrestasjonField.getText();
		form = FormField.getText();
		styrkeOrUtholdenhet = StyrkeOrUtholdenhet.getText();
		// Queries go here ... 
	}
	
}
