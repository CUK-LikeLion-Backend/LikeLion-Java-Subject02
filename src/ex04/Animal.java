package ex04;
abstract class Animal {
    private Brain brain;  // 멤버 변수 brain을 private로 선언합니다. (한국어 해석: 동물의 뇌)

    public Animal(Brain brain) {
        this.brain = brain;
    }

    public abstract void makeSound();  // 추상 메서드 makeSound를 선언합니다. (한국어 해석: 소리를 내는 메서드)

    public Brain getBrain() {
        return brain;
    }

    public void setBrain(Brain brain) {
        this.brain = brain;
    }
}
