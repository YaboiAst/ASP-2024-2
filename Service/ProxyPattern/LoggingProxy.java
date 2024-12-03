package Service.ProxyPattern;

import Service.ExampleServiceInterface;
import Service.RealService;

import java.util.ArrayList;
import java.util.List;

public class LoggingProxy implements ExampleServiceInterface {
    private RealService realService;
    private List<String> log;

    public LoggingProxy(RealService realService) {
        this.realService = realService;
    }

    private void AddLog(String info)
    {
        log.add(info);
    }
    private List<String> getLog()
    {
        return new ArrayList<>(log);
    }

    @Override
    public void operation() {
        realService.operation();
        AddLog("Used service at Now");
    }
}
