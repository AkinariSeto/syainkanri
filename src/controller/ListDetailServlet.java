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
import beans.DetailBean;
import beans.Enum.commissioningStatus;
import beans.Enum.dep;
import beans.Enum.sex;
import beans.Enum.status;
import beans.LoginInfoBean;
import dao.CompanySelectDao;
import dao.DetailDao;

@WebServlet("/detail")
/**
 * 詳細情報をセッションに保存して詳細画面へ遷移するクラス
 *
 * @author setoakinari
 *
 */
public class ListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF-8");

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

		// CompanySelectDaoをインスタンス化
		CompanySelectDao companySelectDao = new CompanySelectDao();
		// 会社情報をリストにしたものをインスタンス化
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();

		// employeeIdのリクエストパラメーターを取得
		String employeeId = request.getParameter("empId");

		// DetailDaoをインスタンス化
		DetailDao detailDao = new DetailDao();
		// DetailBeanをインスタンス化
		DetailBean detailBean = new DetailBean();
		try {
			// 詳細情報を取得したものを代入
			detailBean = detailDao.Detail(employeeId);
			// 会社情報を取得し、companyInfoBeanListに代入
			companyInfoBeanList = companySelectDao.findCompany();
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		// セッション生成
		HttpSession session = request.getSession();
		// 会社情報をセッションに保存
		session.setAttribute("companyInfoBeanList", companyInfoBeanList);
		// セッション生成
		HttpSession session2 = request.getSession();
		// 詳細情報をセッションに保存
		session2.setAttribute("detailBean", detailBean);
		// セッション生成
		HttpSession session4 = request.getSession();
		// 性別をセッションに保存
		session4.setAttribute("gender", sex.values());
		// セッション生成
		HttpSession session5 = request.getSession();
		// ステータスをセッションに保存
		session5.setAttribute("companyStatus", status.values());
		// セッション生成
		HttpSession session6 = request.getSession();
		// 稼働状況をセッションに保存
		session6.setAttribute("commissioningStatus", commissioningStatus.values());
		// セッション生成
		HttpSession session9 = request.getSession();
		// 事業部をセッションに保存
		session9.setAttribute("dep", dep.values());

		// 詳細へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
