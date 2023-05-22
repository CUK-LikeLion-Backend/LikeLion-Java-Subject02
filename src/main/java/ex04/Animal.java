package main.java.ex04;


public abstract class Animal {
    protected Brain brain;
    public Animal(Brain brain){

        this.brain = brain;
    }

   //makeSound 추상 메서드로 정의
    public abstract void makeSound();


}
