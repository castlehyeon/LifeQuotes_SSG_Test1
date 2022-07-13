package com.ll.LifeQuotes_SSG_Test1;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private int wiseSayingId=0;
//    private String content;
//    private String author;
//     이렇게 하면 저장기능이 안되는구나.

    public void run() {
        System.out.println("== 명언 SSG ==");
        Scanner sc = new Scanner(System.in);
        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
        outer:
        while ( true ) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();

            switch (cmd){
                case "등록":
                    System.out.println("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.println("작가 : ");
                    String author = sc.nextLine().trim();
                    ++wiseSayingId;
                    wiseSayings.add(new WiseSaying(wiseSayingId, content, author));
                   //wisesaying(wiseSayingId, content, author) ;
                    //클래스 내에서 계속 사용하는 변수들끼리 넣으려고 했는데 잘 안된다ㅠ
                    System.out.printf("%d번째 명언이 등록 되었습니다.\n", wiseSayingId);
                    break;
                case "삭제" :
                case "목록":
                    System.out.println("번호\t/\t작가\t/\t명언");
                    System.out.println("----------------------");
                    //System.out.println(wiseSayings);
                    for(int i = wiseSayings.size()-1; i>=0; i--){//인덱스는 0부터 시작하니까. -1을 하고 0까지 돌리는구나.
                        System.out.println(wiseSayings.get(i));
                        //지역변수 wiseSaying과 author는 더이상 사용 못함. 클래스로 선언할까.
                        //wiseSayings.size()-1; i>=0 i--
                    //주소값이 나오는 이유: toString 오버라이딩 안해서.
                    }
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }
}
class WiseSaying {
    int wiseSayingId = 0;
    String content;
    String author;

    public WiseSaying(int wiseSayingId, String content, String author) {
        this.wiseSayingId = wiseSayingId;
        this.content = content;
        this.author = author;

    }

    @Override
    public String toString() {
        return wiseSayingId +
                "  /  " + content +
                "  /  " + author;
    }
}
//Aray를 쓰지 않으면 여러개 정보를 인덱스로 저장할 수 없구나. 배열도 써야하고 크기도 바뀌어야한다.
//수정도 되야하고 삭제도 되야한다.