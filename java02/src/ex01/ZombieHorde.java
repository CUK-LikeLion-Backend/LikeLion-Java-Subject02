package ex01;

import java.util.ArrayList;
// 동적배열
// 물기 메서들을 이용해서 물면 배열 안에 다시 넣어보기
public class ZombieHorde {
    private static  ArrayList<Zombie>zombies = new ArrayList<Zombie>();
    public static void horderBite(){
        int t = zombies.size();
        for(int i=0; i<t; i++){ // 존재하는 모든 좀비의 물기 메서드 호출
            zombies.get(i).bite();
        }
    };
    public static ArrayList<Zombie> getZombies() {
        return zombies;
    }
    public static void setZombies(ArrayList<Zombie> zombies) {
        ZombieHorde.zombies = zombies;
    }
    public static void main(String[] args) {
        zombies.add(new Zombie()); // 1개의 좀비 생성
        for(int i=0; i<4; i++) horderBite(); // 2^4 좀비 생성
        System.out.println(zombies.size());
    }

}
