package Subject01.ex01;

public class ZombieHorde {
    // 좀비 군단의 좀비 수
    private int zombieNum = 0;

    // 군집 이름
    private String ZombieHordeName = "";
    private ZombieHorde(int num, String str){
        for(int i = 0; i < num; i++){
            Zombie z = new Zombie(str);
        }
        this.zombieNum = num;
        this.ZombieHordeName = str;
    }

    private void bite(){
        for(int i = 0; i < this.zombieNum; i++){
            Zombie makeZombie = new Zombie(this.ZombieHordeName);
        }
        this.zombieNum *= 2;
    }
    public static void main(String[] args) {
        System.out.println("3마리 좀비 군집 생성");
        ZombieHorde z1 = new ZombieHorde(3, "쫌비");
        System.out.println();

        System.out.println("15마리 좀비 군집 생성");
        ZombieHorde z2 = new ZombieHorde(15, "좀빙");
        System.out.println();

        System.out.println("1마리 좀비 군집 생성");
        ZombieHorde z3 = new ZombieHorde(1, "조옴비");
        System.out.println();

        System.out.println("쫌비 군집 공격");
        z1.bite();
        System.out.println();

        System.out.println("좀빙 군집 공격");
        z2.bite();
        System.out.println();

        System.out.println("조옴비 군집 공격");
        z3.bite();
        System.out.println();
    }
}
