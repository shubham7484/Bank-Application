package bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	
	Connection con = null;
	BankAccountBean bab = null;
	
	public BankAccountBean login(long acno, String pW) {
		try {
			con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from BankAccount where Accno=? and AccountHolderName=?");
			
			ps.setLong(1, acno);
			ps.setString(2, pW);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bab = new BankAccountBean();
				bab.setAcno(rs.getLong(1));
				bab.setName(rs.getString(2));
				bab.setBalance(rs.getDouble(3));
				
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return bab;
	}
}