package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

import java.util.List;

public class CachingProxy implements ExampleServiceInterface {
    private RealService realService;

    List<String> cachedLastOperations;
    private boolean needsRefresh;

    public CachingProxy(RealService realService) {
        this.realService = realService;
    }

    public String CheckCache()
    {
        return null;
    }

    @Override
    public void operation() {
        String cacheHit = CheckCache();
        if (cacheHit == null || needsRefresh) realService.operation();
        else
        {
            System.out.println("Using cached info");
        }
    }
}
