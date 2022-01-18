package hello.advanced.trace.strategy.code;

import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {
    /**
     * 템플릿 출력 패턴 - 익명 내부 클래스
     */
    @Test
    void callBackV1(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비지니스 로직 1 실행"));
        template.execute(() -> log.info("비지니스 로직 2 실행"));
    }
}
