package com.mytrendin.googlemapsapp;

import java.io.Serializable;

import co.uk.rushorm.core.RushObject;

/**
 * Created by ATTech_Android_1 on 02/05/2018.
 */

public class RushORM extends RushObject implements Serializable{
    private String f_name,l_name, propellant,email, gender, password, confirm_password ;

    /*
    AN EMPTY CONSTRUCTOR
     */
    public RushORM() {
    }

    /*
    AN EMPTY CONSTRUCTOR.
     */
    public String getf_Name() {
        return f_name;
    }

    public void setf_Name(String f_name) {
        this.f_name = f_name;
    }

    public String getl_Name() {
        return l_name;
    }

    public void setl_Name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String get_gender() {
        return gender;
    }

    public void set_gender(String gender) {
        this.gender = gender;
    }

    public String get_password() {
        return password;
    }

    public void set_password(String password) {
        this.password = password;
    }

    public String get_Confirm_password() {
        return confirm_password;
    }

    public void set_Confirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }
}
