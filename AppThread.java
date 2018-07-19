
public class ThreadApp {

    public static void main(String[] args) {
        final Processor processor = new Processor(50);

        Thread t1;
        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.produce();
            }
        });
        t1.setName("eventest");

        Thread t2;
        t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                processor.consume();
            }
        });
        t2.setName("oddtest");
        t1.start();
        t2.start();
    }
}
