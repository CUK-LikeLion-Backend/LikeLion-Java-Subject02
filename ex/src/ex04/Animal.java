package ex04;

class Brain {
    private String name;

    public Brain(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

abstract class Animal {
    public abstract void makeSound();
    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound(); // "nabi: meow~~~" 출력
        choco.makeSound(); // "choco: bark!!!!" 출력
    }

}

class Dog extends Animal {
    Brain brain;
    public Dog(Brain brain) {
        this.brain=brain;
    }

    public void makeSound() {
        System.out.println(brain.getName() + ": bark!!!!");
    }

}

class Cat extends Animal {
    Brain brain;

    public Cat(Brain brain) {
        this.brain=brain;
    }

    public void makeSound() {
        System.out.println(brain.getName() + ": meow~~~");
    }

}
