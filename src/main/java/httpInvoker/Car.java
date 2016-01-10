package httpInvoker;

import java.io.Serializable;

/**
 * Created by CHANEL on 2016/1/10.
 */
public class Car implements Serializable {
    private String name;

    private transient Integer capacity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
