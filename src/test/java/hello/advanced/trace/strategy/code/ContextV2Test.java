package hello.advanced.trace.strategy.code;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 사용
     */
    @Test
    void strategyV1(){
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(() -> log.info("비니지니스 로직 2실행"));
    }

    @Test
    void strategyV2(){
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비니지니스 로직 1 실행"));
        context.execute(() -> log.info("비니지니스 로직 2 실행"));
    }

    @Test
    void strategyV4() {
        ContextV1 context1 = new ContextV1(() -> log.info("비지니스 로직 1실행"));
        context1.execute();


        ContextV1 context2 = new ContextV1(() -> log.info("비지니스 로직 1실행"));
        context2.execute();
    }
}
