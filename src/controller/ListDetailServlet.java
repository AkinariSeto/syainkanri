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
import beans.LoginInfoBean;
import dao.EmployeeDetailDao;
import enums.CommissioningStatusEnum.commissioningStatus;
import enums.DepartmentEnum.dep;
import enums.SexEnum.sex;
import enums.StatusEnum.status;

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
		HttpSession session = request.getSession(true);
		// ログイン情報をとってくる
		LoginInfoBean registerUser = (LoginInfoBean) session.getAttribute("loginInfo");
		// セッションが切れている場合ログインページに遷移
		if (registerUser == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 会社情報をリストにしたものをインスタンス化
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();

		// employeeIdのリクエストパラメーターを取得
		String employeeId = request.getParameter("empId");

		EmployeeDetailDao employeeRegisterDao = new EmployeeDetailDao();
		DetailBean detailBean = new DetailBean();
		try {
			// 詳細情報を取得したものを代入
			detailBean = employeeRegisterDao.Detail(employeeId);
			// 会社情報を取得し、companyInfoBeanListに代入
			companyInfoBeanList = employeeRegisterDao.findCompany();
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}

		// 会社情報をセッションに保存
		session.setAttribute("companyInfoBeanList", companyInfoBeanList);
		// 詳細情報をセッションに保存
		session.setAttribute("detailBean", detailBean);
		// 性別をセッションに保存
		session.setAttribute("gender", sex.values());
		// ステータスをセッションに保存
		session.setAttribute("companyStatus", status.values());
		// 稼働状況をセッションに保存
		session.setAttribute("commissioningStatus", commissioningStatus.values());
		// 事業部をセッションに保存
		session.setAttribute("dep", dep.values());

		// 詳細へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
