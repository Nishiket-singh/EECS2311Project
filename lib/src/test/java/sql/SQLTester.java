package sql;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SQLTester {

	Connection con;
	String url;
	String user;
	String password;
	java.sql.Statement stmt;
	ResultSet rs;
	
	@BeforeEach
	void setup() throws SQLException{
		url = "jdbc:mysql://localhost:3306/User_Data" ;
		user = "root" ;
		password = "" ;
		java.sql.Statement stmt;
		ResultSet rs;
		con = DriverManager . getConnection ( url , user , password ) ;
	}
	
	@AfterEach
	void tearDown() throws SQLException {
		con.close();
	}
	
	@Test
	void test_numberOfColumns1() throws SQLException{ 
		rs = con.createStatement().executeQuery("select count(*) from information_schema.columns where table_name = 'person_info';");
		rs.next();
		assertEquals(4, rs.getInt(1)/2);
	}
	
	@Test
	void test_numberOfColumns2() throws SQLException{ 
		rs = con.createStatement().executeQuery("select count(*) from information_schema.columns where table_name = 'Login_Info';");
		rs.next();
		assertEquals(3, rs.getInt(1)/2);
	}
	
	@Test
	void test_numberOfRows1() throws SQLException{
		rs = con.createStatement().executeQuery("select name from person_info;");
		List<String> names = new ArrayList<String>();

        while (rs.next()) {
            names.add(rs.getString(1));
        }
        
        ResultSet rs2 = con.createStatement().executeQuery("select count(*) from person_info;");
        rs2.next();
        assertEquals(rs2.getInt(1), names.size());
	}
	
	@Test
	void test_numberOfRows2() throws SQLException{
		rs = con.createStatement().executeQuery("select username from Login_Info;");
		List<String> names = new ArrayList<String>();

        while (rs.next()) {
            names.add(rs.getString(1));
        }
        
        ResultSet rs2 = con.createStatement().executeQuery("select count(*) from Login_Info;");
        rs2.next();
        assertEquals(rs2.getInt(1), names.size());
	}
	
	
	
	
}
