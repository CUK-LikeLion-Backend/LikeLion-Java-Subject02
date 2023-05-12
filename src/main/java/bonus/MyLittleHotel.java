package bonus;

class Room {
    private int number;

    private Room() {}
    public Room(int number) {
        this.number = number;
    }
    public Room(Room room) {
        this.number = room.number;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
}

public class MyLittleHotel {
    private final Room[] rooms = new Room[8];
    private int size = 0;

    MyLittleHotel() {}
    public void checkIn(int roomNumber) {
        if (size == 8) {
            System.out.println("더 이상 수용할 수 없습니다.");
            return;
        }

        for (int i = 0; i < size; ++ i) {
            if (rooms[i].getNumber() == roomNumber) {
                System.out.println("이미 이용중인 객실입니다.");
                return;
            }
        }

        rooms[size] = new Room(roomNumber);
        size++;
        System.out.println("체크인 성공");
    }

    public void checkOut(int roomNumber) {
        if (size == 0) {
            System.out.println("이용중인 투숙객이 없습니다.");
            return;
        }
        int index = 0;
        for (int i = 0; i < size; ++i) {
            if (rooms[i].getNumber() == roomNumber) {
                break;
            }
            index++;
        }
        if (index == size) {
            System.out.println("해당 번호의 객실은 이용중이 아닙니다.");
            return;
        }
        for (int i = index; i < size - 1; ++i) {
            rooms[i] = rooms[i + 1];
        }
        rooms[size - 1] = null;
        size--;
        System.out.println("체크아웃 성공");
    }

    public int getSize() {
        return size;
    }

    public void printRooms() {
        for (int i=0; i<size; ++i) {
            System.out.println(rooms[i].getNumber() + "번 객실");
        }
    }

    public void changeRoomNumber(int index, int number) {
        if (index < 0 || index >= size) {
            System.out.println("인덱스 에러");
            return;
        }
        rooms[index].setNumber(number);
    }

    public MyLittleHotel shallowCopy() {
        MyLittleHotel tmp = new MyLittleHotel();
        tmp.size = this.size;
        for (int i=0; i<size; ++i) {
            tmp.rooms[i] = this.rooms[i];
        }
        return tmp;
    }

    public MyLittleHotel deepCopy() {
        MyLittleHotel tmp = new MyLittleHotel();
        for (int i=0; i<size; ++i) {
            tmp.checkIn(rooms[i].getNumber());
        }
        return tmp;
    }

    public static void main(String[] args) {
        MyLittleHotel origin = new MyLittleHotel();
        origin.checkIn(101);
        origin.checkIn(102);
        origin.checkIn(103);

        MyLittleHotel shallow = origin.shallowCopy();
        MyLittleHotel deep = origin.deepCopy();

        origin.changeRoomNumber(0,404);

        System.out.println("==== origin ====");
        origin.printRooms();
        System.out.println("==== shallow ====");
        shallow.printRooms();
        System.out.println("==== deep ====");
        deep.printRooms();
        System.out.println("========");

    }
}
