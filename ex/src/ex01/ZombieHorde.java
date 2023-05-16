package ex01;

import java.util.ArrayList;

class Zombie {
    public Zombie() {
        System.out.println("Grraaaaaa...");
    }

    public void bite(Person person) {
        person.becomeZombie();
    }
}

class ZombieHorde {
    private static ArrayList<Zombie> zombies = new ArrayList<>();

    public static void attack(ArrayList<Person> people, int num) {
        Zombie zombie = new Zombie();
        zombie.bite(people.get(num));
    }

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person());
        people.add(new Person());
        people.add(new Person());

        ZombieHorde.attack(people, 0);
        ZombieHorde.attack(people, 2);

        for(int i=0;i<people.size();i++){
            System.out.print((i+1)+"번째: ");
            if(people.get(i).isZombie()){
                System.out.print("좀비");
            }else{
                System.out.print("인간");
            }
            System.out.println();
        }
    }
}

class Person {
    private boolean isZombie;

    public boolean isZombie() {
        return isZombie;
    }

    public void becomeZombie() {
        isZombie = true;
    }
}