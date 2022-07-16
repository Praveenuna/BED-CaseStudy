import java.sql.*;
public class JdbcProgram1 {

	public static void main(String[] args) throws SQLException {
		
		Driver d = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver(d);

		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sys", "Kum@1001");
		
Statement st = con.createStatement();
st.executeUpdate("create table AssignmentCategory(AssignmentCategory varchar(30),Weight(%) number(10))");
		System.out.println("Table is created");
		con.close();
	}

}
