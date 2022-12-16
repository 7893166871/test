package in.neuron.dynamicinput.JDBC.Operations;

import java.util.Scanner;

import in.ineuron.JDBC.Driver.Util.JdbcUtil;

import java.sql.*;

public class UpdateApp {
	public static void updateQueryApp() throws SQLException {

		Connection connection = null;
		Statement statement = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sage value:: ");
		int sage = sc.nextInt();
		System.out.println("Enter the sid value:: ");
		int sid = sc.nextInt();

		try {
			connection = JdbcUtil.getJdbcConnection();
			if (connection != null) {
				statement = connection.createStatement();

				if (statement != null) {
					String updateQuery = String.format("update student set `sage`= %d where `sid` =%d", sage, sid);

					System.out.println(updateQuery);
					int noOfRows = statement.executeUpdate(updateQuery);

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
