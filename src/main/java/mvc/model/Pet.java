package mvc.model;

/**
 * Created by bf50 on 2015/12/22.
 */
public class Pet {
    private String name;
    private String desc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "desc='" + desc + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
