package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMailServlet
 */
@WebServlet("/sendemail")
public class SendMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String recipientEmail = request.getParameter("email");
        
        // 認証コードを生成（適切な方法で生成することをお勧めします）
        String authenticationCode = generateAuthenticationCode();
        
        // メール送信
        sendEmail(recipientEmail, authenticationCode);

        // 認証コードをセッションに保存
        HttpSession session = request.getSession();
        session.setAttribute("authenticationCode", authenticationCode);

        // ユーザーを認証コード入力ページにリダイレクト
        response.sendRedirect("authentication.jsp");
	}
	
    private void sendEmail(String recipientEmail, String authenticationCode) {
        // メール送信のコードをここに追加
        // JavaMail APIを使用してメールを送信する
    }

    private String generateAuthenticationCode() {
        // 認証コードをランダムに生成するコードをここに追加
        // 例: ランダムな数字列の生成
    	return "";
    }

}
