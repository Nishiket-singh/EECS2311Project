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
	
	
	
	
}
