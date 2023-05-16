package ex06;

public class MyLittleArray {
    private Object[] array;
    private int size;

    public MyLittleArray() {
        array = new Object[10];
        size = 0;
    }

    public Object get(int index) {
        checkIndex(index);
        return array[index];
    }

    public void add(Object element) {
        ensureCapacity(size + 1);
        array[size] = element;
        size++;
    }

    public void add(int index, Object element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public void set(int index, Object element) {
        checkIndex(index);
        array[index] = element;
    }

    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
    }

    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    public int indexOf(Object object) {
        if (object == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (object.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int minCapacity) { //배열의 크기가 충분한지 확인
        int currentCapacity = array.length;
        if (minCapacity > currentCapacity) {
            int newCapacity = currentCapacity + (currentCapacity >> 1);  // Increase capacity by 50%
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        MyLittleArray myArray = new MyLittleArray();

        // Adding elements
        myArray.add("Hello");
        myArray.add(123);
        myArray.add(true);

        // Accessing elements
        System.out.println(myArray.get(0));  // Output: Hello
        System.out.println(myArray.get(1));  // Output: 123
        System.out.println(myArray.get(2));  // Output: true

        // Updating element
        myArray.set(1, "Updated");
        System.out.println(myArray.get(1));  // Output: Updated

        // Removing element
        myArray.remove(0);
        System.out.println(myArray.get(0));  // Output: 123

        // Check if it contains an element
        System.out.println(myArray.contains("Hello"));  // Output: false
        System.out.println(myArray.contains(123));      // Output: true

        // Find the index of an element
        System.out.println(myArray.indexOf(123));       // Output: 0
        System.out.println(myArray.indexOf("Hello"));   // Output: -1

        // Size of the array
        System.out.println(myArray.size());             // Output: 2
    }
}
