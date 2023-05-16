package ex04;

public class Cat extends Animal{
    public Cat(Brain brain) {
        super(brain);
    }

    @Override
    public void makeSound() {
        System.out.println(name + ": meow~~~");
    }
}
