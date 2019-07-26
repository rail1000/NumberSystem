package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NumcontiDao;
import model.Numconti;

public class NumcontiServlet extends HttpServlet { // 显示全部数据

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cx_kszh = req.getParameter("cx_kszh") == null ? "" : req.getParameter("cx_kszh");
		String cx_jszh = req.getParameter("cx_jszh") == null ? "" : req.getParameter("cx_jszh");
		System.out.println(cx_kszh);
		System.out.println(cx_jszh);
		NumcontiDao dao = new NumcontiDao();
		List<Numconti> list = dao.getAllNumconti(cx_kszh, cx_jszh);
		req.setAttribute("list", list);
		req.setAttribute("cx_kszh", cx_kszh);
		req.setAttribute("cx_jszh", cx_jszh);
		String info = req.getAttribute("info") == null ? "" : (String) req.getAttribute("info");
		req.setAttribute("info", info);
		req.getRequestDispatcher("numcontilist.jsp").forward(req, resp);
	}
}