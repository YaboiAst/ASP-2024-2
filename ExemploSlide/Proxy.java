package ExemploSlide;

public class Proxy implements Subject {
    private SubjectVerdadeiro subject;
    public Proxy(SubjectVerdadeiro subject) {
        this.subject = subject;
    }
    @Override
    public void request() {
        System.out.println("Executando algo antes do request");
        subject.request();
        System.out.println("Executando algo depois do request");
    }
}


