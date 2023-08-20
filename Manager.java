class Manager extends Person {
    private String idmanger;
    private String passmanger;

    public Manager(String id,String fullname,String gender,String idmanger,String passmanger){
        super(id, fullname, gender);
        this.idmanger=idmanger;
        this.passmanger=passmanger;
    }
    public void setId(String id){
        this.idmanger=id;
    }
    public void setPass(String pass){
        this.passmanger=pass;
    }
    public String getId(){
        return this.idmanger;
    }
    public String getPass(){
        return this.passmanger;
    }
}
