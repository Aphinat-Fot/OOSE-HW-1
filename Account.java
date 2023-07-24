class Account {
    private String id;
    private String name;
    private String password;
    private Double balance;

    public Account(String id,String name,String password,Double balance){
        this.id=id;
        this.name=name;
        this.password=password;
        this.balance=balance;
    }

    public void setId(String id){
        this.id=id;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String password){
        this.password=password;

    }
    public void setBalance(Double balance){
        this.balance=balance;

    }
     public String getId(){
        return this.id;
    } public String getName(){
        return this.name;
    } public String getPassword(){
        return this.password;
    } public Double getBalance(){
        return this.balance;
    }
    public void displayEmployee(){
        System.out.println("Id = "+this.id);
        System.out.println("Name = "+this.name);
        System.out.println("Password = "+this.password);
    }
   

}
