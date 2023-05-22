package ex04;

public class Dog extends Animal{

    Dog(){}
    Dog(Brain brain){
        super.setBrain(brain);
    }

    @Override
    void makeSound() {
        System.out.println("\""+super.getBrain().getName() +": bark!!!\"");
    }

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));

        nabi.makeSound();
        choco.makeSound();
    }
}
