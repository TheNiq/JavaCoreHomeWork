package home25;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class HackMD5 implements Runnable {
    private int start;
    private int end;
    private MessageDigest md5 = MessageDigest.getInstance("MD5");
    private static boolean done = false;
    private String password;

    public HackMD5(int start,int end) throws NoSuchAlgorithmException {
        this.start =start;
        this.end = end;
    }
    private void generator(StringBuilder sb , int position){
        if(done){
            return;
        }
        if(position == sb.length()){
            String possiblePassword = sb.toString();
            byte[] bytes = md5.digest(possiblePassword.getBytes());
            if(Arrays.equals(bytes, BruteForce.hexHashMD5)){
                password = possiblePassword;
                done = true;
            }
            return;
        }
        for (int i = 0;i < BruteForce.alphabet.length && !done; i++){
            char letter = BruteForce.alphabet[i];
            sb.setCharAt(position, letter);

            generator(sb, position +1 );
        }


    }

    @Override
    public void run() {
        for(int length = start; length <= end && !done ;length++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.setLength(length);
            generator(stringBuilder, 0);
        }
        if(done){
            long time = System.currentTimeMillis() - BruteForce.startTime;
            System.out.println("Password cracked in " + TimeUnit.MILLISECONDS.toSeconds(time) + "sec. Password = " + password);
        }else {
            System.out.println( "Password not cracked for subset ");
        }


    }
}
