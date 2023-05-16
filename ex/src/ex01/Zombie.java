package ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zombie {
    private List<String> people;
    private ZombieHorde zombieHorde;

    public Zombie() {
        this.people = new ArrayList<>(Arrays.asList("지헌", "민주", "성원", "우식", "다빈"));
        //Arrays.asList() Arrays의 정적 클래스인 ArrayList 리턴함
        //정적이라 추가 삭제 불가, 생성하면서 초기값 설정 가능,
        this.zombieHorde = new ZombieHorde();
    }

    public List<String> getPeople() {
        return people;
    }

    public void setPeople(List<String> people) {
        this.people = people;
    }

    public void Bite() {
        int numPeople = people.size();
        int randomIndex = (int) (Math.random() * numPeople);
        String victim = people.get(randomIndex);
        System.out.println("Grraaaaaa...");
        people.remove(randomIndex);
        zombieHorde.addZombie(victim);
    }

    public void survivor() {
        for (String person : people) {
            System.out.print(person + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Zombie zombie = new Zombie();
        int biteCount = 0;
        while (biteCount < 4 && zombie.getPeople().size() > 1) {
            zombie.Bite();
            zombie.survivor();
            biteCount++;
        }

        ZombieHorde zombieHorde = zombie.getZombieHorde(); // Zombie 클래스에서 ZombieHorde 객체 생성
        System.out.println("Zombie count: " + zombieHorde.howManyZombie());
    }

    public ZombieHorde getZombieHorde() {
        return zombieHorde;
    }
}
