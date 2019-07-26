package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Numconti;

public class NumcontiDao {
	public List<Numconti> getAllNumconti(String kszh, String jszh) { // 查询所有信息
		List<Numconti> list = new ArrayList<Numconti>(); // 创建集合
		Connection conn = DbHelper.getConnection();
		String sql = "select * from numconti where 1=1 "; // SQL查询语句
		System.out.println(sql);
		if (!"".equals(kszh)) {
			sql = sql + " and numBegin <=" + kszh;
		}
		if (!"".equals(jszh)) {
			sql = sql + " and numEnd >=" + jszh;
		}
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				Numconti numconti = new Numconti();
				numconti.setId(rst.getInt("id")); // 得到ID
				numconti.setTypeA(rst.getString("typeA"));
				numconti.setTypeB(rst.getString("typeB"));
				numconti.setTypeC(rst.getString("typeC"));
				numconti.setNumBegin(rst.getString("numBegin"));
				numconti.setNumEnd(rst.getString("numEnd"));
				numconti.setDateP(rst.getString("dateP"));
				list.add(numconti);
			}
			rst.close(); // 关闭
			pst.close(); // 关闭
		} catch (SQLException e) {
			e.printStackTrace(); // 抛出异常
		}
		return list; // 返回一个集合
	}

	public Numconti getNumcontiById(String id) {
		Numconti numconti = new Numconti();
		Connection conn = DbHelper.getConnection();
		String sql = "select * from numconti a where a.id=" + id; // SQL查询语句
		System.out.println(sql);
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rst = pst.executeQuery();
			while (rst.next()) {
				numconti.setId(rst.getInt("id")); // 得到ID
				numconti.setTypeA(rst.getString("typeA"));
				numconti.setTypeB(rst.getString("typeB"));
				numconti.setTypeC(rst.getString("typeC"));
				numconti.setNumBegin(rst.getString("numBegin"));
				numconti.setNumEnd(rst.getString("numEnd"));
				numconti.setDateP(rst.getString("dateP"));
			}
			rst.close(); // 关闭
			pst.close(); // 关闭
		} catch (SQLException e) {
			e.printStackTrace(); // 抛出异常
		}
		return numconti; // 返回一个集合
	}

	public boolean updateNumconti(Numconti numconti) {
		String sql = "update numconti set typeA=?,typeB=?,typeC=?,numBegin=?,numEnd=?,dateP=? where id=?"; // 修改的SQL语句
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, numconti.getTypeA());
			pst.setString(2, numconti.getTypeB());
			pst.setString(3, numconti.getTypeC());
			pst.setString(4, numconti.getNumBegin());
			pst.setString(5, numconti.getNumEnd());
			pst.setString(6, DbHelper.getDate("yyyy-MM-dd HH:mm:ss"));
			pst.setInt(7, numconti.getId());
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; // 是否添加的判断
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean saveNumconti(Numconti numconti) {
		String sql = "insert into numconti (typeA,typeB,typeC,numBegin,numEnd,dateP) values(?,?,?,?,?,?)"; // 修改的SQL语句
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, numconti.getTypeA());
			pst.setString(2, numconti.getTypeB());
			pst.setString(3, numconti.getTypeC());
			pst.setString(4, numconti.getNumBegin());
			pst.setString(5, numconti.getNumEnd());
			pst.setString(6, DbHelper.getDate("yyyy-MM-dd HH:mm:ss"));
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; // 是否添加的判断
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delNumconti(Numconti numconti) {
		String sql = "delete from  numconti where id=?"; // 删除
		Connection conn = DbHelper.getConnection();
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, numconti.getId());
			int count = pst.executeUpdate();
			pst.close();
			return count > 0 ? true : false; // 是否添加的判断
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}