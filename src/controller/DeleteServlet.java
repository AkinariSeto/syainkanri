package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeInfoDeleteDao;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response, String employeeId) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
//		request.setCharacterEncoding("UTF8");
//
//		EmployeeInfoDeleteDao employeeInfoDeleteDao = new EmployeeInfoDeleteDao();
//		employeeInfoDeleteDao.EmployeeInfoDelete(employeeId);
//		request.getRequestDispatcher("/list.jsp").forward(request, response);
		// String seq = request.getParameter("employeeId");
		// beanList = EmployeeInfoDeleteDao
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response, String employeeId)
			throws ServletException, IOException {
		doGet(request, response);
		
		request.setCharacterEncoding("UTF8");

		EmployeeInfoDeleteDao employeeInfoDeleteDao = new EmployeeInfoDeleteDao();
		employeeInfoDeleteDao.EmployeeInfoDelete(employeeId);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

}
