package ex06;

import java.util.Arrays;

public class MyLittleArray<T> {
    private Object[] elements; // 배열로 표현하기 위해서
    private int size;
    public MyLittleArray(){
        elements = new Object[2]; // 객체 생성 초반에 배열크기 2로 만듦
        size = 0;
    }

    // T는 제네릭 타입 매개변수
    public T get(int index){
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException(); // 예외처리
        }
        return (T)elements[index];
    }

    public void add(T element){
        // element를 추가하면 배열의 크기를 늘려줘야한다.
        if (size == elements.length) { // 1.배열이 가득 찼을경우 사이즈 늘려주기
            sizeUp();
        }
        elements[size] = element; // 2.배열이 가득 차지 않았을 경우
        size++;
    }
    public void add(int index,T element){
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException(); // 예외처리
        }
        if (size == elements.length) { // 1.배열이 가득 찼을경우 사이즈 늘려주기
            sizeUp();
        }
        elements[index] = element;
        size++;
    }
    // set : 배열의 값을 새로운 값으로 대체하는 메소드
    public void set(int index,T element){
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException(); // 예외처리
        }
        elements[index] = element;
    }
    public void remove(int index){
        if(index<0 || index > size){
            throw new IndexOutOfBoundsException(); // 예외처리
        }
        // 제거를 하였기에 배열 한칸씩 앞으로 이동
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--; // remove함으로써 배열 사이즈 감소
    }
    // 포함하고있냐 return을 true or false -> boolean
    public boolean contains(T object) {
        return indexOf(object) != -1; // 이거일경우 존재 하지 않는것
    }
    public int indexOf(T object) {
        if (object != null){
            for (int i = 0; i < size; i++) {
                if (object.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1; // 일치하는 것이 없을때
    }
    public int size() {
        return size;
    }

    public void sizeUp(){ // 배열의 크기를 하나씩 증가
        elements = Arrays.copyOf(elements, size + 1);
    }

    public static void main(String[] args) {
        MyLittleArray<String> myArray = new MyLittleArray<>();
        myArray.add("파일처리");
        myArray.add("데이터통신");
        myArray.add("인공지능");
        myArray.add("선형대수학");
        myArray.add("컴프1");
        myArray.set(0,"인공지능프로그래밍설계");
        myArray.remove(3);

        System.out.println(myArray.contains("컴프1"));
        System.out.println("인덱스: " + myArray.indexOf("인공지능프로그래밍설계"));

        System.out.println("myArray 출력");
        for (int i = 0; i < myArray.size(); i++) {
            System.out.println(myArray.get(i));
        }

    }


}

