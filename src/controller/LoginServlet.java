package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginInfoBean;
import dao.LoginDao;

@WebServlet("/login")
/**
 * 入力されたログインIDとパスワードがDBと一致するか判定するサーブレット
 *
 * @author setoakinari
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * ここからログイン画面へ遷移。
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログイン画面に遷移
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

	/**
	 * ログインID、パスワードを検索して一覧画面へ遷移。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF-8");
		// 入力フォームの値を取得
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		LoginDao loginDao = new LoginDao();
		// LoginInfoBeanを初期化
		LoginInfoBean loginInfoBean = null;

		try {
			// 入力された値でログイン情報検索
			loginInfoBean = loginDao.findOne(loginId, password);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		// ログイン情報が取得できなかった場合
		if (loginInfoBean == null) {
			// リクエストスコープにエラーメッセージを設定
			request.setAttribute("message", "IDまたはパスワードが違います");
			// ログイン画面に遷移
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
			return;
		}

		// セッション生成
		HttpSession session = request.getSession(true);
		// ログイン情報をセッションに保存
		session.setAttribute("loginInfo", loginInfoBean);

		// 一覧へ遷移
		request.getRequestDispatcher("./list").forward(request, response);
	}
}
