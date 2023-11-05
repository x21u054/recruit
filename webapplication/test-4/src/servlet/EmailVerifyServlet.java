package servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.SendEmail;
import dao.EmailVerifyDao;
import dao.UserDao;
import entity.EmailVerify;
import entity.User;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/email-verify")
public class EmailVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsp/emailVerify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 認証コードを生成（適切な方法で生成することをお勧めします）
//        String authenticationCode = generateAuthenticationCode();
//
//        // メール送信
//        sendEmail(recipientEmail, authenticationCode);
//
//        // 認証コードをセッションに保存
//        HttpSession session = request.getSession();
//        session.setAttribute("authenticationCode", authenticationCode);
//
//        // ユーザーを認証コード入力ページにリダイレクト
//        response.sendRedirect("authentication.jsp");
        String email = request.getParameter("email");
		UserDao userDao = new UserDao();
		User user = userDao.findUserByEmail(email);
		String forward = "/WEB-INF/jsp/emailVerify.jsp";
		if (user != null) {
			//既に登録されているメールアドレス
		} else {
			String authToken = generateAuthToken(); // トークン生成

			// 有効期限を2時間後に設定する
			long tokenExpirationMillis = System.currentTimeMillis() + 2 * 60 * 60 * 1000; // 2時間分のミリ秒

			EmailVerify emailVerify = new EmailVerify();
			emailVerify.setEmail(email);
			emailVerify.setToken(authToken);
			emailVerify.setExpiration(tokenExpirationMillis);

			EmailVerifyDao emailVerifyDao = new EmailVerifyDao();
			emailVerifyDao.insert(emailVerify);

			SendEmail sendEmail = new SendEmail();
			sendEmail.execute(emailVerify);

			forward = "/WEB-INF/jsp/emailVerifyResult.jsp";
		}
		request.getRequestDispatcher(forward).forward(request, response);
	}

	private String generateAuthToken() {
		// ランダムなUUIDを生成
		UUID uuid = UUID.randomUUID();
		String authToken = uuid.toString();
		return authToken;
	}

//    private void sendEmail(String recipientEmail, String authenticationCode) {
//        // メール送信のコードをここに追加
//        // JavaMail APIを使用してメールを送信する
//    }

//    private String generateAuthenticationCode() {
//        // 認証コードをランダムに生成するコードをここに追加
//        // 例: ランダムな数字列の生成
//    	return "";
//    }

}
