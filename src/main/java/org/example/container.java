package org.example;

import java.util.Scanner;

//공유 자원 관리자
public class container {
    public static Scanner sc;

    public static void init() { //공유 자원을 모아주는 공간을 초기화
        sc = new Scanner(System.in);
    }

    public static void close() {//공유 자원을 모아주는 공간을 해제
        sc.close();

    }

    public static Scanner getScanner() {
        return sc;
    }
}
