package ex04;

import javax.xml.namespace.QName;

public abstract class Animal {
    private String name;
    public void makeSound(){
    }
    public Animal(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
