import java.sql.*;

public class Tutorial34
{

	public static void main (String[]args)
	{
			// DB's always start with a connection object
		Connection conn = null;

		try
		{
				// The Driver allows for querying of the DB
				// forName will dynamically load the Class for you
			Class.forName("com.mysql.jdbc.Driver");

				// DriverManager is used to handle the JDBC drivers
				// getConnection will establish a connection to the DB
				// ("jdbc:mysql://localhost/schemaName", "userName", "passWord")
			conn = DriverManager.getConnection("jdbc:mysql://localhost/customers", "root", "admin");

				// Statement objects execute a SQL query on the DB
				// createStatement will return a statement object
			Statement sqlStatement = conn.createStatement();

				// This is the String in which I'm going to query the DB with
			String selectStatement = "SELECT first_name FROM CUSTOMER";

				// ResultSet is a table of data from the results of the SQL query
				// It can not be changed once it is been queried.
				// The progression can only be read in one direction
			ResultSet rows = sqlStatement.executeQuery(selectStatement);

				// use a while loop to loop through the results of the query
				// next will loop through until null is returned
			while(rows.next())
			{
				System.out.println(rows.getString("first_name"));

			}
		}
		catch(SQLException e)
		{
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("VendorException: " + e.getErrorCode());
		}
		catch(ClassNotFoundException e)
		{
				// This will execute if the driver can't be found
			e.printStackTrace();
		}

	}
}

/*
 * SQL
 * 		First, Creat a folder on your desktop for all of the java files you download
 * 		Download and Install MySQL Workbench
 * 			https://dev.mysql.com/downloads/workbench/
 *
 * 		Second, Download and Install MySQL connectors for java
 * 			https://dev.mysql.com/downloads/connector/j/
 *
 * 		Third, In Eclipse, right click on the folder in which the java file
 * 			you're working on is located in and click BUILD PATH
 * 			-> Configure Build Path -> then libraries tab
 * 			-> add external jars -> Find the connector.jar file you downloaded
 * 			in step 2.
 *
 * 		CREATE SCHEMA 'CUSTOMERS' ;
 *
 * 		USE CUSTOMERS;
 *
 * 		CREATE TABLE CUSTOMER((first_name, last_name, age, email, website);
 *
 * 		INSERT INTO CUSTOMER (first_name, last_name, age, email, website)
		VALUES ("James", "Patterson", 31, "jpatte95@students.kennesaw.edu", "jpatte95.pythonanywhere.com");
 *
 * 		INSERT INTO CUSTOMER (first_name, last_name, age, email)
		VALUES ("Jill", "Hardin", 52, "jill@mom.com");
 *
 * 		SELECT * FROM CUSTOMERS;
 *
 * 		SELECT * FROM CUSTOMERS WHERE first_name = "James";
 */
