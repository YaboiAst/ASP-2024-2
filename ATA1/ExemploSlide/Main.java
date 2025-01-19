package ExemploSlide;

public class Main {
    public static void main(String[] args) {

        Subject s = new Proxy(new RealSubject());

        s.request();
    }
}
