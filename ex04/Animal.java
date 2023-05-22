package ex04;

public abstract class Animal {
    private Brain brain;

    public Animal(Brain brain) {
        this.brain = brain;
    }

    public Brain getBrain() {
        return brain;
    }
    public abstract void makeSound(); //짖는 소리는 동물마다 다르기에 abstract메서드 생성

    public static void main(String[] args) {

        // animal은 추상화지만 dog,cat이 extends하고있기에 cat과 dog는 객체 생성가능
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();


    }

}
