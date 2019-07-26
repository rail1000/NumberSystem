package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 连接数据库
 * 
 * @author 画船听雨眠
 *
 */
public class DbHelper {
	private static String url = "jdbc:mysql://127.0.0.1/db_mvc"; // 数据库地址
	private static String userName = "root"; // 数据库用户名
	private static String passWord = "root"; // 数据库密码
	private static Connection conn = null;

	private DbHelper() {

	}

	public static Connection getConnection() {
		if (null == conn) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, userName, passWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	// 获取当前时间 yyyy-MM-dd HH:mm:ss
	public static final String getDate(String type) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(type);// 转换格式
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdf.format(date);
	}

	public static void main(String[] args) { // 测试数据库是否连通
		System.err.println(getConnection());
	}
}