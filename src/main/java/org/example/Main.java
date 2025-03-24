package org.example;

public class Main {
    public static void main(String[] args) {

        container.init();

        new App().run();

        container.close();

    }
}


