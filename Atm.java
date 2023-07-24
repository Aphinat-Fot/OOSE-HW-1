import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    private static ArrayList<Account> accountList = new ArrayList<Account>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        applyAccount();
        loginAccount();

    }

    public static void applyAccount() {
        System.out.println("\033[H\033[2J");
        boolean status = true;
        while (status) {
            
            System.out.print("Enter amount of all account = ");
            String accountAll = input.next();
            int accountAllint = Integer.parseInt(accountAll);
            if (accountAll.matches("[0-9]+$") && accountAllint <= 5) {
                System.out.println("Enter Detail of each account.");
                for (int i = 0; i < accountAllint; i++) {
                    status = true;
                    System.out.println("No." + (i + 1));
                    while (status) {
                        System.out.print("Account ID = ");
                        String id = input.next();
                        if (id.matches("[0-9]+") && id.length() == 13) {
                            while (status) {
                                System.out.print("Account Name = ");
                                String name = input.next();
                                if (name.matches("[a-zA-z, ]+$") && name.length() <= 50) {
                                    while (status) {
                                        System.out.print("Password = ");
                                        String password = input.next();
                                        if (password.matches("[0-9]+$") && password.length() == 4) {
                                            while (status) {
                                                System.out.print("Balance = ");
                                                Double balance = input.nextDouble();
                                                if (balance <= 1000000) {
                                                    Account account = new Account(id, name, password, balance);
                                                    accountList.add(account);
                                                    status = false;
                                                } else
                                                    System.out.println("กรุณากำหนดเงินในบัญชีไม่เกิน 1 ล้านบาท");
                                            }

                                        } else
                                            System.out.println("กรุณากำหนดรหัสผ่านไม่เกิน 4 ตัวอักษร");
                                    }
                                } else
                                    System.out.println("กรุณาพิมพ์ภาษาอังกฤษและไม่เกิน 50 ตัวอักษร");
                            }
                        } else
                            System.out.println("13 ตัวอักษร");
                    }
                }

            } else
                System.out.println("NO over 5");
        }
    }

    public static void loginAccount() {
        while (true) {
            System.out.println("\033[H\033[2J");
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.print("Account ID = ");
            String loginid = input.next();
            System.out.print("Account Password = ");
            String loginpas = input.next();
            for (Account account : accountList) {
                if (account.getId().equals(loginid) && account.getPassword().equals(loginpas)) {
                    while(true){
                        System.out.println("\033[H\033[2J");
                        System.out.println("ATM ComputerThanyaburi Bank");
                        System.out.println("Account ID : "+account.getId());
                        System.out.println("Menu Dervice");
                        System.out.println("1. Account Balance");
                        System.out.println("2. Withdrawal");
                        System.out.println("3. Exit");
                        System.out.print("Choose : ");
                        String choose = input.next();
                        if(choose.matches("[3]+$")){
                            break;
                        }else
                            System.out.println("Enter 3 only");
                    }
                }else{
                    System.out.println("\033[H\033[2J");
                    System.out.println("Accoun ID Or Password Not valid");
                }
                   
            }
        }
    }
}
