package in.neuron.dynamicinput.JDBC.Operations;

import java.sql.*;
import java.util.Scanner;

import in.ineuron.JDBC.Driver.Util.JdbcUtil;

public class DeleteApp {

	public static void deleteQueryApp() throws SQLException {

		Connection connection = null;
		Statement statement = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sname value:: ");
		String sname = sc.next();

		connection = JdbcUtil.getJdbcConnection();
		try {
			if (connection != null) {
				statement = connection.createStatement();
				if (statement != null) {
					String deleteQuery = String.format("delete from student where `sname`='%s'", sname);
					System.out.println(deleteQuery);

					int noOfRows = statement.executeUpdate(deleteQuery);
					System.out.println("No of Rows Affected:: " + noOfRows);
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeConnection(null, statement, connection);
			if (sc != null) {
				sc.close();
			}
		}

	}
}
