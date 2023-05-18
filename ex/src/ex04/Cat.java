package ex04;

public class Cat extends Animal{
    private Brain brain;

    Cat(Brain brain){
        this.brain = brain;
    }
    @Override // 이름과 반환형이 같으면서 매개변수 개수와 타입까지 같은 메소드
    public void makeSound(){
        System.out.println(brain.getName() + " : meow~~~~");
    }
}
