package com.example.proxy;

public class ProxyExample {
    public static void main(String[] args) {
        // Objeto real
        Service realService = new RealService();

        // Criar o Proxy
        Service proxyService = LoggingProxy.createProxy(realService);

        // Testando o proxy
        System.out.println("=== Usuário Admin ===");
        proxyService.performAction("admin");

        System.out.println("\n=== Usuário Comum ===");
        proxyService.performAction("user");
    }
}
