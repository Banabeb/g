package user.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import user.model.RegisterDao;
import user.pojo.user;


@WebServlet("/registeru")
public class RegisterUServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user user = accept(request);

		RegisterDao dao = new RegisterDao();

		int res = dao.insertUser(user);

		JSONObject jo = new JSONObject();

		if (res == 1) {
			jo.put("resultCode", 1);
			jo.put("message", "注冊成功");
		} else {
			jo.put("resultCode", 0);
			jo.put("message", "注冊失敗");
		}

		response.getWriter().print(jo);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public user accept(HttpServletRequest request) {

		String email = request.getParameter("email");
		String account = request.getParameter("account");
		String password = request.getParameter("password");

		user user = new user();

		user.setAccount(account);
		user.setEmail(email);
		user.setPassword(password);

		return user;
	}

}
