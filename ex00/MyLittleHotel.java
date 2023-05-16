package ex00;

public class MyLittleHotel {

    private int numOfRooms; // 객실 수
    private int guestNum; // 투숙객 인원 수

    private Room[] rooms; // 배열을 통해 나타낸 객실

    public MyLittleHotel(int numOfRooms, int maxGuests) {
        this.numOfRooms = numOfRooms;
        this.guestNum = 0;
        this.rooms = new Room[numOfRooms];
        for (int i = 0; i < numOfRooms; i++) {
            this.rooms[i] = new Room(i + 1, true);
        }
    }

    public int getNumOfRooms() {
        return numOfRooms;
    }


    public int getGuestNum() {
        return guestNum;
    }

    public boolean checkIn() {
        if (guestNum < 8) {
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i].isUsable()) {
                    rooms[i].setUsable(false);
                    guestNum++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkOut(int roomNumber) {
        if (roomNumber >= 1 && roomNumber <= numOfRooms) {
            Room room = rooms[roomNumber - 1];
            if (!room.isUsable()) {
                room.setUsable(true);
                guestNum--;
                return true;
            }
        }
        return false;
    }

        public class Room {
            private int number; // 객실 번호
            private boolean usable; // 사용 가능 여부

            public Room(int number, boolean usable) {
                this.number = number;
                this.usable = usable;
            }

            public int getNumber() {
                return number;
            }

            public boolean isUsable() {
                return usable;
            }

            public void setUsable(boolean usable) {
                this.usable = usable;
            }

        }

        public static void main(String[] args) {
            MyLittleHotel hotel = new MyLittleHotel(10, 10);

            System.out.println("객실 수: " + hotel.getNumOfRooms());
            System.out.println("최대 수용 인원: " + 8);

            System.out.println("손님1: " + hotel.checkIn()); // true
            System.out.println("손님2: " + hotel.checkIn()); // true
            System.out.println("손님3: " + hotel.checkIn()); // true
            System.out.println("손님4: " + hotel.checkIn()); // true
            System.out.println("손님5: " + hotel.checkIn()); // true
            System.out.println("손님6: " + hotel.checkIn()); // true
            System.out.println("손님7: " + hotel.checkIn()); // true
            System.out.println("손님8: " + hotel.checkIn()); // true
            System.out.println("손님9: " + hotel.checkIn()); // false

            System.out.println("투숙객 수: " + hotel.getGuestNum()); // 8

            System.out.println("체크아웃: " + hotel.checkOut(3)); // true
            System.out.println("체크아웃: " + hotel.checkOut(7)); // true
            System.out.println("체크아웃: " + hotel.checkOut(3)); // false
            System.out.println("투숙객 수: " + hotel.getGuestNum()); // 6
        }
    }

