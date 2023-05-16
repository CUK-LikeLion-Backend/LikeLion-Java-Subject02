package main.java.ex00;

import java.util.Scanner;

public class MyLittleHotel {
//객실 객체를 만들어서 객실 클래스를 구현해서
    private static class Hotel{
        private int[] guest={0,0,0,0,0,0,0,0};

        private Hotel(){
            this.guest=guest;
        }
    }
    public static void Check_in(int roomNum,Hotel hotel){
            if(hotel.guest[roomNum]==0){
                System.out.printf("%d 방에 체크인 되었습니다.\n",roomNum);
                hotel.guest[roomNum]=1;
            } else if (hotel.guest[roomNum]==1) {
                System.out.printf("이미 체크인 되어있는 방입니다.\n");
            }

    }
    public static void Check_out(int roomNum,Hotel hotel){
            if(hotel.guest[roomNum]==1){
                System.out.printf("%d 방이 체크아웃되었습니다.\n",roomNum);
                hotel.guest[roomNum]=0;
            } else if (hotel.guest[roomNum]==0) {
                System.out.printf("이미 체크아웃 되어있는 방입니다.\n");
            }
        }


    public static void main(String[] args) {
        Hotel hotel=new Hotel();
        Scanner sc=new Scanner(System.in);
        //for문은 확인을 위해 2번 반복하려고 넣어둠.
        for(int i=0;i<2;i++){
            System.out.printf("체크인은 true, 체크아웃은 false를 입력하세요 \n");
            boolean room=sc.nextBoolean();
            System.out.printf("체크인/체크아웃 할 방 호수를 입력하세요(0-7) \n");
            int roomNum=sc.nextInt();
            if(room==true){
                Check_in(roomNum,hotel);
            }else if(room==false){
                Check_out(roomNum,hotel);
            }

        }
    }
}
