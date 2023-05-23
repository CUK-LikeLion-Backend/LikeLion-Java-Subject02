package ex00;
class Room {
    private int number;
    public boolean isCheckIn = false;
    public boolean isCheckOut = false;

    public Room(int number) {
        this.number = number;
    }
}
public class MyLittleHotel {
    private Room[] roomsArray = new Room[8];

    public MyLittleHotel() {
        roomsArray = new Room[8];
        for (int i = 0; i < 8; i++) {
            roomsArray[i] = new Room(i + 1);
        }
    }

    public void isCheckIn(int number) {
        if (number <= 0 || number > 8) {
            System.out.println("해당 객실 번호는 없는 객실 번호입니다.");
        }
        else if (roomsArray[number - 1].isCheckIn == true) {
            System.out.println(number + "호실은 이미 체크인되어있는 호실입니다.");
        }
        else {
            roomsArray[number - 1].isCheckIn = true;
            System.out.println(number + "호실에 체크인되었습니다.");
        }
    }

    public void isCheckOut(int number) {
        if (number <= 0 || number > 8) {
            System.out.println("해당 객실 번호는 없는 객실 번호입니다.");
        }
        else if (roomsArray[number - 1].isCheckIn == false) {
            System.out.println(number + "호실은 비어 있습니다. 비어 있는 객실에는 체크아웃할 수 없습니다.");
        }
        else {
            roomsArray[number - 1].isCheckOut = true;
            roomsArray[number - 1].isCheckIn = false;
            System.out.println(number + "호실에 체크아웃되었습니다.");
        }
    }

    public void isFull() {
        int cnt = 0;
        for(int i = 0; i < 8; i++) {
            if (roomsArray[i].isCheckIn == true) {
                cnt += 1;
            }
        }
        if (cnt == 8) {
            System.out.println("호텔의 모든 객실이 체크인되어 더 이상 체크인할 수 없습니다.");
        }
        else {
            System.out.println("아직 체크인할 수 있는 객실이 남아있습니다.");
        }
    }

    public static void main(String[] args) {
        MyLittleHotel hotel = new MyLittleHotel();
        hotel.isFull();
        hotel.isCheckIn(1);
        hotel.isCheckIn(1);
        hotel.isCheckIn(2);
        hotel.isCheckOut(2);
        hotel.isCheckOut(2);
        hotel.isCheckIn(10);
        hotel.isCheckOut(10);
        hotel.isCheckIn(2);
        hotel.isCheckIn(3);
        hotel.isCheckIn(4);
        hotel.isCheckIn(5);
        hotel.isCheckIn(6);
        hotel.isCheckIn(7);
        hotel.isCheckIn(8);
        hotel.isFull();
    }
}