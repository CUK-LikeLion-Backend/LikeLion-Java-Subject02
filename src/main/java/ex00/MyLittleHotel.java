package ex00;

public class MyLittleHotel {
    private Room[] rooms = new Room[8];
    private int customer;

    MyLittleHotel(){
        for(int i=0; i<8; i++){
            rooms[i] = new Room();
        }
    }

    public void checkOut(int roomNum){
        if(!rooms[roomNum-1].isChecked()){
            System.out.println("체크인 된 방이 아닙니다.");
            return;
        }
        else{
            rooms[roomNum-1].checked = false;
            System.out.println("체크아웃 완료");
            customer--;
        }
    }

    public void checkIn(int roomNum){
        if(customer == 8){
            System.out.println("이미 꽉참");
            return;
        }
        if(rooms[roomNum-1].isChecked()){
            System.out.println("이미 체크인 된 방");
        }
        else{
            rooms[roomNum-1].checked=true;
            customer++;
            System.out.println("체크인 완료");
        }
    }

    public void printRooms(){
        int i;
        String checked;
        for(i=0; i<rooms.length ; i++){
            checked = (rooms[i].isChecked())?"체크인 된 방입니다":"빈 방입니다";
            System.out.print((i+1) + "번 방은 ");
            System.out.println(checked);
        }
    }

    class Room {
        boolean checked;
        boolean isChecked(){
            if (this.checked){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyLittleHotel hotel = new MyLittleHotel();

        hotel.checkIn(1);
        hotel.checkIn(4);
        hotel.printRooms();
        hotel.checkOut(3);
        hotel.checkOut(4);
        hotel.printRooms();

    }
}
