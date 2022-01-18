package hello.advanced.trace.threadlocal.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");

        Runnable userA = () ->{
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Thread A = new Thread(userA);
        Thread B = new Thread(userB);
        A.setName("thread A");
        B.setName("thread B");

        A.start();
        sleep(1);
        B.start();

        sleep(2000);
    }

    private void sleep(int i) {
        try{
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
