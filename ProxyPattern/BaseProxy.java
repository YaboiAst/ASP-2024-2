package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

public class BaseProxy implements BasicServiceInterface {
    private BaseRealService realService;

    public BaseProxy(BaseRealService realService) {
        this.realService = realService;
    }

    @Override
    public void operation() {
        System.out.println("Proxy will make a call to the real service...");
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        realService.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        return realService.paramReturnOperation(info);
    }
}
