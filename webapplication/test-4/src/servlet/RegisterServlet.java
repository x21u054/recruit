package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.SecurityConfig;
import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//ユーザ情報を取得
		UserDao userDao = new UserDao();
		User user = userDao.findUserByEmail(email);
		String forward = "/WEB-INF/jsp/register.jsp";
		System.out.println("user: " + user);
		if (user != null) {
			//既に登録されているメールアドレス
		} else {
			password = SecurityConfig.hashPassword(password);
			System.out.println(password);
			user = new User();
			user.setEmail(email);
			user.setPassword(password);
			userDao.insert(user);
			forward = "/WEB-INF/jsp/login.jsp";
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

}
