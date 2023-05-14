package ex00;
import java.util.Random;

class Room{
    private boolean arr[];
    public Room(int size){
        this.arr = new boolean[size];
    }

    public boolean[] getArr() {
        return  this.arr;
    }
}


public class MyLittleHotel {

    public static void main(String[] args) {
        CheckIn();
        CheckOut();


    }



    public static void CheckIn(){
        Random random = new Random();
        //1인 1실
        //방 배정 : i 랜덤으로 선택하여 0,1 값 고르기

        Room room = new Room(8);
        int randomNumber = random.nextInt(8);
        boolean arr[] = room.getArr();

        //곽 찼을경우 체크인 불가능
        if(isFull(arr) ==true){
            System.out.println("체크인이 불가능합니다.");
        }
        //배열의 랜덤 넘버에 해당하는 인덱스의 값이 존재하지 않을경우
        if(arr[randomNumber] == false){
            arr[randomNumber] = true;
        }
        //배열의 랜덤 넘버에 해당하는 인덱스의 값이 존재할 경우
        else{
            //체크인 다른거 진행
            CheckIn();
        }
        System.out.println(arr);
    }

    public static void CheckOut(){
        Random random = new Random();
        //1인 1실
        //방 배정 : i 랜덤으로 선택하여 0,1 값 고르기

        Room room = new Room(8);
        int randomNumber = random.nextInt(8);
        boolean arr[] = room.getArr();
        int i =0;
        for(boolean num:arr){

            //배열의 랜덤 넘버에 해당하는 인덱스의 값이 존재할경우
            if(arr[randomNumber] == true){
                arr[randomNumber] = false;
            }
            //배열의 랜덤 넘버에 해당하는 인덱스의 값이 존재하지 않을경우
            else if(arr[randomNumber] == false){
                //체크아웃 진행
                if( i == arr.length){
                    break;
                }
                continue;
            }
            i+=1;
        }
        System.out.println(arr);


    }
    public static boolean isFull(boolean arr[]){

        int sum =0;
        for(boolean num :arr){
            if(num = true){
                sum+=1;
                if(sum ==arr.length){
                    return true;
                }
            }
            else{
                continue;
            }
            return false;
        }
        return false;
    }


    //만약 room[i] = 1 이면 체크인 불가, 체크아웃 가능

    //만약 room[i] = 0 이면 체크인 가능, 체크아웃 불가




}
