package application;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddActivityController {
	// Initialize JavaFX objects here

	@FXML
	TextField whatField;

	// Need to have, don't touch
	public AddActivityController(){
	}
	
	// Need to have, don't touch
	@FXML
	private void initialize(){
	}
	
	private addToDatabase add = new addToDatabase();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private MySQLAccess read = new MySQLAccess();
	
	@FXML
	private VBox vb;
	
	@FXML
	public void handleTextChange() {
		if (whatField.getText().equals("styrkeøvelse")) {
			Label lbl1 = new Label("Navn: (String)");
			TextField navn = new TextField();
			Label lbl2 = new Label("Beskrivelse: (String)");
			TextField beskrivelse = new TextField();
			Label lbl3 = new Label("Belastning: (int)");
			TextField belastning = new TextField();
			Label lbl4 = new Label("Repitisjoner: (int)");
			TextField repitisjoner = new TextField();
			Label lbl5 = new Label("Sett: (int)");
			TextField sett = new TextField();
			Button btn = new Button("Submit");
			vb.getChildren().addAll(lbl1, navn, lbl2, beskrivelse, lbl3, belastning, lbl4, repitisjoner, lbl5, sett, btn);
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                add.addOvelse(navn.getText(), beskrivelse.getText());
	                add.addStyrkeovelse(Integer.parseInt(belastning.getText()), 
	                		Integer.parseInt(repitisjoner.getText()), 
	                		Integer.parseInt(sett.getText()));
	            }
	        });
		}
		else if (whatField.getText().equals("utholdenhetsøvelse")) {
			Label lbl1 = new Label("Navn: (String)");
			TextField navn = new TextField();
			Label lbl2 = new Label("Beskrivelse: (String)");
			TextField beskrivelse = new TextField();
			Label lbl3 = new Label("Hastighet: (String)");
			TextField hastighet = new TextField();
			Label lbl4 = new Label("Pulssone: (String)");
			TextField pulssone = new TextField();
			Label lbl5 = new Label("Varighet: (Time (hh:mm:ss))");
			TextField varighet = new TextField();
			Button btn = new Button("Submit");
			vb.getChildren().addAll(lbl1, navn, lbl2, beskrivelse, lbl3, hastighet, lbl4, pulssone, lbl5, varighet, btn);
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	add.addOvelse(navn.getText(), beskrivelse.getText());
	            	add.addUtholdenhetsovelse(Integer.parseInt(hastighet.getText()), 
	                		Integer.parseInt(pulssone.getText()), 
	                		Time.valueOf(varighet.getText()));
	            }
	        });
		}
		else if (whatField.getText().equals("økt")) {
			Label lbl1 = new Label("Tidspunkt Start: (Time (hh:mm:ss))");
			TextField tidspunktStart = new TextField();
			Label lbl2 = new Label("Dato: (Date (yyyyMMdd))");
			TextField dato = new TextField();
			Label lbl3 = new Label("Varighet: (Time (hh:mm:ss))");
			TextField varighet = new TextField();
			Label lbl4 = new Label("Kaloriforbruk: (int)");
			TextField kaloriforbruk = new TextField();
			Label lbl5 = new Label("Notat: (String)");
			TextField notat = new TextField();
			Label lbl6 = new Label("Prestasjon: (int)");
			TextField prestasjon = new TextField();
			Label lbl7 = new Label("Form: (int)");
			TextField form = new TextField();
			Label lbl8 = new Label("Hvilke øvelser har du gjort? (String-liste (separert med ', ')");
			TextField ovelser = new TextField();
			Button btn = new Button("Submit");
			vb.getChildren().addAll(tidspunktStart, dato, varighet, kaloriforbruk, notat, prestasjon, form, 
					ovelser, btn);
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	            	Date date = new Date(0);
					try {
						date = new Date(sdf.parse(dato.getText()).getTime());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
	                add.addOkt(
	                		Time.valueOf(tidspunktStart.getText()),
	                		date,
	                		Time.valueOf(varighet.getText()),
	                		Integer.parseInt(kaloriforbruk.getText()),
	                		notat.getText(),
	                		Integer.parseInt(prestasjon.getText()),
	                		Integer.parseInt(form.getText()));
	            }
	        });
		}
		else if (whatField.getText().equals("stats")) {
			Button btn = new Button ("Statistikk for siste sju dager");
			vb.getChildren().addAll(btn);
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                try {
						for(Object okt : read.readDataBase("sisteokt")){
							Label label = new Label(okt.toString());
							vb.getChildren().addAll(label);
						}
	                	read.readDataBase("sisteokt");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
		}
		else if (whatField.getText().equals("historikk")) {
			Button btn = new Button ("Historikk for siste 30 dager");
			vb.getChildren().addAll(btn);
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                try {
	                	for(Object okt : read.readDataBase("sisteokter")){
							Label label = new Label(okt.toString());
							vb.getChildren().addAll(label);
							System.out.println(okt.toString());
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
	        });
		}
	}
}
