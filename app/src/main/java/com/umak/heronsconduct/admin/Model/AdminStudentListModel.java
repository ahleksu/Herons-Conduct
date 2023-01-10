package com.umak.heronsconduct.admin.Model;

public class AdminStudentListModel {

    String id = " ";
    String img_profile  = " ";
    String studList_item_name  = " ";
    String studList_item_college  = " ";
    String studList_item_umak_email  = " ";
    String studList_num_acc  = " ";
    String studList_num_vio  = " ";


    public AdminStudentListModel(String id, String img_profile, String studList_item_name, String studList_item_college, String studList_item_umak_email, String studList_num_acc, String studList_num_vio) {
        this.id = id;
        this.img_profile = img_profile;
        this.studList_item_name = studList_item_name;
        this.studList_item_college = studList_item_college;
        this.studList_item_umak_email = studList_item_umak_email;
        this.studList_num_acc = studList_num_acc;
        this.studList_num_vio = studList_num_vio;
    }


    public String getId() {
        return id;
    }

    public String getImg_profile() {
        return img_profile;
    }

    public String getStudList_item_name() {
        return studList_item_name;
    }

    public String getStudList_item_college() {
        return studList_item_college;
    }

    public String getStudList_item_umak_email() {
        return studList_item_umak_email;
    }

    public String getStudList_num_acc() {
        return studList_num_acc;
    }

    public String getStudList_num_vio() {
        return studList_num_vio;
    }
}
