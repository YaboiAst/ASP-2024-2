import Service.ProxyPattern.BaseProxy;
import Service.RealService;

public class ExampleService {
    public static void main(String[] args) {
        RealService service = new RealService();
        BaseProxy proxy = new BaseProxy(service);

        System.out.println("Making a request...");
        proxy.operation();
    }
}
