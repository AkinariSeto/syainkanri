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

/**
 * Servlet implementation class ListRegist
 */
@WebServlet("/ListRegisterServlet")
public class ListRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");
		HttpSession session3 = request.getSession(true);
		LoginInfoBean registerUser = (LoginInfoBean) session3.getAttribute("loginInfo");
		String loginId = registerUser.getLoginId();
		
		HttpSession session2 = request.getSession(true);
		session2.invalidate();
		
		
		// ログインDaoを生成
		LoginInfoBean loginInfoBean = new LoginInfoBean();
		loginInfoBean.setLoginId(loginId);
		// セッション生成
		HttpSession session = request.getSession(true);
		// ログイン情報をセッションに保存
		session.setAttribute("loginInfo", loginInfoBean);
		
		CompanySelectDao companySelectDao = new CompanySelectDao();
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
		
		String nextPage;
		nextPage = "/WEB-INF/jsp/detail.jsp";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		RequestDispatcher dispatcher = request.getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);
		
		// 詳細へ遷移
//		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
