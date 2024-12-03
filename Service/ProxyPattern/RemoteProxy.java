package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

public class RemoteProxy implements ExampleServiceInterface {
    private RealService realService;

    public RemoteProxy(RealService realService) {
        this.realService = realService;
    }

    private boolean connectToServer()
    {
        return true;
    }

    @Override
    public void operation() {
        if (connectToServer()) realService.operation();
        else System.out.println("Connection Failed");
    }
}
