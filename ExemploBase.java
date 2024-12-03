interface Subject {
    void request();
}

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("Algum processo sendo feito pelo serviço real");
    }
}

class Proxy implements Subject {
    private final Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("Proxy faz algo antes da chamada pro serviço");
        subject.request();
        System.out.println("Proxy pode fazer algo depois da chamada");
    }
}
