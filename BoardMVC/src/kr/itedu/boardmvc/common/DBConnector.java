package kr.itedu.boardmvc.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnector {

	public static void main(String args[]) {

	}

	public static Connection getConn() throws SQLException {

		Connection conn = null;
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/oracleDB");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

		return conn;

	}

	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void close(Connection conn, PreparedStatement ps) {

		close(conn, ps, null);
	}

	public static void close(Connection c) {
		close(c, null, null);
	}

	public static void close(PreparedStatement ps) {
		close(null, ps, null);
	}

	public static void close(PreparedStatement ps, ResultSet rs) {
		close(null, ps, rs);
	}
}
