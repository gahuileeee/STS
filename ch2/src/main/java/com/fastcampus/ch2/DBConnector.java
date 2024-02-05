package com.fastcampus.ch2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {
	public static Connection getConnection() throws SQLException, NamingException {
	    Context initCtx = new InitialContext();
	    Context ctx = (Context) initCtx.lookup("java:comp/env");
	    DataSource ds = (DataSource) ctx.lookup("jdbc/keyword");

	    Connection conn = ds.getConnection();
	    return conn;
	}
	  public static void close(Object stmt, Object rs, Object conn) throws SQLException {
		  if(rs instanceof ResultSet) {
			  ((ResultSet) rs).close();
		  }
		  if(stmt instanceof Statement) {
			  (( Statement) stmt).close();
		  }
		  if(conn instanceof Connection) {
			  ((Connection) conn).close();
		  }
	  }

}
