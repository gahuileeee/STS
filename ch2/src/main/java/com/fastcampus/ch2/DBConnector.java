package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	  public static Connection getConnection(String host, String database, String user, String password) throws SQLException {
	        String DB_URL = "jdbc:mysql://" + host + "/" + database + "?useUnicode=true&"
	                + "characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
	        return DriverManager.getConnection(DB_URL, user, password);
	    }

}
