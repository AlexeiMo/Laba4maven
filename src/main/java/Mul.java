import org.apache.log4j.Logger;

public class Mul implements Runnable{
    int a11=0,a12=0,b11=0,b21;
    double result=0;

    private static final Logger log = Logger.getLogger(Mul.class);

    public Mul(int a11,int a12,int b11,int b21)
    {
        this.a11= a11;
        this.a12=a12;
        this.b11=b11;
        this.b21=b21;
    }
    public void run() {
        result=a11*b11+a12*b21;
        log.info("Результат вычисления: " + result);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public double GetResult()
    {
        log.info("Результат вычисления: " + result);
        return result;
    }

}
