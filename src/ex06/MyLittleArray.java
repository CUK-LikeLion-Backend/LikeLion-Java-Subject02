package ex06;

public class MyLittleArray {

    String[] arr1 = {"A","B","C"};
    // 기존 배열
    int[] array = {1, 2, 3, 4};


    MyLittleArray myLittleArray = new MyLittleArray();
    public String get(int index){
        return arr1[index];
    }

    public int[] add(Integer num){
// 새로운 배열 생성
        int[] newArray = new int[array.length + 1];
// 기존 배열 요소 복사
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        // 맨 마지막 요소에 값 추가
        int valueToAdd = num;
        newArray[newArray.length - 1] = valueToAdd;
        return newArray;
    }

//add(index, element)
    public int[] add(int index, Integer value){

        array[index] = value;
        if(index > array.length){
            // 새로운 배열 생성
            int[] newArray = new int[array.length + 1];
// 기존 배열 요소 복사
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            // 맨 마지막 요소에 값 추가
            int valueToAdd = value;
            newArray[index] = valueToAdd;
            return newArray;
        }
        return array;
    }
//set(index, element)

    public int[] set(int index, Integer value){

        array[index] = value;

        return array;
    }
//remove(index)
    public int[] remove(int index){
        // 새로운 배열 생성
        int[] newArray = new int[array.length - 1];

// 삭제할 인덱스 이전까지의 요소 복사
        for (int i = 0; i < index; i++) {
            newArray[i] = array[i];
        }

// 삭제할 인덱스 이후부터의 요소 복사
        for (int i = index + 1; i < array.length; i++) {
            newArray[i - 1] = array[i];
        }
        return newArray;
    }
//contains(object)
    public int contains(Object a){

    }
//indexOf(object)
public static int indexOf(Object[] array, Object element) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == null) {
            if (element == null) {
                return i;
            }
        } else {
            if (array[i].equals(element)) {
                return i;
            }
        }
    }
    return -1;
}
//size()

}
