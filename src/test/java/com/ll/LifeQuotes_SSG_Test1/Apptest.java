package com.ll.LifeQuotes_SSG_Test1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Apptest {
    @Test
    public void Rq_getPath(){
        Rq rq = new Rq("삭제?id=1");
        String path = rq.getpath();
        assertEquals("삭제", path);
    }
    @Test
    public void Rq_getIntParam(){
        Rq rq = new Rq("삭제?id=1");
        int id = rq.getIntParam("id", 0);
        assertEquals(1, id);
    }
    @Test
    void 파일에_내용쓰기() {
        Util.mkdir("test_data");
        Util.saveToFile("test_data/1.json", "내용");
    }
    @Test
    void 파일내용불러오기() {
        String line = Util.loadFile("test_data/1.json");

        assertEquals("내용", line);
    }
    @Test
    void 삭제기능(){
        Rq rq = new Rq("삭제?=55");
        ArrayList<WiseSaying> wiseSayings = new ArrayList<>();
        int deleteId = rq.getIntParam("id", 0);
        String message = "명언은 존재하지 않습니다.";
        if ( deleteId == 0 ){ //deleteId값이 사용자 번호(index+1)
            System.out.printf(message);
        } else {
            wiseSayings.remove(deleteId-1);
            System.out.printf("%d번째 명언이 삭제 되었습니다.\n", deleteId);
        }
        assertEquals("명언은 존재하지 않습니다.", message);
    }
}
