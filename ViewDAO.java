package bank_application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ViewDAO {
	int k =0;
	BankAccountBean bBean = null;
	public BankAccountBean view(BankAccountBean bab) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from BankAccount where AccNo=?");
			
			ps.setLong(1, bab.getAcno());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				bBean.setAcno(rs.getLong(1));
				bBean.setName(rs.getString(2));
				bBean.setBalance(rs.getDouble(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bBean;
	}
}
