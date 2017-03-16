package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;


public class MySQLAccess {
		private Connection connect = null;
        private Statement statement = null;
        private PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;

        
        public int getPrimaryKey(String tableName) throws Exception {
            try {
                // This will load the MySQL driver, each DB has its own driver
                Class.forName("com.mysql.jdbc.Driver");
                // Setup the connection with the DB
                String connectionURL = "jdbc:mysql://localhost:3306/treningsdagbok?useSSL=false";
                connect = DriverManager.getConnection(connectionURL, "root", "passord");

                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();

                resultSet = statement.executeQuery("select * from treningsdagbok." + tableName);

            	int lastKey = 0;
            	
                while (resultSet.next()) {
                	lastKey = resultSet.getInt(1);
                }
                
            	return lastKey;

            } catch (Exception e) {
                    throw e;
            } finally {
                    close();
            }
            	

    }
        
        public Time getPrimaryKey(String tableName, boolean isMalepunkt) throws Exception {
            try {
                // This will load the MySQL driver, each DB has its own driver
                Class.forName("com.mysql.jdbc.Driver");
                // Setup the connection with the DB
                String connectionURL = "jdbc:mysql://localhost:3306/treningsdagbok?useSSL=false";
                connect = DriverManager.getConnection(connectionURL, "root", "passord");

                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();

                resultSet = statement.executeQuery("select * from treningsdagbok." + tableName);

				Time lastKey = new Time(1); 
            	
                while (resultSet.next()) {
                	lastKey = resultSet.getTime(2);
                }
                
            	return lastKey;

            } catch (Exception e) {
                    throw e;
            } finally {
                    close();
            }
            	

    }
        
        
        public String getStringQuery(String tableName, boolean hasDefault, int numberOfParameters){
            String stringQuery = "insert into  treningsdagbok." + tableName +" values (";
            
            if (hasDefault){
            	stringQuery += "default";
                for (int i = 0; i < numberOfParameters; i++){
                	stringQuery += ", ?";
                }
            }
            else{
            	stringQuery += "?";
                for (int i = 0; i < numberOfParameters - 1; i++){
                	stringQuery += ", ?";
                }
            }
            
            stringQuery += ")";
            
            return stringQuery;
        }
        
        public int getNumberOfParameters(HashMap<Integer, String> stringMap, HashMap<Integer, Integer> intMap,
        		HashMap<Integer, Double> doubleMap, HashMap<Integer, Date> dateMap, HashMap<Integer, Time> timeMap){
        	
        	int parameters = 0;
        	
        	if (stringMap != null){
        		parameters += stringMap.size();
        	}
        	
        	if (intMap != null){
        		parameters += intMap.size();
        	}
        	
        	if (doubleMap != null){
        		parameters += doubleMap.size();
        	}
        	
        	if (dateMap != null){
        		parameters += dateMap.size();
        	}
        	
        	if (timeMap != null){
        		parameters += timeMap.size();
        	}
        	
        	return parameters;
        }
        
