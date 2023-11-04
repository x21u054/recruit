package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import config.SecurityConfig;
import dao.UserDao;
import entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
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
		String forward = "/WEB-INF/jsp/login.jsp";
		System.out.println("user: " + user);
		if (user != null) {
			//パスワード認証を実施
			Boolean isLogin = SecurityConfig.verifyPassword(password, user.getPassword());
			System.out.println("isLogin: " + isLogin);
			if (isLogin) {
				//セッションにユーザ情報を格納
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				forward = "/WEB-INF/jsp/home.jsp";
			} else {
				//認証に失敗
			}
		} else {
			//該当するユーザなし
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

}
