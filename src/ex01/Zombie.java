package ex01;

public class Zombie {

    public Zombie(){
        System.out.println("Grraaaaaa...");
    }

    public Zombie attack(){
        System.out.println("좀비의 공격 -> 좀비로 변함!");
        return new Zombie();
        //좀비에게 공격당하면 좀비로 변하기에 새로운 좀비 객체 생성
    }
}
