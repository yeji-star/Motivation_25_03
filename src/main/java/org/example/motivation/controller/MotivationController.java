package org.example.motivation.controller;

import org.example.container;
import org.example.motivation.entity.Motivation;

import java.util.*;

public class MotivationController {

    int lastId = 0;

    List<Motivation> motivations = new ArrayList<>();

    public void add() {

        int id = lastId + 1;
        System.out.print("body : ");
        String body = container.getScanner().nextLine();
        System.out.print("소스 : ");
        String 소스 = container.getScanner().nextLine();

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

    public void delete(String 명령) {
//        String[] 명령bits = 명령.split(" ");
//        int id = Integer.parseInt(명령bits[1]);

        int id = Integer.parseInt(명령.split(" ")[1]); // 정수화 과정

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) { // 순회시키기
            if (motivation.getId() == id) { //둘의 자료형이 달라서 처음엔 오류가 걸림 그래서 int로 바꿔줌
                foundMotivation = motivation; // id를 찾으면 그 값을 파운드가 갖게 됨
                break;
            }
        }

        if (foundMotivation == null) { // 근데 못가지게 될 수 잇어... 그 경우 == null이라 이걸 출력
            System.out.println("그 번호 없음");
            return;
        }

        motivations.remove(foundMotivation);
        System.out.println(id + "번호 삭제됨");

    }

    public void delete2(String 명령) {
//        String[] 명령bits = 명령.split(" ");
//        int id = Integer.parseInt(명령bits[1]);

        int id = Integer.parseInt(명령.split("\\?id=")[1]); // 정수화 과정

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) { // 순회시키기
            if (motivation.getId() == id) { //둘의 자료형이 달라서 처음엔 오류가 걸림 그래서 int로 바꿔줌
                foundMotivation = motivation; // id를 찾으면 그 값을 파운드가 갖게 됨
                break;
            }
        }

        if (foundMotivation == null) { // 근데 못가지게 될 수 잇어... 그 경우 == null이라 이걸 출력
            System.out.println("그 번호 없음");
            return;
        }

        motivations.remove(foundMotivation);
        System.out.println(id + "번호 삭제됨");

    }

    public void edit(String 명령) {
        int id;
        try {
            id = Integer.parseInt(명령.split(" ")[1]);// 정수화 과정
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("명령어 확인하십쇼");
            return;
        }

        Motivation foundMotivation = findByte(id);

        if (foundMotivation == null) { // 근데 못가지게 될 수 잇어... 그 경우 == null이라 이걸 출력
            System.out.println("그 번호 없음");
            return;
        }
        //찾은 noti에 인스턴스 변수에 접근
        System.out.println("body(기존) : " + foundMotivation.getBody());
        System.out.println("소스(기존) : " + foundMotivation.getSource());

        String newbody;
        String new소스;
        //수정사항 입력받기

        while (true) {
            System.out.print("new body : ");
            newbody = container.getScanner().nextLine().trim();

            if (newbody.length() != 0) { // 아무것도 입력 안할시 수정사항을 입력하라고 잔소리
                break;
            }
            System.out.println("수정사항을 입력하세요.");
        }

        while (true) {
            System.out.print("new 소스 : ");
            new소스 = container.getScanner().nextLine();

            if (new소스.length() != 0) { // 아무것도 입력 안할시 수정사항을 입력하라고 잔소리
                break;
            }
            System.out.println("수정사항을 입력하세요.");
        }
        
        foundMotivation.setBody(newbody);
        foundMotivation.setSource(new소스);

        System.out.println(id + "번 moti 수정됨");
        
        
    }

    //명령어의 id와 일치하는 moti 찾기
    private Motivation findByte(int id) {

        for (Motivation motivation : motivations) { // 순회시키기
            if (motivation.getId() == id) { //둘의 자료형이 달라서 처음엔 오류가 걸림 그래서 int로 바꿔줌
                return motivation;
            }
        }
        return null;
    }
}
