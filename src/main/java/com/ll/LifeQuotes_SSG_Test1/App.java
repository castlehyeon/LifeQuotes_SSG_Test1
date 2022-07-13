package com.ll.LifeQuotes_SSG_Test1;

import java.util.Scanner;

public class App {
    private int wiseSayingId=0;

    public void run() {
        System.out.println("== 명언 SSG ==");

        Scanner sc = new Scanner(System.in);
        outer:
        while ( true ) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd){
                case "등록":
                    System.out.println("명언 : ");
                    String wiseSaying = sc.nextLine().trim();
                    System.out.println("작가 : ");
                    String author = sc.nextLine().trim();
                    ++wiseSayingId;
                    System.out.printf("%d번째 명언이 등록 되었습니다.\n", wiseSayingId);
                    break;
                case "목록":
                    break outer;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
