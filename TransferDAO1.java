package bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransferDAO1 {
	Connection con = null;
	int k =0;
	
	public int transfer(long amount, long acno) {
		try {
			
			con = DBConnection.getCon();
			PreparedStatement ps1 = con.prepareStatement("update BankAccount set ACCOUNTBALANCE= ACCOUNTBALANCE+? where AccNo=? ");
			
			ps1.setLong(1, amount);
			ps1.setLong(2, acno);
			
			k = ps1.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
