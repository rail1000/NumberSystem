package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.NumcontiDao;
import model.Numconti;

public class NumcontiInitServlet extends HttpServlet { // 显示全部数据

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id") == null ? "0" : req.getParameter("id");
		NumcontiDao dao = new NumcontiDao();
		Numconti numconti = dao.getNumcontiById(id);
		if (numconti == null) {
			numconti = new Numconti();
			numconti.setId(0);
		}
		req.setAttribute("numconti", numconti);
		req.getRequestDispatcher("numcontiedit.jsp").forward(req, resp);
	}
}