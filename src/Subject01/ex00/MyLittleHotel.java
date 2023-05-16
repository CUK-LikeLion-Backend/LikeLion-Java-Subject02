package Subject01.ex00;

import java.util.Scanner;

public class MyLittleHotel {
    private static boolean[] Hotel = new boolean[8];
    private static boolean[] checkIn(int chkNum){
        if(Hotel[chkNum - 1] == true){
            System.out.println("이미 배정된 객실입니다.");
        }
        MyLittleHotel.Hotel[chkNum - 1] = true;
        return Hotel;
    }

    private static boolean[] checkout(int chkNum){
        if(Hotel[chkNum - 1] == false){
            System.out.println("배정되지 않은 객실입니다.");
        }
        Hotel[chkNum - 1] = false;
        return Hotel;
    }

    private static boolean checkFull(){
        int i;
        for(i = 0; i < 8; i++){
            if(Hotel[i] == false){
                break;
            }
        }
        if(i == 8){
            return true;
        }
        return false;
    }

    private static boolean correctNum(int num){
        if(num <= 0 || num > 8){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyLittleHotel H = new MyLittleHotel();

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++) {
            if(H.checkFull()){
                System.out.println("호텔이 꽉 찼습니다.");
                break;
            }
            System.out.println("체크인 할 객실 번호를 입력하세요.(1 ~ 8)");
            int num = sc.nextInt();
            if(correctNum(num)) {
                H.checkIn(num);
            } else{
                System.out.println("잘못된 객실 번호입니다.");
            }
        }

        for(int i = 0; i < 10; i++) {
            System.out.println("체크아웃 할 객실 번호를 입력하세요.(1 ~ 8)");
            int num = sc.nextInt();
            if(correctNum(num)) {
                H.checkout(num);
            } else{
                System.out.println("잘못된 객실 번호입니다.");
            }
        }

        System.out.print("최종 체크인 된 객실은 ");
        for(int i = 0; i < 8; i++){
            if(H.Hotel[i] == true){
                System.out.printf("%d ",i);
            }
        }
        System.out.println("입니다.");
    }
}
