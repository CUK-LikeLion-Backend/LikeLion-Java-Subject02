package ex04;

public class Cat extends Animal {
    private String name;
    public Cat(Brain brain){ // Brain 객체를 파라미터로 받는 생성자는 Cat의 맴버 name의 Brain의 멤버 name을 저장한다.
        String name = brain.getName();
        this.name=name;
    }
    public void makeSound(){
        System.out.println(name+": meow~~~");
    }
}
