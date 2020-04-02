package home25;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BruteForce {
    public static  char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    public static final int  PASSWORD_MAX_LENGTH = 30;
    public static String hashMD5 = "13d70e09909669272b19647c2a55dacb";
    public static byte[] hexHashMD5 = hexStringToByteArray(hashMD5);
    public static long  startTime;


    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte)((Character.digit(s.charAt(i), 16) << 4) +
                    Character.digit(s.charAt(i + 1), 16));
        }
        return data;

    }



}
