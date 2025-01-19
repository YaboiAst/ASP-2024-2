package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

public class RemoteProxy implements BasicServiceInterface {
    private BaseRealService realService;

    public RemoteProxy(BaseRealService realService) {
        this.realService = realService;
    }

    private boolean connectToServer()
    {
        // Connect to some remote service here
        return true;
    }

    @Override
    public void operation() {
        System.out.println("Remote Proxy Call");
        if (connectToServer()) {
            System.out.println("Connection Succesful");
            realService.operation();
        }
        else System.out.println("Connection Failed");
    }

    @Override
    public void paramOperation(String info) {
        System.out.println("Remote Proxy Call");
        if (connectToServer()) {
            System.out.println("Connection Succesful");
            realService.paramOperation(info);
        }
        else System.out.println("Connection Failed");
    }

    @Override
    public String returnOperation() {
        System.out.println("Remote Proxy Call");
        if (connectToServer()) {
            System.out.println("Connection Succesful");
            return realService.returnOperation();
        }
        else {
            System.out.println("Connection Failed");
            return null;
        }
    }

    @Override
    public String paramReturnOperation(String info) {
        System.out.println("Remote Proxy Call");
        if (connectToServer()) {
            System.out.println("Connection Succesful");
            return realService.paramReturnOperation(info);
        }
        else {
            System.out.println("Connection Failed");
            return null;
        }
    }
}
