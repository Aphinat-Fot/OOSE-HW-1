public class Person {
    private String id,fullname,gender;
    // private int rate;

    public Person(String id,String fullname,String gender){
        this.id=id;
        this.fullname=fullname;
        this.gender=gender;
    }

    // public void setRate(int rate){
    //     this.rate=rate;
    // }
    public void setId(String id){
        this.id=id;
    }
    public void setFullname(String fullname){
        this.fullname=fullname;
    }
    public void setGender(String gender){
        this.gender=gender;
    }
    public String getId(){
        return id;
    }
     public String getFullname(){
        return fullname;
    }
     public String getGender(){
        return gender;
    }
    // public int getRate(){
    //     return rate;
    // }
}

