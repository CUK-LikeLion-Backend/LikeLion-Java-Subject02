package ex06;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// 제네릭 클래스
class ClassName<E> {

    private E[] list = (E[]) new Object[10];	// 제네릭 타입 변수
    private int index = 0;

    public E get(int index) throws Exception {	// 제네릭 타입 반환 메소드
        if(index > this.index){
            throw new Exception("해당 index에는 값이 없습니다.\n");
        }

        return (E) list[index];
    }

    public void add(E element) throws Exception {
        if(this.index > list.length){
            throw new Exception("배열이 꽉찼습니다.\n");
        }
        list[index] = element;
        this.index++;
    }

    public void add(int index, E element) throws Exception {
        if(this.index >= list.length){
            throw new Exception("배열이 꽉찼습니다.\n");
        }

        for(int i = this.index; i>index; i--){
            list[i] = list[i-1];
        }
        list[index] = element;
        this.index++;
    }

    public void set(int index, E element) throws Exception {
        if(index >= this.index){
            throw new Exception("해당 index에는 값이 없습니다.\n");
        }

        list[index] = element;
    }

    public void remove(int index) throws Exception{
        if(index > this.index){
            throw new Exception("해당 index에는 값이 없습니다.\n");
        }

        this.index--;
        for(int i = index; i<this.index-1; i++){
            list[i] = list[i+1];
        }
        list[this.index] = null;
    }

    public boolean contains(E object) throws Exception {
        for(int i = 0; i<this.index; i++){
            if(list[i] == object) return true;
        }
        throw new Exception("해당 object가 없습니다.\n");
    }

    public int indexOf(E object) throws Exception{
        for(int i = 0; i<this.index; i++){
            if(list[i] == object) return i;
        }

        // 못 찾았을 때 예외처리
        throw new Exception("해당 object가 없습니다.\n");
    }

    public int size(){
        return this.index;
    }

    public void printList(){
        for(int i = 0; i<this.index;i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

}

public class MyLittleArray {
    public static void main(String[] args) throws Exception {

        ClassName<String> a = new ClassName<String>();

        // add
        try {
            a.add("10");
            a.add("20");
            a.add("30");
            a.add("50");
            a.add("60");
            a.add("70");
            a.add("80");
            a.add("90");
            a.add("100");
            a.add("110");
            a.add("120");
        }
        catch (Exception e) {
            System.out.println("add 예외 발생: " + e.getMessage());
        }
        a.printList();

        try {
            a.remove(9);
        }
        catch (Exception e) {
            System.out.println("add 예외 발생: " + e.getMessage());
        }
        a.printList();
        System.out.println("size = " + a.size());

        // add index
        try {
            a.add(3, "4");
        }
        catch (Exception e) {
            System.out.println("add index 예외 발생: " + e.getMessage());
        }
        a.printList();


        // set
        try {
            a.set(10, "40");
        }
        catch (Exception e) {
            System.out.println("set index 예외 발생: " + e.getMessage());
        }
        a.printList();


        try {
            a.add(1,"15");
        }
        catch (Exception e) {
            System.out.println("add 예외 발생: " + e.getMessage());
        }

        System.out.println(a.contains("10"));


        a.printList();

        try {
            System.out.println("Method get : " + a.get(1));
        } catch (Exception e) {
            System.out.println("get 예외 발생: " + e.getMessage());
        }

        try {
            System.out.println("Method contains : " + a.contains("15"));
        } catch (Exception e) {
            System.out.println("contains 예외 발생: " + e.getMessage());
        }

        try {
            System.out.println("Method indexOf : " + a.indexOf("10"));
        } catch (Exception e) {
            System.out.println("indexOf 예외 발생: " + e.getMessage());
        }

        System.out.println(a.size());
        a.printList();

    }
}
