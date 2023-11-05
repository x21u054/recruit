package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		if (request.getServletPath().equals("/")) {
//			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
//		} else {
//			StringBuilder sb = new StringBuilder();
//			Path file = Paths.get(this.getServletContext().getRealPath("/WEB-INF/css/login.css"));
//			try (BufferedReader br = Files.newBufferedReader(file)) {
//				String text;
//				while ((text = br.readLine()) != null) {
//					sb.append(text);
//				}
//			}
//
//			response.setContentType("text/css");
//			PrintWriter out = response.getWriter();
//			out.println(sb);
//			out.close();
//		}
		
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		System.out.println("ユーザのセッションを確認します");
//		
//		String forward = "/WEB-INF/jsp/login.jsp";
//		if (user != null) {
//			System.out.println("セッションがあります");
//			forward = "/WEB-INF/jsp/home.jsp";
//		} else {
//			//セッション切れ
//			System.out.println("セッションがありません");
//		}
//		request.getRequestDispatcher(forward).forward(request, response);

		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
