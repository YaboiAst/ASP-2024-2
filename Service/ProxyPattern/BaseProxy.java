package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

public class BaseProxy implements ExampleServiceInterface {
    private RealService realService;

    public BaseProxy(RealService realService) {
        this.realService = realService;
    }

    @Override
    public void operation() {
        System.out.println("Proxy will make a call to the real service...");
        realService.operation();
    }
}
