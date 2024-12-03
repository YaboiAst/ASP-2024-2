package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

import java.util.List;

public class SmartProxy implements ExampleServiceInterface {
    private RealService realService;
    List<String> clientsId;

    public SmartProxy(RealService realService) {
        this.realService = realService;
    }

    private void CheckClients()
    {
        for(String client : clientsId)
        {
            if (client == "ativo") return;
        }

        // Destroy service
        realService = null;
    }

    @Override
    public void operation() {
        clientsId.add("Id");
        realService.operation();
    }
}
