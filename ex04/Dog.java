package ex04;

public class Dog extends Animal{
    public Dog (Brain brain){
        super(brain);
    }

    public void makeSound(){
        System.out.printf("%s : bark!!!\n", brain.getName());
    }
}
