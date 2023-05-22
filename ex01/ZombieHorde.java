package ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// 좀비 군단에 있는 좀비가 한번씩은 사람을 문다는 의미인듯
public class ZombieHorde {
    private int ZombieHordeCount = 4; // 초기 좀비 수는 4명
    private int num = 4; // 추가될 좀비의 번호의 시작 5,6,7,8(사람 -> 좀비)
    private List<Zombie> zombies;   // 좀비 객체를 담는 리스트
    public ZombieHorde() {
        zombies = new ArrayList<>();   // 빈 리스트로 초기화
        zombies.add(new Zombie(1));  // 초기 좀비 4마리 + 4(사람 4명) =  총 8마리 되어야함.
        zombies.add(new Zombie(2));
        zombies.add(new Zombie(3));
        zombies.add(new Zombie(4));
    }
    public int getZombieHordeCount(){
        return ZombieHordeCount;
    }
    public void setZombieHordeCount(int ZombieHordeCount){
        this.ZombieHordeCount = ZombieHordeCount;
    }
    public List<Zombie> getZombies() {
        return zombies;
    }
    public void addZombie(Zombie zombie) {
        zombies.add(zombie);
    }
    public void biteHuman(Zombie zombie){
        Random random = new Random();


        int randomNum = random.nextInt(zombies.size());
        int[] intArray;

        num++;
        System.out.println("Grraaaaaaa...");
        System.out.println("좀비인 "+zombies.get(randomNum) + " 에 의해 " + "사람 " +num +"이 좀비가 되었습니다.");

        if(zombie.getHumanCount() > 0) {
            // 0. 좀비 하나는 무조건 한명의 사람을 물어야함.
            // 1. 사람수 하나 줄어듦 -> 좀비수 하나 증가
            // 2. 소리를 내야한다. -> zombie 클래스에 존재.
            zombie.setHumanCount(zombie.getHumanCount() - 1);
            zombies.add(new Zombie(num));
        }
    }
}