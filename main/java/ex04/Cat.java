package main.java.ex04;

public class Cat extends Animal{
    public Cat(Brain name){
        this.name= name.toString();
    }
    public void makeSound(){
        System.out.printf("meow~\n",name);
    }
}
