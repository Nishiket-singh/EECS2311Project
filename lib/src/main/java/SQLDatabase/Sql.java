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
			Scanner myobj = new Scanner(System.in);
			System.out.println("Enter name");
			String name = myobj.nextLine();

			System.out.println("Enter age");
			int age = myobj.nextInt();
			myobj.nextLine();

			System.out.println("Enter gender");
			String gender = myobj.nextLine();


			System.out.println("Enter id ");
			int ID = myobj.nextInt();
			myobj.nextLine();


			System.out.println("Enter Username");
			String Username = myobj.nextLine();
			

			System.out.println("Enter password");
			String pass = myobj.nextLine();
			String[] query = {"select * from person_info;" ,"select * from Login_Info;"};
			String  query2 = "Insert into person_info(name,age,gender,ID)" + " VALUES(? ,? ,? ,?)";
			String query3 = "Insert into Login_Info(ID, Username, Password)" + "VALUES(? , ? , ?)";

			PreparedStatement  preparedstatement = con.prepareStatement(query2);
			preparedstatement.setString(1,name);
			preparedstatement.setInt(2, age);
			preparedstatement.setString(3, gender);
			preparedstatement.setInt(4, ID);
			preparedstatement.execute();
			
			PreparedStatement  preparedstatement2 = con.prepareStatement(query3);
			preparedstatement2.setInt(1, ID);
			preparedstatement2.setString(2,Username);
			preparedstatement2.setString(3,pass);

			preparedstatement2.execute();

			for (String q : query) {
				ResultSet result = statement.executeQuery(q);
				while ( result . next () ) {
					String data = " " ;

					for ( int i = 1; i < 4; i ++) {
						data += result . getString ( i ) + " ";
					}
					System . out . println ( data ) ;
				}
				System.out.println("\n");
			}

		} 
		catch ( SQLException e ) {
			e . printStackTrace () ;
		}
	}
}


