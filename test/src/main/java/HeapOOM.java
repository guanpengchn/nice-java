import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Java堆溢出
 *
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author wangschd
 */
public class HeapOOM {
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<Object>();

//        while(true) {
//            list.add(new Object());
//        }

        Timer timer = new Timer();
        while(true) {
            timer.schedule(new TimerTask() {
                public void run() {
                    list.add(new Object());
                }
            }, 10);
        }

    }
	
	/*
	 *  Result: 
	 *  java.lang.OutOfMemoryError: Java heap space
		Dumping heap to java_pid3740.hprof ...
		Heap dump file created [27889538 bytes in 0.171 secs]
		Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
		...
	 */
}