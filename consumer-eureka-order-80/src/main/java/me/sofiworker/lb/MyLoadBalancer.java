package me.sofiworker.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sofiworker
 * @date 2020/7/11  11:19
 * 轮询的自定义实现
 */
@Component
public class MyLoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncr() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        return next;
    }

    public ServiceInstance lb(List<ServiceInstance> serviceInstances) {
        return serviceInstances.get(getAndIncr() % serviceInstances.size());
    }
}
