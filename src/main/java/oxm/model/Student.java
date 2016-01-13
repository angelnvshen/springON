package oxm.model;

import javax.xml.bind.annotation.*;

/**
 * Created by bf50 on 2016/1/13.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="student")
public class Student {
    @XmlElement(required = true)
    private String name;
    @XmlAttribute
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
