package ex00;

import java.util.Random;
import java.util.Scanner;

class Hotel {
    private boolean[] rooms; // 객실을 저장하기 위한 Room 배열
    private int occupiedRooms; // 현재 입주한 객실 수

    //기본생성자로 배열 초기화
    public Hotel(int roomCount) {
        rooms = new boolean[roomCount];
        for (int i = 0; i < roomCount; i++) {
            rooms[i] = false; // 초기 객실 비어있음
        }
        occupiedRooms = 0; // 초기 입주한 객실 수는 0으로 설정
    }
    public boolean reserveRoom() {

        Random random=new Random();
        int roomNumber = random.nextInt(8); // 0 ~ (MAX_ROOMS - 1) 범위의 랜덤 숫자 생성
        while (!rooms[roomNumber]) {
            // 해당 객실이 비어있는 경우에만 예약 가능
            rooms[roomNumber] = true;
            System.out.println((roomNumber + 1) + "번 객실 예약 성공");

            return true;
        }
        return true;
    }

    public boolean checkOut(int roomNumber) {
        if (roomNumber < 1 || roomNumber > 8) {
            System.out.println("잘못된 객실 번호입니다.");
            return false;
        } else if (!rooms[roomNumber - 1]) { // 해당 객실이 이미 비어있는 경우 체크아웃 불가능
            System.out.println(roomNumber + "번 객실은 이미 비어있습니다.");
            return false;
        } else {
            rooms[roomNumber - 1] = false;
            System.out.println(roomNumber + "번 객실 체크아웃 성공");
            return true;
        }
    }
}

    public class MyLittleHotel {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(8);
        Scanner scanner = new Scanner(System.in);

        System.out.print("숙박 인원 수를 입력하세요: ");
        int numOfGuests = scanner.nextInt();

        for (int i = 0; i <= numOfGuests; i++) {
            boolean success = hotel.reserveRoom();
            if (!success) {
                System.out.println("예약마감");
                break;
            }
        }

        System.out.print("체크아웃할 객실 번호를 입력하세요: ");
        int roomNumber = scanner.nextInt();
        boolean success = hotel.checkOut(roomNumber);
        if (!success) {
            System.out.println("체크아웃에 실패하였습니다.");
        }
    }
}
