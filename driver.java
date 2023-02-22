//James Dirr CSC-460

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class driver {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("------------PART A------------");
        ExecutorService ES = Executors.newFixedThreadPool(9);
        List< Future<?> > myFutures = new ArrayList<Future<?>>();

        for(int i = 0; i < 60; i++){
            sampleThread temp = new sampleThread(i);
            Future <?> f = ES.submit(temp);
            myFutures.add(f);
        }
        for ( Future<?> curfuture : myFutures ) {
            curfuture.get();
        }
        ES.shutdown();
        System.out.println("------------PART B------------");

        Future<Integer> list[] = new Future[350];
        ExecutorService ES1 = Executors.newCachedThreadPool();
        for(int i = 0; i < 350; i++){
            sampleCallable temp = new sampleCallable(i);
            Future<Integer> f = ES1.submit(temp);
            list[i] = f;
        }
            for (int i = 0; i < 350; i++ ) {
                    int output = list[i].get();
                    System.out.println("Result from Thread-" + i + ": " + output);
        }
        ES1.shutdown();
         sleep(3000);
    }

}
