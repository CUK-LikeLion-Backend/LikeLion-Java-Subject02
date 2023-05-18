package ex04;

class Dog extends Animal {
    public Dog(Brain brain) {
        super(brain);
    }

    @Override
    public void makeSound() {
        System.out.println(getBrain().getName() + ": bark!!!!");  // 동물의 이름과 "bark!!!!"를 출력합니다. (한국어 해석: 개는 짖습니다.)
    }
}

