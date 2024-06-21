package com.example.csd214_lab2;

public class login {
    private int Id;
    private String Name;

    private String Email;

    private String Password;

    public login(int Id, String Name, String Email, String Password) {
        this.Id = Id;
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = Password;
    }

}

