import java.util.concurrent.atomic.AtomicInteger;

public class Timer extends Thread{
    int a;

    @Override
    public void run() {
        super.run();
        while (true){
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(a*10);
            a=0;
        }
    }
}
