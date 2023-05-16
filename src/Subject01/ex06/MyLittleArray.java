package Subject01.ex06;

public class MyLittleArray<T> {
    // 배열의 최대 길이
    private int MaxSize = 3;

    // 배열의 현재 인덱스
    private int idx = 0;
    private T[] array = (T[]) new Object[MaxSize];; // Object로 배열 생성 후 T로 형변환


    // 현재 배열 길이 반환
    private int size(){
        return this.idx;
    }

    // index의 값 반환
    private T get(int index){
        if(index < 0 || index >= size()){
            System.out.println("잘못된 인덱스입니다.");
            return null;
        }
        return array[index];
    }

    private void set(int index, T element){
        if(index < 0 || index >= size()){
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        array[index] = element;
    }

    private void add(T element){
        try {
            if (size() < MaxSize) {
                array[idx++] = element;
            } else {
                throw new Exception("배열이 가득 찼습니다.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void add(int index, T element){
        try{
            if(size() < MaxSize){
                for(int i = idx - 1; i >= index; i--){
                    array[i + 1] = array[i];
                }
                array[index] = element;
            } else{
                throw new Exception("배열이 가득 찼습니다.");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void remove(int index){
        if (size() > 0 && index >= 0 && index < size()) {
            for (int i = index; i < idx - 1; i++) {
                array[i] = array[i + 1];
            }
            array[idx - 1] = null; // 마지막 인덱스의 값을 null로 설정
            idx--;
        } else {
            System.out.println("유효하지 않은 인덱스입니다.");
        }
    }

    private boolean contains(T object){
        for(int i = 0; i < idx; i++){
            if(array[i] == object){
                return true;
            }
        }
        return false;
    }

    private int indexOf(T object){
        for(int i = 0; i < idx; i++){
            if(array[i] == object){
                return i;
            }
        }
        return -1;
    }

    private void print(){
        for(int i = 0; i < size(); i++){
            System.out.printf("%s ",array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLittleArray<String> stringArray = new MyLittleArray<>();
        MyLittleArray<Integer> intArray = new MyLittleArray<>();
        MyLittleArray<Boolean> booleanArray = new MyLittleArray<>();

        stringArray.add("a"); // a
        System.out.println(stringArray.get(1)); // a

        stringArray.add("b"); // a b
        stringArray.print();

        stringArray.add("c"); // a b c
        stringArray.print();

        stringArray.add("d"); // a b c
        stringArray.print();

        stringArray.set(0, "z"); // z b c
        stringArray.print();

        stringArray.set(3, "z"); // 잘못된 인덱스
        stringArray.print();

        stringArray.add(2, "x"); // 삽입 불가
        stringArray.print();

        stringArray.remove(2);
        stringArray.print();

        System.out.println(stringArray.get(2));
        System.out.println(stringArray.size());
        System.out.println(stringArray.contains("z"));
        System.out.println(stringArray.indexOf("z"));
        stringArray.print();

        intArray.add(1);
        intArray.print();

        booleanArray.add(true);
        booleanArray.print();
    }
}
