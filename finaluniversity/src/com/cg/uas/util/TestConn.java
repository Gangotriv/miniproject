package com.cg.uas.util;
import java.sql.*;

public class TestConn {

	    public static void main(String[] args) throws Exception {
	        String url = "jdbc:oracle:thin:@DIN39000585:1522:xe";
	        String username = "system";
	        String password = "root";
	        String driver = "oracle.jdbc.OracleDriver";

	        Class.forName(driver);
	        Connection conn = DriverManager.getConnection(url, username, password);
	        try {
	            Statement statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT SYSDATE FROM DUAL");
	            while(rs.next()) {
	                System.out.println(rs.getObject(1));
	            }
	        } finally {
	            conn.close();
	        }
	    }
	}
