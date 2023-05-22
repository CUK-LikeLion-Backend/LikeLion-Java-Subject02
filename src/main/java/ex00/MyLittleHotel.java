package main.java.ex00;

import java.util.LinkedList;
import java.util.Scanner;

public class MyLittleHotel {
    //객체를 동시에 최대 8개 배정할 수 있는 호텔
    private Room[] rooms;

    private class Room {
        private int roomNumber;
        private boolean isAvailable;

        public Room(int roomNumber) {
            this.roomNumber = roomNumber;
            this.isAvailable = true;
            }

            public int getRoomNumber(){
                return roomNumber;
            }
        }

    //MyLittleHotel 클래스
    public MyLittleHotel() {
        rooms = new Room[8];
        //roomNumber 가 1~8까지인 room 으로 초기화
        for (int i = 0; i < rooms.length; i++) {
            rooms[i] = new Room(i + 1);
        }
    }
    public void checkIn() {
        int availableRoomCount = 0;

        for (Room room : rooms) {
            if (room.isAvailable) {
                availableRoomCount++;
            }
        }
        if (availableRoomCount == 0) {
            System.out.println("모든 객실이 예약되었습니다.");
            return;
        }

        int number = (int) (Math.random() * availableRoomCount);
        int count = 1;
        //인데스 탐색하기 위한 임시 변수

       for(Room room : rooms){
           if(room.isAvailable){
               if(count == number){
                    room.isAvailable=false;
                   System.out.println("객실 " + room.getRoomNumber() + " 체크인하였습니다.");
                   return;
               }
               count++;
           }
        }

    }

    public void checkOut(int value){
        for(Room room : rooms) {
            if (!room.isAvailable) {
                if (value == room.getRoomNumber()) {
                    room.isAvailable = true;
                    System.out.println("객실 " + room.getRoomNumber() + " 체크아웃하였습니다.");
                    return;
                }
            }
        }
        System.out.println(value + "은 체크아웃할 수 없습니다.");
    }

    public void show(){
        System.out.println("방 현황");
        for(Room room: rooms){
            if(room.isAvailable ==true){
                System.out.println("객실 " + room.getRoomNumber() +":"+ "Empty");
            }
            else{
                System.out.println("객실 " + room.getRoomNumber() +":"+ "Not Empty");
            }
        }
    }

    public void test(){
        MyLittleHotel test = new MyLittleHotel();
        test.checkIn();
        test.checkIn();
        test.show();
        System.out.println("체크아웃할 방을 선택하세요 >>> (3번 입력) ");
        test.checkOut(3);
        test.show();
        System.out.println("체크아웃할 방을 선택하세요 >>> ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        test.checkOut(num);
        test.show();
    }

        public static void main (String[]args){

            MyLittleHotel test = new MyLittleHotel();
            test.test();
        }
}








