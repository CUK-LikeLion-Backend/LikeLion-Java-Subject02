package ex00;

import java.util.Scanner;

public class MyLittleHotel {
    private int[] room;

    // 생성자
    public MyLittleHotel(int roomCount) {
        room = new int[roomCount];
    }

    // getter
    public int getRoomUsed(int num) {
        return room[num - 1];
    }

    // setter
    public void setCheckIn(int num) {
        room[num - 1] = 1;
    }

    public void setCheckOut(int num) {
        room[num - 1] = 0;
    }

    public void printRoom(){
        for(int i = 0; i<room.length; i++){
            System.out.println(room[i] + " ");
        }
        System.out.println();
    }

    // 얕은 복사 메소드
    public MyLittleHotel shallowCopy() {
        MyLittleHotel copy = new MyLittleHotel(room.length);
        copy.room = this.room;
        return copy;
    }

    // 깊은 복사 메소드
    public MyLittleHotel deepCopy() {
        MyLittleHotel copy = new MyLittleHotel(room.length);
        for (int i = 0; i < room.length; i++) {
            copy.room[i] = this.room[i];
        }
        return copy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("객실 개수를 입력해주세요: ");
        int roomCount = sc.nextInt();
        MyLittleHotel hotel = new MyLittleHotel(roomCount);

        while (true) {
            System.out.println("어떤 메뉴를 선택하시겠습니까?");
            System.out.println("1. 체크인 2. 체크아웃 3. 종료");
            int menu = sc.nextInt();

            if (menu == 1) {
                System.out.println("몇번 객실을 원하시나요?");
                int num = sc.nextInt();
                if (hotel.getRoomUsed(num) == 1) {
                    System.out.println("이미 예약 완료된 방입니다.");
                } else {
                    hotel.setCheckIn(num);
                    System.out.println("체크인 완료");
                }
            } else if (menu == 2) {
                System.out.println("객실의 번호를 입력해주세요");
                int num = sc.nextInt();
                if (hotel.getRoomUsed(num) == 1) {
                    hotel.setCheckOut(num);
                    System.out.println("체크아웃 완료");
                } else {
                    System.out.println("배정되지 않은 객실입니다.");
                }
            } else {
                break;
            }
            System.out.println();
        }
        hotel.printRoom();

        MyLittleHotel shallowCopy = hotel.shallowCopy();
        System.out.println("얕은 복사 완료");
        shallowCopy.printRoom();

        MyLittleHotel deepCopy = hotel.deepCopy();
        System.out.println("깊은 복사 완료");
        deepCopy.printRoom();
    }
}
