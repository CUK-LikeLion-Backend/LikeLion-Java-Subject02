package ex00;

public class MyLittleHotel {

    private boolean[] rooms;

    public MyLittleHotel(int num) {

        rooms = new boolean[num];
    }

    public int checkIn(){
        for(int i = 0; i < rooms.length; i++){  //Mylittlehotel객체 생성시 줬던 num값 = length
            if(rooms[i] == false){  //빈방이었으면
                rooms[i] = true;    //체크인시 true 저장
                return i + 1;   //방 번호
            }
        }
        return -1;  //(빈방이 없을때 )더이상 체크인 불가
    }

    public boolean checkOut(int roomNo){
        if(roomNo >= 1  && roomNo <= rooms.length && rooms[roomNo-1] == true){
            rooms[roomNo - 1] = false;  //객실 번호는 1부터, 배열 인덱스는 0부터이기에 -1해줌
            return true;    //체크아웃 하면 true 반환
        }
        return false;
    }

    public boolean isFull() {
        for (boolean room : rooms) {
            if (!room) {    //rooms배열의 요소가 false일떄
                return false;   //빈방이 있다는 것이므로 f -> 가득차지 않음
            }
        }
        return true;
    }


    public static class Manager{
        private MyLittleHotel hotel;

        public Manager(int num){ //Manager 생성시 MyLittleHotel 생성되도록

            hotel = new MyLittleHotel(num);
        }

        public int checkIn(){
            if(hotel.isFull()== false){ //호텔이 가득 차지 않았을 떄
                return hotel.checkIn();
            }
            return -1;  //호텔이 가득 찼을떄
        }

        public boolean checkOut(int roomNo){

            return hotel.checkOut(roomNo);
        }

    }

    public static void main(String[] args) {
        Manager manager = new Manager(8);

        for(int i = 1; i <= 10; i++){
            int roomNo = manager.checkIn();
            if(roomNo != -1){   //체크인을 하는 경우
                System.out.println("손님"+i+" "+roomNo+"번방 체크인");
            }
            else{   //빈 방이 었을때
                System.out.println("호텔이 가득 찼습니다. 손님"+i+"는 체크인 불가");
            }
        }

        System.out.println("");

        for(int i = 1; i <=8; i++){
            if(manager.checkOut(i) == true){
                System.out.println(i+"번방 체크아웃");
            }
            else{
                System.out.println(i+"번방 체크아웃 실패");
            }
        }
    }

}

