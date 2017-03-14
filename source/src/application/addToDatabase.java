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
        
		Integer foreignKey = 0;
		try {
			foreignKey = sql.getPrimaryKey("ovelse");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey);
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
	
	public void addMalsetning(int intensitet, Time varighet){
		
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
		intMap.put(2, intensitet);
		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(3, varighet);
		

		try {
			sql.writeDataBase(null, intMap, null, null, timeMap, "malsetning", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void addResultat(double prestasjon){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreginKey1 = 0;
		Integer foreginKey2 = 0;
		
		try {
			foreginKey1 = sql.getPrimaryKey("ovelse");
			foreginKey2 = sql.getPrimaryKey("okt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreginKey1);
		intMap.put(2, foreginKey2);
		
		HashMap<Integer, Double> doubleMap = new HashMap<Integer, Double>();
		doubleMap.put(3, prestasjon);
		
		 

		try {
			sql.writeDataBase(null, intMap, doubleMap, null, null, "resultat", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void addMal(int oktID, int ovelseID, Time varighet){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreginKey1 = 0;
		Integer foreginKey2 = 0;
		
		try {
			foreginKey1 = sql.getPrimaryKey("ovelse");
			foreginKey2 = sql.getPrimaryKey("okt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreginKey1);
		intMap.put(2, foreginKey2);
		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(3, varighet);
		
		 

		try {
			sql.writeDataBase(null, intMap, null, null, timeMap, "mal", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMaling(Time tidspunkt){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreginKey1 = 0;
		
		try {
			foreginKey1 = sql.getPrimaryKey("okt");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreginKey1);

		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, tidspunkt);
		
		 

		try {
			sql.writeDataBase(null, intMap, null, null, timeMap, "maling", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addUtemaling(String vaertype, double temperatur, String fore){
		
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreignKey1 = 0;
		@SuppressWarnings("deprecation")
		Time foreignKey2 = new Time(0, 0, 1);
		
		try {
			foreignKey1 = sql.getPrimaryKey("maling");
			foreignKey2 = sql.getPrimaryKey("maling", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey1);

		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, foreignKey2);
		
		HashMap<Integer, String> stringMap = new HashMap<Integer, String>();
		stringMap.put(3, vaertype);
		stringMap.put(4, fore);
		
		HashMap<Integer, Double> doubleMap = new HashMap<Integer, Double>();
		doubleMap.put(5, temperatur);

		 

		try {
			sql.writeDataBase(stringMap, intMap, doubleMap, null, timeMap, "utemaling", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void addInnemaling(double ventilasjon, int antallTilskuere){
		
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreignKey1 = 0;
		@SuppressWarnings("deprecation")
		Time foreignKey2 = new Time(0, 0, 1);
		
		try {
			foreignKey1 = sql.getPrimaryKey("maling");
			foreignKey2 = sql.getPrimaryKey("maling", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey1);
		intMap.put(4, antallTilskuere)

		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, foreignKey2);
		

		
		HashMap<Integer, Double> doubleMap = new HashMap<Integer, Double>();
		doubleMap.put(3, ventilasjon);

		 

		try {
			sql.writeDataBase(null, intMap, doubleMap, null, timeMap, "innemaling", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void addSvomMalepunkt(int lengde, int takPerLengde, double hastighet){
		
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreignKey1 = 0;
		@SuppressWarnings("deprecation")
		Time foreignKey2 = new Time(0, 0, 1);
		
		try {
			foreignKey1 = sql.getPrimaryKey("maling");
			foreignKey2 = sql.getPrimaryKey("maling", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey1);

		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, foreignKey2);
		
		intMap.put(3, lengde);
		intMap.put(4, takPerLengde);
		
		HashMap<Integer, Double> doubleMap = new HashMap<Integer, Double>();
		doubleMap.put(5, hastighet);

		 

		try {
			sql.writeDataBase(null, intMap, doubleMap, null, timeMap, "svom", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addSykkelMalepunkt(double watt, double cadence, int puls, double lengde, double hastighet){
		
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreignKey1 = 0;
		@SuppressWarnings("deprecation")
		Time foreignKey2 = new Time(0, 0, 1);
		
		try {
			foreignKey1 = sql.getPrimaryKey("maling");
			foreignKey2 = sql.getPrimaryKey("maling", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey1);
		intMap.put(7, puls);
		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, foreignKey2);
		
		
		HashMap<Integer, Double> doubleMap = new HashMap<Integer, Double>();
		doubleMap.put(3, watt);
		doubleMap.put(4, cadence);
		doubleMap.put(5, lengde);
		doubleMap.put(6, hastighet);


		try {
			sql.writeDataBase(null, intMap, doubleMap, null, timeMap, "sykkel", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addLopMalepunkt(int antallSkritt, int puls, double lengde, double hastighet){
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreignKey1 = 0;
		@SuppressWarnings("deprecation")
		Time foreignKey2 = new Time(0, 0, 1);
		
		try {
			foreignKey1 = sql.getPrimaryKey("maling");
			foreignKey2 = sql.getPrimaryKey("maling", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey1);
		intMap.put(3, antallSkritt);
		intMap.put(6, puls);
		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, foreignKey2);
		
		
		HashMap<Integer, Double> doubleMap = new HashMap<Integer, Double>();
		doubleMap.put(4, hastighet);
		doubleMap.put(5, lengde);
		

		try {
			sql.writeDataBase(null, intMap, doubleMap, null, timeMap, "lop", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addStyrkeMalepunkt(int vekt, int repetisjon, int sett){
		
		MySQLAccess sql = new MySQLAccess();
		
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>(); 
        
		Integer foreignKey1 = 0;
		@SuppressWarnings("deprecation")
		Time foreignKey2 = new Time(0, 0, 1);
		
		try {
			foreignKey1 = sql.getPrimaryKey("maling");
			foreignKey2 = sql.getPrimaryKey("maling", true);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		intMap.put(1, foreignKey1);
		intMap.put(3, vekt);
		intMap.put(4, repetisjon);
		intMap.put(5, sett);
		
		HashMap<Integer, Time> timeMap = new HashMap<Integer, Time>();
		timeMap.put(2, foreignKey2);
		
		

		try {
			sql.writeDataBase(null, intMap, null, null, timeMap, "styrke", false);
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
