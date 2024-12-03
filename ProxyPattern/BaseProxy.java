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
        System.out.println("Base Proxy Call");
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        System.out.println("Base Proxy Call");
        realService.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        System.out.println("Base Proxy Call");
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        System.out.println("Base Proxy Call");
        return realService.paramReturnOperation(info);
    }
}
