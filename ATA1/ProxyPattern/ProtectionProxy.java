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
        System.out.println("Protection Proxy Call");
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        System.out.println("Protection Proxy Call");
        if (checkCredentials(info))
        {
            System.out.println("Valid Credentials! Accessing real service");
            realService.paramOperation(info);
        }
        else
        {
            System.out.println("Invalid credentials! Try Again\n");
        }
    }

    @Override
    public String returnOperation() {
        System.out.println("Protection Proxy Call");
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        System.out.println("Protection Proxy Call");
        return realService.paramReturnOperation(info);
    }
}
