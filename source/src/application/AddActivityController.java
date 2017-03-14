package application;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddActivityController {
	// Initialize JavaFX objects here
	@FXML
	DatePicker TidspunktStartField;
	
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
		LocalDate tidspunktStart;
		String notat, styrkeOrUtholdenhet;
		int varighet, kaloriforbruk, prestasjon, form;
		String[] exercises = Exercises.getText().split(", ");
		for (String ex : exercises) {
			// Henter ut alle øvelser herfra
		}
		tidspunktStart = TidspunktStartField.getValue();
		varighet = Integer.parseInt(VarighetField.getText());
		kaloriforbruk = Integer.parseInt(KaloriforbrukField.getText());
		notat = NotatField.getText();
		prestasjon = Integer.parseInt(PrestasjonField.getText());
		form = Integer.parseInt(FormField.getText());
		styrkeOrUtholdenhet = StyrkeOrUtholdenhet.getText();
		// Queries go here ... 
	}
	
}
