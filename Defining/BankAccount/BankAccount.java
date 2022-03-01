package src.Defining.BankAccount;

public class BankAccount {

    private int id;
    private  double balance;
    private static int accountCount =0;
    public   static double interestRate=0.02;
    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }



    public BankAccount() {
    accountCount++;
    this.id=accountCount;
    this.balance=0;
    }

    public int getId() {
        return id;
    }

public void deposit(double money){
        this.balance+=money;
}

public double getInterest(int years){
        return years*interestRate*this.balance;
}

}
