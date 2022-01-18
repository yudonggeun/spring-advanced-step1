package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbtractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 repositoryV1;
    private final LogTrace trace;

    public void orderItem(String itemId) {

        AbtractTemplate<Void> template = new AbtractTemplate<Void>(trace) {
            @Override
            protected Void call() {
                repositoryV1.save(itemId);
                return null;
            }
        };

        template.execute("OrderServiceV5.orderItem()");
    }
}
