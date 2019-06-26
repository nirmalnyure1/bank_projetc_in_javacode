

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Atm {
	public void at() {
     int p;
	int b;
	int m;
	int aamnt;
	int wamnt;
	 int tac;
	 
	 
	 
	 
	 System.out.println("\t\t_________________________________________________________");
	 System.out.println("\t\t|-----||||    WELLCOME TO OUR ATM SERVICE ||||-----------|");
	 System.out.println("\t\t|________________________________________________________|");
	 Scanner r =new Scanner(System.in);
	try {
	
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","");
	     Statement stat= cn.createStatement();
	        
	     
	     System.out.println("\nenter your account number");
	     String an=r.nextLine();
			 
		 System.out.println("enter your pin");
		 p=r.nextInt();
		 r.nextLine();
	     String qery="select pin from getdata where acnumber='"+an+"'";
		 ResultSet ps =stat.executeQuery(qery);
		 ps.next();
		 b=ps.getInt("pin");
			 
		 
		 for(int i=0;i<=1;i++) 
			 {
			 if(b==p)
			 {
	              continue;
             }
           else 
           {
        	   System.out.println("pin donot matched\nenter your pin again");
  			   p=r.nextInt();
  			   r.nextLine();
  	           String qeery="select pin from getdata where acnumber='"+an+"'";
  			   ResultSet pss =stat.executeQuery(qeery);
  			   pss.next();
  			  b=pss.getInt("pin");
          }
	      }
         
		 if(b==p) 
         {
        	  System.out.println("wellcome to your account");
              System.out.println("\t\t\t\t***SELECT THE OPTION***\n");
	          System.out.println("1.withdraw money enter 1\t2. balance enquery enter 2\t3.pin change_enter 3\n\n\n4.mini statement enter 4 \t5.fund transfer 5 \t\t6.for go back enter 6");
	          m=r.nextInt();
	    
	 switch (m) {
	
	     case 1://withdraw balance
		
		  System.out.println("enter amount you want to  withdraw" );
		  wamnt=r.nextInt();
		  r.nextLine();
		 
		  String query="select balance from getdata where acnumber='"+an+"'";
		  ResultSet rs =stat.executeQuery(query);
			rs.next();
			 aamnt=rs.getInt("balance");
			 aamnt-=wamnt;
	        if(aamnt>=0) 
	        {
	        	//aamnt-=wamnt;
	        
	         String sq="INSERT INTO statement(acnumber,withdraw,current_balance) VALUES('"+an+"','"+wamnt+"','"+aamnt+"') ";
	         stat.executeUpdate(sq);
			
		
			
				
				 String sql="Update getdata set balance='"+aamnt+"' where acnumber ='"+an+"'";
			     stat.executeUpdate(sql);
			     System.out.println("your withdraw balance is decutected from you main balance");
	        }
	        else {
	        	System.out.println("\nInsufficent balance");
			    	 }
			     
			     
			     
			     break;
		
		//balance enquery
	    case 2:
	       	int aaamnt;
		    String q="select balance from getdata where acnumber='"+an+"'";
		       ResultSet s =stat.executeQuery(q);
			   s.next();
	 		  aamnt=s.getInt("balance");
	    	System.out.println("current balance in your account\n"+aamnt+"");
               break;
	 	//pin change
	   case 3:
		   
		    System.out.println("enter your current pin ");
		   int cp=r.nextInt();
		   if(cp==p)
		   {
		           System.out.println("enter your new pin");
	               	 int np=r.nextInt();
	               	 System.out.println("\nconfirm pin");
	               	 int cnp=r.nextInt();
	             	r.nextLine();
	             	if(cnp==np)
	             	{
	             	 String ql="Update getdata set pin='"+np+"' where acnumber ='"+an+"'";
	                    stat.executeUpdate(ql);
	                   System.out.println("your pin is susessfully changed");
	             	}
	             	else { System.out.println("pin donot matched");
	             		
	             	}
	                   
		   }
		   else
		   {
			   System.out.println("pin wrong");
		   }
	                    	break;
		
		
case 4:
	             System.out.println(" mini statemtnt\n\n");
	             System.out.println("Account Number: "+an);	 
	           
	            	
	            	String qs="select *from statement where acnumber='"+an+"'";
	            	
	        	
	        		ResultSet rn =stat.executeQuery(qs);
	        	       
	        		
	        		 System.out.println("Date\t\t\tDeposit\t\tWithdraw\tavilable_balacne");
	        		    while(rn.next())
	        			{
	        		    	String name=rn.getString(4)+"\t:"+ rn.getString(2)+"\t\t:"+rn.getString(3)+"\t\t:"+rn.getString(5);
	        		        System.out.println(name);
	        			}
		
		
	        		//    String name=rs.getString(2)+" : "+ rs.getString(3)+" : "+rs.getString(5);
		
		break;
		
		 
	case 5:
		  System.out.println("enter bank account in which you want to transfer money");
		
		  tac=r.nextInt();
		  r.nextLine();
		 
		  System.out.println("enter amount to want to transfer");
		 int tamnt=r.nextInt();
		 r.nextLine();
		 
		    String q1="select balance from getdata where acnumber='"+an+"'";
			ResultSet s1 =stat.executeQuery(q1);
			s1.next();
			 int a=s1.getInt("balance");
			 
			 String q3="select balance from getdata where acnumber='"+tac+"'";
				ResultSet s2 =stat.executeQuery(q3);
				s2.next();
				 int b2=s2.getInt("balance");
			 
			 a-=tamnt;
		 
		      if(a>=0) {	 
				
				 String q2="Update getdata set balance='"+a+"' where acnumber ='"+an+"'";
			     stat.executeUpdate(q2);
		   
			     
			   
			     b2+=tamnt;
		     String q4="Update getdata set balance='"+b2+"' where acnumber ='"+tac+"'";
		     stat.executeUpdate(q4);  
		     System.out.println("\ntransaction is done sucessfully");
			}
			else {
				 System.out.println("\nInsufficient balance");
			}
		               break;
	
	           case 6:
		               break;
	
              	default:
		              break;
		  
	
	            }
       }
         else
      { 
	     System.out.println("\nyou have enter wrong pin three time");
	     }
	  
 }
	catch ( ClassNotFoundException|SQLException e) {
		 System.out.println("acount number invalid");
		// e.printStackTrace();
		 }
	}
	
}
