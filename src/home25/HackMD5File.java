package home25;
import java.io.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HackMD5File {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/niq/Downloads/hashesorg2019"),"utf-8"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            byte[] bytes = md5.digest(line.getBytes());
            if(Arrays.equals(bytes,BruteForce.hexHashMD5)){
                System.out.println(line);
                return;
            }
        }



    }


}
