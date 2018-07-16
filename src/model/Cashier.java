/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ALOLA
 */
public class Cashier extends People {

    private String user;
    private String pass;
    private int nok;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getNok() {
        return nok;
    }

    public void setNok(int nok) {
        this.nok = nok;
    }
}
