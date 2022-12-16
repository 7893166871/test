package in.neuron.dynamicinput.JDBC.Operations;

//rt.jar => part of jdk s/w
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.ineuron.JDBC.Driver.Util.JdbcUtil;

//MYSQL _JAR => given by mysql db vendor
//import com.mysql.cj.jdbc.Driver;

public class InsertApp {
	public static void insertQueryApp() throws SQLException {

		Connection connection = null;
		Statement statement = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the sname value: ");
		String sname = sc.next();

		System.out.println("Enter the sage value: ");
		int sage = sc.nextInt();

		System.out.println("Enter the saddr value: ");
		String saddr = sc.next();

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				// Creation of statement object to move to the location using connection
				statement = connection.createStatement();
				if (statement != null) {
					String sqlSelectQuery = String.format(
							"insert into student(`sname`,`sage`,`saddr`) values ('%s',%d,'%s')", sname, sage, saddr);
					// Using Statement object execute the query
					System.out.println(sqlSelectQuery);
					int rowsAffected = statement.executeUpdate(sqlSelectQuery);

					// Process the resultSet to get the data
					System.out.print("No of RowsAffected: " + rowsAffected);
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// closing of resources

		finally {
			JdbcUtil.closeConnection(null, statement, connection);
			if (sc != null) {
				sc.close();
			}

		}

	}
}
