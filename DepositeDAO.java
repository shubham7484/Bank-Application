package bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DepositeDAO {
	int k=0;
	
	public int deposite(long amount, long acno) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("update BankAccount set ACCOUNTBALANCE =  ACCOUNTBALANCE+? where AccNo=?");
			
			ps.setLong(1, amount);
			ps.setLong(2, acno);
			
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return k;
	}
}
