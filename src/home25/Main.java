package home25;



import java.security.NoSuchAlgorithmException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        int cores = Runtime.getRuntime().availableProcessors();
        int lengthSet = BruteForce.PASSWORD_MAX_LENGTH/cores;
        int end = 0;
        BruteForce.startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);
        while (end < BruteForce.PASSWORD_MAX_LENGTH){
            int start = end + 1;
            end = start + lengthSet;
            if(end > BruteForce.PASSWORD_MAX_LENGTH){
                end = BruteForce.PASSWORD_MAX_LENGTH;

            }
            executorService.submit(new HackMD5(start,end));


        }

        executorService.shutdown();

    }
}
