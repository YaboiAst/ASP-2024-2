package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

public class VirtualProxy implements BasicServiceInterface {
    private BaseRealService realService;

    public VirtualProxy(BaseRealService realService) {
        this.realService = realService;
    }

    @Override
    public void operation() {
        BaseRealService service = new BaseRealService();
        service.operation();
    }

    @Override
    public void paramOperation(String info) {
        BaseRealService service = new BaseRealService();
        service.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        BaseRealService service = new BaseRealService();
        return service.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        BaseRealService service = new BaseRealService();
        return service.paramReturnOperation(info);
    }
}
