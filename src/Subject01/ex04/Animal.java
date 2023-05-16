package Subject01.ex04;

abstract public class Animal {
    private String animalName = "";
    private String animalSound = "";
    public Animal(Brain name, String sound) {
        this.animalName = name.animalName;
        this.animalSound = sound;
    }

    private void makeSound() {
        if(this.animalName.equals("")){
            System.out.println("이름이 없는 동물은 소리를 낼 수 없습니다.");
            return;
        }
        System.out.println(this.animalName + ": " + this.animalSound);
    }

    private void eating(){
        if(this.animalName.equals("")){
            System.out.println("이름이 없는 동물은 밥을 먹을 수 없습니다.");
            return;
        }
        System.out.println(this.animalName + " 밥 먹는 중...");
    }

    public static void main(String[] args) {
        Animal nabi = new Cat(new Brain("nabi"));
        Animal choco = new Dog(new Brain("choco"));
        //Animal noName = new Dog(new Brain()); 이름 없어서 생성 불가

        nabi.makeSound();
        choco.makeSound();
        nabi.eating();
    }
}
