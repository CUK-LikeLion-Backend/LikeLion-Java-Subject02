package ex04;

public class Cat extends Animal{
    private String name;

    public Cat(Brain brain){
        super(brain);   //부모클래스의 생성자 호출 후 name 초기화
        this.name = brain.getName();
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println(name+": meow~~~");
    }

}
