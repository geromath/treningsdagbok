package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditExerciseController {
	
	private MySQLAccess mysql = new MySQLAccess();
	
	public EditExerciseController() {
	}
	
	@FXML
	public void initialize(){	
	}
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField descriptionTextField;
	
	@FXML
	private TextField choiceTextField;
	
	@FXML
	private Button button;
	
	public void handleButtonPress(){
		String name = nameTextField.getText();
		String description = descriptionTextField.getText();
		String choice = choiceTextField.getText();
		System.out.println(name + description + choice);
	}
	
}
