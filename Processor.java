public class Processor {

    private  int number = 1;
    private final int no;

    public Processor(int no){
        this.no=no;
    }
    public void produce(){
        synchronized (this) {
            while (no > number) {
                testEven(this.number);
                number++;
                try {
                    wait();
                    System.out.println("notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consume(){
        synchronized (this) {
            while (no > number) {
                oddTest(this.number);
                number++;
                notify();
            }
        }
    }

    public void testEven(int val){
        if(val%2==0)
            System.out.println("even number "+val);
        System.out.println("Actual number in evenTest is " +number);
    }

    public void oddTest(int val){
        if(val%2==1)
            System.out.println("odd number " +val);
        System.out.println("Actual number in oddTest "+number);
    }
}
