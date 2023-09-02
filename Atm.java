import java.util.ArrayList;
import java.util.Scanner;

public class Atm {
    private static ArrayList<Account> accountList = new ArrayList<Account>();
    private static ArrayList<Manager> managerList = new ArrayList<Manager>();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        applyManager();
        loginManager();
        applyAccount();
        loginAccount();

    }

    public static int setRate() {
        System.out.println("\033[H\033[2J");
        System.out.print("Please enter BTC rate => ");
        int rate = input.nextInt();
        return rate;
    }

    public static void applyManager() {
        System.out.println("\033[H\033[2J");
        System.out.println("Applymanager");
        boolean status = true;
        while (status) {
            System.out.print("ID Person Card = ");
            String id = input.next();
            System.out.print("Manager Fullname = ");
            String fullname = input.next();
            System.out.print("Gender(man,woman) = ");
            String gender = input.next();
            System.out.print("Manager ID = ");
            String idmanager = input.next();
            System.out.print("Manager Password = ");
            String idpassword = input.next();
            Manager manager = new Manager(id, fullname, gender, idmanager, idpassword);
            managerList.add(manager);
            status = false;
        }
    }

    public static void loginManager() {
        boolean status = true;
        while (status) {
            System.out.println("\033[H\033[2J");
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.print("Manager ID = ");
            String loginidmg = input.next();
            System.out.print("Manager Password = ");
            String loginpassmg = input.next();
            for (Manager manager : managerList) {
                if (manager.getId().equals(loginidmg) && manager.getPass().equals(loginpassmg)) {
                    status = false;
                } else {
                    System.out.println("\033[H\033[2J");
                    System.out.println("Accoun ID Or Password Not valid");
                }
            }
        }
    }

    public static void applyAccount() {
        int rate = setRate();
        // int rate = managerList.get(0).getRate();
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
                        System.out.print("ID Person Card = ");
                        String id = input.next();
                        System.out.print("Account Name = ");
                        String fullname = input.next();
                        System.out.print("Gender(man,woman) = ");
                        String gender = input.next();
                        System.out.print("Account ID = ");
                        String idaccount = input.next();
                        if (idaccount.matches("[0-9]+") && idaccount.length() == 13) {
                            while (status) {
                                System.out.print("Password = ");
                                String password = input.next();
                                if (password.matches("[0-9]+$") && password.length() == 4) {
                                    while (status) {
                                        System.out.print("Balance = ");
                                        Double balance = input.nextDouble();
                                        if (balance <= 1000000) {
                                            Account account = new Account(id, fullname, gender, idaccount,
                                                    password, balance,rate);
                                            accountList.add(account);
                                            status = false;
                                        } else
                                            System.out.println(
                                                    "Please ensure that the account balance does not exceed 1 million Baht.");
                                    }

                                } else
                                    System.out.println("Please set a password consisting of 4 letters in number");
                            }

                        } else
                            System.out.println("Please set a Account ID consisting of 13 letters in number");
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
                    menuList(account);
                } else {
                    System.out.println("\033[H\033[2J");
                    System.out.println("Accoun ID Or Password Not valid");
                }

            }
        }
    }

    public static void menuList(Account user) {
        boolean status = true;
        // System.out.println("\033[H\033[2J");
        while (status) {
            boolean status1 = true;
            System.out.println("ATM ComputerThanyaburi Bank");
            System.out.println("Account ID : " + user.getId());
            System.out.println("Menu Dervice");
            System.out.println("1. Check");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposite");
            System.out.println("4. Transfer");
            System.out.println("5. Exit");
            System.out.print("Choose : ");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    user.checKable();
                    break;
                case 2:
                    System.out.println("1.Withdraw by bath");
                    System.out.println("2.Withdraw by btc");
                    System.out.println("Enter Number : ");
                    int choose1 = input.nextInt();
                    switch (choose1) {
                        case 1:
                            while (status1) {
                                System.out.println("The amount of money in your account. = " + user.getBalance());
                                System.out.print("The amount of money you want to withdraw. = ");
                                int withdraw = input.nextInt();
                                if (user.getBalance() >= withdraw) {
                                    user.withdraWable(withdraw);
                                    status1 = false;
                                } else {
                                    System.out.println("-------------------------------------------------------");
                                    System.out.println("Please verify the balance in your account.");
                                    System.out.println("-------------------------------------------------------");
                                    status1 = false;
                                }

                            }
                            break;
                        case 2:
                            while (status1) {
                                double btc = user.getBalance() / user.getRate();
                                System.out.println("The amount of BTC in your account. = " + btc);
                                System.out.print("The amount of BTC you want to withdraw. = ");
                                double btc1 = input.nextInt();
                                if (btc >= btc1) {
                                    double btc2 = btc - btc1;
                                    double btc3 = btc - btc2;
                                    double withdraw = btc3 * user.getRate();
                                    user.withdraWable(withdraw);
                                    status1 = false;
                                } else {
                                    System.out.println("-------------------------------------------------------");
                                    System.out.println("Please verify the BTC in your account.");
                                    System.out.println("-------------------------------------------------------");
                                    status1 = false;
                                }

                            }
                            break;
                    }

                    break;
                case 3:

                    while (status1) {
                        System.out.println("The amount of money in your account. = " + user.getBalance());
                        System.out.print("The amount of money you would like to deposit. = ");
                        int deposite = input.nextInt();
                        user.depositEable(deposite);
                        status1 = false;
                    }
                    break;

                case 4:
                    while (status1) {
                        System.out.print("tranfer id = ");
                        String tranfer = input.next();
                        if (tranfer.length() == 13) {
                            if (user.getId().equals(tranfer)) {
                                System.out.println("-------------------------------------------------------");
                                System.out.println("Your own account. ");
                                System.out.println("-------------------------------------------------------");
                            } else {
                                for (Account account : accountList) {
                                    if (account.getId().equals(tranfer)) {
                                        System.out.println("Account ID =" + account.getId());
                                        System.out.println("FullName =" + account.getFullname());
                                        System.out
                                                .println("The amount of money in your account. = " + user.getBalance());
                                        System.out.print("The amount of money you wish to transfer. = ");
                                        int tranfer1 = input.nextInt();
                                        if (user.getBalance() >= tranfer1) {
                                            user.setBalance(user.getBalance() - tranfer1);
                                            account.tranfeRable(tranfer1);
                                            status1 = false;
                                        } else {
                                            System.out
                                                    .println("-------------------------------------------------------");
                                            System.out.println("Please verify the balance in your account.");
                                            System.out
                                                    .println("-------------------------------------------------------");
                                            status1 = false;
                                        }

                                    }
                                }
                            }

                        } else {
                            System.out.println("-------------------------------------------------------");
                            System.out.println("Please set a Account ID consisting of 13 letters in number");
                            System.out.println("-------------------------------------------------------");
                            status1 = false;
                        }

                    }

                    break;
                case 5:
                    System.out.println("5");
                    status = false;
                    break;
            }

        }
    }
}
