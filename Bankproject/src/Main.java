


import java.sql.SQLException;
import java.util.Scanner;



public class Main {
   public static void main(String [] args)   { 
	 System.out.println("\t\t______________________________________________________");
	 System.out.println("\t\t|-----||||    WELLCOME TO EBANKING SYSTEM  ||||-------|");
	 System.out.println("\t\t|____________________________________________________|");
	   int menu;
	

	   
	  do {
	     System.out.println("\t\t\t\t***SELECT THE OPTION***");
	     System.out.println("1. To go to Bank enter 1 \t2.To go to ATM enter 2\t 3.To exit enter 3");
	     Scanner sc=new Scanner(System.in);
	     menu=sc.nextInt();
	  switch(menu) 
	  {  
case 1:
		  System.out.println("");
		  
		     System.out.println("\t\t______________________________________________________");
			 System.out.println("\t\t|-----||||    WELLCOME TO BANKING SERVICE  ||||-------|");
			 System.out.println("\t\t|____________________________________________________|");
			 System.out.println("1.To create account enter 1 \t2.To deposit enter 2\t 3.To go back enter 3");
			 int ms;
			// Scanner ms=new Scanner(System.in);
			 
			 
			 ms=sc.nextInt();
			 switch(ms)
			 {
			 case 1:
			 
			 CreateAccount obj=new CreateAccount ();
		     obj.account();
		     System.out.println("\t\t***THANK YOU BABY FOR USING OUR BANKING SERVICE*** \n\n");
		     break;
			
			 case 2:
			
			 Deposit obj2=new Deposit ();
		     obj2.deposit1();
		     System.out.println("\t\t***THANK YOU BABY FOR USING OUR BANKING SERVICE*** \n\n");
	         break;
			 
			 case 3:
			 break;	 
				 
			 }
   break;

case 2:
		
		  Atm obj3=new Atm();
		  obj3.at();
		  System.out.println("\n\n\t\t***THANK YOU BABY FOR USING OUR ATM SERVICE*** \n\n");
          break;
	  
case 3:
		  System.exit(0);



default:
		  System.out.println("invalid input");
	      break;
			  
	  
	  }
	  
	  }while(menu!=3);
	//}
	//catch (SQLException e) {
		// System.out.println("invalid infromation \n");}
	
	
	}
   
	
}

