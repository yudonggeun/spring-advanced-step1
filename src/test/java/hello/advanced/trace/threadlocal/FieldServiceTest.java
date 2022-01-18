package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field(){
        log.info("main start");

        Runnable userA = () ->{
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
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
