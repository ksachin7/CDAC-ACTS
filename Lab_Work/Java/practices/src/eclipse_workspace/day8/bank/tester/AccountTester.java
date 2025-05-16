package eclipse_workspace.day8.bank.tester;
import java.util.Scanner;

import eclipse_workspace.day8.bank.Account;
import eclipse_workspace.day8.bank.CurrentAccount;
import eclipse_workspace.day8.bank.DepositeAccount;
import eclipse_workspace.day8.bank.SavingAccount;

import java.time.LocalDate;

public class AccountTester {

	public AccountTester() {}

	public static void main(String[] args) {
		Account[]arr=new Account[50];
		int index=0;
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println(""
					+ "\n1.Add Account"
					+ "\n2.Calculate Interset"
					+ "\n3.Print Data"
					+ "\n4.Exit");
			System.out.println("Enter your choice: ");
			int choice= sc.nextInt();
			switch(choice) {
			case 1: {
				System.out.println("Enter Account type:"
						+ "\n Enter C for Current Account"
						+ "\n Enter D for Deposite Account"
						+ "\n Enter S for Saving Account");
				String ch = sc.next();

				String name="";
				LocalDate dop=null;
				double balance=0.0;
				System.out.println("Enter your name: ");
				name= sc.next();
//				sc.nextLine();
//				System.out.println("Enter your date of opening account: ");
//				name= sc.next();
				System.out.println("Enter balance: ");
				balance= sc.nextDouble();
			
				if(ch.equalsIgnoreCase("c")) {
					 arr[index++] = new CurrentAccount( name, LocalDate.now(), balance,"Current");
				}
				else if(ch.equalsIgnoreCase("d")) {
					arr[index++] = new DepositeAccount( name, LocalDate.now(), balance,"Deposite");
				}
				else if(ch.equalsIgnoreCase("s")) {
					arr[index++] = new SavingAccount( name, LocalDate.now(), balance,"Saving");
				}
				System.out.println("Account Added!");
				break;
			}
			case 2:{
				System.out.println("Enter Account number: ");
				int acc = sc.nextInt();
				for(int i=0;i<index;i++) {
					if(arr[i].getAccNo()==acc) {
						System.out.println("The intrest for :"+acc+" is "+arr[i].applyInterest());				
					}
				}
				break;
			}
			case 3:{
				for(Account e: arr) {
					if(e !=null)
						System.out.println(e);
				}
				break;
			}
			case 4:{
				System.out.println("Program Exited.");
				return;
			}
			default: 
				System.out.println("Invalid input!");
				break;
			}
		}
		
	}
	

}
