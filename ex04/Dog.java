package ex04;

public class Dog extends Animal{

    public Dog(Brain brain) {
        super(brain);
    }
    @Override
    public void makeSound() {
        System.out.println( super.getBrain() +"bark!!!");
    };
}
