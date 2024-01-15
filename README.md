# NBC Admin Service

## 프로젝트 개요
내배캠은 다양한 학습 트랙을 제공하는 만큼 수많은 수강생을 효율적으로 관리할 필요가 있다. NBC 어드민 서비스는 이러한 요구사항을 해결하기 위한 사내 어드민 서비스다. 
NBC 어드민 서비스에서는 트랙을 학습하고 있는 수강생을 관리할 수 있고, 수강생에 따른 개인별 학습현항에 대해 관리할 수 있다.

## 기술 스택

- JDK 17
- Github
- IntelliJ ultimate

## 기술 명세서
- 수강생 관리
  - 수강생 정보를 등록할 수 있다.
    - 등록 필수 정보
      - 고유 번호
      - 이름
      - 과목 목록
    - 예외사항
      - 수강생의 고유번호가 중복된 경우
      - 선택한 필수 과목의 수가 3개 미만인 경우
  - 수강생 목록을 조회할 수 있다.
  - 조회된 수강생은 아래의 정보를 포함하고 있다.
    - 고유 번호
    - 이름
- 점수 관리 
  - 수강생의 과목별 시험 회차 및 점수를 등록할 수 있다.
  - 점수를 등록하면 자동으로 등급이 추가 저장된다.
    - [예외사항]
      - 등록하려는 과목의 회차 점수가 이미 등록되어 있는 경우
      - 회차에 10 초과 및 1 미만의 수를 입력한 경우
      - 점수에 100 초과 및 음수를 입력한 경우
  - 수강생의 과목별 회차 점수를 수정할 수 있다.
  - 수강생의 특정 과목 회차별 등급을 조회할 수 있다.
    - 조회된 정보에는 아래의 내용이 포함되어 있다.
      - 과목 타입
      - 회차
      - 등급
      - 점수


## 협업방법

- 진행사항
  - Github [Projects](https://github.com/users/Modafi/projects/4)를 통해서 진행 사항을 관리
   ![Screenshot 2024-01-15 at 2 28 51 PM](https://github.com/Modafi/NBC-admin-project/assets/155048724/1598733e-c7b5-4404-9d6a-668306f89d99)

- Git Convention
  - 이슈관리를 위해서 커밋은 이슈번호를 포함해서 작성
    - `[issue number] [commit message]`
    - `ex) #18 implement student manager`
- Pull Request
  - Pull Request 는 최소 2명의 리뷰어의 승인이 필요
  - Comment 내용이 없다면 `LGTM` 등의 확인 메시지 남기기
  - Force push 는 금지


## 클래스 다이어그램
<div align="center">  
  <img src="https://github.com/Modafi/NBC-admin-project/assets/155048724/2eeed2e3-a18d-4354-bd3a-ea3f83f9c34e" width=700 />
</div>


## 서비스 UI


## 회고
