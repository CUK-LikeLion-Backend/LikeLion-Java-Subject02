package ex01;

public class Zombie {
    private boolean isZombie;

    // 좀비의 초기 설정은 사람
    public Zombie() {
        this.isZombie = false;
    }

    public boolean getIsZombie() {
        return isZombie;
    }

    public void setIsZombie(boolean isZombie) {
        this.isZombie = isZombie;
    }

    // 좀비로 감염됨
    public void turnIntoZombie() {
        this.isZombie = true;
        System.out.println("Grraaaaaa...");
    }
}