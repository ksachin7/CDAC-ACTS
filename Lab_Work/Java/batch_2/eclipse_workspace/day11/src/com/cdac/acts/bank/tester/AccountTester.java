package com.cdac.acts.bank.tester;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.List;
import java.util.Scanner;

import com.cdac.acts.bank.Account;

public class AccountTester {

	public void addNumber(List <? super Integer> list ) {
		for(int i=0; i<list.size(); i++) {
			list.add(i);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Account> accList = new ArrayList<Account>();
		int index=0;
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println(""
					+ "1.Add Account\n"
					+ "2.Print all Accounts\n"
					+ "3.Create  unmodifiable from existing list\n"
					+ "4.Use Upper bound\n"
					+ "5.User lower bound\n"
					+ "6.Exit\n");
			int choice = sc.nextInt();
			
			switch(choice) {
			
			case 1:{
				System.out.println("Enter Account Number: ");
				int accNo = sc.nextInt();
				
				System.out.println("Enter Account Name: ");
				String accName = sc.next();
				
				System.out.println("Enter Account date of joining in yyyy-mm-dd ");
				String date = sc.next();
				LocalDate dateOfOpening = LocalDate.parse(date);
				
				
				System.out.println("Enter Account balance: ");
				double balance = sc.nextDouble();
				
				accList.add(new Account( accNo,accName,dateOfOpening,balance));
				break;
			}
			case 2: {
				for(Account i: accList ) {
					System.out.println(i);
				}
				break;
			}
			
			case 3:{
				List<Account> unmodifiedLsit = Collections.unmodifiableList(accList);
				System.out.println("Unmodified List is Craeted.");
				Iterator listIterator= unmodifiedLsit.listIterator();
				while (listIterator.hasNext()) {
		            System.out.println(listIterator.next());
		        }
				
				for(Account i: unmodifiedLsit ) {
					System.out.println(i);
				}
			}
			case 4:{
				
			}
			
			case 5:
//				addNumbers(123);			}
			
			case 6:{
				return;
			}
			
			}
			
		}


	}

}
