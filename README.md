***도메인 설명 + ERD(또는 클래스 다이어그램) 1장***

**도메인 설명**
1. id : PK, 각 행을 구분하여 쿼리문을 효율적으로 작성하기 위한 column
2. name : 추천한 장소의 이름을 저장하기 위한 column, 255자 까지 입력 가능.
3. location : 추천한 장소의 위치를 저장 위한 column 255자 까지 입력 가능.
4. description : 추천된 장소의 대한 정보를 입력하는 column, 최대 TEXT 형식으로 저장되어 있음.

**ERD 사진**

![ERD 캡처](https://github.com/gunhee05090-bit/MakeAPI/blob/master/ERD%20%EC%BA%A1%EC%B2%98.png)



**API 명세 (메서드, URI, 요청/응답 DTO, 상태 코드)**
1. createForm, /restaurants/new
2. create, /restaurants/new, CreateRequestDto, FOUND(리다이렉션으로 재 등록되는 것을 방지)
3. FindForm, /restaurantf
4. list, /restaurants
5. FindOneForm, /restaurant
6. printOne, /restaurantOne
7. FindOne, /restaurantOne, FindRequestDto, FOUND(목록확인 HTML로 이동하기 위해 FOUND 상태코드 사용)
8. updateForm, /restaurants/update
9. updateFormlocation, /restaurants/update/location
10. updateFormDescription, /restaurants/update/description
11. updatelocation, /restaurants/update/location, UpdateRequestDto, FOUND(목록으로 쉽게 이동할 수 있도록 home("/")으로 리다이렉션)
12. updatedescription, /restaurants/update/description, UpdateRequestDto, FOUND(목록으로 쉽게 이동할 수 있도록 home("/")으로 리다이렉션)
13. deleteForm, /restaurants/delete
14. deleteRestaurant, /restaurants/delete, DeleteRequestDto, NO_CONTENT(삭제 완료가 되면 보낼 메세지 없음으로 인지하게 함.)

- Postman / `curl` / IntelliJ HTTP Client 중 하나로 모든 API를 호출한 스크린샷 또는 결과

![Home](https://github.com/gunhee05090-bit/MakeAPI/blob/master/Home.png)

![createform](https://github.com/gunhee05090-bit/MakeAPI/blob/master/createform.png)

![delete](https://github.com/gunhee05090-bit/MakeAPI/blob/master/delete.png)

![deleteform](https://github.com/gunhee05090-bit/MakeAPI/blob/master/deleteform.png)

![findOneform](https://github.com/gunhee05090-bit/MakeAPI/blob/master/findOneform.png)

![findhome](https://github.com/gunhee05090-bit/MakeAPI/blob/master/findhome.png)

![findlist](https://github.com/gunhee05090-bit/MakeAPI/blob/master/findlist.png)

![updatehome](https://github.com/gunhee05090-bit/MakeAPI/blob/master/updatehome.png)

![updatelocation](https://github.com/gunhee05090-bit/MakeAPI/blob/master/updatelocationform.png)

![updatedescription](https://github.com/gunhee05090-bit/MakeAPI/blob/master/updatedescriptionform.png)



- 강의에서 배운 내용 중 이번에 직접 써본 것 3가지
1. 응답에 상태코드를 직접 설정.
2. 새로운 테이블을 생성하고 엔티티와 테이블을 연결했으며 Column에 제한 조건을 붙여보았음.
3. 다양한 애노테이션을 사용하여 MVC를 형성하였으며, GET, POST, DELETE를 사용하여 데이터를 다루어 봄.


- **왜 Controller에서 엔티티를 직접 받지 않고 DTO로 분리했는지** 본인의 언어로 답하기
- Controller에서 엔티티를 직접 받는 경우 다음과 같은 문제가 발생할 수 있음
    1. 서비스에는 트렌젝션이 걸려 있지만 컨트롤러에는 걸려있지 않아서 충돌이 날 가능성이 존재함.
    2. 엔티티 그 자체를 움직이게 하는 것임으로 엔티티에 무결성을 망가지게 할 수 있음.


- 막혔던 부분 1가지와 어떻게 해결했는지
1. Dto 설계 : 최대한 많은 예시와 사용방법을 찾아서 정확한 방법으로 사용하려고 노력함.
2. Application 형성 불가 오류 : 코드를 직접 꼼꼼히 읽어보면서 오류가 발생한 부분을 찾아 수정함. 경로의 중복이나 자바의 버전, 테이블 등이
문제를 만들어냈으며 컨트롤러와 resource를 알맞게 조정하여 오류를 없앰.

