import java.awt.*;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //    Scanner
    Scanner sc = new Scanner(System.in);
    //    Choose and switch case
    String chose;
    //    SavingAccount class
    SavingAccount savingAccount = new SavingAccount("Null","Null","Null","Null","Null",0);
    CheckingAccount checkingAccount = new CheckingAccount("Null","Null","Null","Null","Null",0);
    //    Color
    String red = "\u001B[31m";   // Red color for prompt
    String reset = "\u001B[0m";
    String green = "\u001B[32m";
    //    Data type of Checking Account
    String userName;
    String dateOfBirth;
    String gender;
    String phoneNumber;
    double balance = 0;
    //    Account with saving Account and num = 1
    int number = 1;

    //    ValidName
    public String validateUserName() {
        while (true) {
            System.out.print("User Name     : ");
            userName = sc.nextLine();
            if (userName.matches("[a-zA-Z ]+")) {
                return userName;
            } else {
                System.out.println(red + "Enter Again Input Text Only" + reset);
            }
        }
    }

    //    Validate Date of Birth
    public String validateDateofBirth() {
        while (true) {
            System.out.println(green + "Enter Pattern regex example [12-12-2005]" + reset);
            System.out.print("Date of Birth : ");
            dateOfBirth = sc.nextLine();
            if (dateOfBirth.matches("^(0[1-9]|[12][0-9]|3[01])[-/](0[1-9]|1[0-2])[-/](19[0-9]{2}|20[0-2][0-9])$")) {
                return dateOfBirth;
            } else {
                System.out.println(red + "Enter Again Input Text Only" + reset);
            }
        }
    }

    //    Validate of gender
    public String validateGender() {
        while (true) {
            System.out.print("Gender        : ");
            gender = sc.nextLine();
            if (gender.matches("Female|female")) {
                return gender;
            } else if (gender.matches("Male|male")) {
                return gender;
            } else {
                System.out.println(red + "Enter Again Input Text Only" + reset);
            }
        }
    }

    //    Validate of Phone Number
    public String validatePhoneNumber() {
        while (true) {
            System.out.print("Phone Number  : ");
            phoneNumber = sc.nextLine();
            if (phoneNumber.matches("[0-9]\\d{8}")) {
                return phoneNumber;
            } else {
                System.out.println(red + "Enter Again Input 9 Number Only" + reset);
            }
        }
    }

    //    Create Account
    public void CreateAccount() {
//        Input Data value
        validateUserName();
        validateDateofBirth();
        validateGender();
        validatePhoneNumber();
//        Get value
        checkingAccount = new CheckingAccount("Checking Account", userName, dateOfBirth, gender, phoneNumber, 0);

//        Booking success
        System.out.println(green + "YOU ARE BOOKING SUCCESS !!" + reset);
    }

    //    Create Saving Account
    public void CreateSaveAccount() {
        validateUserName();
        validateDateofBirth();
        validateGender();
        validatePhoneNumber();
        savingAccount = new SavingAccount("Saving Account", userName, dateOfBirth, gender, phoneNumber, 0);
    }

    //    Create Account in Case 1
    public void CreateAccountCase1() {
        do {
            System.out.println("1. Create Checking Account");
            System.out.println("2. Create Saving Account");
            System.out.println("3. Back");
            System.out.print("=> Enter to Choose Option : ");
            chose = sc.nextLine();
            if (chose.matches("[1-3]")) {
                switch (chose) {
                    case "1": {
                        System.out.println("=".repeat(20) + "Create Account" + "=".repeat(20));
                        CreateAccount();
                        System.out.println("=".repeat(56));
                        break;
                    }
                    case "2": {
                        System.out.println("=".repeat(20) + "Create Saving Account" + "=".repeat(20));
                        CreateSaveAccount();
                        System.out.println("=".repeat(61));
                        break;
                    }
                    case "3": {
                        return;
                    }
                }
            } else {
                System.out.println(red + "=> Please Enter Number 1-3 Only !!" + reset);
            }
        } while (true);
    }

    //    checking account deposit
    public void checkingAccountDeposit() {
        System.out.print("=> Enter money to deposit: ");
        double amount = sc.nextDouble();
        System.out.println();
        System.out.println("\t\t\t\tChecking Account");
        System.out.println("Received    : " + "\t\t\t" + "$ " + amount);
        System.out.println("Total       : " + "\t\t\t" + "$ " + checkingAccount.deposit(amount));
        System.out.println("=".repeat(45));
        System.out.println("Deposit successful!");
        sc.nextLine();
    }

    //    saving account deposit
    public void savingAccountDeposit() {
        System.out.print("=> Enter money to depopsit: ");
        double amount = sc.nextDouble();
        System.out.println();
        System.out.println("\t\t\t\tChecking Account");
        System.out.println("Received    : " + "\t\t\t" + "$ " + amount);
        System.out.println("Total       : " + "\t\t\t" + "$ " + savingAccount.deposit(amount));
        System.out.println("=".repeat(45));
        System.out.println("Deposit successful!");
        sc.nextLine();
    }

    //    Deposit Money Case 2
    public void DepositMoneyCase2() {
        sc.nextLine();
        do {
            System.out.println("1. Checking Account");
            System.out.println("2. Savings Account");
            System.out.println("3. Back");
            System.out.print("Choose an option : ");
            chose = sc.nextLine();
            if (chose.matches("[1-3]")) {
                switch (chose) {
                    case "1": {
                        checkingAccountDeposit();
                        break;
                    }
                    case "2": {
                        savingAccountDeposit();
                        break;
                    }
                    case "3": {
                        return;
                    }
                }
            } else {
                System.out.println(red + "=> Please Enter Number 1-3 Only !!" + reset);
            }
        } while (true);
    }

    public void savingAccountWithdraw(){
        System.out.print("=> Enter Money Withdraw : ");
        double money = sc.nextDouble();
        savingAccount.withdraw(money);
        sc.nextLine();
    }

    public void checkingAccountWithdraw(){
        System.out.print("=> Enter Money Withdraw : ");
        double money = sc.nextDouble();
        checkingAccount.withdraw(money);
        sc.nextLine();
    }

    public void WithdrawMoneyCase3() {
        sc.nextLine();
        do {
            System.out.println("1. Checking Account");
            System.out.println("2. Savings Account");
            System.out.println("3. Back");
            System.out.print("Choose an option : ");
            chose = sc.nextLine();
            if (chose.matches("[1-3]")) {
                switch (chose) {
                    case "1": {
                        checkingAccountWithdraw();
                        break;
                    }
                    case "2": {
                        savingAccountWithdraw();
                        break;
                    }
                    case "3": {
                        return;
                    }
                }
            } else {
                System.out.println(red + "=> Please Enter Number 1-3 Only !!" + reset);
            }
        } while (true);
    }

    //    Display Account
    public void DisplayAccount() {
        checkingAccount.displayAccountInfo();
        System.out.println();
        System.out.println();
        savingAccount.displayAccountInfo();
    }

    //    Menu for switch Case
    public void menu() {
        do {
            System.out.println("=".repeat(20));
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Display Account");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("Enter Your Choose : ");
            chose = sc.nextLine();
//            Validation switch case
            if (chose.matches("[1-9]")) {
                switch (chose) {
                    case "1": {
                        System.out.println(">".repeat(20) + "Create Account" + "<".repeat(20));
                        CreateAccountCase1();
                        break;
                    }
                    case "2": {
                        System.out.println(">".repeat(20) + "Account Deposit" + "<".repeat(20));
                        DepositMoneyCase2();
                        break;
                    }
                    case "3": {
                        System.out.println(">".repeat(20) + "Account Deposit" + "<".repeat(20));
                        WithdrawMoneyCase3();
                        break;
                    }
                    case "4":{
                        System.out.println(">".repeat(20) + "Account Transfer" + "<".repeat(20));
                        break;
                    }
                    case "5": {
                        DisplayAccount();
                        break;
                    }
                    case "7": {
                        return;
                    }
                }
            } else {
                System.out.println(red + "=> Please Enter Numb Only !!" + reset);
            }
        } while (true);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }
}
