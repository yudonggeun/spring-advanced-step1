package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbtractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderServiceV1;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(String itemId){

        AbtractTemplate<String> template = new AbtractTemplate<String>(trace) {
            @Override
            protected String call() {
                orderServiceV1.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}
