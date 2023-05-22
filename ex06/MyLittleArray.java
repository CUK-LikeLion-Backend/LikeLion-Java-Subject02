package ex06;

public class MyLittleArray {
    private Object[] arr;
    private int size;

    public MyLittleArray(){
        this.arr = new Object[10];
        this.size = 0;
    }

    //값을 받아오는 메소드
    //예외처리 : 인덱스가 0보다 작거나, 배열의 사이즈보다 클때
    public Object get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    //끝에 요소 추가하기
    public void add(Object element){
        arr[size] = element;
        size ++; //사이즈 꼭 나중에 증가시켜야함!!
    }

    //원하는 인덱스에 요소 추가하기
    //예외처리 : 인덱스가 0보다 작거나, 배열의 사이즈보다 클때
    public void add(int index, Object element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        //배열 복사하는 함수 (원본배열, 원본배열시작인덱스, 복사한요소를 저장할 배열, 복사한요소를 저장할 인덱스, 복사할 요소의 개수)
        System.arraycopy(arr, index, arr, index+1, size - index);
        arr[index] = element;
        size++;
    }

    //원하는 인덱스에 새로운값 저장하기
    //똑같이 예외처리
    public void set(int index, Object element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
    }

    //원하는인덱스 삭제
    //똑같이 예외처리
    public void remove(int index){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        //1 2 3 4 5 //3지우면
        //1 2 4 5    //두개복사해야하니까 => 5 - 2 - 1 = size - index - 1
        System.arraycopy(arr, index+1, arr, index, size - index - 1);
        arr[--size] = null;
    }

    //배열안에 존재하는지 안하는지 확인
    public boolean contains(Object object){
        for (int i = 0; i < size; i++){
            if (arr[i] == object)
                return true;
        }
        return false;
    }

    //배열안에 몇번째 인덱스인지 반환
    public int indexOf(Object object){
        for (int i = 0; i<size; i++){
            if (arr[i] == object)
                return i;
        }
        return -1;
    }

    public int size(){
        return size;
    }

    public static void main(String[] args) {
        MyLittleArray myLittleArray = new MyLittleArray();

        //add
        myLittleArray.add(10); //10
        myLittleArray.add(20); //10 20
        myLittleArray.add(30); //10 20 30
        myLittleArray.add(0, 0); //0 10 20 30

        System.out.println(myLittleArray.get(0)); //0
        System.out.println(myLittleArray.get(1)); //10

        //set
        myLittleArray.set(3, 3); //0 10 20 3
        System.out.println(myLittleArray.get(3)); //3

        //remove
        myLittleArray.remove(2); //0 10 3
        System.out.println(myLittleArray.get(2)); //3

        //contains
        System.out.println(myLittleArray.contains(10)); //true
        System.out.println(myLittleArray.contains(100)); //false

        //indexOf
        System.out.println(myLittleArray.indexOf(0)); //0
    }
}