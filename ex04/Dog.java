package ex04;

public class Dog extends Animal{
    public Dog(Brain brain) {
        super(brain.getName());
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + ": bark!!!!");
    }

}
