import ProxyPattern.*;
import Base.Services.BaseRealService;

public class ExampleService {
    public static void main(String[] args) {
        // Instantiate base service
        BaseRealService service = new BaseRealService();

        // Instantiate all proxys
        BaseProxy baseProxy = new BaseProxy(service);
        VirtualProxy virtualProxy = new VirtualProxy();
        ProtectionProxy protectionProxy = new ProtectionProxy(service);
        RemoteProxy remoteProxy = new RemoteProxy(service);
        LoggingProxy loggingProxy = new LoggingProxy(service);
        CachingProxy cachingProxy = new CachingProxy(service);
        SmartProxy smartProxy = new SmartProxy(service);

        // TESTING BASE PROXY
        System.out.println("Making a request for Base Proxy...");
        baseProxy.operation();
        baseProxy.paramOperation("INFO");
        baseProxy.returnOperation();
        baseProxy.paramReturnOperation("INFO");
        System.out.println("\n------------------------------------------------\n");

        // TESTING CACHING PROXY
        System.out.println("Making a request for Caching Proxy...");
        cachingProxy.operation();
        cachingProxy.paramOperation("INFO");
        cachingProxy.returnOperation();
        cachingProxy.paramReturnOperation("INFO");
        cachingProxy.paramReturnOperation("INFO");
        System.out.println("\n------------------------------------------------\n");

        // TESTING LOGGING PROXY
        System.out.println("Making a request for Logging Proxy...");
        loggingProxy.operation();
        loggingProxy.paramOperation("INFO");
        loggingProxy.returnOperation();
        loggingProxy.paramReturnOperation("INFO");
        loggingProxy.printLog();
        System.out.println("\n------------------------------------------------\n");

        // TESTING PROTECTION PROXY
        System.out.println("Making a request for Protection Proxy...");
        protectionProxy.operation();
        protectionProxy.paramOperation("INFO");
        protectionProxy.paramOperation("11111111111");
        protectionProxy.returnOperation();
        protectionProxy.paramReturnOperation("INFO");
        System.out.println("\n------------------------------------------------\n");

        // TESTING REMOTE PROXY
        System.out.println("Making a request for Remote Proxy...");
        remoteProxy.operation();
        remoteProxy.paramOperation("INFO");
        remoteProxy.returnOperation();
        remoteProxy.paramReturnOperation("INFO");
        System.out.println("\n------------------------------------------------\n");

        // TESTING SMART PROXY
        System.out.println("Making a request for Smart Proxy...");
        smartProxy.operation();
        smartProxy.paramOperation("INFO");
        smartProxy.returnOperation();
        smartProxy.paramReturnOperation("INFO");
        System.out.println("\n------------------------------------------------\n");

        // TESTING SMART PROXY
        System.out.println("Making a request for Virtual Proxy...");
        virtualProxy.operation();
        virtualProxy.paramOperation("INFO");
        virtualProxy.returnOperation();
        virtualProxy.paramReturnOperation("INFO");
        System.out.println("\n------------------------------------------------\n");
    }
}
