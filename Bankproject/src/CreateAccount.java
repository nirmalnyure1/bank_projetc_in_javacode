import java.util.InputMismatchException;
import java.sql.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateAccount {


	public void account() {
			try	 {
		
		
	
		Scanner sc =new Scanner(System.in);

		Class.forName("com.mysql.cj.jdbc.Driver");
	
	  Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","");
	  Statement stat= cn.createStatement();
			
			System.out.println("fill your information to create your account\n");
		
			
		
			
			System.out.println("enter account number"); 
			 int an=sc.nextInt();
			 sc.nextLine();
			
			 System.out.println("enter the first name of user");
			 String fn=sc.nextLine();
			 System.out.println("enter the last name of the user");
			 String ln=sc.nextLine();
			 System.out.println("enter your pin");
			 int p=sc.nextInt();
			 sc.nextLine();
			 
			 System.out.println("enter phone number");
			 int pn=sc.nextInt();
			 sc.nextLine();
			 System.out.println("occupation");
			 String o=sc.nextLine();
			 System.out.println("enter citizenship number");
			 int cno=sc.nextInt();
			 sc.nextLine();
			 System.out.println("gender");
			 char g=sc.next().charAt(0);
			 sc.nextLine();
			 System.out.println("marital status");
			 String ms=sc.nextLine();
			 
			 
			 
			 String sql="INSERT INTO getdata(acnumber,fname,lname,pin,pnumber,occupation,citizenshipnumber,gender,maritalstatus) VALUES "
			 		+ "('"+an+"' ,'"+fn+"','"+ln+"','"+p+"','"+pn+"','"+o+"','"+cno+"','"+g+"','"+ms+"')";			 
		     stat.executeUpdate(sql);
		     System.out.println("your account  is created ");
		     
			
	 }
		catch (InputMismatchException |ClassNotFoundException | SQLException e) {
			 System.out.println("invalid infromation \n");
			// e.printStackTrace();
		}
	}}