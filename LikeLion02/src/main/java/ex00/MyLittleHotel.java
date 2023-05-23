package main.java.ex00;

import java.util.Scanner;
class CheckInOut{
    private  int[] guest={0,0,0,0,0,0,0,0};
    private int roomNum;
    public int[] getGuest() {
        return guest;
    }

    public void setGuest(int[] guest) {
        this.guest = guest;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void Check_in(int roomNum, int[] guest){
        if(guest[roomNum]==0){
            System.out.printf("%d 방에 체크인 되었습니다.\n",roomNum);
            guest[roomNum]=1;
        } else if (guest[roomNum]==1) {
            System.out.printf("이미 체크인 되어있는 방입니다.\n");
        }

    }
    public void Check_out(int roomNum,int[] guest){
        if(guest[roomNum]==1){
            System.out.printf("%d 방이 체크아웃되었습니다.\n",roomNum);
            guest[roomNum]=0;
        } else if (guest[roomNum]==0) {
            System.out.printf("이미 체크아웃 되어있는 방입니다.\n");
        }
    }
}


public class MyLittleHotel {
    //객실 객체를 만들어서 객실 클래스를 구현해서

    public static void main(String[] args) {
        CheckInOut check=new CheckInOut();
        Scanner sc=new Scanner(System.in);
        //for문은 확인을 위해 2번 반복하려고 넣어둠.
        for(int i=0;i<2;i++){
            System.out.printf("체크인은 true, 체크아웃은 false를 입력하세요 \n");
            boolean room=sc.nextBoolean();
            System.out.printf("체크인/체크아웃 할 방 호수를 입력하세요(0-7) \n");
            int roomNum=sc.nextInt();
            if(room==true){
                check.Check_in(roomNum,check.getGuest());
            }else if(room==false){
                check.Check_out(roomNum, check.getGuest());
            }

        }
    }
}
