package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbHelper;
import dao.NumcontiDao;
import model.Numconti;

@MultipartConfig
public class NumcontiSaveServlet extends HttpServlet { // 添加数据
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");// 主键
		String typeA = req.getParameter("typeA");// typeA
		String typeB = req.getParameter("typeB");// typeB
		String typeC = req.getParameter("typeC");// typeC
		String numBegin = req.getParameter("numBegin");// numBegin
		String numEnd = req.getParameter("numEnd");// numEnd
		String dateP = DbHelper.getDate("yyyy-MM-dd HH:mm:ss");// dateP
		System.out.println(id);
		System.out.println(typeA);
		System.out.println(typeB);
		System.out.println(typeC);
		System.out.println(numBegin);
		System.out.println(numEnd);
		System.out.println(dateP);
		NumcontiDao sd = new NumcontiDao();
		Numconti numconti = new Numconti();
		numconti.setTypeA(typeA);
		numconti.setTypeB(typeB);
		numconti.setTypeC(typeC);
		numconti.setNumBegin(numBegin);
		numconti.setNumEnd(numEnd);
		numconti.setDateP(dateP);
		if (id != null && !id.equals("0")) {// 修改
			numconti.setId(Integer.parseInt(id));
			// 进行信息修改
			if (sd.updateNumconti(numconti)) {
				req.setAttribute("info", "修改成功！");
			} else {
				req.setAttribute("info", "修改失败！");
			}
		} else// 新增
		{
			// 进行信息修改
			if (sd.saveNumconti(numconti)) {
				req.setAttribute("info", "保存成功！");
			} else {
				req.setAttribute("info", "保存失败！");
			}
		}

		req.getRequestDispatcher("NumcontiServlet").forward(req, resp);
	}
}