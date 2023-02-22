//James Dirr CSC-460

 import java.util.Random;
 import java.util.concurrent.Callable;

 import static java.lang.Thread.sleep;

 public class sampleCallable implements Callable<Integer> {
        int name;
        public sampleCallable(int num){
            this.name = num;
        }

    @Override
    public Integer call() throws Exception {
        Random rand = new Random();
        int time = rand.nextInt(201-100) + 100;
        int numRand = rand.nextInt(101 - 1) + 1;
        sleep(time);
        System.out.println("Thread-" + name + " calculating square of " + numRand);
        int square = numRand * numRand;
        return square;
    }
}
