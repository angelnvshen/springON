package webservice;

import java.io.Serializable;

/**
 * Created by bf50 on 2016/1/11.
 */
public class Account implements Serializable{
    private String name;
    private double money;
    private String curreny;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getCurreny() {
        return curreny;
    }

    public void setCurreny(String curreny) {
        this.curreny = curreny;
    }

    public Account(String name, double money, String curreny) {
        this.name = name;
        this.money = money;
        this.curreny = curreny;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "curreny='" + curreny + '\'' +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}
