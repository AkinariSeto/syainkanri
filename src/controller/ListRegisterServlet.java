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
import dao.CompanySelectDao;
import login.LoginInfoBean;


@WebServlet("/ListRegisterServlet")
public class ListRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF8");
		//セッションを生成
		HttpSession session3 = request.getSession(true);
		
		LoginInfoBean registerUser = (LoginInfoBean) session3.getAttribute("loginInfo");
		String loginId = registerUser.getLoginId();
		// セッション生成
		HttpSession session2 = request.getSession(true);
		//セッションを切断
		session2.invalidate();
		
		// ログインBeanを生成
		LoginInfoBean loginInfoBean = new LoginInfoBean();
		//ログインIDをセット
		loginInfoBean.setLoginId(loginId);
		// セッション生成
		HttpSession session = request.getSession(true);
		// ログイン情報をセッションに保存
		session.setAttribute("loginInfo", loginInfoBean);
		//CompanySelectDaoを生成
		CompanySelectDao companySelectDao = new CompanySelectDao();
		//
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();
		try {
			// 入力された値でログイン情報検索
			companyInfoBeanList = companySelectDao.findCompany();
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		
		// セッション生成
		HttpSession session4 = request.getSession();
		// ログイン情報をセッションに保存
		session4.setAttribute("companyInfoBeanList", companyInfoBeanList);
		
		//詳細画面へフォワード
		String nextPage;
		nextPage = "/WEB-INF/jsp/detail.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
