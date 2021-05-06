package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ListInfoBean;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF-8");
		// EmployeeListDaoを生成
		EmployeeListDao employeeListDao = new EmployeeListDao();
		// 一覧用リストを生成
		List<ListInfoBean> infoBeanList = new ArrayList<ListInfoBean>();
		try {
			// 一覧用の情報を検索
			infoBeanList = employeeListDao.EmployeeListInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// セッションを生成
		HttpSession session1 = request.getSession(true);
		// recordInsertedSuccessfullyを削除
		session1.removeAttribute("recordInsertedSuccessfully");
		// セッション生成
		HttpSession session = request.getSession();
		// 一覧用の情報をセッションに保存
		session.setAttribute("InfoBeanList", infoBeanList);
		// 一覧画面へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}
}
