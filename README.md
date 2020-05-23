# 여행복행
#### 우리나라 대표 휴양지인 제주도에 대한 다양한 정보를 제공하고 많은 사람들의 방문을 유도할 수 있는 프로젝트

[Project-study] ( https://github.com/JaeHyukSim/project-study/blob/master/README.md )
-------------

### 담당 부분과 기능
+ ERD 설계, 호텔 리스트, 호텔 디테일, 호텔 예약 시스템 구축
### 개발 기간
+ #### 2020-xx-xx ~ 2020-yy-yy
### 팀원 
+ 심재혁 김유진 김학민 신승호 조성빈
# 설명서 : 
	1.web.xml을 수정한다
		=> 수정 방법:
			1. app.xml을 우클릭해서 properties를 누른다.
			2. location을 복사한다 ex) C://어쩌구저쩌구...
			3. 이것을 경로에 맞게 수정한다 + src도 마찬가지로  
			
	2.app.xml을 수정한다.
			1. @Controller를 하려는 target Package를 beans태그 내에 놓는다.  
			
	3.패키지를 만든다.
			1.com.sist.자신이 맡은 부분.model을 만든다. - 이 위에 모델을 만든다
			2.                               .dao도 만들고, mapper도 만들고 다 만든다 + 
			3. Config.xml에 자신의 mapper를 등록한다
				=> alias : vo를 등록하고, mapper : mapper를 매핑한다  
				
	4.열심히 만든다 ^^  
	
	
	-참고하기-
			1.index.jsp를 실행시켜서 -> 여행상품 보기
			2. hotel관련된 패키지 보기 or WebContent의 views에서 hotel보기
			3. 자신 담당 탬플릿을 복사해서 자신 폴더로 가져오기(템플릿 수정하면 안됩니다!)
			4. 원래 템플릿 동작을 보고 싶다면, index.jsp에서 c:if문이 있는 div에서,
				내부 html문서를 전부 주석하고, 이미 주석이 된 부분을 푼다
			5. 마지막으로, 자신의 view로 접근하기 위해 main_01_header.jsp(template의 main폴더)
			에서 xxx.jsp?mode=yy 를, xxx.do로 바꾼다
      
   	picture_project2.png 을 참고하시오
