package com.umak.heronsconduct;

public class Users2 {

    private String Uid;
    private String Name;
    private String Email;
    private String NumberId;
    private String Address;
    private String Birthdate;
    private String Phone;
    private String Password;
    private int Usertype;


    public Users2(String uid, String name, String email, String numberId, String address, String birthdate, String phone, String password, int usertype) {
        Uid = uid;
        Name = name;
        Email = email;
        NumberId = numberId;
        Password = password;
        Usertype = usertype;
        Address = address;
        Birthdate = birthdate;
        Phone = phone;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNumberId() {
        return NumberId;
    }

    public void setNumberId(String numberId) {
        NumberId = numberId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getUsertype() {
        return Usertype;
    }

    public void setUsertype(int usertype) {
        Usertype = usertype;
    }
}
