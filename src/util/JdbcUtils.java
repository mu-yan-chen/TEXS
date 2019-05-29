package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcUtils {

	static String url = null;
	static String user = null;
	static String password = null;
	static {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
			Class.forName(bundle.getString("driver"));
			url = bundle.getString("url");
			user = bundle.getString("user");
			password = bundle.getString("password");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("���������ļ�ʧ��!");
		}
	}
	
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException("��ȡ����ʧ��!");
		}
	}
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
