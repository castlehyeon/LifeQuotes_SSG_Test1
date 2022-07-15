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
    public String toString() {
        return wiseSayingId +
                "  /  " + content +
                "  /  " + author;
    }
}