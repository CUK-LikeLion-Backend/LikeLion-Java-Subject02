package ex04;

public class Cat extends Animal {
    String name;

    @Override
    void makeSound() {
        System.out.println(name + "meow~~~~~~~~~~~");
    }

    public Cat(Brain brain){
        this.name = brain.getStr();
    }
}
