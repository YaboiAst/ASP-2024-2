package ExemploSlide;

public class Proxy implements Subject {
    private RealSubject subject;
    public Proxy(RealSubject subject) {
        this.subject = subject;
    }
    @Override
    public void request() {
        System.out.println("Executando algo antes do request");
        subject.request();
        System.out.println("Executando algo depois do request");
    }
}


