package Base.Services;

import Base.Interfaces.BasicServiceInterface;

public class BaseRealService implements BasicServiceInterface {

    @Override
    public void operation() {
        System.out.println("Real service call\n");
    }

    @Override
    public void paramOperation(String info) {
        System.out.println("Real service call\n" + info + " was passed\n");
    }

    @Override
    public String returnOperation() {
        System.out.println("Real service call\n" + "Returning some string value\n");
        return "AAA";
    }

    @Override
    public String paramReturnOperation(String info) {
        System.out.println("Real service call\n" + info + " was passed\n" + "Returning some string value\n");
        return "AAA";
    }
}
