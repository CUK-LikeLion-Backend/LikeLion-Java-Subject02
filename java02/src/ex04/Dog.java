package ex04;

public class Dog extends Animal{
    public Dog(Brain brain) {
        super(brain); // 조상클래스의 생성자를 호출 -> 초기화
    }
    @Override
    public void makeSound() {
        System.out.println("(" + brain.getName() +") : "+ "bark!!!");
    }
}
