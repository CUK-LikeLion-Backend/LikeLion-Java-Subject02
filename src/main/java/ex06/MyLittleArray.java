package ex06;

public class MyLittleArray<T> {
    Object[] arr = null;
    int capacity = 0;
    int size = 0;

    public MyLittleArray(int capacity){
        this.capacity = capacity;
        arr = new Object[capacity];
        size = 0;
    }
    public MyLittleArray(){
        capacity = 1;
        arr = new Object[capacity];
        size = 0;
    }

    private void expandArray(){
        capacity *= 2;
        Object[] tempArr = new Object[capacity];
        copyArr(tempArr, arr);
        arr = new Object[capacity];
        copyArr(arr, tempArr);
    }

    private void copyArr(Object[] dest, Object[] src){
        for(int i = 0; i < src.length; i++){
            dest[i] = src[i];
        }
    }

    public void add(T element){
        if(size == capacity){
            expandArray();
        }

        arr[size++] = element;
    }

    public void add(int index, T element){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == capacity){
            expandArray();
        }

        for(int i = size; i >= index; i--)
            arr[i] = arr[i-1];

        arr[index] = element;
        size++;
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (T) arr[index];
    }

    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
        return (T) arr[index];
    }

    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T result = (T) arr[index];
        arr[index] = null;
        size--;
        if(size > 0) {
            for(int i = index; i < size; i++) {
                arr[i] = arr[i+1];
            }
        }
        return result;
    }

    public boolean contains(Object o) {
        for (int i=0; i<size; ++i) {
            if (arr[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        for (int i=0; i<size; ++i) {
            if (arr[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return this.size;
    }
    public int getCapacity() {
        return this.capacity;
    }

    public static void main(String[] args) {
        MyLittleArray<Integer> arr = new MyLittleArray<Integer>();
        System.out.println("배열 크기 : " + arr.getCapacity());
        System.out.println("데이터 삽입 1~5");
        for(int i = 0; i < 5; i++) {
            arr.add((i+1));
        }

        //출력
        System.out.println("\n==출력1==");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i + "번째 : " + arr.get(i) + " | ");
        }
        System.out.println("\n배열 크기 : " + arr.getCapacity());



        System.out.println("\n==출력2==");
        System.out.println("1번째 6을 삽입");
        System.out.println("4번째 7을 삽입");
        arr.add(1, 6);
        arr.add(4, 7);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i + "번째 : " + arr.get(i) + " | ");
        }
        System.out.println("\n배열 크기 : " + arr.getCapacity());



        System.out.println("\n==출력3==");
        System.out.println("1번째 요소 삭제 : " + arr.remove(1));
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i + "번째 : " + arr.get(i) + " | ");
        }
        System.out.println("\n배열 크기 : " + arr.getCapacity());



        System.out.println("\n==출력4==");
        System.out.println("전부 삭제");
        while(arr.size() > 0) {
            System.out.println("0번째 삭제: " + arr.remove(0));
        }
        System.out.println("\n배열 크기 : " + arr.getCapacity());



        //출력
        System.out.println("\n==출력6==");
        System.out.println("데이터 삽입 5개");
        for(int i = 0; i < 5; i++) {
            arr.add((i*2));
        }
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i + "번째 : " + arr.get(i) + " | ");
        }
        System.out.println("\n배열 크기 : " + arr.getCapacity());


        System.out.println("\n==출력7==");
        System.out.println("0번째 요소 수정: " + arr.set(0, 100));
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i + "번째 : " + arr.get(i) + " | ");
        }
        System.out.println("\n배열 크기 : " + arr.getCapacity());



        System.out.println("\n==출력8==");
        System.out.println("100을 포함하는가? " + arr.contains(100));
        System.out.println("0을 포함하는가? " + arr.contains(0));
        System.out.println("\n배열 크기 : " + arr.getCapacity());



        System.out.println("\n==출력9==");
        System.out.println("100의 위치는? " + arr.indexOf(100));
        System.out.println("0의 위치는? " + arr.indexOf(0));
        System.out.println("\n배열 크기 : " + arr.getCapacity());

    }
}