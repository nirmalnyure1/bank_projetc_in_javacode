

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deposit {
	public void deposit1()
	{
		

	
		
		try {
			 Scanner r =new Scanner(System.in);
			
			 System.out.println("enter account number");
			 String an=r.nextLine();
			
			 
		
			
			 
		//	Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","");
			// System.out.println("Database Connection Success!");
			 
			 Statement stat= cn.createStatement();
			 
			 
			 String query="select balance from getdata where acnumber='"+an+"'";
				
				
				ResultSet rs =stat.executeQuery(query);
				rs.next();
				int b=rs.getInt("balance");
				System.out.println("\n");
				System.out.println("current balance:\t"+b+"\n");
				
				 System.out.println("enter amount you want to deposit");
				 
				int depositamnt=r.nextInt();
				 r.nextLine();
			
				 String qu="INSERT INTO statement(acnumber,deposit ) VALUES('"+an+"','"+depositamnt+"')";
				 stat.executeUpdate(qu);
				 
				 
				 System.out.println("\n");
				 b+=depositamnt;
			 String sql="Update getdata set balance='"+b+"' where acnumber ='"+an+"'";
		     stat.executeUpdate(sql);
		    
		     
		     String sq="Update  statement set current_balance='"+b+"' where acnumber ='"+an+"'";
		     stat.executeUpdate(sq);
		     System.out.println("you balance is depostited in your acount\n");
		 }
		 catch ( SQLException e) {
			 System.out.println("acount number invalid");
			// e.printStackTrace();
			 
		 }
		
		
		
	}

}






