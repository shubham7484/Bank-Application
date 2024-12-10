package bank_application;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		long acno = Long.parseLong(req.getParameter("acno"));
		String name = req.getParameter("name");
		
		BankAccountBean bab = new LoginDAO().login(acno, name);
		
		if(bab==null) {
			req.setAttribute("msg", "Invalid account name or account holder name");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			HttpSession hs = req.getSession();
			hs.setAttribute("BABean", bab);
			req.setAttribute("msg", bab);
			
			req.getRequestDispatcher("LoginSuccess.jsp").include(req, res);
		}
	}
}