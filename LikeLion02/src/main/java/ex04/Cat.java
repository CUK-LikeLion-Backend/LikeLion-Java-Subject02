package main.java.ex04;

public class Cat extends Animal{
    public Cat(Brain name){
        this.name= name;
    }

    @Override
    public String toString() {
        return name.name;
    }

    @Override
    public void makeSound(){
        System.out.printf("%s: meow~\n",toString());
    }
}
