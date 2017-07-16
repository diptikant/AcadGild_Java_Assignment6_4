package Java_Assignment64;
/*
 * This class will help  to master the Exception Handling concepts.
 */
import java.util.*;
public class Java_Assignment6_4 
{

	public static void main(String[] args) 
	{
		int atmNo;
		int loopCnt=0;
	    double amt;
	    Scanner sc=new Scanner(System.in);//Initializing the Scanner class
		BankAtm firstAtm =new BankAtm(101,"MySBI","MUM",12000); //1st BankATM object
		BankAtm secondAtm =new BankAtm(102,"MyICICI","MUM",15000);//2nd BankATM object
		BankAtm thirdAtm =new BankAtm(101,"MyUTI","MUM",20000); //3rd BankATM object
	      while(loopCnt<6)    
	      {
	        try
	        {
	        	System.out.println("Enter one of the ATM number you like to use(101/102/103)");
	        	atmNo = sc.nextInt();
	        	System.out.println("Enter the amount to withdraw:");
	        	amt = sc.nextDouble();
	        	if(atmNo==101)
	        		firstAtm.withdraw(amt); //Withdrawing the amt from 1st atm
	        	if(atmNo==102)
	        		secondAtm.withdraw(amt); //Withdrawing the amt from 2nd atm
	        	if(atmNo==103)
	        		thirdAtm.withdraw(amt); //Withdrawing the amt from 3rd atm
	           
	           
	        }
	        catch(Exception e)
	        {
	            System.out.println("Warning: "+e.getMessage());
	        }
	        loopCnt++;
	      }
	      sc.close();
	      

	}

}
class BankATMException extends Exception //User defined exception class
{  
	 /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	BankATMException(String s)
	 {  
	  super(s);  
	 }  
}  
class BankAtm //Bank ATM class defination
{
	int atmid;
	String bankName,location;
	double balance;
	BankAtm(int aid,String bname,String loc,double bal) //constructor of BankATM class
	{
		atmid=aid;
		bankName=bname;
		location=loc;
		balance=bal;
	}
	    
	void withdraw(double amt)throws BankATMException
	{  
		if(amt>balance)  //Checking for sufficient balance to withdraw
	    {
			throw new BankATMException("Balance is insufficient to withdraw."); 
	      
	    }
	    else if(balance<10000) //Checking for  balance more than 10000
	    {
	    	throw new BankATMException("Can not withdraw balance is less than 10000.");  
	    }
	    else
	    { 
	    	balance=balance-amt;
	    	System.out.println("Successful Transaction. Available cash in ATM: "+balance); //Displaying the sucessful transaction message
	    }
	}  
	void diposite(double amt)
	{
		balance=balance+amt;  
		System.out.println("The balance amt after diposite ="+amt);
	}
}
