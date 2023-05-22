package ex04;

public class Cat extends Animal{

    Cat(){}
    Cat(Brain brain){
        super.setBrain(brain);
    }

    @Override
    void makeSound() {
        System.out.println("\""+super.getBrain().getName() +": meow~~~\"");
    }
}
