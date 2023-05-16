package ex04;

public class Dog extends Animal {
    public Dog(Brain brain) {
        super(String.valueOf(brain));
    }

    public void makeSound() {
        System.out.println(getName() + ": bark!!!!");
    }
}