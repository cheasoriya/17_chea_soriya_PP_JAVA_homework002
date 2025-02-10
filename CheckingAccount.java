import java.util.Random;
public class CheckingAccount implements Account {
    private String accountType;
    private String userName;
    private String dateOfBirth;
    private String gender;
    private String phoneNumber;
    private double Balance;

    //    Color
    String red = "\u001B[31m";   // Red color for prompt
    String reset = "\u001B[0m";
    String green = "\u001B[32m";

    //    Random ID

    public static String generateRandomID() {
        Random random = new Random();
        long id = (long) (random.nextDouble() * 1_000_000_000L);  // Generate a random long between 0 and 999999999
        return String.format("%010d", id);  // Format it to a 10-digit string, leading zeros if needed
    }

    double withdrawMoney;
    public CheckingAccount(String accountType, String userName, String dateOfBirth, String gender, String phoneNumber, double balance) {
        this.accountType = accountType;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.Balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = "CHECKING ACCOUNT";
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public double deposit(double amount) {
        if (amount > 0){
            Balance += amount;
        }else {
            System.out.println("Deposit must be positive");
        }
        return amount;
    }

    @Override
    public double withdraw(double amount) {
        if (amount > 0 && amount <= Balance){
            Balance -= amount;
        }
        else if (amount > Balance){
            System.out.println("Insufficient funds");
        }
        return  amount;
    }

    @Override
    public double transfer(double amount, Account targettAccount) {
        if (amount <= 0){
            System.out.println(red+"You can not transfer money"+reset);
        }else{
            targettAccount.deposit(amount);
            targettAccount.withdraw(amount);
        }
        return amount;
    }

    public String getAccountType() {
        return accountType;
    }


    @Override
    public void displayAccountInfo() {
        System.out.println("=".repeat(20)+"Checking Account"+"=".repeat(20));
        System.out.println();
        System.out.println("\t\t\t Account Type  : "+green+getAccountType()+reset);
        System.out.println("\t\t\t Account Number: "+green+generateRandomID()+reset);
        System.out.println("\t\t\t UserName      : "+green+getUserName()+reset);
        System.out.println("\t\t\t Date of Birth : "+green+getDateOfBirth()+reset);
        System.out.println("\t\t\t Gender        : "+green+getGender()+reset);
        System.out.println("\t\t\t Phone Number  : "+green+getPhoneNumber()+reset);
        System.out.println("\t\t\t Balance       : "+green+getBalance()+reset);
        System.out.println();
        System.out.println("=".repeat(56));
    }
}
