package main.java.ex01;

import java.util.Scanner;

public class Zombie {
        int add;
        void grr(){
            //좀비가 될 떄 출력하도록 함.
            String sound="Grraaaaaa";
            System.out.println(sound+"(*"+add+")");
        }
    public static void main(String[] args) {
        //사람을 물까요? -> true 입력시 물고 false 입력시 안문다.
        //물려서 좀비가 되면 grrr 소리를 낸다.
        //좀비의 수와 인간의 수를 입력받고 인간이 물릴때마다 숫자 수정+좀비소리
        Zombie zombi=new Zombie();
        ZombieHorde zomHor=new ZombieHorde();
        Scanner sc=new Scanner(System.in);
        //인간의 숫자를 입력
        System.out.println("인간의 숫자를 입력하세요");
        int HumNum= sc.nextInt();
        //좀비의 숫자를 입력
        System.out.println("좀비의 숫자를 입력하세요");
        zomHor.total= sc.nextInt();
        //zonbi에서 add는 군단에서 total과 같음
        zombi.add=zomHor.total;
        //물린 사람 수 만큼 grr출력
        zombi.grr();
        //total 풀력
        zomHor.printTotal();
        HumNum-=zombi.add;
        System.out.printf("남은사람은 %d명이고, 좀비군단은 %d명으로 증가했다.",HumNum,zomHor.total);
    }
}
