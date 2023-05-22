package ex04;

public abstract class Animal  {
    private String name;
    abstract void makeSound();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        Animal nabi = new Cat(new Brain("nabi"));
        Animal coco = new Dog(new Brain("coco"));

        nabi.makeSound();
        coco.makeSound();


    }
}
