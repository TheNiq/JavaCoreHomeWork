package Home6;
import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray() {
        array = new int [0];
    }

    public int[] getArray() {
        return array;
    }

    public int[] add(int addNum) {
        int[] buffer = new int[array.length + 1];
        if(array.length > 0){
            for (int i =0;i < array.length; i++ ){
                buffer[i] = array[i];
            }
            buffer[array.length] = addNum;
            array = buffer;
        }
        else {
            buffer[0] = addNum;
            array = buffer;
        }
        return array;

    }
    public Integer get(int index){
        if(index >= array.length || index < 0){
            return null;
        }
        return array[index];

    }
    public boolean contains(int num){
        boolean isContains = false;
        for(int i = 0;i < array.length;i++){
            if(array[i] == num){
                isContains = true;
            }
        }
        return isContains;
    }
    public boolean equals(int[] externalArray){
        boolean result = false;
        if(array.length != externalArray.length){
            return result;
        }
        for (int i =0;i < externalArray.length;i++){
            if(array[i] == externalArray[i]){
                result = true;

            }else {
                result = false;
                break;
            }

        }
        return result;
    }
    public int[] addAll(int[] externalArray){
        int count = 0;
       int[] buffer = new int[array.length + externalArray.length];
       for(int i = 0;i < array.length;i++){
           buffer[i] = array[i];
           count++;
       }
       for(int i =0;i < externalArray.length;i++){
           buffer[count] = externalArray[i];
           count++;
       }
       array = buffer;
       return array;

    }
    public void clear(){
        array = new int[0];
    }

    public void print(){
        for (int num:
             array) {
            System.out.print(num +" ");

        }
        System.out.println();
    }
    public Integer findOrIndexO(int num){
        Integer index = null;
        for(int i = 0;i < array.length;i++){
            if(array[i] == num){
                index = i;
            }
        }
        return index;

    }
    public int getSize(){
        return array.length;
    }


    public void sort(){
        boolean sorted = false;
        int temp ;
        while (!sorted){
            sorted = true;
            for(int i =0;i < array.length-1;i++){
                if(array[i] > array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);

    }
}



