public interface Account {
    double deposit(double amount);
    double withdraw(double amount);
    double transfer(double amount, Account targettAccount);
    void displayAccountInfo();
}
