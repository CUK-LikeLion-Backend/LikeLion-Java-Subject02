package ex01;

public class Zombie {
    private boolean Attack = false;
    //공격하지 않았으면 false

    public Zombie(){
        System.out.println("Grraaaaaa...");
    }

    public boolean bite() {
        //공격했으면 true
        Attack = true;
        return Attack;
    }

}

