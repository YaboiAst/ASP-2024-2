package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

import java.util.ArrayList;
import java.util.List;

public class SmartProxy implements BasicServiceInterface {
    private BaseRealService realService;
    List<String> clientsId;

    public SmartProxy(BaseRealService realService) {
        this.realService = realService;
        clientsId = new ArrayList<>();
    }

    // This function runs on some time intervals
    private void CheckClients()
    {
        for(String client : clientsId)
        {
            if (client.equals("clienteAtivo")) return;
        }

        // Destroy service
        realService = null;
    }

    @Override
    public void operation() {
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        clientsId.add(info);
        realService.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        clientsId.add(info);
        return realService.paramReturnOperation(info);
    }
}
