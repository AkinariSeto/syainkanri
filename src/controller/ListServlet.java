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

import beans.ListInfoBean;
import dao.EmployeeListDao;

/**
 * Servlet implementation class Detail
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");// UTF-8にエンコーディング
		
		// EmployeeListDaoを生成
		EmployeeListDao employeeListDao = new EmployeeListDao();
		List<ListInfoBean> infoBeanList = new ArrayList<ListInfoBean>();
		try {
			// 入力された値でログイン情報検索
			infoBeanList = employeeListDao.EmployeeListInfo();
		} catch (Exception e) {
//			throw new ServletException(e.getMessage());
			e.printStackTrace();
		}
		
		// セッション生成
		HttpSession session = request.getSession();
		// ログイン情報をセッションに保存
		session.setAttribute("InfoBeanList", infoBeanList);
		
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}
}
