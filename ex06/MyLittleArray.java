package ex06;

public class MyLittleArray <E> {
    private Object[] array;
    private int size;

    public MyLittleArray() {
        array = new Object[30];
        size = 0;
    }

    public E get(int index) {  // 다양한 타입의 요소를 저장하고 반환하기 위한 일반화 구조 제공
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E)array[index];   // array가 Object 타입이므로 E 타입으로 형변환
    }

    public void add(E element) {
        array[size] = element;
        size++;
    }

    public void add(int index, E element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = size; i > index; i--) {
            array[i] = array[i-1];   // 요소를 한 칸씩 뒤로 밀어줌
        }
        array[index] = element;
        size++;
    }

    public void set(int index, E element) {   // 지정 인덱스의 요소 변경
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }

    public void remove(int index) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = index; i < size-1; i++) {
            array[i] = array[i+1];   // 요소를 한 칸씩 앞으로 밀어줌
        }
        array[size-1] = null;
        size--;
    }

    public boolean contains(E object) {   // 객체가 배열에 포함되어 있는지 확인
        return (indexOf(object) != -1);
    }

    public int indexOf(E object) {
        for(int i = 0; i < size; i++) {
            if(array[i].equals(object)) return i;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        MyLittleArray <Integer> intArray = new MyLittleArray<>();   // 제너릭에서 매개 변수에는 참조형 타입밖에 올 수 없으므로 int 타입이 아닌 Integer 타입으로 배열 생성
        System.out.println("<  add()  >");
        intArray.add(17);
        intArray.add(29);
        intArray.add(6);
        intArray.add(34);
        intArray.add(3, 1);
        intArray.add(5, 50);
        intArray.add(6, 19);
        intArray.add(7, 64);
        intArray.print();
        System.out.println("\n==============================\n");
        System.out.println("<  remove()  >");
        intArray.remove(0);
        intArray.remove(5);
        intArray.print();
        System.out.println("\n==============================\n");

        System.out.println("<  set()  >");
        intArray.set(0, 80);
        intArray.set(5, 22);
        intArray.print();
        System.out.println("\n==============================\n");

        int element = intArray.get(2);
        System.out.println("2번 인덱스에 해당하는 요소 값 : " + element);

        boolean contain1 = intArray.contains(22);
        System.out.println("배열 내에 22의 값을 갖는 요소가 존재합니까? " + contain1);
        boolean contain2 = intArray.contains(77);
        System.out.println("배열 내에 77의 값을 갖는 요소가 존재합니까? " + contain2);

        int index = intArray.indexOf(22);
        System.out.println("요소 22의 인덱스 : " + index);

        int size = intArray.size();
        System.out.println("배열의 크기 : " + size);
        }
    }
