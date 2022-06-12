package test;
import java.util.*;
import java.sql.*;

public class JDBCon6 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter user name :");
			String uname = sc.nextLine();
			System.out.println("Enter user password :");
			String pword = sc.nextLine();
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","student");
			PreparedStatement pstm = con.prepareStatement("Select * from userreg41 where uname = ? and pword = ?");
			pstm.setString(1, uname);
			pstm.setString(2, pword);
			ResultSet rs = pstm.executeQuery();
			if(rs.next())
			{
				System.out.println("login Successfully.....");
				System.out.println("FirstName "+rs.getString(3));
				System.out.println("LastName "+rs.getString(4));
				System.out.println("Address "+rs.getString(5));
				System.out.println("EmailId "+rs.getString(6));
				System.out.println("PhoneNo "+rs.getLong(7));
				
			}else {
				System.out.print("invalid password and userid ....");
			}
			
			sc.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
