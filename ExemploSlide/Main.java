package ExemploSlide;

public class Main {
    public static void main(String[] args) {

        Subject s = new Proxy(new SubjectVerdadeiro());

        s.request();
    }
}
