package org.example;

import org.example.motivation.controller.MotivationController;
import org.example.system.controller.SystemController;

import java.util.Scanner;

public class App {

    private Scanner sc;

    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.println("==motivation 실행==");

        SystemController systemController = new SystemController();
        MotivationController motivationController = new MotivationController(sc);

        while (true) {
            System.out.print("사용자 입력 :  ");
            String 명령 = sc.nextLine();
            if (명령.equals("종료")) {
                systemController.exit();
                break;
            }

            if(명령.equals("add")) {
                motivationController.add();
            } else if(명령.equals("list")) {
                motivationController.list();
//            } //else if(명령.equals("delete")) {
//                motivationController.delete();
            } else {
                System.out.println("사용 불가. 다시 입력하세요.");
                continue;
            }

        }
    }
}

