package ex00;

import java.util.ArrayList;

public class MyLittleHotel {

    boolean[] myhotel=new boolean[8];
    int num=0;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void print(){
        for(int i=0;i<8;i++){
            if(myhotel[i]==true){
                System.out.println("배정된 방입니다.");
            }else{
                System.out.println("빈 방입니다.");
            }
        }
    }

    public void checkin(){
        int tmp = 0;
        for(int i=0;i<8;i++){
            if(myhotel[i]==false){
                break;
            }
            tmp=i;
        }
        if(tmp==7){
            System.out.println("객실이 가득차 체크인 불가합니다.");
            return;
        }
        myhotel[getNum()]=true;
        setNum(getNum()+1);
    }

    public void checkout(int num){
        myhotel[num]=false;
    }

    public static void main(String[] args) {
        MyLittleHotel myLittleHotel=new MyLittleHotel();
        myLittleHotel.checkin();
        myLittleHotel.checkin();
        myLittleHotel.checkin();
        myLittleHotel.checkin();
        myLittleHotel.checkin();
        myLittleHotel.checkin();
        myLittleHotel.checkout(3);
        myLittleHotel.print();
    }
}
