package ex04;

class Cat extends Animal {
    public Cat(Brain brain) {
        super(brain);
    }

    @Override
    public void makeSound() {
        System.out.println(getBrain().getName() + ": meow~~~");  // 동물의 이름과 "meow~~~"를 출력합니다. (한국어 해석: 고양이는 야옹합니다.)
    }
}
