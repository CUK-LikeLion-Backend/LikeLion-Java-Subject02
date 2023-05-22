package ex04;

public abstract class Animal {
    Brain brain;

    public Animal(Brain brain){
        this.brain = brain;
    }

    public void makeSound(){
    }

    public static void main(String[] args) {

        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}
