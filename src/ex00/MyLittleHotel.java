package ex00;
import java.util.Random;

class Room{
    private Boolean[] array;

    public Room(){
        System.out.println("Room 클래스의 기본 생성자 호출");
    }

    public Room(int count) {
        this.array = new Boolean[count];
    }

    public Boolean[] setArray(int count){
        for(int i = 0; i < count; i++)
            this.array[i] = false;
        return this.array;
    }
}
//> **Requirements**
//        >
//        > 1. 방이 8개인 수용하는 호텔을 만들어보세요.
//        > 2. 호텔이 가득차면 더 이상 체크인을 할 수 없습니다.
//        > 3. 배정되지 않은 객실은 체크아웃 할 수 없습니다.
//        > 4. 객실은 번호는 임의로 배정할 수 있습니다.
//        > 5. 객실은 배열을 사용해서 저장합니다.
public class MyLittleHotel {

    private Room room;
    private Boolean[] rooms;

    public MyLittleHotel(){
        room = new Room(8);
        rooms = room.setArray(8);
        System.out.println("MyLittleHotel 클래스의 기본 생성자 호출");
    }

    public Boolean isFull(){
        int count = 0;
        for(Boolean n : rooms)
            if(n == true) count++;
        if(count == 8) return true;
        return false;
    }
    public void checkIn(){

        if(this.isFull()) {
            System.out.println("방이 꽉찼습니다.");
            return;
        }

        Random random = new Random();
        int roomNumber = random.nextInt(8);

        if(rooms[roomNumber] == false) {
            rooms[roomNumber] = true;
            System.out.printf("%d방 예약에 성공하셨습니다.\n", roomNumber);
            return;
        }
        else checkIn();
    }

    public void checkOut(int roomNumber){
        if(rooms[roomNumber] == false){
            this.rooms[roomNumber] = true;
            System.out.printf("%d번 방 체크아웃이 완료되었습니다\n", roomNumber);
            return;
        }
        System.out.printf("%d번 방은 이미 체크아웃이 완료된 방입니다.\n", roomNumber);
        return;
    }

    public static void main(String[] args) {
        MyLittleHotel hotel = new MyLittleHotel();

        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();
        hotel.checkIn();

        hotel.checkOut(0);
    }
}
