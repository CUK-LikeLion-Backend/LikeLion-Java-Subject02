package main.java.ex04;

public class Dog extends Animal{
    public Dog(Brain name){
        this.name= name;
    }

    @Override
    public String toString() {
        return name.name;
    }

    @Override
    public void makeSound(){
        System.out.printf("%s: bark!!!\n",toString());
    }
}
