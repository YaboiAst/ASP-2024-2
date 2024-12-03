package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class CachingProxy implements BasicServiceInterface {
    private BaseRealService realService;

    Dictionary<String, String> cachedLastOperations;
    private boolean needsRefresh;

    public CachingProxy(BaseRealService realService) {
        this.realService = realService;
        cachedLastOperations = new Hashtable<>();
    }

    public void AddToCache(String info, String ret)
    {
        if (cachedLastOperations.size() >= 3)
            cachedLastOperations.remove(0);
        cachedLastOperations.put(info, ret);
    }
    public String CheckCache(String info)
    {
        return cachedLastOperations.get(info);
    }

    @Override
    public void operation() {
        System.out.println("Cache Proxy Call");
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        System.out.println("Cache Proxy Call");
        realService.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        System.out.println("Cache Proxy Call");
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        System.out.println("Cache Proxy Call");
        String cache = CheckCache(info);
        if (cache == null || needsRefresh) {
            System.out.println("Not found in Cache, calling real service");
            cache = realService.paramReturnOperation(info);
            AddToCache(info, cache);
        }
        else  System.out.println("Cache hit!");

        return cache;
    }
}
