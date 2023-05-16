package ex04;

public abstract class Animal {
    private Brain brain;
    Animal (Brain brain){
        this.brain = brain;
    }
    public void makeSound() {
        System.out.print(brain.getName() + ": ");
    }
}

class Main{
    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal coco = new Dog(new Brain("coco"));

        nabi.makeSound();
        coco.makeSound();
    }
}

