import java.util.ArrayList;

public class Account {

	private String name;
	private int  accountNum;
	private int pin;
	private double balance;
	private ArrayList<String> transactions;
	
	
	public Account(String name, int accountNum, int pin, double balance) 
	{
	   this.name = name;
	   this.accountNum = accountNum;
	   this.pin = pin;
	   this.balance = balance;
	   transactions = new ArrayList<>();
	   
	   transactions.add("account created with balance: " + balance);
	}
	
	public int getAccountNum()
	{
		return accountNum;
	}
	
	public boolean validatePin(int enteredPin) 
	{
		return this.pin == enteredPin;
	}
	
	public double getBalance() 
	{
		return balance;
	}
	
	public void deposite(double amount) 
	{
		balance = balance + amount;
		transactions.add("Deposited: " + amount);
	}
	
	public boolean withDraw(double amount)
	{
		if (balance >= amount) 
		{
			balance = balance - amount;
			transactions.add("Withdraw: " + amount);
			return true;
		}
		return false;
	}
		
		public void transfer(Account receiver, double amount)
		{
			this.balance = this.balance - amount;
			receiver.balance = receiver.balance + amount;
			transactions.add("Transfered " + amount + " to Acc No: " + receiver.accountNum);
			receiver.transactions.add("Received " + amount + " from Acc No: " + this.accountNum);
		}
		
		public void printTransactions()
		{
			System.out.println("\n.....Transaction History....");
			
			for (String t : transactions)
			{
				System.out.println(t);
			}
		}
		
		public void displayDetails()
		{
			System.out.println("\n Name : " + name);
			System.out.println("Acc No: " + accountNum);
			System.out.println("Balance: " + balance);
		}
	}
	

