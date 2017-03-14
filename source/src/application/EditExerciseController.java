package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class EditExerciseController {
	
	// private addToDatabase mysql;
	
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
	private VBox vb;
	
	Label belastning = new Label("Belastning");;
	TextField belastningTextField;
	
	Label repitisjoner = new Label("Repitisjoner");;
	TextField repitisjonerTextField;
	
	Label sett = new Label("Sett");;
	TextField settTextField;
	
	Label hastighet = new Label("Hastighet");;
	TextField hastighetTextField;
	
	Label pulssone = new Label("Pulssone");;
	TextField pulssoneTextField;
	
	Label varighet = new Label("Varighet");;
	TextField varighetTextField;
	
	@FXML
	public void handleChoiceChange(){
		if(choiceTextField.getText().equals("styrke")){			
			vb.getChildren().addAll(belastning, belastningTextField, repitisjoner, 
					repitisjonerTextField, sett, settTextField);
		}
		else if (choiceTextField.getText().equals("utholdenhet")) {
			vb.getChildren().addAll(hastighet, hastighetTextField, pulssone, pulssoneTextField, varighet,
					varighetTextField);
		}
	}
	
	@FXML
	private Button button;
	
	public void handleButtonPress(){
		String name = nameTextField.getText();
		String description = descriptionTextField.getText();
//		Spørring for øvelse
		
		if(choiceTextField.getText().equals("styrke")){
			int bel = Integer.parseInt(belastningTextField.getText());
			int rep = Integer.parseInt(repitisjonerTextField.getText());
			int set = Integer.parseInt(settTextField.getText());
//			Spørring for styrkeøvelse
		}
		else if (choiceTextField.getText().equals("utholdenhet")) {
			int hast = Integer.parseInt(hastighetTextField.getText());
			int puls = Integer.parseInt(pulssoneTextField.getText());
			int varig = Integer.parseInt(varighetTextField.getText());
//			Spørring for utholdenhet her
		}
		else {
			System.out.println("Dette skal ikke skje ... ");
		}
	}
	
}
