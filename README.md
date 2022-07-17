# LifeQuotes_SSG_Test1
혼자서 다시만드는 ssg 명언앱

## 목표 <br>
1차: ~~*CRUD 기능 구현하기 (ArrayList)*~~ <br>
2차: ~~*수정과 삭제기능 TDD*~~ <br>
3차: ~~*모듈화( Controller와 Repository로 나누기)*~~ <br>
4차-1: ~~*영속중 중 파일 저장, 불러오기 구현 TDD*~~ <br>
4차-2: *객체를 JSON으로 변환하여 저장, 불러오기 구현 TDD* <br>
4차-3: ~~*빌드 기능 구현*~~ <br><br>

*해시맵 도입X <br>
*JSON변환 X <br><br>

## 이슈

수정과 삭제 시

1. 목록 번호보다 넘어서면 IndexOutOfBoundsException 오류<br>

2.  id값에 아무것도 적지 않는다면 NumberFormatException 오류 <br>

3. 삭제 또는 수정만 적는다면 ArrayIndexOutOfBoundsException 오류 <br>

4. 삭제 또는 수정 뒤 ?까지만 적는다면 ArrayIndexOutOfBoundsException 오류

