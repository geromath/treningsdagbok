package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LogController {
	// Initialize JavaFX objects here
		@FXML
		Label antallOkter;
		
		@FXML
		Label antallTimer;

		// Need to have, don't touch
		public LogController(){
		}
		
		// Need to have, don't touch
		@FXML
		private void initialize(){
//			Spørringer her og ... For antall økter og antall timer
			antallOkter.setText("This is an example");
			antallTimer.setText("This is another example");
		}
}
