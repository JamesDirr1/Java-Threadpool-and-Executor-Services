//James Dirr CSC-460

import java.util.Random;

import static java.lang.Thread.sleep;

public class sampleThread  implements Runnable{
    int name;
    public sampleThread(int num){
        this.name = num;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int maxTime = 1001;
        int randomTime = rand.nextInt(maxTime);
        //String name =  Thread.currentThread().getName(); //doesn't match name from example output?
        try {
            System.out.println("Thread-" + name + " is sleeping for " + randomTime + " milliseconds.");
            sleep(randomTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

