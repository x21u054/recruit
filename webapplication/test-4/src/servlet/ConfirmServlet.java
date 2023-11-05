package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import config.SecurityConfig;
import dao.EmailVerifyDao;
import dao.UserDao;
import entity.EmailVerify;
import entity.User;

/**
 * Servlet implementation class ConfirmServlet
 */
@WebServlet("/confirm")
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String token = request.getParameter("token");

		EmailVerifyDao emailVerifyDao = new EmailVerifyDao();
		EmailVerify emailVerify = emailVerifyDao.findEmailVerifyByToken(token);

		if (emailVerify != null) {
			HttpSession session = request.getSession();
			session.setAttribute("email", emailVerify.getEmail());
		} else {

		}
		request.getRequestDispatcher("/WEB-INF/jsp/confirm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		password = SecurityConfig.hashPassword(password);
		System.out.println(password);
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		UserDao userDao = new UserDao();
		userDao.insert(user);

		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
	}

}
