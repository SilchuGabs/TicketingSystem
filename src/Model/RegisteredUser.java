package Model;

import java.util.Date;
import java.sql.*;

public class RegisteredUser  {

	private String creditCard;
	private String CVV;
	private int age;
	public static final String CONNECTION_STRING = "jdbc:postgresql://mod-fund-databases.cs.bham.ac.uk:5432/fundamentals";
	public static final String USER_NAME ="sgf854";
	public static final String PASSWORD ="Nazareno0519";

	public RegisteredUser(int age) {
		super();
		this.age=age;
	}

	public RegisteredUser() {

	}


	public void searchByDate(String firstname)  {

		Connection connection=null;
		try {
			connection= DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
			PreparedStatement st= connection.prepareCall ("SELECT firstname from staff where firstname=?");
			st.setString(1,  firstname);
			st.execute();
			ResultSet result=st.getResultSet();
			while (result.next()) {
				System.out.println(result.getString(1));
			}

		} catch (SQLException e) {
			System.out.println("Error.." + e.getMessage());

		}


	}


	public void searchByEvent(String eventName) {
		System.out.println ("silvana");
	}




}