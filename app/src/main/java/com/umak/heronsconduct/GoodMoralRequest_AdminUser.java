package com.umak.heronsconduct;

public class GoodMoralRequest_AdminUser {
    private String name;
    private String email;
    private String college;
    private String date;
    private String time;

    public GoodMoralRequest_AdminUser(String name, String email, String college, String date, String time) {
        this.name = name;
        this.email = email;
        this.college = college;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getCollege() {

        return college;
    }

    public void setCollege(String college) {

        this.college = college;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {

        this.time = time;
    }
}
