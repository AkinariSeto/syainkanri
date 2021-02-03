package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.EmployeeRegistBean;
import dao.EmployeeRegistDao;

/**
 * Servlet implementation class NewRegistServlet
 */
@WebServlet("/NewRegistServlet")
public class NewRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewRegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");// UTF-8にエンコーディング

		String name = request.getParameter("name");
		String nameHiragana = request.getParameter("name_hiragana");
		String birthday = request.getParameter("birthday");
		String sex = request.getParameter("sex");
		String mailAddress = request.getParameter("mail_address");
		String telephoneNumber = request.getParameter("telephone_number");
		String companyInfoId = request.getParameter("company_info_id");
		String businessManager = request.getParameter("business_manager");
		String department = request.getParameter("department");
		String commissioningStatus = request.getParameter("commissioning_status");
		String hireDate = request.getParameter("hire_date");
		String retireDate = request.getParameter("retire_date");
		String status = request.getParameter("status");

		EmployeeRegistDao employeeRegistDao = new EmployeeRegistDao();
		EmployeeRegistBean employeeRegistBean = null;

		try {
			// 入力された値でログイン情報検索
			employeeRegistBean = employeeRegistDao.EmployeeRegist(name, nameHiragana, birthday, sex, mailAddress, telephoneNumber);
			employeeRegistBean = employeeRegistDao.EmployeeRegist2(companyInfoId, businessManager, department, commissioningStatus, hireDate, retireDate, status);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		// ログインIDを設定
		employeeRegistBean.setName(employeeRegistBean.getName());
		employeeRegistBean.setNameHiragana(employeeRegistBean.getNameHiragana());
		employeeRegistBean.setBirthday(employeeRegistBean.getBirthday());
		employeeRegistBean.setSex(employeeRegistBean.getSex());
		employeeRegistBean.setMailAddress(employeeRegistBean.getMailAddress());
		employeeRegistBean.setTelephoneNumber(employeeRegistBean.getTelephoneNumber());
		employeeRegistBean.setCompanyInfoId(employeeRegistBean.getCompanyInfoId());
		employeeRegistBean.setBusinessManager(employeeRegistBean.getBusinessManager());
		employeeRegistBean.setDepartment(employeeRegistBean.getDepartment());
		employeeRegistBean.setCommissioningStatus(employeeRegistBean.getCommissioningStatus());
		employeeRegistBean.setHireDate(employeeRegistBean.getHireDate());
		employeeRegistBean.setRetireDate(employeeRegistBean.getRetireDate());
		employeeRegistBean.setStatus(employeeRegistBean.getStatus());

		// セッション生成
		HttpSession session = request.getSession();
		// ログイン情報をセッションに保存
		session.setAttribute("employeeRegistBean", employeeRegistBean);

		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
		dispatcher.forward(request, response);
	}
}
