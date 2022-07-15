package com.ll.LifeQuotes_SSG_Test1;
//Rq클래스는 사용자의 리퀘스트를 받는 용도이다.
//리퀘스트로 명령어 분기와 경로설정, id를 추출하는데 쓰인다.
public class Rq {
    String url;//명령어?id=숫자;의 형태

    public Rq(String url) {//생성자에서 초기화를 꼭 하자.
        this.url = url;//사용자에게 입력받은 url로 해당 클래스 멤버를 초기화한다.
    }

    public int getIntParam(String paramName, int defaultValue) {
        //어떤 일을 하는 메서드: 1단계-?로 명령어분기 2단계-&로 id=숫자분리 3단계-=로 Value값 추출.
        //1단계
        String[] urlBits = url.split("\\?", 2);
        //urlBits로 ?를 기준으로 나눈다. 이렇게 된다면 [0]: 명령어, [1]: "id=숫자1&id=숫자2...&id=숫자n"로 쪼개지겠지.
        urlBits = urlBits[1].split("&");
        //urlBits를 쪼갠 후 1번에 담긴 것만 다시 쪼갠 후에 [0]: id=숫자1, [1]: id=숫자2...

        //2단계
        for (String urlBit : urlBits) {
            //향상된 for문으로 urlBits[]에 있는 요소를 하나씩 뽑아 스트링의 urlBit로 추출한다.
            //"id=숫자1", "id=숫자2"...
            String[] paramNameAndValue = urlBit.split("=", 2);
            //추출한 urlBit를 =기준으로 또 나눈다.
            String paramName_ = paramNameAndValue[0];
            //id
            String paramValue = paramNameAndValue[1];
            //숫자

            //3단계
            if (paramName.equals(paramName_)) { //유저가 입력한 paramName과 저장된 parmName_이 같은지 확인
                return Integer.parseInt(paramValue); //같다면 스트링이였던 paramValue를 정수로 변환해 리턴.
            }
        }

        return defaultValue;
    }

    public String getpath() {
        String[] urlBits = url.split("\\?", 2);

        return urlBits[0];
    }
}
