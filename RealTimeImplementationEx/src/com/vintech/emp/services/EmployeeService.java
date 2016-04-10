package com.vintech.emp.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vintech.proj.Emp;

public class EmployeeService {
public static void main(String[] args) throws Exception {
	Emp e=new Emp();
	Connection con=null;
	getEmployee(e);
	try{
		con = getConnection();

		String sql="insert into employee values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		populateparametres(e, pstmt);
		pstmt.executeQuery();
		pstmt.close();
		
			}
			catch(Exception  ex){}
			finally{
				if( con!=null){
					con.close();
				}
			}
}

private static void populateparametres(Emp e, PreparedStatement pstmt) throws SQLException {
	pstmt.setInt(1, e.getEid());
	pstmt.setString(2, e.getFirstName());
	pstmt.setString(3, e.getLastName());
	pstmt.setString(4, e.getEmail());
}

private static Connection getConnection() throws ClassNotFoundException, SQLException {
	Connection con;
	Class.forName("oracle.jdbc.driver.OracleDriver");
 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
	System.out.println("connection sucessfull");
	return con;
}

private static void getEmployee(Emp e) {
	e.setFirstName("bamboo");
	e.setLastName("dell");
	e.setEmail("bamboo@dell.com");
	e.setEid(3);
}
}
