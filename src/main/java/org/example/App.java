package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class App {

//주체가 누군지 파악
    public void run() {
        System.out.println("==motivation 실행==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController();

        while (true) {
            System.out.print("사용자 입력 :  ");
            String 명령 = container.getScanner().nextLine();

            if (명령.equals("종료")) { // 예외 기능
                systemController.exit();
                break;
            } else if (명령.length() == 0) {
                System.out.println("명령어가 입력되지 않았음");
                continue;
            }

            if (명령.equals("add")) { // 길안내 (라우팅) 역할
                motivationController.add();
            } else if (명령.equals("list")) {
                motivationController.list();
            } else if (명령.startsWith("delete?")) {
                motivationController.delete2(명령);
            } else if (명령.startsWith("delete")) {
                motivationController.delete(명령);
            } else if (명령.startsWith("edit")) {
                motivationController.edit(명령);
            } else {
                System.out.println("사용 불가. 다시 입력하세요.");
                continue;
            }

        }
    }
}


