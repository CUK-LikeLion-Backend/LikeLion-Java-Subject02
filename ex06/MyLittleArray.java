package ex06;

public class MyLittleArray {
    private Object[] array;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyLittleArray() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyLittleArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity should be greater than 0.");
        }
        array = new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return array[index];
    }

    public boolean add(Object element) {
        if (size == array.length) {
            resize();
        }
        array[size++] = element;
        return true;
    }

    public void add(int index, Object element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        if (size == array.length) {
            resize();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public Object set(int index, Object element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        Object prevElement = array[index];
        array[index] = element;
        return prevElement;
    }

    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        Object removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removedElement;
    }

    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void resize() {
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }


    public static void main(String[] args) {
        MyLittleArray arr = new MyLittleArray();

        // add
        arr.add("Hello");
        arr.add("World");
        arr.add(123);
        arr.add(true);

        // get
        System.out.println(arr.get(0)); // output: "Hello"
        System.out.println(arr.get(1)); // output: "World"
        System.out.println(arr.get(2)); // output: 123
        System.out.println(arr.get(3)); // output: true

        // set
        arr.set(1, "Java");
        System.out.println(arr.get(1)); // output: "Java"

        // remove
        arr.remove(2);
        System.out.println(arr.get(2)); // output: 123

        // add
        arr.add(1, "Programming");
        System.out.println(arr.get(1)); // output: "Programming"
        System.out.println(arr.get(2)); // output: "Java"

        // element 존재 확인
        System.out.println(arr.contains("Java")); // output: true
        System.out.println(arr.contains("Python")); // output: false

        // element 인덱스 값 구하기
        System.out.println(arr.indexOf("Programming")); // output: 1
        System.out.println(arr.indexOf("Python")); // output: -1

        // 배열 크기 구하기
        System.out.println(arr.size()); // output: 4
    }
}