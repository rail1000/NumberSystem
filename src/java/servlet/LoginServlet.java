package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

public class LoginServlet extends HttpServlet { // 显示全部数据

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String role = req.getParameter("role");
		System.out.println(username + "    " + password + "    " + role);
		UserDao ud = new UserDao();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user = ud.login(user);
		if (user == null) {
			String message = "帐号、密码错误，登录失败！";
			req.setAttribute("message", message);
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.getSession().setAttribute("loginuser", user);
			String message = "";
			if ("1".equals(user.getRole())) {// 申请人
				message = "申请人登录成功";
				req.setAttribute("message", message);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			} else if ("2".equals(user.getRole())) {// 审核人
				message = "审核人登录成功";
				req.setAttribute("message", message);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			} else if ("3".equals(user.getRole())) {// 补号人
				message = "补号人登录成功";
				req.setAttribute("message", message);
				req.getRequestDispatcher("success.jsp").forward(req, resp);
			} else if ("4".equals(user.getRole())) {// 管理员
				message = "管理员登录成功";
				req.setAttribute("message", message);
				req.getRequestDispatcher("NumcontiServlet").forward(req, resp);
			}
		}
		// req.getSession().setAttribute("bhr", "bhr1");// 假设已经登录成功，记录当前补号人用户名
		// req.getRequestDispatcher("NumcontiServlet").forward(req, resp);
	}
}