        public void writeDataBase(HashMap<Integer, String> stringMap, HashMap<Integer, Integer> intMap,
        		HashMap<Integer, Double> doubleMap, HashMap<Integer, Date> dateMap, HashMap<Integer, Time> timeMap, 
        		String tableName, boolean hasDefault) throws Exception {
        	
        	try {
                // This will load the MySQL driver, each DB has its own driver
                Class.forName("com.mysql.jdbc.Driver");
                // Setup the connection with the DB
                String connectionURL = "jdbc:mysql://localhost:3306/treningsdagbok?useSSL=false";
                connect = DriverManager.getConnection(connectionURL, "root", "passord");

                // Statements allow to issue SQL queries to the database
                statement = connect.createStatement();
                
                
                int numberOfParameters = getNumberOfParameters(stringMap, intMap, doubleMap, dateMap, timeMap);               
                String stringQuery = getStringQuery(tableName, hasDefault, numberOfParameters);
                preparedStatement = connect.prepareStatement(stringQuery);
                
                if (stringMap != null){
                    for (HashMap.Entry<Integer, String> entry : stringMap.entrySet()) {
                        Integer key = entry.getKey();
                        String value = entry.getValue();
                        preparedStatement.setString(key, value);
                    }
                }

                if (intMap != null){
                    for (HashMap.Entry<Integer, Integer> entry : intMap.entrySet()) {
                        Integer key = entry.getKey();
                        Integer value = entry.getValue();
                        System.out.println("Key: " + key + ", value: " + value);
                        preparedStatement.setInt(key, value);
                    }
                }
                
                if (doubleMap != null){
                    for (HashMap.Entry<Integer, Double> entry : doubleMap.entrySet()) {
                        Integer key = entry.getKey();
                        Double value = entry.getValue();
                        preparedStatement.setDouble(key, value);
                    }
                }
                
                if (dateMap != null){
                    for (HashMap.Entry<Integer, Date> entry : dateMap.entrySet()) {
                        Integer key = entry.getKey();
                        Date value = entry.getValue();
                        preparedStatement.setDate(key, value);
                    }
                }
                

                if (timeMap != null){
                    for (HashMap.Entry<Integer, Time> entry : timeMap.entrySet()) {
                        Integer key = entry.getKey();
                        Time value = entry.getValue();
                        System.out.println("Key: " + key + ", value: " + value);
                        preparedStatement.setTime(key, value);
                    }
                }

                preparedStatement.executeUpdate();



        } catch (Exception e) {
                System.out.println("Bug");
        		throw e;
        } finally {
                close();
        }
        	
        }
        
        
        
        public ArrayList readDataBase(String tableName) throws Exception {
                try {
                    // This will load the MySQL driver, each DB has its own driver
                    Class.forName("com.mysql.jdbc.Driver");
                    // Setup the connection with the DB
                    String connectionURL = "jdbc:mysql://localhost:3306/treningsdagbok?useSSL=false";
                    connect = DriverManager.getConnection(connectionURL, "root", "passord");

                    // Statements allow to issue SQL queries to the database
                    statement = connect.createStatement();

                    resultSet = statement.executeQuery("select * from treningsdagbok." + tableName);

                    writeMetaData(resultSet);
                    return writeResultSet(resultSet);

                } catch (Exception e) {
                        throw e;
                } finally {
                        close();
                }

        }

        private void writeMetaData(ResultSet resultSet) throws SQLException {
                // Now get some metadata from the database
                // Result set get the result of the SQL query

                System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
                for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
                        System.out.println("Kolonne " + i + " "+ resultSet.getMetaData().getColumnName(i));
                        System.out.println(resultSet.getMetaData().getColumnClassName(1));
                }
        }
        
        
        public ArrayList<String> getMetaData(ResultSet resultSet) throws SQLException {
        	
        	ArrayList<String>  res = new ArrayList<String>();
        	
        	for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){
        		res.add(resultSet.getMetaData().getColumnName(i));
        	}
        	
        	return res;
        }
        
        
        
        

        private ArrayList writeResultSet(ResultSet resultSet) throws SQLException {
                // ResultSet is initially before the first data set
        		
        	ArrayList<String> colName = getMetaData(resultSet);
        	int number_of_cols = colName.size();
        	
        	ArrayList<String> liste1 = new ArrayList<>();
        	String okt = "";
            while (resultSet.next()) {
                    // It is possible to get the columns via name
                    // also possible to get the columns via the column number
                    // which starts at 1

            	for (int i = 0; i < number_of_cols; i++){
            		okt += resultSet.getString(colName.get(i));
            	}
            	liste1.add(okt);
            	okt = "";
            }
			return liste1;
        }

        // You need to close the resultSet
        private void close() {
                try {
                        if (resultSet != null) {
                                resultSet.close();
                        }

                        if (statement != null) {
                                statement.close();
                        }

                        if (connect != null) {
                                connect.close();
                        }
                } catch (Exception e) {
                	System.out.println(e.getMessage());
                }
        }
}
