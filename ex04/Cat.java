package ex04;

class Cat extends Animal {
    public Cat(Brain brain) {
        super(brain);
    }

    @Override
    public void makeSound() {
        super.makeSound();
        System.out.println("meow~~~");
    }
}
