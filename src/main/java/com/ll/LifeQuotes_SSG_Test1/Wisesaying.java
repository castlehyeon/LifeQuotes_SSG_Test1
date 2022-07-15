package com.ll.LifeQuotes_SSG_Test1;

class WiseSaying {
    int wiseSayingId;
    String content;
    String author;

    public WiseSaying(int wiseSayingId, String content, String author) {
        this.wiseSayingId = wiseSayingId;
        this.content = content;
        this.author = author;

    }

    @Override
    //메서드다.
    //()이게있겠네-> toString()
    //클래스.toString() -> String
    //오브젝트 메서드를 쓰는건 조금 다른것같아.
    //sout에서 println(클래스명);
    public String toString() {
        return wiseSayingId +
                "  /  " + content +
                "  /  " + author;
    }
}