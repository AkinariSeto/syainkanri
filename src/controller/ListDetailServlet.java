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

import beans.CompanyInfoBean;
import beans.DetailBean;
import dao.CompanySelectDao;
import dao.DetailDao;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListDetailServlet")
public class ListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF8");

		
		CompanySelectDao companySelectDao = new CompanySelectDao();
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();
//		EmployeeListDao employeeListDao = new EmployeeListDao();
//		List<ListInfoBean> infoBeanList = new ArrayList<ListInfoBean>();
//		try {
//			// 入力された値でログイン情報検索
//			infoBeanList = employeeListDao.EmployeeListInfo();
//		} catch (Exception e) {
//			throw new ServletException(e.getMessage());
//		}

		
		String employeeId = request.getParameter("employeeId");
		
		DetailDao detailDao = new DetailDao();
//		CompanySelectDao companySelectDao = new CompanySelectDao();
		DetailBean detailBean = new DetailBean();
		try {
		// 入力された値でログイン情報検索
		detailBean = detailDao.Detail(employeeId);
//		detailBean = detailDao.Detail(employeeId);
	} catch (Exception e) {
		throw new ServletException(e.getMessage());
	}
		try {
			// 入力された値でログイン情報検索
			companyInfoBeanList = companySelectDao.findCompany();
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		// セッション生成
		HttpSession session = request.getSession();
		// ログイン情報をセッションに保存
		session.setAttribute("companyInfoBeanList", companyInfoBeanList);
		// セッション生成
		HttpSession session2 = request.getSession();
		// ログイン情報をセッションに保存
		session2.setAttribute("detailBean", detailBean);
		// 一覧へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
