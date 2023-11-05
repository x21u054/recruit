package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MessageDao;
import entity.Message;
import entity.User;
/**
 * Servlet implementation class ThreadServlet
 */
@WebServlet("/thread/*")
public class ThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThreadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("ユーザのセッションを確認します");
		
		String forward = "/WEB-INF/jsp/login.jsp";
		if (user != null) {
			System.out.println("セッションがあります");
			forward = "/WEB-INF/jsp/thread.jsp";
			
			// URLからスレッドIDを抽出
			String[] urlParts = request.getRequestURI().split("/");
			int threadId = Integer.parseInt(urlParts[urlParts.length - 1]);
			
			// スレッドIDを使用してメッセージを取得し、JSPに渡す
			MessageDao messageDao = new MessageDao();
			List<Message> messages = messageDao.findMessageByThreadId(threadId);
			messages.forEach(System.out::println);
			
			request.setAttribute("messages", messages);
			request.setAttribute("threadId", threadId);
		} else {
			//セッション切れ
			System.out.println("セッションがありません");
		}

        // JSPにフォワード
        request.getRequestDispatcher(forward).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("ユーザのセッションを確認します");
		
		String forward = "/WEB-INF/jsp/login.jsp";
		if (user != null) {
			System.out.println("セッションがあります");
			forward = "/WEB-INF/jsp/thread.jsp";

			// URLからスレッドIDを抽出
			String[] urlParts = request.getRequestURI().split("/");
			int threadId = Integer.parseInt(urlParts[urlParts.length - 1]);
			
			request.setCharacterEncoding("UTF-8");
			String content = request.getParameter("content");

			int ownerId = user.getId();
			
			MessageDao messageDao = new MessageDao();
			Message message = new Message();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			System.out.println(content);
			System.out.println(threadId);
			System.out.println(ownerId);
			System.out.println(timestamp);
			
			message.setContent(content);
			message.setThreadId(threadId);
			message.setOwnerId(ownerId);
			message.setTimestamp(timestamp);
			messageDao.insert(message);
			
			// スレッドIDを使用してメッセージを取得し、JSPに渡す
			List<Message> messages = messageDao.findMessageByThreadId(threadId);
			messages.forEach(System.out::println);
			
			request.setAttribute("messages", messages);
			request.setAttribute("threadId", threadId);
		} else {
			//セッション切れ
			System.out.println("セッションがありません");
		}
		
        // JSPにフォワード
        request.getRequestDispatcher(forward).forward(request, response);
	}
}
