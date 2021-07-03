package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeInfoDeleteDao;

@WebServlet("/delete")
/**
 * 削除を実行し一覧画面へ遷移するサーブレット
 * 
 * @author setoakinari
 *
 */
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF-8");
		// employeeIdのリクエストパラメーターを取得
		String employeeId = request.getParameter("empId");
		// EmployeeInfoDeleteDaoをインスタンス化
		EmployeeInfoDeleteDao employeeInfoDeleteDao = new EmployeeInfoDeleteDao();

		try {
			// employeeIdの削除を実行
			employeeInfoDeleteDao.EmployeeInfoDelete(employeeId);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		// 一覧画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
