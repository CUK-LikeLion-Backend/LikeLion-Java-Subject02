package ex04;

public class Dog extends Animal{

    String name;

    @Override
    void makeSound() {
        System.out.println(name + "bark!!!!");
    }

    public Dog(Brain brain){
        this.name = brain.getStr();
    }
}
