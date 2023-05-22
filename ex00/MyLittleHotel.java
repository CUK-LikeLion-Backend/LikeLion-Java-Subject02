package ex00;

public class MyLittleHotel {
    private int size;   // 객체에 저장된 요소의 수
    private Guest[] data;   // Guest 객체를 저장하는 배열

    MyLittleHotel(int size) {
        this.size = size;
        this.data = new Guest[size];
    }

    public int getEmptyRoomNumber() {
        for(int i = 0; i < this.data.length; i++) {   // 객체의 크기를 나타내는 배열의 길이
            if(this.data[i] == null) return i;
        }
        return -1;
    }

    public int findRoomNumber(int roomNumber) {
        for(int i = 0; i < this.data.length; i++) {
            Guest guest = this.data[i];
            if(guest != null && guest.roomNumber == roomNumber) return i;
        }
        return -1;
    }

    public boolean checkIn(Guest guest) {
        int emptyRoomNumber = getEmptyRoomNumber();
        if(emptyRoomNumber == -1) {
            System.out.println("빈 객실이 없어 예약이 불가능합니다.");
            return false;
        }
        this.data[emptyRoomNumber] = guest;
        return true;
    }

    public boolean checkOut(int roomNumber) {
        int findResult = findRoomNumber(roomNumber);
        if(findResult == -1) {
            System.out.println("정보와 일치하는 객실이 없습니다.");
            return false;
        }
        this.data[findResult] = null;
        return true;
    }

    public void printGuest() {
        for(Guest guest : this.data) {
            if(guest != null) System.out.println(guest);
        }
    }

    public static class Guest {   // 손님 정보를 저장하는 배열
        private String name;
        private int roomNumber;

        public Guest(String name, int roomNumber) {
            this.name = name;
            this.roomNumber = roomNumber;
        }
        public String getName() {
            return name;
        }
        public int getRoomNumber() {
            return roomNumber;
        }
        public String toString() {
            return "Guest [ Name : " + name + ", RoomNumber : " + roomNumber + " ]";
        }
    }

    public static void main(String[] args) {
        MyLittleHotel hotel = new MyLittleHotel(8);

        hotel.checkIn(new Guest("Lion", 0));
        hotel.checkIn(new Guest("Dog", 1));
        hotel.checkIn(new Guest("Cat", 2));
        hotel.checkIn(new Guest("Capybara", 3));
        hotel.checkIn(new Guest("Rabbit", 4));
        hotel.checkIn(new Guest("Monkey", 5));
        hotel.checkIn(new Guest("Chinchilla", 6));
        hotel.checkIn(new Guest("Giraffe", 7));
        hotel.printGuest();
        hotel.checkIn(new Guest("Tiger", 7));

        System.out.println("\n==============================\n");
        hotel.checkOut(0);
        hotel.checkOut(1);
        hotel.checkOut(2);
        hotel.checkOut(3);
        hotel.printGuest();
        hotel.checkOut(10);
    }
}
