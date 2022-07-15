package com.ll.LifeQuotes_SSG_Test1;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

//레포지토리는 데이터관리역할이다.
public class WiseSayingRepository {
    private int wiseSayingId=0;
    Scanner sc;
    ArrayList<WiseSaying> wiseSayings;
    public WiseSayingRepository(){
        sc = new Scanner(System.in);
        wiseSayings = new ArrayList<>();
    }
    public void write(Rq rq) {
        System.out.println("명언 : ");
        String content = sc.nextLine().trim();
        System.out.println("작가 : ");
        String author = sc.nextLine().trim();
        ++wiseSayingId;
        wiseSayings.add(new WiseSaying(wiseSayingId, content, author));
        //wisesaying(wiseSayingId, content, author) ;
        //클래스 내에서 계속 사용하는 변수들끼리 넣으려고 했는데 잘 안된다ㅠ
        System.out.printf("%d번째 명언이 등록 되었습니다.\n", wiseSayingId);
    }

    public void update(Rq rq) {
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
            wiseSayings.set(updateId-1, new WiseSaying(updateId, updateContent, updateAuthor));
            System.out.printf("%d번째 명언이 수정 되었습니다.\n", updateId);
        }
    }

    public void remove(Rq rq) {
        //삭제는 추가적인 정보가 필요하니 쿼리스트링 도입. Rq클래스 필요!
        //이걸 전부 이제 리펙토링 들어가는게 맞다. 1. 스위치문 삭제=> 각자 메서드로 해결, 2. Rq클래스로 받고, 명령어 분기 3. 쿼리스트링 해결
        //삭제?id=1이라는 입력이 들어온다면...
        int deleteId = rq.getIntParam("id", 0);
        if ( deleteId == 0 ){
            System.out.printf("%d번 명언은 존재하지 않습니다.",deleteId);
        } else {
            wiseSayings.remove(deleteId-1);
            System.out.printf("%d번째 명언이 삭제 되었습니다.\n", deleteId);
        }

    }

    public void list(Rq rq) {
        System.out.println("번호\t/\t작가\t/\t명언");
        System.out.println("----------------------");
        //System.out.println(wiseSayings);
        for(int i = wiseSayings.size()-1; i>=0; i--){//인덱스는 0부터 시작하니까. -1을 하고 0까지 돌리는구나.
            System.out.println(wiseSayings.get(i));
            //지역변수 wiseSaying과 author는 더이상 사용 못함. 클래스로 선언할까.
            //wiseSayings.size()-1; i>=0 i--
            //주소값이 나오는 이유: toString 오버라이딩 안해서.
        }
    }

    public void build(Rq rq) {
        File d = new File("test_data");

        if( d.exists()) {


            //내용에 해당되는 부분객체 생성
            //String saveFile = wiseSayings; 이런식으로 말고 요소 하나씩 \n을 기준으로 body에 담는 식으로 해보자.
            String body = "";
            for(int i = 0; i<wiseSayings.size(); i++ ){
                body += wiseSayings.get(i) + "\n";
            }
            int fileNum = 1;

            //디렉토리 내부에 같은 파일이 있는지 검사
            //File f = new File("test_data/1.json");
            String DATA_DIRECTORY = "test_data";
            File dir = new File(DATA_DIRECTORY);

            String[] filenames = dir.list();//파일리스트 추출
            //이대로 하면 1.json이 들어가므로 .split으로 1만 걸러내야함.

            for (String filenamseBit : filenames) {
                String[] fileName = filenamseBit.split(".", 2);
                //추출한 urlBit를 =기준으로 또 나눈다.
                String fileName_ = fileName[0];
                //파일이름은 숫자일것. [1]은 필요없어.

                //3단계
                if (fileName.equals(fileName_)) { //기존 file리스트 이름과 생성하려는 파일이름이 같은지 확인.
                    ++fileNum;
                }
            }
            Util.saveToFile("test_data/"+fileNum+".json", body);
            // 테스트처럼 ""를 넣으면 바뀌지 않으니, path, fileName 변수를 넣어볼까.

            System.out.printf("%d.json 파일이 추가되었습니다.\n",fileNum);
        }else {//만약 디렉토리가 없다면 생성
            System.out.println("디렉토리가 존재하지 않습니다.");
            Util.mkdir("test_data");
            System.out.println("다시 실행해주세요");
            return;
        }

    }
    //파일저장은 해당 디렉토리에 번호를 계속 매겨서 저장하는 식으로 해보자.
    //
}
