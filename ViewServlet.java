package bank_application;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewServlet extends HttpServlet{
	@SuppressWarnings("unused")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(false);
		BankAccountBean bab = (BankAccountBean)hs.getAttribute("BABean");
		
		if(hs==null) {
			req.setAttribute("msg", "Session is expired<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			BankAccountBean bean = new ViewDAO().view(bab);
			req.setAttribute("bankBean", bab);
			req.getRequestDispatcher("ViewSuccess.jsp").forward(req, res);
		}
	}
}