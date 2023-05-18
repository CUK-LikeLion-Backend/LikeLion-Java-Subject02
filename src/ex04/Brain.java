package ex04;

class Brain {
    private String name;  // 멤버 변수 name을 private로 선언합니다. (한국어 해석: 뇌의 이름)

    public Brain(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));  // "nabi"라는 이름의 고양이 객체를 생성합니다.
        Animal choco = new Dog(new Brain("choco"));  // "choco"라는 이름의 강아지 객체를 생성합니다.

        nabi.makeSound();  // 고양이의 소리를 출력합니다.
        choco.makeSound();  // 강아지의 소리를 출력합니다.
    }
}

