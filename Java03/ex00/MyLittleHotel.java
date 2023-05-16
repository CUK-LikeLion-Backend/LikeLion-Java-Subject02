package ex00;

public class MyLittleHotel {
    private int numberOfRooms;
    private boolean[] isRoomEmpty;

    // 호텔 내 객실의 개수를 8개로 설정하고 모두 비어있도록 설정
    public MyLittleHotel() {
        numberOfRooms = 8;
        isRoomEmpty = new boolean[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            isRoomEmpty[i] = true;
        }
    }

    // 객실의 개수를 반환하는 메소드
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    // 객실이 비어 있는 지 여부를 반환하는 메소드
    public boolean[] getIsRoomEmpty() {
        return isRoomEmpty;
    }

    public void checkIn(int roomNumber) {
        // 체크인하려는 객실 번호가 0보다 작거나 8 이상일 경우 다시 지정하도록 함
        if (roomNumber < 0 || roomNumber >= numberOfRooms) {
            System.out.println("객실 번호를 다시 지정해주세요.");
        }
        // 이미 체크인되어있는 객실에 체크인을 시도하는 경우 알림 문구
        if (!isRoomEmpty[roomNumber]) {
            System.out.println("해당 객실이 이미 체크인되었습니다.");
        }
        // 객실 체크인 문구
        isRoomEmpty[roomNumber] = false;
        System.out.println("객실에 체크인되었습니다.");
    }

    public void checkOut(int roomNumber) {
        // 체크아웃하려는 객실 번호가 0보다 작거나 8 이상일 경우 다시 지정하도록 함
        if (roomNumber < 0 || roomNumber >= numberOfRooms) {
            System.out.println("객실 번호를 다시 지정해주세요.");
        }
        // 비어있는 객실에 체크아웃을 시도하는 경우 알림 문구
        if (isRoomEmpty[roomNumber]) {
            System.out.println("해당 객실이 비어 있어 체크아웃할 수 없습니다.");
        }
        // 객실 체크아웃 문구
        isRoomEmpty[roomNumber] = true;
        System.out.println("객실이 체크아웃되었습니다.");
    }

    public void isFull() {
        // 아직 비어 있는 객실이 있는 경우 알림 문구
        for (int i = 0; i < numberOfRooms; i++) {
            if (isRoomEmpty[i]) {
                System.out.println("아직 남은 객실이 있습니다.");
            }
        }
        // 객실이 가득 찼을 때 알림 문구
        System.out.println("객실이 가득 차서 더 이상 체크인을 할 수 없습니다.");
    }
    public static void main(String[] args) {
        MyLittleHotel hotel = new MyLittleHotel();

        int numberOfRooms = hotel.getNumberOfRooms();
        boolean[] isRoomEmpty = hotel.getIsRoomEmpty();

        hotel.checkIn(0);

        hotel.checkIn(0);

        hotel.checkOut(0);

        hotel.checkOut(0);

        for (int i = 0; i < numberOfRooms; i++) {
            hotel.checkIn(i);
        }
        hotel.isFull();
    }
}