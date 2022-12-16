package in.neuron.dynamicinput.JDBC.Operations;

import java.sql.*;
import java.util.Scanner;

import in.ineuron.JDBC.Driver.Util.JdbcUtil;

public class SelectApp {

	public static void selectQueryApp() throws SQLException {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sid value: ");
		int sid = sc.nextInt();

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null) {

				statement = connection.createStatement();
				if (statement != null) {

					String sqlSelectQuery = String
							.format("select `sid`, `sname`, `sage`, `saddr` from student where sid= %d", sid);
					System.out.println(sqlSelectQuery);
					resultSet = statement.executeQuery(sqlSelectQuery);

					
					if (resultSet.next()) {
						System.out.println("SID\tSNAME\tSAGE\tSADDR");
						System.out.println("==============================");
						int viewsid = resultSet.getInt("sid");
						String viewsname = resultSet.getString("sname");
						int viewsage = resultSet.getInt("sage");
						String viewsaddr = resultSet.getString("saddr");

						System.out.println(viewsid + "\t" + viewsname + "\t" + viewsage + "\t" + viewsaddr);
					} else {
						System.out.println("Record not available for the given id:: " + sid);
					}
				}

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.closeConnection(resultSet, statement, connection);
			if (sc != null) {
				sc.close();
			}
		}
	}
}
