package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NumcontiDao;
import model.Numconti;

public class NumcontiDelServlet extends HttpServlet { // 显示全部数据

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id") == null ? "0" : req.getParameter("id");
		NumcontiDao sd = new NumcontiDao();
		Numconti numconti = new Numconti();
		numconti.setId(Integer.parseInt(id));
		// 进行信息修改
		if (sd.delNumconti(numconti)) {
			req.setAttribute("info", "删除成功！");
		} else {
			req.setAttribute("info", "删除失败！");
		}
		req.getRequestDispatcher("NumcontiServlet").forward(req, resp);
	}
}