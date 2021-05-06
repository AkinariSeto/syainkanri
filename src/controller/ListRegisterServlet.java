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

import beans.CompanyInfoBean;
import beans.LoginInfoBean;
import dao.CompanySelectDao;

@WebServlet("/ListRegisterServlet")
/**
 * セッションを切断し、空の状態で新規登録画面へ遷移するサーブレット
 *
 * @author setoakinari
 *
 */
public class ListRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF8");
		// セッションを生成
		HttpSession session3 = request.getSession(true);
		// ログイン情報をとってくる
		LoginInfoBean registerUser = (LoginInfoBean) session3.getAttribute("loginInfo");
		// セッションが切れている場合ログインページに遷移
		if (registerUser == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			return;
		}
		// ログイン情報からとってきたログインIDをloginIdに代入
		String loginId = registerUser.getLoginId();
		// セッション生成
		HttpSession session2 = request.getSession(true);
		// セッションを切断
		session2.invalidate();
		// セッション生成
		HttpSession session5 = request.getSession(true);
		// フォームの再送信防止
		session5.removeAttribute("recordInsertedSuccessfully");
		// ログインBeanを生成
		LoginInfoBean loginInfoBean = new LoginInfoBean();
		// ログインIDをセット
		loginInfoBean.setLoginId(loginId);
		// セッション生成
		HttpSession session = request.getSession(true);
		// ログイン情報をセッションに保存
		session.setAttribute("loginInfo", loginInfoBean);
		// CompanySelectDaoを生成
		CompanySelectDao companySelectDao = new CompanySelectDao();
		// 会社情報のリストを生成
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();
		try {
			// 会社IDと略称を検索
			companyInfoBeanList = companySelectDao.findCompany();
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		// セッション生成
		HttpSession session4 = request.getSession();
		// 会社IDと略称ををセッションに保存
		session4.setAttribute("companyInfoBeanList", companyInfoBeanList);

		// 詳細画面へフォワード
		String nextPage;
		nextPage = "/WEB-INF/jsp/detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
