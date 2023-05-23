package main.java.ex01;

import java.util.Scanner;

public class ZombieHorde {
    private int[] zomHor;
    public ZombieHorde(int total){
        for(int i=0;i<total;i++){
            zomHor=new int[i];
        }
    }
    void attack(){
        System.out.println("Grrrraaaaa");
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Zombie zombi=new Zombie();
        System.out.println("좀비생성");
        System.out.println(zombi.bite());
        System.out.println("좀비의 숫자를 입력하세요");
        int zom= sc.nextInt();
        ZombieHorde zombieHorde=new ZombieHorde(zom);
        System.out.println("새로운 좀비 생성");
        for(int i=0;i<zom;i++){
            zombieHorde.attack();
        }
        zom+=zom;
        System.out.println("\n공격을 원한다면 attack을 입력하세요.\n");
        String input= sc.next();
        if(input.equals("attack")) {
            System.out.println("\n좀비군단 공격!\n");
            for (int i = 0; i < zom; i++) {
                zombieHorde.attack();
            }
        }
    }
}
