package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import validation.Validation;

@WebServlet("/detail")
/**
 * 詳細情報をセッションに保存して詳細画面へ遷移するクラス
 *
 * @author setoakinari
 *
 */
public class ListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 新規登録ボタン、詳細リンクをクリックしたときの処理。
	 * 詳細情報と会社情報を取得して詳細画面へ遷移。
	 */

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
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// 会社情報をリストにしたものをインスタンス化
		List<CompanyInfoBean> companyInfoBeanList = new ArrayList<CompanyInfoBean>();

		// employeeIdのリクエストパラメーターを取得
		String empId = request.getParameter("empId");

		EmployeeDetailDao employeeRegisterDao = new EmployeeDetailDao();
		DetailBean detailBean = new DetailBean();
		try {
			// 詳細情報を取得したものを代入
			detailBean = employeeRegisterDao.detail(empId);
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
		session.setAttribute("sex", sex.values());
		// ステータスをセッションに保存
		session.setAttribute("companyStatus", status.values());
		// 稼働状況をセッションに保存
		session.setAttribute("commissioningStatus", commissioningStatus.values());
		// 事業部をセッションに保存
		session.setAttribute("dep", dep.values());

		// 詳細画面へ遷移
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

	/**
	 * 詳細画面の登録ボタン、詳細ボタンをクリックしたときの処理
	 * 詳細画面のパラメータを取得してバリデーションチェックを実行。問題なければ新規登録、更新処理を実行。
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// UTF-8にエンコーディング
		request.setCharacterEncoding("UTF-8");
		SimpleDateFormat displayedFormat = new SimpleDateFormat("yyyy/MM/dd");
		try {
			// セッションを生成
			HttpSession session = request.getSession(true);
			// login情報をregisterUserに代入
			LoginInfoBean registerUser = (LoginInfoBean) session.getAttribute("loginInfo");
			// セッションが切れている場合ログインページに遷移
			if (registerUser == null) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
				dispatcher.forward(request, response);
				return;
			}
			// 入力フォームの値を取得
			String empId = request.getParameter("empId");
			String name = request.getParameter("name");
			String nameHiragana = request.getParameter("nameHiragana");
			String birthday = request.getParameter("birthday");
			String sex = request.getParameter("sex");
			String mailAddress = request.getParameter("mailAddress");
			String telephoneNumber = request.getParameter("telephoneNumber");
			String createdId = request.getParameter("created_id");
			String companyInfoId = request.getParameter("companyInfoId");
			String businessManager = request.getParameter("businessManager");
			String department = request.getParameter("department");
			String commissioningStatus = request.getParameter("commissioningStatus");
			String enterDate = request.getParameter("enterDate");
			String retireDate = request.getParameter("retireDate");
			String status = request.getParameter("status");

			// 受け取ったパラメータをdetailValidationBeanにセット
			DetailBean detailValidationBean = new DetailBean();
			detailValidationBean.setName(name);
			detailValidationBean.setNameHiragana(nameHiragana);
			detailValidationBean.setBirthday(birthday);
			detailValidationBean.setSex(sex);
			detailValidationBean.setMailAddress(mailAddress);
			detailValidationBean.setTelephoneNumber(telephoneNumber);
			if (!"".equals(companyInfoId) && companyInfoId != null) {
				detailValidationBean.setCompanyInfoId(Integer.parseInt(companyInfoId));
			}
			detailValidationBean.setBusinessManager(businessManager);
			detailValidationBean.setDepartment(department);
			detailValidationBean.setCommissioningStatus(commissioningStatus);
			detailValidationBean.setEnterDate(enterDate);
			detailValidationBean.setRetireDate(retireDate);
			detailValidationBean.setStatus(status);

			Validation validation = new Validation();
			// Validationクラスで追加したエラーメッセージをerrorMessageに代入
			List<String> errorMessage = validation.validation(detailValidationBean);

			DetailBean detailBean = null;
			//errorMessageにエラーメッセージが入っていたらエラーメッセージを表示させる。
			if (errorMessage.size() != 0) {
				detailBean = new DetailBean();
				if (!"".equals(empId) && empId != null) {
					detailBean.setEmployeeId(Integer.parseInt(empId));
				}
				detailBean.setName(name);
				detailBean.setNameHiragana(nameHiragana);
				detailBean.setBirthday(birthday);
				detailBean.setSex(sex);
				detailBean.setMailAddress(mailAddress);
				detailBean.setTelephoneNumber(telephoneNumber);
				if (!"".equals(companyInfoId) && companyInfoId != null) {
					detailBean.setCompanyInfoId(Integer.parseInt(companyInfoId));
				}
				detailBean.setBusinessManager(businessManager);
				detailBean.setDepartment(department);
				detailBean.setCommissioningStatus(commissioningStatus);
				detailBean.setEnterDate(enterDate);
				detailBean.setRetireDate(retireDate);
				detailBean.setStatus(status);
				String displayErrorMessage = "";
				for (String addedErrorMessage : errorMessage) {
					displayErrorMessage += addedErrorMessage + "<br>";
				}
				request.setAttribute("detailBean", detailBean);
				request.setAttribute("errorMessage", displayErrorMessage);
				request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
			} else {
				//入力された誕生日のフォーマットを"yyyy-MM-dd"の形に変える
				if (birthday != null && !request.getParameter("birthday").equals("")) {
					Date displayedBirthday = displayedFormat.parse(request.getParameter("birthday"));
					birthday = new SimpleDateFormat("yyyy-MM-dd").format(displayedBirthday);
				}

				//入力された入社日のフォーマットを"yyyy-MM-dd"の形に変える
				if (enterDate != null && !request.getParameter("enterDate").equals("")) {
					Date displayedHireDate = displayedFormat.parse(request.getParameter("enterDate"));
					enterDate = new SimpleDateFormat("yyyy-MM-dd").format(displayedHireDate);
				}

				//入力された退社日のフォーマットを"yyyy-MM-dd"の形に変える
				if (retireDate != null && !request.getParameter("retireDate").equals("")) {
					Date displayedRetireDate = displayedFormat.parse(request.getParameter("retireDate"));
					retireDate = new SimpleDateFormat("yyyy-MM-dd").format(displayedRetireDate);
				}

				EmployeeDetailDao employeeRegisterDao = new EmployeeDetailDao();

				// employeeIdがnullか空文字ではないときに更新する。
				if (empId != null && !empId.equals("") && !empId.equals("0")) {

					// employee_infoに入っている情報を更新する
					employeeRegisterDao.employeeUpdateInfo(empId, name, nameHiragana,
							birthday, sex, mailAddress, telephoneNumber, createdId, registerUser.getLoginId());
					// employee_stateに入っている情報を更新する
					employeeRegisterDao.employeeUpdateState(empId, companyInfoId,
							businessManager, department, commissioningStatus, enterDate, retireDate, status,
							registerUser.getLoginId());
					// employeeIdがあるときは登録する。
				} else {
					// employee_infoに情報を登録する。
					employeeRegisterDao.employeeRegisterInfo(name, nameHiragana, birthday,
							sex,
							mailAddress, telephoneNumber, createdId, registerUser.getLoginId());
					// employee_stateに情報を登録する。
					employeeRegisterDao.employeeRegisterState(companyInfoId,
							businessManager,
							department, commissioningStatus, enterDate, retireDate, status,
							registerUser.getLoginId());
				}
				// 一覧画面へリダイレクト
				response.sendRedirect("list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
