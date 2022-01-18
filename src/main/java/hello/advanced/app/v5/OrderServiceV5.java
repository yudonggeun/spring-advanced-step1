package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceCallback;
import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbtractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 repositoryV1;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 repositoryV1, LogTrace trace) {
        this.repositoryV1 = repositoryV1;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderServiceV5.orderItem()", (TraceCallback<Void>) () -> {
            repositoryV1.save(itemId);
            return null;
        });
    }
}
