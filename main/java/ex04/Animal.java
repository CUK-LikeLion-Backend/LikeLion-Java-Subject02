package main.java.ex04;

public abstract class Animal {
    //필드
    String name;
    //생성자
    //메서드
    public void Name(){
        System.out.printf("%s: ",name);
    }
    //추상 메서드
    public abstract void makeSound();
}
