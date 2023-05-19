package ex00;

import java.sql.Array;
import java.util.Random;

public class MyLittleHotel {
    public static void main(String[] args) {
        Room room = new Room();
        Random random = new Random();
        /*room.cheackin(random.nextInt(7)+1);
        room.cheackin(random.nextInt(7)+1);
        room.cheakout(random.nextInt(7)+1);
        room.cheakout(random.nextInt(7)+1);*/
        room.cheackin(1);
        room.cheackin(8);
        room.cheakout(1);
        room.cheakout(1);
    }

}
class Room{
    private int[] room = new int[8];


    void cheackin(int roomNumber){
        if(room[roomNumber - 1] != 0){
            System.out.println("이미 "+roomNumber+"번 방에 손님이 있습니다.");
        }
        else {
            room[roomNumber - 1] = roomNumber;
            System.out.println(roomNumber  + "번방에 손님이 체크인하였습니다.");
        }
    }
    void cheakout(int roomNumber){
        if(room[roomNumber - 1] != 0) {
            System.out.println(roomNumber  + "번방에 손님이 체크아웃하였습니다.");
            room[roomNumber - 1] = 0;
        }

        else
            System.out.println("객실에 손님이 없습니다.");

    }


}
