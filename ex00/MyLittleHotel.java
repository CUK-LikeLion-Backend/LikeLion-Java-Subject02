package ex00;

import java.util.Scanner;

public class MyLittleHotel {
    Scanner scan=new Scanner(System.in);
    boolean[] room = new boolean[8];


    private void Checkin() {
        int num=0;
        boolean state = false;
        for (int i = 0; i < 8; i++) {
            if (!room[i]) {
                state = true;
                num=i;
                break;
            }
        }
        if (state == false) {System.out.println("체크인을 할 수 없습니다");}
        else{System.out.println(num+"호실에 체크인을 할 수 없습니다");}
    }

    private void Checkout(int room_num) {
        if(!room[room_num]) {System.out.println(room_num+"호실 체크아웃 실패");}
        else{System.out.println(room_num+"호실 체크아웃 성공");}
    }


    public static void main(String[] args) {
        MyLittleHotel hotel=new MyLittleHotel();

        //방이 모두 가득 찬 상태에서 체크인이 가능한가 테스트
        boolean[] state1={true,true,true,true,true,true,true,true};
        hotel.room=state1;
        hotel.Checkin();

        //7호실이 빈 상태에서 체크인이 가능한가 테스트
        boolean[] state2={true,true,true,true,true,true,true,false};
        hotel.room=state2;
        hotel.Checkin();

        //7호실이 체크아웃 가능여부
        hotel.Checkout(7);

        //3호실이 체크아웃 가능여부
        hotel.Checkout(3);

    }
}
