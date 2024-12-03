package ProxyPattern;

import Base.Interfaces.BasicServiceInterface;
import Base.Services.BaseRealService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoggingProxy implements BasicServiceInterface {
    private BaseRealService realService;
    private List<String> log;

    public LoggingProxy(BaseRealService realService) {
        this.realService = realService;
        log = new ArrayList<>();
    }

    private void AddLog(String info)
    {
        log.add(info);
    }
    public List<String> getLog()
    {
        return new ArrayList<>(log);
    }

    @Override
    public void operation() {
        AddLog("Used service operation at " + Date.from(Instant.now()));
        realService.operation();
    }

    @Override
    public void paramOperation(String info) {
        AddLog("Used service paramOperation at " + Date.from(Instant.now()));
        realService.paramOperation(info);
    }

    @Override
    public String returnOperation() {
        AddLog("Used service returnOperation at " + Date.from(Instant.now()));
        return realService.returnOperation();
    }

    @Override
    public String paramReturnOperation(String info) {
        AddLog("Used service paramReturnOperation at " + Date.from(Instant.now()));
        return realService.paramReturnOperation(info);
    }
}
