package Home6;


public class Main {
    public static void print(int [] arr){
        for (int i = 0;i <arr.length;i++ ){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[4];
        arr[0] = 15;
        arr[1] = 25;
        arr[2] = 35;


        MyArray myArray = new MyArray();
        myArray.add(10);
        myArray.add(20);
        myArray.add(30);
        System.out.println(myArray);
        System.out.println(myArray.get(1));
        System.out.println(myArray.contains(21));
        System.out.println(myArray.equals(arr));
        myArray.addAll(arr);
        System.out.println(myArray);
        System.out.println(myArray.getSize());
        System.out.println(myArray.findOrIndexO(25));
        myArray.sort();
        System.out.println(myArray);





    }
}
