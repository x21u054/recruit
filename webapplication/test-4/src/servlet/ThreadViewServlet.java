package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ThreadDao;
import entity.Thread;
import entity.User;
/**
 * Servlet implementation class ThreadViewServlet
 */
@WebServlet("/thread")
public class ThreadViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ThreadDao threadDao = new ThreadDao();
		List<Thread> threads = threadDao.findAll();
		threads.forEach(System.out::println);
				
		request.setAttribute("threads", threads);
		request.getRequestDispatcher("/WEB-INF/jsp/threadView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		int ownerId = user.getId();
		ThreadDao threadDao = new ThreadDao();
		Thread thread = new Thread();
		thread.setTitle(title);
		thread.setOwnerId(ownerId);
		threadDao.insert(thread);

		request.getRequestDispatcher("/thread").forward(request, response);
	}

}
