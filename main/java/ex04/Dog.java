package main.java.ex04;

public class Dog extends Animal{
    public Dog(Brain name){
        this.name= name.toString();
    }
    public void makeSound(){
        System.out.printf("bark!!!\n");
    }
}
