package ex00;
import java.util.Random;
import java.util.Scanner;
class RoomManager {
    final int ROOMS = 8; // 방 갯수 상수
    private int[] roomlist = new int[ROOMS];

    public RoomManager(){} //기본 생성자

    void FistSet() { // 초기 방 크기 만큼의 공실을 세팅하는 메소드
        for (int i = 0; i < roomlist.length; i++) {
            roomlist[i] = 0;
        }
    }

    boolean fullCheck() { // 만실을 체크하는 메소드
        int count = 0;
        for (int i = 0; i < roomlist.length; i++) {
            if (roomlist[i] == 1)
                count++;
        }
        if (count == 8)
            return true;
        else
            return false;
    }

    void AllRoomCheck() { // 모든 방 상태 체크, 출력 메소드
        int count = 0;
        for (int i = 0; i < roomlist.length; i++) {
            if (roomlist[i] != 0) {
                count++;
            }
        }
        System.out.println("\n 공실 갯수 : " + (ROOMS - count));
        System.out.print("Room : ");
        for (int i = 0; i < roomlist.length; i++) {
            System.out.print(roomlist[i] + " ");
        }
        System.out.print("\n\n");
    }

    void Checkin() {
        if (fullCheck() == true) {
            System.out.println("객실이 가득 찼습니다.");
            return; // 만실일 경우 체크인 메소드 종료
        }

        Random random = new Random();
        while (true) {
            int roomNum = (random.nextInt(8));
            if (roomlist[roomNum] == 0) {
                System.out.println((roomNum + 1) + "번 방 체크인 되었습니다.");
                roomlist[roomNum] = 1;
                break;
            } else continue; // 비어있는 방을 고를 때 까지 랜덤 무한 반복
        }
    }


    void CheckOut() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("checkOut할 방 번호를 알려주세요 : ");
        int roomNum = scanner.nextInt();
        if(roomNum>ROOMS||roomNum<1) {
            System.out.println(roomNum + "잘못된 입력입니다.");
            return;
        }
        if (roomlist[roomNum - 1] != 0) {
            System.out.println(roomNum + "번 방 체크아웃 되었습니다.");
            roomlist[roomNum - 1] = 0;
        } else {
            System.out.println("방이 이미 비어있습니다.");
        }
    }

    void Menu() {
        int exit = 0;
        while (exit == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("\n---이용할 메뉴를 선택해주세요---\n1. 체크인\n2. 체크아웃\n3. 공실확인\n4. 종료\n");
            int userChoice = scanner.nextInt();
            if (userChoice < 1 || userChoice > 4) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                Menu();
            } else {
                switch (userChoice) {
                    case 1:
                        Checkin();
                        break;
                    case 2:
                        CheckOut();
                        break;
                    case 3:
                        AllRoomCheck();
                        break;
                    case 4:
                        System.out.println("호텔 프로그램 종료합니다.");
                        exit =1;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요");
                }

            }
        }
    }
}

    public class MyLittleHotel {
        public static void main(String[] args) {
            RoomManager room = new RoomManager();
            room.FistSet();
            room.Menu();
        }

    }
