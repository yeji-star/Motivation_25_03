package org.example.motivation.controller;

import org.example.motivation.entity.Motivation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotivationController {

    int lastId = 0;

    List<Motivation> motivations = new ArrayList<>();
    Scanner sc;

    public MotivationController(Scanner sc) {
        this.sc = sc;
    }

    public void add() {

        int id = lastId + 1;
        System.out.print("body : ");
        String body = sc.nextLine();
        System.out.print("소스 : ");
        String 소스 = sc.nextLine();

        Motivation motivation = new Motivation(id, body, 소스);

        motivations.add(motivation);
        System.out.printf("%d번 motivation이 등록됨\n", id);
        lastId++;
    }

    public void list() {
        if (motivations.size() == 0) {
            System.out.println("등록된 것이 없습니다.");
            return;
        }

        System.out.println("=".repeat(40));
        System.out.printf("   id    /     source      /      body        \n");

        for (int i = motivations.size() - 1; i >= 0; i--) {
            Motivation motivation = motivations.get(i);

            if (motivation.getSource().length() > 7) {
                System.out.printf("   %d    /     %s     /      %s        \n", motivation.getId(), motivation.getSource().substring(0, 5) + "...", motivation.getBody());
                continue;
            }
            System.out.printf("   %d    /     %s        /      %s        \n", motivation.getId(), motivation.getSource(), motivation.getBody());
        }
        System.out.println("=".repeat(40));
    }

//    public void delete() {
//        System.out.print("몇 번을 삭제?");
//        String delete = sc.nextLine();
//
////입력을 했는데 그 번호의 모티가 없을 경우
////리스트에 잇을 모티의 번호를 입력했는데 없는 경우
//        if () {
//            System.out.printf("%d번 motivation은 존재하지 않음");
//            // 여긴 리턴보다 컨티뉴드 아니냐
//        }
//
////입력을 해서 그 숫자가 있고 그 리스트를 없애는 경우
//
//        System.out.printf("%d번 motivation이 삭제되었습니다.");
//    }
}
