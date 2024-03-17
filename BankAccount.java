import java.util.*;

public abstract class BankAccount{
	int accountNumber;
	int aadharNumber;
	String ownerName;
	double ROI;
	double balance;
	
	public BankAccount(int aadharNumber,String ownerName,double ROI,double balance){
		this.aadharNumber=aadharNumber;
		this.ownerName=ownerName;
		this.ROI=ROI;
		this.balance=balance;
	}
	
	void openAccount(){
		System.out.println("Your account has been opened in this bank");
	}
	
	void deposit(double amount){
		balance=balance+amount;
		System.out.println("Current balance is: "+balance);
	}
	
	abstract void closeAccount();
	
	abstract void updateInterest();
}

interface Debitable{
	public double withdraw(double amount);
}

class FixedDeposit extends BankAccount{
	int lockInPeriod;
	static int accountNumber=55000;
	
	public FixedDeposit(int lockInPeriod,int aadharNumber,String ownerName,double ROI,double balance){
		super(aadharNumber,ownerName,ROI,balance);
		this.lockInPeriod=lockInPeriod;
		accountNumber=accountNumber+1;
	}
	
	public void updateInterest(){
		if((1>=lockInPeriod)&&(lockInPeriod<=2)){
			ROI=0.06;
            System.out.println("Rate of interest in current case is: "+ROI);
		}
		else if((2<lockInPeriod)&&(lockInPeriod<=5)){
			 ROI=0.065;
             System.out.println("Rate of interest in current case is: "+ROI);
		}
		else if(lockInPeriod>5){
			ROI=0.07;
            System.out.println("Rate of interest in current case is: "+ROI);
		}
	}

    void tenureBalance(){
        balance=balance+balance*ROI;
        System.out.println("The balance after completing the tenure will be: "+balance);
    }
	
	void openAccount(){
		System.out.println("FD Account Number of new user is:"+ accountNumber+"\nName : "
        +ownerName+"\nAadhar Number : "+aadharNumber+"\nCurrent Balance: "+balance);
	}
	
    

	void closeAccount(){
        Scanner myObj=new Scanner(System.in);
        System.out.println("Enter the no. of years you want to keep your money in bank: ");
        int timeout=myObj.nextInt();

        if(lockInPeriod>timeout){
		 balance=balance-0.05*balance;
		 System.out.println("After closing account ur amount is:"+ balance);
        }
        else{
            for(int n=1;n<timeout;n++){
                balance=balance+balance*ROI;
            }
            System.out.println("You've completed ur tenure,ur balance is: "+balance);
        }
	}	
}	


class SavingAccount extends BankAccount implements Debitable{
	
	static int accountNumber=11000;

	public SavingAccount(int aadharNumber,String ownerName,double ROI,double balance){
		super(aadharNumber,ownerName,ROI,balance);
		accountNumber=accountNumber+1;
	}	
	
	public double withdraw(double amount){
		 balance=balance-amount;
		System.out.println("New balance is"+balance);
		return balance;
	}
	
	void closeAccount(){
		System.out.println("Your account has been closed");
	}
	
	void updateInterest(){
		ROI=0.04;
        System.out.println("Rate of interest in current case is: "+ROI);
	}
	
	void openAccount(){
		System.out.println("Savings Account Number of new user is:"+ accountNumber+"\nName : "
        +ownerName+"\nAadhar Number : "+aadharNumber+"\nCurrent Balance: "+balance);
	}
}

class Main{
	public static void main(String[] args){
		SavingAccount s1=new SavingAccount(525875,"Prince",0.04,6534);
		//s1.withdraw(200);
		s1.openAccount();
		SavingAccount s2=new SavingAccount(525895,"Prince Maurya",0.04,6534);
		s2.openAccount();
		FixedDeposit f1=new FixedDeposit(4,525832,"Prince Maurya FD",0.04,6534);
		f1.openAccount();	
		f1.updateInterest();
                f1.tenureBalance();
                f1.closeAccount();
		FixedDeposit f2=new FixedDeposit(7,525832,"Prince Maurya FD2",0.04,6534);
		f2.openAccount();
	        f2.updateInterest();
	        f2.tenureBalance();
	        f2.closeAccount();
		f2.deposit(5000);
		
	}
}

