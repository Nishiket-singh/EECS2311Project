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
	
	@Test
	void test_username() throws SQLException{ 
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Harshil';");
		rs.next();
		assertEquals("hasd", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Aisha';");
		rs.next();
		assertEquals("Agft", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Esha';");
		rs.next();
		assertEquals("Ehgs", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Nish';");
		rs.next();
		assertEquals("Nisdf", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Hashim';");
		rs.next();
		assertEquals("Ssdr", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Amina';");
		rs.next();
		assertEquals("asdf", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ayesha';");
		rs.next();
		assertEquals("gsdg", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ailin';");
		rs.next();
		assertEquals("jdsaf", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ozzy';");
		rs.next();
		assertEquals("Oas", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.username from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Eagle';");
		rs.next();
		assertEquals("jsdg", rs.getString(1));	
	}
	
	
	@Test
	void test_password() throws SQLException{ 
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Harshil';");
		rs.next();
		assertEquals("123", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Aisha';");
		rs.next();
		assertEquals("456", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Esha';");
		rs.next();
		assertEquals("789", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Nish';");
		rs.next();
		assertEquals("012", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Hashim';");
		rs.next();
		assertEquals("382", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Amina';");
		rs.next();
		assertEquals("928", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ayesha';");
		rs.next();
		assertEquals("382", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ailin';");
		rs.next();
		assertEquals("205", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ozzy';");
		rs.next();
		assertEquals("208", rs.getString(1));
		rs = con.createStatement().executeQuery("select Login_info.password from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Eagle';");
		rs.next();
		assertEquals("203", rs.getString(1));	
	}
	
	@Test
	void test_ID() throws SQLException{ 
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Harshil';");
		rs.next();
		assertEquals(100, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Aisha';");
		rs.next();
		assertEquals(200, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Esha';");
		rs.next();
		assertEquals(300, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Nish';");
		rs.next();
		assertEquals(400, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Hashim';");
		rs.next();
		assertEquals(500, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Amina';");
		rs.next();
		assertEquals(600, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ayesha';");
		rs.next();
		assertEquals(700, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ailin';");
		rs.next();
		assertEquals(800, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Ozzy';");
		rs.next();
		assertEquals(900, rs.getInt(1));
		rs = con.createStatement().executeQuery("select Login_info.ID from Login_Info inner join person_info on Login_Info.ID = person_info.ID where person_info.name = 'Eagle';");
		rs.next();
		assertEquals(1000, rs.getInt(1));	
	}
	
	
	
	
	
	
}
