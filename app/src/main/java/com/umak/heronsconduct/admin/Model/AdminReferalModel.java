package com.umak.heronsconduct.admin.Model;

public class AdminReferalModel {
    String Image;
    String Title;
    String CodeNumber;
    String College;
    String Reporter;
    String Offender;
    String Time;
    String Location;



    public AdminReferalModel(String image, String title, String codeNumber, String college, String reporter, String offender, String time, String location) {

        Image = image;
        Title = title;
        CodeNumber = codeNumber;
        College = college;
        Reporter = reporter;
        Offender = offender;
        Time = time;
        Location = location;

    }


    public AdminReferalModel(String college) {
        College = college;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getTime() {
        return Time;
    }

    public String getLocation() {
        return Location;
    }

    public String getImage() {
        return Image;
    }

    public String getTitle() {
        return Title;
    }

    public String getCodeNumber() {
        return CodeNumber;
    }

    public String getCollege() {
        return College;
    }

    public String getReporter() {
        return Reporter;
    }

    public String getOffender() {
        return Offender;
    }
}
