package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbtractTemplate<T> {
    private final LogTrace trace;

    public T execute(String message){
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        } catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();
}
