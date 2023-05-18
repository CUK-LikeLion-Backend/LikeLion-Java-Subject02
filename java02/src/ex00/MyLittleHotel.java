package ex00;

import java.util.Scanner;

class HotelRoom{
}
public class MyLittleHotel {

    private static int size = 0;
    public static void checkIn(HotelRoom[] room){
        if(size>=8) {
            System.out.println("비어 있는 방이 없습니다.");
            return;
        }
        for(int i=0; i<8; i++){
            if(room[i] != null) continue;
            else {
                room[i] = new HotelRoom();
                System.out.println(i+"번 방 체크인 되셨습니다.");
                return ;
            }
        }
    }
    public static void checkOut(HotelRoom[] room,  int roomNum){
        if(room[roomNum] == null){
            System.out.println("배정되지 않은 객실은 체크아웃 할 수 없습니다.");
            return;
        }
        room[roomNum] = null;
        System.out.println(roomNum + "번 방 체크 아웃 되셨습니다.");

    }
    public static void main(String[] args) {
        //객체를 담을 배열 생성
        HotelRoom[] roomArray = new HotelRoom[8];
        // while문 돌면서 수용인원 확인
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Command 'checkIn' or 'checkOut' : ");
            String command = sc.nextLine();
            if (command.equals("checkIn")) {
                checkIn(roomArray);
            } else if(command.equals("checkOut")) {
                System.out.print("What is you room number? : ");
                int roomNum = sc.nextInt() ;
                checkOut(roomArray,roomNum);
            }else{
                System.out.println("you can only command 'checkIn' or 'checkout'");
            }
        }
    }
}
