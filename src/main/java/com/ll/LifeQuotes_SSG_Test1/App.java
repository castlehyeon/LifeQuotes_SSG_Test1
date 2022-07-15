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
            Rq rq = new Rq(cmd);
            String path = rq.getpath();

            switch (path){
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
                case "수정":
                    int updateId = rq.getIntParam("id", 0);
                    if ( updateId == 0 ){
                        System.out.printf("%d번 명언은 존재하지 않습니다.",updateId);
                    } else {
                        WiseSaying wiseSaying = wiseSayings.get(updateId-1);
                        System.out.printf("명언(기존): %s\n", wiseSaying.content);
                        System.out.printf("명언 : ");
                        String updateContent = sc.nextLine().trim();
                        System.out.printf("작가(기존): %s\n", wiseSaying.author);
                        System.out.printf("작가 : ");
                        String updateAuthor = sc.nextLine().trim();
                        wiseSayings.set(updateId-1, new WiseSaying(wiseSayingId, updateContent, updateAuthor));
                        System.out.printf("%d번째 명언이 수정 되었습니다.\n", updateId);
                    }
                    break;
                case "삭제": //삭제는 추가적인 정보가 필요하니 쿼리스트링 도입. Rq클래스 필요!
                    //이걸 전부 이제 리펙토링 들어가는게 맞다. 1. 스위치문 삭제=> 각자 메서드로 해결, 2. Rq클래스로 받고, 명령어 분기 3. 쿼리스트링 해결
                    //삭제?id=1이라는 입력이 들어온다면...
                    int deleteId = rq.getIntParam("id", 0);
                    if ( deleteId == 0 ){
                        System.out.printf("%d번 명언은 존재하지 않습니다.",deleteId);
                    } else {
                        wiseSayings.remove(deleteId-1);
                        System.out.printf("%d번째 명언이 삭제 되었습니다.\n", deleteId);
                    }
                    break;
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

//Aray를 쓰지 않으면 여러개 정보를 인덱스로 저장할 수 없구나. 배열도 써야하고 크기도 바뀌어야한다.
//수정도 되야하고 삭제도 되야한다.
//6단계: 이걸 전부 이제 리펙토링 들어가는게 맞다. 1. 스위치문 삭제=> 각자 메서드로 해결, 2. Rq클래스로 받고, 명령어 분기 3. 쿼리스트링 해결