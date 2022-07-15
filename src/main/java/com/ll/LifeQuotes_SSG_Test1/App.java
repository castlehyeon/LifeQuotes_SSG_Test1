package com.ll.LifeQuotes_SSG_Test1;
import java.util.Scanner;
//App은 응대다!
public class App {

    public void run() {
        System.out.println("== 명언 SSG ==");
        WiseSayingController controller = new WiseSayingController();
        Scanner sc = new Scanner(System.in);
        outer:
        while ( true ) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);
            String path = rq.getpath();

            switch (path){
                case "등록":
                    controller.write(rq);
                    //컨트롤러로 전부 옮겼으니, rq를 인자로 받는게 맞을 것.
                    break;
                case "수정":
                    controller.update(rq);
                    break;
                case "삭제":
                    controller.remove(rq);
                    break;
                case "목록":
                    controller.list(rq);
                    break;
                case "빌드":
                    controller.build(rq);
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

//6단계 컨트롤러, 레포로 나누기 시작.