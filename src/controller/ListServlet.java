package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ListInfoBean;
import beans.LoginInfoBean;
import dao.EmployeeListDao;

@WebServlet("/list")
/**
 * DBから情報をとってきて一覧画面へ遷移するクラス
 *
 * @author setoakinari
 *
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 一覧画面表示用の情報を検索して、一覧画面へ遷移。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

		EmployeeListDao employeeListDao = new EmployeeListDao();
		List<ListInfoBean> infoBeanList = new ArrayList<ListInfoBean>();
		try {
			// 一覧用の情報を検索
			infoBeanList = employeeListDao.employeeListInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 一覧用の情報をセッションに保存
		session.setAttribute("InfoBeanList", infoBeanList);
		// 一覧画面へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}
}
