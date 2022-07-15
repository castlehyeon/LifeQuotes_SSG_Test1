package com.ll.LifeQuotes_SSG_Test1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Apptest {
    @Test
    public void Rq_getPath(){
        Rq rq = new rq("삭제?id=1");
        String path = rq.getpath();
        assertEquals("삭제", path);
    }
    @Test
    public void Rq_getIntParam(){
        Rq rq = new rq("삭제?id=1");
        assertEquals("삭제", path);
    }
}
