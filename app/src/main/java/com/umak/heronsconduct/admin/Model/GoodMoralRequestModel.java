package com.umak.heronsconduct.admin.Model;

public class GoodMoralRequestModel {

    String Id;
    String name_of_requestor;
    String requestor_college;
    String email_of_requestor;
    String date_of_request;


    public GoodMoralRequestModel(String id, String name_of_requestor, String requestor_college, String email_of_requestor, String date_of_request) {
        Id = id;
        this.name_of_requestor = name_of_requestor;
        this.requestor_college = requestor_college;
        this.email_of_requestor = email_of_requestor;
        this.date_of_request = date_of_request;
    }

    public String getId() {
        return Id;
    }

    public String getName_of_requestor() {
        return name_of_requestor;
    }

    public String getRequestor_college() {
        return requestor_college;
    }

    public String getEmail_of_requestor() {
        return email_of_requestor;
    }

    public String getDate_of_request() {
        return date_of_request;
    }
}
