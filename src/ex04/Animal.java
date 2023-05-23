package ex04;

class Dog extends Animal{
    public Dog(Brain brain){
        super.setName(brain.getName());
    }

    public void makeSound(){
        System.out.println(this.getName() + " : bark!!");
    }
}

class Cat extends Animal{
    public Cat(Brain brain){
        super.setName(brain.getName());
    }

    public void makeSound(){
        System.out.println(this.getName() + " : meow~~");
    }
}

class Brain{
    private String name;

    public Brain(String name){
        this.name= name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public abstract class Animal {
    private String name;
    abstract public void makeSound();

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
