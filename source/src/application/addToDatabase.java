package application;

import java.sql.Time;
import java.util.HashMap;

public class addToDatabase {

	public void addOvelse(String navn, String beskrivelse){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, String> stringMap = new HashMap<Integer, String>(); 
        stringMap.put(1, navn);
        stringMap.put(2, beskrivelse);
		
		try {
			sql.writeDataBase(stringMap, null, null, null, null, "ovelse", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addUtholdenhetsovelse(int hastighet, int pulssone, Time varighet){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreginKey = 0;
		try {
			foreginKey = sql.getPrimaryKey("ovelse");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreginKey);
		intMap.put(2, hastighet);
		intMap.put(3, pulssone);

		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
        timeMap.put(4, varighet);
		
		try {
			sql.writeDataBase(null, intMap, null, null, timeMap, "utholdenhetsovelse", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addStyrkeovelse(int belastning, int repetisjon, int sett){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreginKey = 0;
		try {
			foreginKey = sql.getPrimaryKey("ovelse");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreginKey);
		intMap.put(2, belastning);
		intMap.put(3, repetisjon);
		intMap.put(4,  sett);
		
		try {
			sql.writeDataBase(null, intMap, null, null, null, "styrkeovelse", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		addToDatabase db = new addToDatabase();
		db.addOvelse("ny", "desc");
		
		Time varighet = new Time(2);
		
		MySQLAccess sql = new MySQLAccess();

		
		db.addOvelse("Vektløft", "Mark");
		db.addStyrkeovelse(10, 5, 20);
		
		
	}
	
}
