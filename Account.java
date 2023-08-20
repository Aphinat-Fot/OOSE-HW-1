class Account extends Person implements ATMAction {
    private String idlogin;
    private String password;
    private Double balance;

    public Account(String id, String fullname, String gender, String idlogin, String password, Double balance) {
        super(id, fullname, gender);
        this.idlogin = idlogin;
        this.password = password;
        this.balance = balance;
    }

    public void setId(String id) {
        this.idlogin = id;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public void setBalance(Double balance) {
        this.balance = balance;

    }

    public String getId() {
        return this.idlogin;
    }

    public String getPassword() {
        return this.password;
    }

    public Double getBalance() {
        return this.balance;
    }

    public void checKable() {
        System.out.println("-------------------------------------------------------");
        System.out.println("The amount of money in your account. = "+this.balance);
        System.out.println("-------------------------------------------------------");
    }

    public void withdraWable(int value) {
        this.balance -= value;
        System.out.println("-------------------------------------------------------");
        System.out.println("The withdrawal has been successful.");
        System.out.println("-------------------------------------------------------");
    }

    public void depositEable(int value) {
        this.balance += value;
        System.out.println("-------------------------------------------------------");
        System.out.println("The deposit has been successful.");
        System.out.println("-------------------------------------------------------");

    }

    public void tranfeRable(int value) {
        this.balance += value;
       System.out.println("-------------------------------------------------------");
        System.out.println("The money transfer has been successful.");
       System.out.println("-------------------------------------------------------");
    }
}
