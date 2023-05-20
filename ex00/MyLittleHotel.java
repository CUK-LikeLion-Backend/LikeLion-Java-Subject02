package ex00;

import java.util.Scanner;

//예외처리로 배열이 가득차면 더이상 체크인을 할 수 없도록!!
//예외처리로 배정되지 않은 객실은 체크아웃을 할 수 없다
//객실은 원하는객실 !!!
//room번호 = 1이면 사람있는거 room번호 = 0이면 빈 방

public class MyLittleHotel {
    private int[] hotel;

    public MyLittleHotel() {
        hotel = new int[8];
    }

    Scanner sc = new Scanner(System.in);

    public void HotelCheckIn(String name, int room) throws Exception {
        //예외처리 할 조건
        //1. 룸이 다 찰 경우
        //2. 이미 예약된 객실을 원하는 경우
        //3. 1~8번 말고 다른 객실을 입력한 경우

        //1번
        if (isFull(hotel)) {
            throw new Exception("객실이 다 찼습니다 ㅠ,ㅠ");
        }

        //2번 (원하는객실이 다 경우)
        if (hotel[room - 1] == 1) {
            throw new Exception("이미 예약된 객실입니다");
        }

        //3번
        if (room < 1 || room > 8) {
            throw new Exception("1~8번방만 체크인 할 수 있습니다.");
        }

        //배열  : 0 1 2 3 4 5 6 7
        //룸넘버 : 1 2 3 4 5 6 7 8
        hotel[room - 1] = 1; //배정 완료 (예외처리보다 먼저하면 체크인하고 바로 2번예외처리에 걸림!!)
        System.out.printf("%s님이 %d번 객실에 체크인하였습니다.\n", name, room);
        System.out.printf("------------------------------\n");
        System.out.printf("\n");
    }

    private boolean isFull(int[] hotel) {
        for (int room : hotel) {
            if (room == 0) //룸이 하나라도 0이면 꽉찬게 아니므로 false
                return false;
        }
        return true;
    }

    public void HotelCheckOut(int room) throws Exception {
        //예외처리 조건
        //1. 빈방은 체크아웃할 수 없다
        //2. 1~8번방이 아닌 방은 없다

        //1번
        if (hotel[room - 1] == 0) {
            throw new Exception("빈방은 체크아웃할 수 없습니다");
        }

        //2번
        if (room < 1 || room > 8) {
            throw new Exception("1~8번방만 체크아웃할 수 있습니다");
        }

        hotel[room - 1] = 0; //체크아웃 완료
        System.out.printf("%d번방 체크아웃 완료되었습니다\n", room);
        System.out.printf("------------------------------\n");
        System.out.printf("\n");
    }

    public static void main(String[] args) {
        MyLittleHotel Hotel = new MyLittleHotel();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int hotel[] = new int[8];
            int i = 0;

            System.out.println("체크인 하시나요?: y / n");
            String ans = sc.next();

            //체크인
            if (ans.equals("y")) {
                System.out.println("이름을 입력하세요");
                String name = sc.next();
                System.out.println("원하는 객실번호를 알려주세요");
                int room = sc.nextInt();

                try {
                    Hotel.HotelCheckIn(name, room);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            //체크아웃
            else {
                System.out.println("체크아웃 객실을 알려주세요");
                int room = sc.nextInt();

                try {
                    Hotel.HotelCheckOut(room);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
