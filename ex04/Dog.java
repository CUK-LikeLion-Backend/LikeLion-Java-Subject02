package ex04;

public class Dog extends Animal {
    Dog(Brain brain) {
        super(brain);
    }
    @Override
    public void makeSound() {
        System.out.println(brain.getName() + " : bark!!!!");
    }
}
