package bank_application;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		long amount = Long.parseLong(req.getParameter("amount"));
		
		
		BankAccountBean bean= (BankAccountBean)(req.getSession(false).getAttribute("BABean"));
		
		int k = new DepositeDAO().deposite(amount, bean.getAcno());
		if (k > 0) {
			req.setAttribute("msg", "Money deposited successfully");
			req.getRequestDispatcher("DepositSuccess.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "Invalid amount");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}