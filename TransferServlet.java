package bank_application;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		long number = Long.parseLong(req.getParameter("number"));
		long amount = Long.parseLong(req.getParameter("amount"));
		
		 BankAccountBean bab = (BankAccountBean)req.getSession(false).getAttribute("BABean");
		
		int k1 = new TransferDAO1().transfer(amount, number);
		int k2 = new TransferDAO2().transfer(amount, bab.getAcno());
		
		if(k1>0 && k2>0) {
			req.setAttribute("msg", "Amount transfered successfully");
			req.getRequestDispatcher("transfersuccess.jsp").forward(req, res);
		}else {
			req.setAttribute("msg", "Invalid account number or amount");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}
	}
}
