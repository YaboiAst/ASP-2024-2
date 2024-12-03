package com.example.proxy;

public class RealService implements Service {
    @Override
    public void performAction(String user) {
        System.out.println("Ação realizada para o usuário: " + user);
    }
}
