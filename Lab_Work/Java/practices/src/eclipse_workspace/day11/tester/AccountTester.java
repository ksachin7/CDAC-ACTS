package eclipse_workspace.day11.tester;

import eclipse_workspace.day11.bank.Account;
import java.time.LocalDate;
import java.util.*;

public class AccountTester {
	private static boolean dummyAdded = false;
//	private static final ArrayList<Account> accList = new ArrayList<>();
	private static final List<Account> accList = new LinkedList<>();

	// Upper bound: reading from a list (T or a subclass)
	public static void printAccountNames(List<? extends Account> list) {
		for (Account acc : list) {
			System.out.println(acc.getAccName());
		}
	}

	// Lower bound: writing to a list (T or a subclass)
	public static void addDummyAccount(List<? super Account> list) {
		if (!dummyAdded) {
			list.add(new Account(100, "Default", LocalDate.now(), 1500));
			//		list.add(new SavingsAccount(999, "Dummy", LocalDate.now(), 2000));	// If SavingsAccount is a subclass of Account
			dummyAdded = true;
			System.out.println("Dummy account added.");
		} else {
			System.out.println("Dummy account already added. Skipping.");
		}

//		Account acc= list.get(1); 	// CE
		Object obj= list.get(0);
		System.out.println(obj);
	}

	public static void main(String[] args) {
		List<Account> unmodifiableList=null;
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
			
			case 1:
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

			case 2:
				for(Account i: accList ) {
					System.out.println(i);
				}
				break;
			
			case 3:
				unmodifiableList = Collections.unmodifiableList(accList);
				System.out.println("Unmodified List is Created.");

				Iterator<Account> it= unmodifiableList.iterator();
				while (it.hasNext()){
					Account acc=it.next();
					System.out.println(acc);
				}

				ListIterator<Account> listIt = unmodifiableList.listIterator();		// bi-directional iteration
				System.out.println("Forward:");
				while (listIt.hasNext()) {
					System.out.println(listIt.next());
				}

				System.out.println("Backward:");
				while (listIt.hasPrevious()) {
					System.out.println(listIt.previous());
				}

				for(Account i: unmodifiableList ) {
					System.out.println(i);
				}
				break;

			case 4:
				System.out.println("Using upper bound (prints account names):");
				printAccountNames(unmodifiableList != null ? unmodifiableList : accList);
				break;
			
			case 5:
				System.out.println("Using lower bound (adds dummy account):");
				addDummyAccount(accList);
				System.out.println("Dummy account added.");
				break;
			
			case 6:
				System.out.println("Exiting...");
				return;

			default: System.out.println("Invalid choice!");
			}
		}
	}
}
