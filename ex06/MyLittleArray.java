package ex06;

public class MyLittleArray {
    private Object[] objects;
    private int size;
    private int num;
    public MyLittleArray(int num){
        this.num = num;
        objects = new Object[num];
        size = 0;
    }

   Object get(int index){
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException("인덱스의 범위 벗어남.");
       return objects[index];
   }
   void add(Object element){
        objects[size] = element;
        size++;
   }
   void add(int index,Object element){
       if(index > size || index < 0)
           throw new IndexOutOfBoundsException("인덱스의 범위 벗어남.");
       for (int i = size - 1; i >= index; i--) {
           objects[i+1] = objects[i];
       }
       if(size == num){
           throw  new IndexOutOfBoundsException("최대 배열의 크기보다 큽니다.");
       }
       objects[index] = element;
       size++;
   }
   void set(int index, Object element){
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("인덱스의 범위 벗어남.");
       }
       objects[index] = element;
   }
   void remove(int index){
       if (index < 0 || index >= size) {
           throw new IndexOutOfBoundsException("인덱스의 범위 벗어남.");
       }
       for (int i = index; i < size - 1; i++) {
           objects[i] = objects[i + 1];
       }
       objects[size - 1] = null;
       size--;
   }
   boolean contains(Object element){
       for (int i = 0; i < size; i++) {
           if (objects[i].equals(element))
               return true;
       }
       return false;
   }
   int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (objects[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    int size(){
        return size;
    }
}