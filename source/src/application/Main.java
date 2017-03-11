package application;
	
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("EditExerciseView.fxml"));
			
	        Scene scene = new Scene(root, 500, 800);
	    
	        primaryStage.setTitle("Treningsdagbok");
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		MySQLAccess sql = new MySQLAccess();
        sql.readDataBase("ovelse");
        
        
        
        HashMap<Integer, String> stringMap = new HashMap<Integer, String>();
        stringMap.put(1, "testtest");
        stringMap.put(2, "besktest");
        
        HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>();
        
        sql.writeDataBase(stringMap, intMap, null, null, null, "ovelse", true);	
        
        sql.readDataBase("ovelse");
        
//        sql.writeDataBase("Test�velse", "Dette er en test");
//        sql.readDataBase();
		// launch(args);
	}
}
