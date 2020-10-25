package com.example.appmovilesunicauca2020.model;

public class RegisterUserModel {

    private int id;
    private String nameUser, mailUser, phoneUser,  passUser;

    public RegisterUserModel(int id, String nameUser, String mailUser,
                             String phoneUser,  String passUser) {
        this.id = id;
        this.nameUser = nameUser;
        this.mailUser = mailUser;
        this.phoneUser = phoneUser;
        this.passUser = passUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getPhoneUser() { return phoneUser; }

    public void setPhoneUser(String phoneUser) { this.phoneUser = phoneUser; }

    public String getPassUser() {
        return passUser;
    }

    public void setPassUser(String passUser) {
        this.passUser = passUser;
    }
}
