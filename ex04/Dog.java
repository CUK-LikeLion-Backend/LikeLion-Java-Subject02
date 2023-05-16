package ex04;

public class Dog extends Animal {
    public Dog(Brain brain) {
        super(brain);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("bark!!!!");
    }
}
