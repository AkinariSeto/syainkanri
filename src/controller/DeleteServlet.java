package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfoBean;
import dao.EmployeeListDao;

@WebServlet("/delete")
/**
 * 削除を実行し一覧画面へ遷移するサーブレット
 * 
 * @author setoakinari
 *
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 削除を実行するメソッド
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF-8");
		// セッションを生成
		HttpSession session = request.getSession(true);
		// ログイン情報をとってくる
		LoginInfoBean registerUser = (LoginInfoBean) session.getAttribute("loginInfo");
		// セッションが切れている場合ログインページに遷移
		if (registerUser == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// employeeIdのリクエストパラメーターを取得
		String empId = request.getParameter("empId");
		EmployeeListDao employeeListDao = new EmployeeListDao();

		try {
			// employeeIdの削除を実行
			employeeListDao.employeeInfoDelete(empId);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		// 一覧画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
