# SimpleVariableLanguage
언어 제작시 변수를 용의하게 만들 수 있는 라이브러리 입니다. </br>

## Jar 파일 다운로드 링크
[모든 버전 다운로드]()</br>
[V1 다운로드]()</br>

# 사용법
jar 파일을 다운로드 후 라이브러리 들어가서 jar파일을 추가해 주세요.</br>
</br>

# 클래스
  - VariableType : 변수 타입을 정하는 클래스 입니다.
  - VariableSet : 변수를 저장하는 조건을 정하는 클래스 입니다.
  - VariableGet : 변수를 불러오는 조건을 정하는 클래스 입니다.

</br> 처음에 위 클래스를 new 하셔서 만들어주시고 사용하시면 됩니다.
</br> 일부 기능에 문제가 생길 수 있어 VariableType, VariableSet, VariableGet 순서로 생성하는 것을 추천드립니다.

## 클래스 설명
  VariableType variableType = new VariableType(...);
  - 첫번째 타입 설정 방법 (String startVar, String endVar, boolean mode)
    1. startVar : 해당 줄의 시작을 알리는 값
    2. endVar : 해당 줄의 마지막으 알리는 값
    3. mode : true 일때 공백을 제외한 처음과 끝이 startVar, endVar이여야함
  ```java
  예시1)
  VariableType variableType = new VariableType("시작", "마지막", true);
  위 조건일때 언어) 시작 안녕하세요. 마지막
  
  예시2)
  //false 일때 startVar, endVar 밖에 있는 ...음, 음... 은 무시하게 됩니다.
  VariableType variableType = new VariableType("시작", "마지막", false);
  위 조건일때 언어) 음... 시작 안녕하세요. 마지막 ...음
  ``` 
  
  - 첫번째 타입 설정 방법 (String var, Local local, boolean mode)
    1. var : 처음 또는 마지막에 들어가는 글자
    2. local : var이 처음에 시작하는 문자라면 Local.START, 마지막에 들어가는 문자라면 Local.END를 사용
    3. mode : 첫번째 타입 설정과 동일
    4. 설명 : local이 START일때는 var부터 마지막까지, local이 END라면 처음부터 var까지 값을 가져옴

  ```java
  예제1)
  VariableType variableType = new VariableType("시작", Local.START, true);
  위 조건일때 언어) 시작 안녕하세요.
  
  예제2)
  VariableType variableType = new VariableType("시작", Local.END, true);
  위 조건일때 언어) 안녕하세요. 시작
  ```
  
</br>

---

</br>
  
  VariableSet variableSet = new VariableSet(...);
  - 첫번째 타입 설정 방법 ()
    1. 설명 :타입 미설정이 가능합니다.
  
  - 두번째 타입 설정 방법 (String start, String end)
    1. start : 변수 맨앞에 오는 글짜
    2. end : 변수 맨마지막에 오는 글짜
  ```java
  예제)
  VariableSet variableSet = new VariableSet("아", "이");
  위 조건일때 언어) 아 변수명 이 (아변수명이)
  ```
  
  - 세번째 타입 설정 방법 (String var, Local local)
      1. var : 처음 또는 마지막에 오는 변수앞에 오는 글짜
      2. local : 처음에 오면 Local.START, 마지막에 오면 Local.END
      3. 설명 : VariableType과 첫번째 타입 설정 방법과 동일


</br>

---

</br>
  
  VariableGet variableGet = new VariableGet(...);
  - 첫번째 타입 설정 방법 ()
      1. 설명 : 이 클래스는 매개변수가 불필요합니다.


</br>

---

</br>


