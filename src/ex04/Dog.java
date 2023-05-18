package ex04;

public class Dog extends Animal{
    private String name;

    public Dog(Brain brain){
        super(brain);   ////부모클래스의 생성자 호출 후
        this.name = brain.getName();    //name 초기화
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println(name+": bark!!!");
    }

}
