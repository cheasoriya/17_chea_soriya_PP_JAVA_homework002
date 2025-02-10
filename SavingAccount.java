import java.util.Random;

class SavingAccount implements Account {
    private String accountType;
    private String userName;
    private String dateOfBirth; //valid on leap year, aldo upper 16 years old
    private String gender;
    private String phoneNumber;
    private double balance;
    double withDrawMoney;
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

    public SavingAccount(String accountType, String userName, String dateOfBirth, String gender,String phoneNumber, double balance) {
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.userName = userName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double deposit(double amount) {
        if (amount > 0){
            balance =+ amount;
        }else {
            System.out.println(red+"Deposit amount must be positive."+reset);
        }
        return amount;
    }

    @Override
    public double withdraw(double amount) {
        while (true){
            withDrawMoney = amount + (amount*0.8);
            if (withDrawMoney > amount*1.80){
                System.out.println(red+"You Can not withdraw money more than 80 percent of money"+reset);
            }else{
                balance -= amount;
            }
            return  amount;
        }
    }

    @Override
    public double transfer(double amount, Account targettAccount) {
        return 0;
    }

    @Override
    public void displayAccountInfo() {
        System.out.println("=".repeat(20)+"Saving Account"+"=".repeat(20));
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
