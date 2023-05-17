package ex04;

public abstract class Animal {  //추상 클래스
    private String name;

    public Animal(Brain brain){

        this.name = brain.getName();
    }
    public void makeSound(){};

    public static void main(String[] args) {

        Animal nabi = new Cat(new Brain("nabi"));
        Animal coco = new Dog(new Brain("coco"));

        nabi.makeSound();
        coco.makeSound();

    }
}
