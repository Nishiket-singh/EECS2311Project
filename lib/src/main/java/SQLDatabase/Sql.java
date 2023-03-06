package SQLDatabase;
import java.sql.*;
import java.util.Scanner;


public class Sql {

	public static void main (String [] args) {
		String url = "jdbc:mysql://localhost:3306/User_Data";
		String user = "root";
		String password = "300A.phase5";

		try {
			Connection con = DriverManager . getConnection ( url , user , password ) ;

			Statement statement = con . createStatement () ;

		} 
		catch ( SQLException e ) {
			e . printStackTrace () ;
		}
	}
}


