package com.ll.LifeQuotes_SSG_Test1;

//컨트롤러는 점원이다.
public class WiseSayingController {
    WiseSayingRepository repository = new WiseSayingRepository();

    public WiseSayingController(){

    }
    public void write(Rq rq) {
        repository.write(rq);
    }

    public void update(Rq rq) {
        repository.update(rq);
    }

    public void remove(Rq rq) {
        repository.remove(rq);
    }

    public void list(Rq rq) {
        repository.list(rq);
    }
}
