import java.util.Scanner;

class BankAccount{
	public String name;
	public double balance = 0;
	
	public BankAccount(double bal,String nm){
		this.balance = bal;
		this.name = nm;
	}
}

class ATM{
    private BankAccount user;
    
    private double atm_bal = 0;

    public ATM(double bal) {
        this.atm_bal = bal;
    }
 
    public void deposit(double amount) {
        if (amount > 0) {
            user.balance += amount;
            System.out.println("Deposit successful. New balance: " + user.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if ((amount > 0 && amount <= user.balance )&& amount <= this.atm_bal) {
            user.balance -= amount;
            this.atm_bal -= amount;
            
            System.out.println("Withdrawal successful. New balance: " + user.balance);
        }
        else {
            System.out.println("Invalid withdrawal amount or insufficient ATM funds.");
        }
    }

    public double checkBalance() {
        return user.balance;
    }
    
    public void start(BankAccount userAccount) {
         
         this.user = userAccount;
         
        Scanner sc = new Scanner(System.in);
        
        boolean flag = true;

        while (flag) {
            System.out.println("Name : "+user.name);
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    deposit(amount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double amount2 = sc.nextDouble();
                    withdraw(amount2);
                    break;

                case 3:
                    System.out.println("Current balance: " +checkBalance());
                    break;

                case 4:
                    System.out.println("Exiting ATM. Thank you!");
                    flag = false;
                    break;
                 
                default:
                    System.out.println("Invalid choice. Please try again.");
                    
            }
        }
        
    }
}

public class task_3 {
    public static void main(String[] args) {
        
        BankAccount user1 = new BankAccount(1000.0,"User A");
        BankAccount user2 = new BankAccount(600.0,"User B");
        ATM atm = new ATM(20000);
        
        atm.start(user1);
        atm.start(user2);
    }
}