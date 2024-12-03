package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

public class ProtectionProxy implements BasicServiceInterface {
    private BaseRealService realService;

    public ProtectionProxy(BaseRealService realService) {
        this.realService = realService;
    }

    private boolean checkCredentials(String credential)
    {
        return (credential.length() == 11);
    }

    @Override
    public void operation() {
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        if (checkCredentials(info))
        {
            realService.paramOperation(info);
        }
        else
        {
            System.out.println("Invalid credentials! Try Again\n");
        }
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
