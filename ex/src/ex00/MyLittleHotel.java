package ex00;

public class MyLittleHotel {
    private static class Room {
        private int roomNumber; // 방 번호
        private boolean isOccupied; // 사용중

        public Room(int roomNumber, boolean isOccupied) {
            this.roomNumber = roomNumber;
            this.isOccupied = isOccupied;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public boolean isOccupied() {
            return isOccupied;
        }

        public void setOccupied(boolean occupied) {
            isOccupied = occupied;
        }
    }

    private Room[] rooms;
    private int numberOfRooms; // 호텔의 전체 객실 수
    private int numberOfGuests; // 현재 호텔에 머물고 있는 손님 수

    public MyLittleHotel() {
        rooms = new Room[8];
        numberOfRooms = 8;
        numberOfGuests = 0;

        // 각 방의 번호와 상태를 초기화, 방 번호를 부여함
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new Room(i + 1, false);
        }
    }

    public Room[] getRooms() {
        return rooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setRooms(Room[] rooms) {
        this.rooms = rooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    // 체크인 메소드
    public void checkIn() {
        // 호텔이 가득 찼을 경우
        if (numberOfGuests == numberOfRooms) {
            System.out.println("더 이상 체크인할 수 없습니다.");
            return;
        }

        // 첫 번째 빈 방에 손님을 배정
        for (int i = 0; i < numberOfRooms; i++) {
            if (!rooms[i].isOccupied()) {
                rooms[i].setOccupied(true);
                numberOfGuests++;
                System.out.println("객실 " + rooms[i].getRoomNumber() + "에 체크인하셨습니다.");
                return;
            }
        }
    }

    // 체크아웃 메소드
    public void checkOut(int roomNumber) {
        // 객실 번호가 올바르지 않을 경우
        if (roomNumber < 1 || roomNumber > numberOfRooms) {
            System.out.println("올바르지 않은 객실 번호입니다.");
            return;
        }

        // 체크인한 손님이 없는 경우
        if (!rooms[roomNumber - 1].isOccupied()) {
            System.out.println("이미 빈 방입니다.");
            return;
        }

        // 객실을 체크아웃 처리
        rooms[roomNumber - 1].setOccupied(false);
        numberOfGuests--;
        System.out.println("객실 " + roomNumber + "에서 체크아웃하셨습니다.");
    }

        public static void main(String[] args) {
            MyLittleHotel hotel = new MyLittleHotel();

            // 초기 상태 출력
            System.out.println("=== 초기 상태 ===");
            printStatus(hotel);

            // 체크인 3회
            hotel.checkIn();
            hotel.checkIn();
            hotel.checkIn();
            hotel.checkOut(2);
            System.out.println("=== 체크아웃 후 상태 ===");
            printStatus(hotel);

            // 체크인 3회
            hotel.checkIn();
            hotel.checkIn();
            hotel.checkIn();
            System.out.println("=== 체크인 후 상태 ===");
            printStatus(hotel);
        }
        private static void printStatus(MyLittleHotel hotel) {
            System.out.println("전체 객실 수: " + hotel.getNumberOfRooms());
            System.out.println("빈 객실 수: " + (hotel.getNumberOfRooms() - hotel.getNumberOfGuests()));
            System.out.println("손님 수: " + hotel.getNumberOfGuests());

            System.out.println("각 객실의 상태: ");
            for (MyLittleHotel.Room room : hotel.getRooms()) {
                System.out.println("객실 " + room.getRoomNumber() + ": " + (room.isOccupied() ? "손님이 있습니다" : "빈 방입니다"));
            }

            System.out.println();
        }
    }



