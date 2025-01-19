package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

public class VirtualProxy implements BasicServiceInterface {
    private BaseRealService realService;

    public VirtualProxy()
    {}

    public VirtualProxy(BaseRealService realService) {
        this.realService = realService;
    }

    @Override
    public void operation() {
        System.out.println("Virtual Proxy Call");
        BaseRealService service = new BaseRealService();
        service.operation();
    }

    @Override
    public void paramOperation(String info) {
        System.out.println("Virtual Proxy Call");
        BaseRealService service = new BaseRealService();
        service.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        System.out.println("Virtual Proxy Call");
        BaseRealService service = new BaseRealService();
        return service.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        System.out.println("Virtual Proxy Call");
        BaseRealService service = new BaseRealService();
        return service.paramReturnOperation(info);
    }
}
