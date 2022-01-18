package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbtractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderServiceV1;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderServiceV1, LogTrace trace) {
        this.orderServiceV1 = orderServiceV1;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(String itemId){

        return template.execute("OrderController.request()", () -> {
            orderServiceV1.orderItem(itemId);
            return "ok";
        });
    }
}
