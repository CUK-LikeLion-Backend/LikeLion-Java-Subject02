package ex04;

import javax.lang.model.element.Name;

public class Cat extends Animal{

    public Cat(Brain nabi) {
        setName(nabi.getName());
    }

    @Override
    public void makeSound(){
        System.out.println(getName() + ": meow~~~");
    }
}
