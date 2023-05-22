package ex00;

import java.util.Scanner;
import java.util.Random;

class Rooms {
    private String[] rooms = {"101", "102", "201", "202", "301", "302", "401", "402"};
    private String[] guests = new String[8];

    private boolean containsGuest(String guestName) {
        for (String guest : guests) {
            if (guest != null && guest.equals(guestName)) {
                return true;
            }
        }
        return false;
    }

    int checkIn(String guestName) {
        if (containsGuest(guestName)) {
            System.out.println(guestName + "님은 이미 다른 방에서 체크인 중입니다.");
            return -1;
        } else {
            Random rand = new Random();
            int roomIndex = rand.nextInt(8);
            while (guests[roomIndex] != null) {
                roomIndex = rand.nextInt(8);
            }
            guests[roomIndex] = guestName;
            System.out.println(guestName + "님, " + rooms[roomIndex] + "번 방에 체크인 되셨습니다.");
            return roomIndex;
        }
    }

    boolean checkOut(String guestName) {
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null && guests[i].equals(guestName)) {
                guests[i] = null;
                System.out.println(guestName + "님, 체크아웃 되셨습니다.");
                return true;
            }
        }
        System.out.println(guestName + "님은 체크인한 적이 없습니다.");
        return false;
    }

    String getRoom(String guestName) {
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null && guests[i].equals(guestName)) {
                return rooms[i];
            }
        }
        return null;
    }
}

public class MyLittleHotel {
    public static void main(String[] args) {
        Rooms rooms = new Rooms();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("이름을 입력하시오: ");
            String name = scanner.next();
            if (name.equals("그만")) {
                break;
            }
            String room = rooms.getRoom(name);
            if (room != null) {
                System.out.println(name + "가 체크인한 방은: " + room);
                System.out.println("체크아웃 하시겠습니까? (Y/N)");
                String input = scanner.next();
                if (input.equalsIgnoreCase("Y")) {
                    rooms.checkOut(name);
                }
            } else {
                rooms.checkIn(name);
            }
        }
    }
}
