package com.ll.LifeQuotes_SSG_Test1;

import org.junit.jupiter.api.Test;

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
}
