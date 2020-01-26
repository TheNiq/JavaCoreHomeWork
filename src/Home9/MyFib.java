package Home9;

public class MyFib {
    public static long[] cache = new long[101];
    public static long fi(int num){
        if(cache[num] != 0){
            return cache[num];
        }
        else if(num == 0 || num == 1){
            cache[num] = 1;
            return 1;
        }else {
            long result = fi(num -2) + fi(num -1 );
            cache[num] = result;
            return result;

        }


    }
    public static void main(String[] args) {
        System.out.println(fi(100));
    }
}
