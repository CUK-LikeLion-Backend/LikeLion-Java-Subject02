package main.java.ex01;

public class ZombieHorde {
    int total;
    void printTotal(){
        System.out.printf("%d명이 좀비가 되었습니다.\n",total);
        total+=total;
    }
}
