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
			TextField navn = new TextField();
			TextField beskrivelse = new TextField();
			TextField belastning = new TextField();
			TextField repitisjoner = new TextField();
			TextField sett = new TextField();
			Button btn = new Button("Submit");
			vb.getChildren().addAll(navn, beskrivelse, belastning, repitisjoner, sett, btn);
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
			TextField navn = new TextField();
			TextField beskrivelse = new TextField();
			TextField hastighet = new TextField();
			TextField pulssone = new TextField();
			TextField varighet = new TextField();
			Button btn = new Button("Submit");
			vb.getChildren().addAll(navn, beskrivelse, hastighet, pulssone, varighet, btn);
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
			TextField tidspunktStart = new TextField();
			TextField dato = new TextField();
			TextField varighet = new TextField();
			TextField kaloriforbruk = new TextField();
			TextField notat = new TextField();
			TextField prestasjon = new TextField();
			TextField form = new TextField();
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
			vb.getChildren().addAll();
			btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                try {
	                	for(Object okt : read.readDataBase("sisteokt")){
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
