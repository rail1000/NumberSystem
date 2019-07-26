package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserDao {

	public User login(User user) { // 查询产品信息
		Connection conn = DbHelper.getConnection();
		String tablename = "";
		if ("1".equals(user.getRole())) {// 申请人
			tablename = " tbl_sqr ";
		} else if ("2".equals(user.getRole())) {// 审核人
			tablename = " tbl_shr ";
		} else if ("3".equals(user.getRole())) {// 补号人
			tablename = " tbl_bhr ";
		} else if ("4".equals(user.getRole())) {// 管理员
			tablename = " tbl_gly ";
		}
		String sql = "select * from " + tablename + " where username=? and pwd=?"; // SQL查询语句
		System.out.println(sql);
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				user.setId(rst.getInt("id")); // 得到ID
				user.setRealname(rst.getString("realname"));
			}
			rst.close(); // 关闭
			pst.close(); // 关闭
		} catch (SQLException e) {
			e.printStackTrace(); // 抛出异常
		}
		if (user.getRealname() == null) {
			user = null;
		}
		return user; // 返回一个集合
	}

}