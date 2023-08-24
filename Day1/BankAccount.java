package Day1;

public class BankAccount {

    private int accountNumber;
    private String accHolderName;
    private float accBalance;

    public BankAccount(int accountNumber, String accHolderName, float accBalance){
        this.accountNumber = accountNumber;
        this.accBalance = accBalance;
        this.accHolderName = accHolderName;
    }

    public void withdraw(int amount){
        if(amount<=accBalance){
            accBalance -= amount;
        }
    }

    public void deposit(int amount){
        accBalance += amount;
    }

    public void showInfo(){
        System.out.println("Account Holder Name: "+accHolderName);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Current Balance: "+accBalance);
    }


}
