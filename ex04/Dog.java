package ex04;

public class Dog extends Animal{

    public Dog(Brain choco) {
        setName(choco.getName());
    }

    @Override
    public void makeSound(){
        System.out.println(getName() +": bark!!!");
    }

}
