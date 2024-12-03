package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingProxy {
    public static Service createProxy(Service realService) {
        return (Service) Proxy.newProxyInstance(
                realService.getClass().getClassLoader(),
            new Class[]{Service.class},
            new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // Adicionando Logs
                    System.out.println("Log: Método chamado - " + method.getName());

                    // Autenticação simples
                    String user = (String) args[0];
                    if (!"admin".equals(user)) {
                        System.out.println("Autenticação falhou para o usuário: " + user);
                        return null;
                    }

                    // Chama o método real
                    Object result = method.invoke(realService, args);

                    // Pós-processamento
                    System.out.println("Log: Método concluído - " + method.getName());
                    return result;
                }
            }
        );
    }
}
