package ex04;

public class Cat extends Animal{
    public Cat (Brain brain){
        super(brain);
    } //부모클래스에 접근하기 위해 super씀

    public void makeSound(){
        System.out.printf("%s : meow~~~\n", brain.getName());
    }
}
