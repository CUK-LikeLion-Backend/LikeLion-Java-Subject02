package ex04;

public class Brain {
    private String name;
    public Brain(String name){ // 생성자 직접입력시 기본 생성자 자동작성 안됨.
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public static void main(String[] args) {

        Animal nabi = new Cat(new Brain("nabi"));
        Animal coco = new Dog(new Brain("choco"));

        nabi.makeSound();
        coco.makeSound();

    }
}
