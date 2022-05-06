package com.example.antiquette;

import com.google.gson.annotations.SerializedName;

public class User {
    private int id;
    private String email;
    private  String password;
    private String name;
    private String confirmPassword;

    public String getSuccess() {
        return success;
    }

    @SerializedName("success")
    private String success;


    public User(int id, String email, String password, String name, String confirmPassword, String success) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.confirmPassword = confirmPassword;
        this.success = success;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}

