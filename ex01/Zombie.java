package ex01;

public class Zombie {
    public Zombie(){
        System.out.println("Grraaaaaa"); //생성자 통해서 좀비 생성
    }
     public Zombie bite(){ //좀비가 사람물어 새 좀비 만들기
        System.out.println("인간을 물어 Zombie가 되었다!");
        return new Zombie();
    }
}