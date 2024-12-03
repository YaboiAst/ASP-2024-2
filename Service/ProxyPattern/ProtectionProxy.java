package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

public class ProtectionProxy implements ExampleServiceInterface {
    private RealService realService;

    public ProtectionProxy(RealService realService) {
        this.realService = realService;
    }

    private boolean checkCredentials(String credential)
    {
        return (credential.length() == 11);
    }

    @Override
    public void operation() {
        if (checkCredentials("12345678910")) realService.operation();
        else System.out.println("Credential invalid");
    }
}
