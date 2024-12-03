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
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        realService.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        String cache = CheckCache(info);
        if (cache == null || needsRefresh)
            cache = realService.paramReturnOperation(info);

        return cache;
    }
}
