package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

public class VirtualProxy implements ExampleServiceInterface {

    @Override
    public void operation() {
        RealService service = new RealService();
        service.operation();
    }
}
