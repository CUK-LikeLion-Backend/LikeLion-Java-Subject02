package ex06;

public class MyLittleArray<T> {
    Object[] arr = null;
    int length = 0;
    int size = 0;

    public MyLittleArray(int length){ // 생성자
        this.length = length;
        arr = new Object[length];
        size = 0;
    }
    public MyLittleArray(){ // 생성자
        length = 1;
        arr = new Object[length];
        size = 0;
    }

    private void expandArray(){ //Array 확장
        length *= 2;
        Object[] tempArr = new Object[length];
        copyArr(tempArr, arr);
        arr = new Object[length];
        copyArr(arr, tempArr);
    }

    private void copyArr(Object[] dest, Object[] src){
        for(int i = 0; i < src.length; i++){
            dest[i] = src[i];
        }
    }

    public void add(T element){
        if(size == length){
            expandArray();
        }

        arr[size++] = element;
    }

    public void add(int index, T element){ // index 값이 주어지면 index 위치에 저장, index 뒤의 값은 index+1씩 밀린다
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(size == length){
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
        if(size > 0) { // 인텍스 재정렬
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
    public int getlength() {
        return this.length;
    }

    public static void main(String[] args) {
        MyLittleArray<Integer> arr = new MyLittleArray<Integer>();
        for(int i = 0; i < 5; i++) {
            arr.add((i+1));
        }
        System.out.println("index / value");

        System.out.println("\n--get() 실행--");
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i+"/"+ arr.get(i) + "  ");
        }
        System.out.println("\nlength : " + arr.getlength());


        System.out.println("\n--add() 실행--");
        System.out.println("add : 2/4  3/6");
        arr.add(2, 4);
        arr.add(3, 6);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i+"/"+ arr.get(i) + "  ");
        }
        System.out.println("\nlength : " + arr.getlength());


        System.out.println("\n--set() 실행--");
        System.out.println("set 3/50");
        arr.set(3,50);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i+"/"+ arr.get(i) + "  ");
        }
        System.out.println("\nlength : " + arr.getlength());


        System.out.println("\n--remove() 실행--");
        System.out.println("remove 1");
        arr.remove(1);
        for(int i = 0; i < arr.size(); i++) {
            System.out.print(i+"/"+ arr.get(i) + "  ");
        }
        System.out.println("\nlength : " + arr.getlength());


        System.out.println("\n--contains() 실행--");
        System.out.println("contains 50?" + arr.contains(50));
        System.out.println("contains 100?" + arr.contains(100));
        System.out.println("\nlength : " + arr.getlength());



        System.out.println("\n--indexOf() 실행--");
        System.out.println("index of 50? " + arr.indexOf(50));
        System.out.println("index of 100? " + arr.indexOf(100));
        System.out.println("\nlength : " + arr.getlength());

    }
}