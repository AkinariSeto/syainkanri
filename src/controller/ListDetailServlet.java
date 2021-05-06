package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.CompanyInfoBean;
import beans.DetailBean;
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
		request.setCharacterEncoding("UTF8");

		// CompanySelectDaoをインスタンス化
		CompanySelectDao companySelectDao = new CompanySelectDao();
		// 会社情報をリストにしたものをインスタンス化
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();

		// employeeIdのリクエストパラメーターを取得
		String employeeId = request.getParameter("empId");

		Random randomValue = new Random();

		// DetailDaoをインスタンス化
		DetailDao detailDao = new DetailDao();
		// DetailBeanをインスタンス化
		DetailBean detailBean = new DetailBean();
		try {
			// 詳細情報を取得したものを代入
			detailBean = detailDao.Detail(employeeId);

		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		try {
			// 会社情報を取得し、companyInfoBeanListに代入
			companyInfoBeanList = companySelectDao.findCompany();
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
//		computeSquare(detailBean.department);
		//computeSquare(1);

//		System.out.println(detailBean.department);
		// セッション生成
		HttpSession session = request.getSession();
		// 会社情報をセッションに保存
		session.setAttribute("companyInfoBeanList", companyInfoBeanList);
		// セッション生成
		HttpSession session2 = request.getSession();
		// 詳細情報をセッションに保存
		session2.setAttribute("detailBean", detailBean);
		// 詳細へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

//	public enum dep(department){
//		switch (department) {
//		case 0:
//			return "開発";
//			break;
//		case 1:
//			return "NW";
//			break;
//		case 2:
//			return "検証";
//			break;
//		case 3:
//			return "オフィス";
//			break;
//		case 4:
//			return "管理";
//			break;
//    }
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
