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
		if(choiceTextField.getText().equals("styrke")){
			String bel = belastningTextField.getText();
			String rep = repitisjonerTextField.getText();
			String set = settTextField.getText();
//			Sp�rring for styrke�velse
		}
		else if (choiceTextField.getText().equals("utholdenhet")) {
			String hast = hastighetTextField.getText();
			String puls = pulssoneTextField.getText();
			String varig = varighetTextField.getText();
//			Sp�rring for utholdenhet her
		}
		else {
			System.out.println("Dette skal ikke skje ... ");
		}
	}
	
}
