package in.ineuron.JDBC.Driver.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import in.neuron.dynamicinput.JDBC.Operations.DeleteApp;
import in.neuron.dynamicinput.JDBC.Operations.InsertApp;
import in.neuron.dynamicinput.JDBC.Operations.SelectApp;
import in.neuron.dynamicinput.JDBC.Operations.UpdateApp;

public class JdbcUtil {

	private JdbcUtil() {

	}

	public static Connection getJdbcConnection() throws SQLException {
		// resources used in jdbc application
		Connection connection = null;

		// 2. Establish the Connection
		String url = "jdbc:mysql://localhost:3306/enterprisejava";
		String user = "root";
		String password = "Srthn@123";

		connection = DriverManager.getConnection(url, user, password);

		if (connection != null)
			return connection;

		return connection;
	}

	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection)
			throws SQLException {

		// 6. closing the resources used
		if (resultSet != null) {
			resultSet.close();
		}
		if (statement != null) {
			statement.close();

		}
		if (connection != null) {
			connection.close();

		}

	}

	public static int takeInput() throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.print("User please select no from MENU!!:: ");
		int value = sc.nextInt();
		

		if (value >= 1 && value <= 4) {
			System.out.println("Validating...!!!");
			Thread.sleep(2000);

			return value;
		} else {
			Thread.sleep(2000);
			System.out.println("Validation not succesful, User! please guess number between 1 to 4!!");
		}
		return takeInput();
		
		
	}

	public static void main(String[] args) throws Exception {

		System.out.println("=========WELCOME TO JDBC OPERATIONS=========");
		System.out.println("MENU");
		System.out.print("1.CREATE \n");
		System.out.print("2.READ \n");
		System.out.print("3.UPDATE \n");
		System.out.print("4.DELETE \n");

		switch (takeInput()) {
		case 1:
			InsertApp.insertQueryApp();
			break;
		case 2:
			SelectApp.selectQueryApp();
			break;
		case 3:
			UpdateApp.updateQueryApp();
			break;
		case 4:
			DeleteApp.deleteQueryApp();
			break;
		default:
			System.out.println("*****INVALID INPUT********** ");
		}

		System.out.println("\n ====THANK YOU FOR USING THE APPLICATION========");
	}
}
