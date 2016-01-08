package burlap.model;

import java.io.Serializable;

/**
 * Created by bf50 on 2016/1/8.
 */
public class Food implements Serializable {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
