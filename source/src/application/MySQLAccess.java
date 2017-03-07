package application;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
        private Connection connect = null;
        private Statement statement = null;
        private PreparedStatement preparedStatement = null;
        private ResultSet resultSet = null;

        public void readDataBase() throws Exception {
                try {
                        // This will load the MySQL driver, each DB has its own driver
                        Class.forName("com.mysql.jdbc.Driver");
                        // Setup the connection with the DB
                        String connectionURL = "jdbc:mysql://localhost:3306/project?useSSL=false";
                        connect = DriverManager.getConnection(connectionURL, "root", "qppq2002");

                        // Statements allow to issue SQL queries to the database
                        statement = connect.createStatement();
                        
                        // Result set get the result of the SQL query
                        resultSet = statement.executeQuery("select * from project.ovelse");
                        writeResultSet(resultSet);

                        // PreparedStatements can use variables and are more efficient
                        preparedStatement = connect.prepareStatement("insert into  project.ovelse values (default, ?, ?)");
                        // Parameters start with 1
                        preparedStatement.setString(1, "Svømming");
                        preparedStatement.setString(2, "prøve å ikke synke.");
                        preparedStatement.executeUpdate();

                        preparedStatement = connect.prepareStatement("SELECT navn, beskrivelse OVELSE from project.ovelse");
                        resultSet = preparedStatement.executeQuery();
                        writeResultSet(resultSet);

                        /* Remove again the insert comment
                        preparedStatement = connect
                        .prepareStatement("delete from project.ovelse where myuser= ? ; ");
                        preparedStatement.setString(1, "Test");
                        preparedStatement.executeUpdate();
						*/
                        resultSet = statement
                        .executeQuery("select * from project.ovelse");
                        writeMetaData(resultSet);

                } catch (Exception e) {
                        throw e;
                } finally {
                        close();
                }

        }

        private void writeMetaData(ResultSet resultSet) throws SQLException {
                //         Now get some metadata from the database
                // Result set get the result of the SQL query

                System.out.println("The columns in the table are: ");

                System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
                for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
                        System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
                }
        }

        private void writeResultSet(ResultSet resultSet) throws SQLException {
                // ResultSet is initially before the first data set
                while (resultSet.next()) {
                        // It is possible to get the columns via name
                        // also possible to get the columns via the column number
                        // which starts at 1
                        // e.g. resultSet.getSTring(2);
                	resultSet.getString(1);
                }
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

                }
        }

}
