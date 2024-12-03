package Service;

public class RealService implements  ExampleServiceInterface{

    @Override
    public void operation() {
        System.out.println("This is the real service call");
    }
}
