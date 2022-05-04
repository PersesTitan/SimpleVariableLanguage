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
  VariableType variableType = new VariableType("시작", "마지막", false);
  위 조건일때 언어) 음... 시작 안녕하세요. 마지막 ...음
  ``` 
  
  - 첫번째 타입 설정 방법 (String var, Local local, boolean mode)
    1. var : 
