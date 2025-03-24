package org.example.motivation.entity;

import java.util.Scanner;
import java.util.*;

import static org.example.container.sc;

public class Motivation {

    private int id;
    private String body;
    private String 소스;

    public Motivation(int id, String body, String 소스) {
        this.id = id;
        this.body = body;
        this.소스 = 소스;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return 소스;
    }

    public void setSource(String 소스) {
        this.소스 = 소스;
    }

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", source='" + 소스 + '\'' +
                '}';
    }
}
