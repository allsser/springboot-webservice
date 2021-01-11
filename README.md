# SpringBoot&AWS Wab_Service

[이동욱](https://jojoldu.tistory.com/539) 님의 스프링 부트와 "[AWS로 혼자 구현하는 웹 서비스](https://www.google.com/search?q=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%99%80+aws%EB%A1%9C+%ED%98%BC%EC%9E%90+%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94+%EC%9B%B9%EC%84%9C%EB%B9%84%EC%8A%A4&oq=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%99%80+AWS&aqs=chrome.0.0l2j69i57j0l2j69i60.14329j1j7&sourceid=chrome&ie=UTF-8)" 를 보면서 공부하였습니다.

**Version**

* Spring Boot 2.4.1
* Gradle 6.7.1
* IntelliJ IDEA 2020.3
* JUnit 5



## INDEX

1. ### [Intellij Springboot start](#1-intellij-springboot-start)

   1.1 [Gradle 프로젝트를 Spring Boot 프로젝트로 변경하기](#11-gradle-프로젝트를-spring-boot-프로젝트로-변경하기)
   
   2.2 [인텔리제이에서 깃과 깃허브 사용하기](#22-인텔리제이에서-깃과-깃허브-사용하기)
   
2. ### [스프링 부트에서 테스트 코드를 작성](#2-스프링-부트에서-테스트-코드를-작성)

   2.1 [테스트 코드 소개](#21-테스트-코드-소개)
   
   2.2 [Hello Controller 테스트 코드 작성하기](#22-Hello-Controller-테스트-코드-작성하기)
   
   2.3 [롬복 소개 및 설치](#23-롬복-소개-및-설치)
   
   2.4 [HelloController 코드를 롬복으로 전환하기](#24-HelloController-코드를-롬복으로-전환하기)
   
3. ### [스프링 부트에서 JPA로 데이터베이스 다루기](#3-스프링-부트에서-JPA로-데이터베이스-다루기)

   3.1 [JPA란?](#31-JPA란)
   
   3.2 [프로젝트에 Spring Data Jpa 적용](#32-프로젝트에-Spring-Data-Jpa-적용)
   
   3.3 [Spring Data JPA 테스트 코드 작성](#33-Spring-Data-JPA-테스트-코드-작성)
   
   3.4 [등록/수정/조회 API 만들기](#34-등록수정조회-api-만들기)
   
   
   
   



---

### 1. Intellij Springboot start

#### 1.1 Gradle 프로젝트를 Spring Boot 프로젝트로 변경하기

* [스프링 이니셜라이저](https://start.spring.io/) 를 통해서 진행하면 편하지만, **build.gradle**를 사용하는 이유는 코드의 역할과 이니셜라이저 외에 추가로 의존성을 추가하는 방법을 배우기 위해서이다.

* Gradle5 -> Gradle6 로 바뀌면서 교재와는 달라진 부분이 있다. [참고 블로그](https://jojoldu.tistory.com/539)

* 버전 업데이트를 하기 위해서 CMD에서 기존 프로젝트가 있는 디렉토리로 이동한 후에 아래 명령어 입력

  > gradlew wrapper --gradle-version 6.7.1
  


**그레이들 프로젝트를 스프링 부트 프로젝트로 변경하기**

```build.gradle
plugins { //(1)
	id 'org.springframework.boot' version '2.4.1'
	id 'io.spring.dependency-management' version '1.0.10.RELEASE'
	id 'java'
}

group '그룹 id' // com.allsser.book
version '1.0.4-SNAPSHOT-'+new Date().format("yyyyMMddHHmmss)
sourceCompatibility = 1.8

repositories {
	mavenCentral()
	jcenter()
}

// for Junit5 가 되면서 추가 되었다.
test { //(2)
	useJUnitPlatform()
}

dependencies {
	// (3)
	implementation(org.springframework.book:spring-boot-starter-web')
	implementation(org.springframework.book:spring-boot-starter-mustache')
	
	// lombok
	implementation('org.projectlombok:lombok')
	annotationProcessor('org.projectlombok:lombok')
	testlmplementation('org.projectlombok:lombok')
	testAnnotationProcessor('org.projectlombok:lombok')
	
	implementation('org.stringframework.boot:spring-boot-starter-data-jpa')
	implementation("org.mariadb.jdbc:mariadb-java-client")
	implementation('com.h2database:h2')
	
	testlmplementation('org.springframework.boot:spring-boot-starter-test')
	
	// Spring Security 권한 부분이다.
	implementation('org.springframework.boot:spring-boot-starter-oauth2-client')
	implementation('org.springframework.session:spring-session-jdbc')
	
	testlmplementation("org.springframework.security:spring-security-test")
}
```

(1) plugins{ ... }

```

plugins {
	id 'org.springframework.boot' version '2.4.1' // Gradle6에서는 RELEASE 삭제
	
	id 'io.spring.dependency-management' version '1.0.10.RELEASE'
	// 스프링 부트의 의존성들을 관리해 주는 플러그인이라 꼭 추가해줘야 한다.
	
	id 'java'
}

repositories { // 각종 의존성 (라이브러리)들을 어떤 원격 저장소에서 받을지를 정한다.
    mavenCentral()
    jcenter() // 라이브러리 업로드 난이도 때문에 jcenter를 많이 쓴다.
    
    // 최근에 나온 jcenter 라이브러리는 업로드 하면 mavenCentral에도 업로드될 수 있도록 자동화를 할 	 // 수 있다.
    // mavenCentral, jcenter 둘 다 등록하여 사용
}
```

(2)  test { ... }

* JUnit5를 사용하기 위해서는 필수로 선언되어야 한다.

(3)  implementation, testlmplementation

* **Gradle 6가 되면서** compile, testCompile은 **Soft Deprecate** 되었다.
* 그대신 implementation, testlmplementation 가 추가되었다.
* 이에 관련된 [참고 블로그](https://jojoldu.tistory.com/538)

```(3)
dependencies { // 프로젝트 개발에 필요한 의존성들을 선언하는 곳이다.
	
	implementation(org.springframework.book:spring-boot-starter-web')
	// 기존 교재에서 사용한던 compile 메소드는 Gradle6 가 되면서 implementation으로 교체하여 사용
	// 하여야 한다.
	
	implementation(org.springframework.book:spring-boot-starter-mustache')
	...
	...
}
```



---

#### 2.2 인텔리제이에서 깃과 깃허브 사용하기

1. 인텔리제이에서 단축키**(Ctrl + Shift + A)**를 사용하여 **Action 검색창**을 열어 **share project on github**을 검색한다.

2. 깃허브 로그인 화면이 나오면 깃허브 계정으로 로인한다. **[Repository name]** 필드에 생성할 저장소 정보를 입력하면 등록한 이름으로 **깃허브 저장소가 생성**된다. (대부분의 프로젝트 이름을 깃허브 저장소와 같은 이름을 사용하니, 같은 이름을 등록하는 것이 좋다.)

3. 맨처음 동기화 과정에서 커밋 항목으로 추가할 것인지 묻는 안내문이 나올 경우 **No**을 선택한다. 그럼 프로젝트의 첫 번째 커밋을 위한 팝업창이 등장한다.

4. 팝업창에서 **.idea 디렉토리는 커밋하지 않는다.** 이유는 인텔리제이에서 프로젝트 **실행시 자동으로 생성되는 파일들**이기 때문에 깃허브에 올리기에는 불필요 하다.

5. .idea 폴더를 앞으로의 **모든 커밋 대상에서 제외되도록 처리하는 방법**은 **.gitignore 파일**을 사용한다. .gitignore 파일은 "이 파일 안에 기입된 내용들은 모두 깃에서 관리하지 않겠다."를 의미한다.

6. .gitignore 플러그인을 설치하기 위해서 단축키**(Ctrl + Shift + A)**를 사용하여 **Action 검색창**을 열어 **plugins**을 검색해서 플러그인을 열어 **Marketplace** 탭에서 **.ignore**을 검색하여 설치해준다. (**인텔리제이를 다시 시작해야만 설치한 플러그인이 적용된다.**)

7. 왼쪽 위의 프로젝트 오른쪽 클릭하거나 단축키**(Alt + Insert)**를 눌러 생성 목록을 열고나서 생성 목록 아래에 **[.ignore file -> gitignore file(Git)]**을 선택하여 .gitignore 파일을 생성시켜 준다.

8. 생성된 .gitignore 파일에 깃 체크 대상에서 제외하고 싶은 이름을 작성하면 된다.

   > .gradle
   >
   > .idea

9.  깃 커밋 창을 여는 단축키**(Ctrl + K)**를 눌러 커밋 메시지를 작성 후 푸쉬**(Ctrl + Shift + K)**를 해주면 된다.



----

### 2. 스프링 부트에서 테스트 코드를 작성

* 최근 대부분의 서비스 회사가 테스트 코드에 관해 요구를 하고 있다.

  

#### 2.1 테스트 코드 소개

* **TDD : 테스트가 주도하는 개발**

* **단위 테스트(Unit Test) : 테스트 코드를 먼저 작성**



**단위 테스트 코드를 작성하는 이유?**

> * 단위 테스트는 개발단계 초기에 문제를 발견하게 도와준다.
> * 단위 테스트는 개발자가 나중에 코드를 리팩토링하거나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는지 확인할 수 있다.
> * 단위 테스트는 기능에 대한 불확실성을 감소시킬 수 있다.
> * 단위 테스트는 시스템에 대한 실제 문서를 제공한다. 즉, 단위 테스트 자체가 문서로 사용할 수 있다.



**단위 테스트 코드를 사용하면 좋은 이유**

> * 코드 수정시 톰켓을 계속 올렸다 내렸다 할 필요가 없다. -> 테스트 코드를 사용하면 **자동검증**이 가능하다.
> * 개발자가 만든 기능을 안전하게 보호해준다.
> * 테스트 코드를 사용하면 문제를 조기에 찾을 수 있다.



**테스트 프레임워크로는 xUnit가 있다. 이는 개발환경(x)에 따라 Unit 테스트를 도와주는 도구라 생각하면 된다.**

>* JUnit - Java
>* DBUnit -DB
>* CppUnit - C++
>* NUnit - .net



#### 2.2 Hello Controller 테스트 코드 작성하기

1. 패키지 안에 있는 Java 디렉토리에 새로운 패키지**(New -> Package)**를 생성한다. 일반적으로  패키지 명은 **웹 사이트 주소의 역순**으로 한다. Ex) book.allsser.com(사이트의 주소 보통 Group Id 이다.)이라면 패키지 명은 com.allsser.book 이다. 최종적으로 springboot라는 프로젝트 명을 사용하여 com.allsser.book.springboot가 된다.

2. 새로 만든 패키지(com.allsser.book.springboot) 아래에 Java 클래스를 생성한다. 클래스의 이름은 Application으로 한다.

   ![Application](images/Application.PNG)

3. 아래와 같이 코드를 작성해 준다.

   ```Application
   import org.springframework.boot.SpringApplication;
   import org.springframework.boot.autoconfigure.SpringBootApplication;
   
   @SpringBootApplication	// {1}
   public class Application {
   	public static void main(String[] args) {
   		SpringApplicaiton.run(Application.class, args);	// {2}
   	}
   }
   ```
   
   
   
   * **Application 클래스**는 앞으로 만들 프로젝트의 **메인 클래스**이다.
   * {1} **@SpringBootApplication**으로 인해 스프링 부트의 자동 설정, 스프링 **Bean** 일기와 생성을 자동으로 설정된다.
   * {1}**@SpringBootApplication 이 있는 위치부터 설정을 읽기** 때문에 항상 **프로젝트 최상단에 위치하고 있어야 한다.**
* {2}main 메소드에서 실행하는 **SpringApplication.run**으로 인해 내장 *WAS를 실행시켜 준다.
  
```WAS
   WAS(Web Application Server, 웹 애플리케이션 서버)
   -내장 WAS란 외부에 WAS를 두지 않고 애플리케이션을 실행할 때 내부에서 WAS를 실행하는 것을 뜻한다.
   -이렇게 하면 항상 서버에 톰켓을 설치할 필요가 없어지게 되고, 스프링 부트로  만들어진 Jar 파일로 실행하면 된다.
   -내장 WAS를 사용하면 '언제 어디서나 같은 환경에서 스프링 부트를 배포'할 수 있다.
```

   

4. 테스트를 위한 **Controller**를 만들어야 한다. 위에 만든 패키지 하위에 **web 패키지를 만들어 준다.

   ![web](images/web.PNG)

   web 패키지 안에 **컨트롤러와 관련된 클래스들은 모두 이 패키지** 안에서 관리해 준다.

   

5. HelloController 라는 이름의 클래스를 만들어 준다.

   생성됬으면 간단한 API를 생성해 준다.

   ```HelloController
   import org.springframework.web.bind.annotation.GetMapping;
   import org.springframework.web.bind.annotation.RestController;
   
   @RestController	// {1}
   public class HelloController {
   
   	@GetMapping("/hello")}	// {2}
   	public String hello() {
   		return "hello";
   	}
   }
   ```

   

   * {1} **RestController**
     * 컨트롤러를 JSON을 반환하여 컨트롤러로 만들어 준다.
     * 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다.
     
   * {2} **GetMapping**

     * HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
     * 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 되었다.

     

6. 테스트 코드를 검증하기 위해 main 디렉토리가 이난 test 디렉토리로 가서 위와 같이 com.allsser.book.springboot를 생성해 준다.

   ![testSpringbook](images/testSpringBook.PNG)

   

7. 생성된 클래스에 아래와 같이 테스트 코드를 추가해 준다.

   ```HelloControllerText
   import org.junit.jupiter.api.Test;	// {1}
   import org.junit.jupiter.api.extension.ExtendWith;
   import org.springframework.beans.fectory.annotation.Autowired;
   import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
   import org.springframework.test.context.junit.jupiter.SpringExtension;
   import org.springframework.test.web.servlet.MockMvc;
   
   import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
   import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
   import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
   
   @Extend(SpringExtension.class)	// {2}
   @WebMvcTest(controllers = HelloController.class)	// {3}
   public class HelloControllerTset {
   
   	@Autowired	// {4}
   	private MockMvc mvc;	// {5}
   	
   	@Test
   	public void hello_to_return() throws Exception {
   		String hello = "hello";
   		
   		mvc.perform(get("/hello"))		// {6}
   				.andExpect(status().isOk())		// {7}
   				.andExpect(content().string(hello));	//{8}
   	}
   }
   ```

   * {1} **.Tset** 

     * JUnit4 에서 JUnit5로 넘어오면서 달라졌다.(교재에서는 JUnit4 사용, 현재 프로젝트는 JUnit5)
     * import 패키지 : org.junit.Test (JUnit4) -> **org.junit.jupiter.api.Tset (JUnit5)**

   * {2} **@Extend(SpringExtension.class)**

     * 어노테이션 : @RunWith (Junit4) -> **@Extend(JUnit5)**
     * import 패키지 : org.junit.runner.RunWith (Junit4) -> **org.junit.jupiter.api.extension.ExtenWith (JUnit5)**
     * 테스트를 진행할 떄 Junit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
     * 여기서는 **SpringExtension (JUnit)** 라는 스프링 실행자를 사용한다. (SpringRunner (Junit4))
     * 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 한다.

   * {3} **@WebMvcTest**

     * 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션이다.
     * 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
     * 단, @Service, @Component, @Repository 등은 사용할 수 없다.
     * 어기서는 컨트롤러만 사용하기 때문에 선언한다.

   * {4} **@Autowired**

     * 스프링이 관리하는 빈(bean)을 주입 받는다.

   * {5} **private MockMvc mvc**

     * 웹 API를 테스트할 때 사용한다.
     * 스프링 MVC 테스트의 시작점이다.
     * 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.

   * {6} **mvc.perfrom(get("/hello"))**

     * MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
     * 체이닝이 지원되어 아래와 같이 여러 검증 기능을 이어서 선언할 수 있다.

   * {7} **.andExpect(status().isOk())**

     * mvc.perform의 결과를 검증한다.
     * HTTP Header의 Status를 검증한다.
     * 우리가 흔히 알고 있는 200, 404, 500 등의 상태를 검증한다.
     * 여기서는 OK 즉, 200인지 아닌지를 검증한다.

   * {8} **.andExpect(content().string(hello))**

     * mvc.perform의 결과를 검증한다.
     * 응답 본문의 내용을 검증한다.
     * Controller에서 "hello"를 리턴하기 때문에 이 값이 맞는지 검증한다.

     

   (JUnit4 -> JUnit5 변경된 사항 [참고 블로그](https://jojoldu.tistory.com/539))

   

8. 테스트 코드 실행

   ![testCode](images/testCode.PNG)

   메소드의 왼쪽 화살표를 클릭하여 실행한다.

   

   ![testCodeOK](images/testCodeOK.PNG)

   테스트 코드가 성공하면 다음과 같이 나온다.

   

9. 수동으로 실행하여 정상적인 값 출력하기

   * Application.java 파일로 이동하여 **main 메소드의 왼쪽 화살표 버튼을 클릭**해 준다.

   ![ApplicationStart](images/ApplicationStart.PNG)

   * 실행해 보면 톰캣 서버가 8080 포트로 실행된 것을 로그에서 확인할 수 있다.

     ![Application8080](images/Application8080.PNG)

   * **localhost:8080/hello**로 접속하면 hello가 잘 나오는 것을 확인할 수 있다.

     ![localhost_hello](images/localhost_hello.PNG)

   * 테스트 코드의 결과와 같은 것을 확인할 수 있다. **테스트 코드는 꼭 따라 해야 한다.**그래야 견고한 소프트웨어를 만들수 있다. 절대 **수동으로 검증하고 테스트 코드를 작성하진 않는다.**
   * 교재 버전과 현재 실습 버전과 다르다. 만약, 교재 그대로 실습을 진행하게 되면 수동으로 실행시 localhost:8080/hello 로 접속하게 되면 "아이디와 비번을 쳐서 접속하라는 로그인 창"이 뜬다. (이거 버전때문인지 모르고 교재 그대로 진행했다가 로그인 창이 게속 열려서 고생했다. 버전 중요!!)



#### 2.3 롬복 소개 및 설치

* **자바 개발자들의 필수 라이브러리 롬복**

* 롬복은 자바 개발할 때 자주 사용하는 코드 **Getter, Setter, 기본생성자, toString 등**을 어노테니션으로 자동 생성해 준다.

* build.gradle에 **implementation('org.projectlombok:lombok')** 코드를 추가해 준다.

  ![build_lombok](images/build_lombok.PNG)

  ​			Refresh로 새로고침해서 라이브러리(의존성이라고도 한다)를 내려 반는다.

* 롬복을 설치하는 방법은 **플러그인 Action을 검색한다.(Ctrl + Shitf + A)**창이 열리면 **Plugins**를 검색하여 **Marketplace**로 이동하여 **"lombok"**을 검색한다. 검색결과에서 나온 **Lombok Plugin**버튼을 눌려 설치해 준다.

* 마지막으로 **Enable annotation processing**을 체크해 준다.

![lombokCheck](images/lombokCheck.PNG)

* 롬복은 프로젝트마다 설정해야 한다. 플러그인 설치는 한번만 하면 되지만, build.gradle에 라이브러리를 추가하는 것과 Enable annotation processing를 체크하는 것은 프로젝트마다 진행해야 한다.
* 롬복 설정을 했으니 이제 기존 코드를 **롬복으로 리팩토링**해준다.



#### 2.4 HelloController 코드를 롬복으로 전환하기

* **테스트 코드가 우리의 코드를 지켜주기 때문에** 롬복으로 변경하고 문제가 생기는지 돌려보면 알 수 있다.



1. web 패키지에 dto 패키지를 추가해 준다. 앞으로 **모든 응답 Dto는 이 Dto 패키지에 추가**하겠다. 이 패키지에 HelloResponseDto를 생성해 준다.

   ![Dto](images/Dto.PNG)

   

   HelloResponseDto 코드를 작성해 준다.

   ```HelloResponseDto
   import lombok.Getter;
   import lombok.RequiredArgsConstructor;
   
   @Getter	// {1}
   @RequiredArgsConstructor	// {2}
   public class HelloResponseDto {
   
   	private final String name;
   	private final int amount;
   
   }
   ```

   * {1} **@Getter**
     * 선언된 모든 필드의 get 메소드를 생성해 준다.
   * {2} **@RequiredArgsConstructor**
     * 선언된 모든 final 필드가 포함된 생성자를 생성해준다.
     * final이 없는 필드는 생성자에 포함되지 않는다.

   

2.  이 Dto에 적용된 롬복이 잘 작동하는지 간단한 테스트 코드를 작성한다.

   * 테스트 코드의 작성은 위와 같이  똑같은 패키지를 추가해주고 작성한다.

     ![dtoTest](images/dtoTest.PNG)

   * HelloRespnseDtoTest 클래스의 코드를 추가해 준다.

     ```HelloResponseDtoTest
     import org.junit.Tset;
     import static org.assertj.core.api.Assertions.assertThat;
     
     public class HelloResponseDtoTest {
     	
     	@Test
     	public void 롬복_기능_테스트() {
     		//given
     		String name = "test";
     		int amount = 1000;
     		
     		//when
     		HelloResponseDto dto = new HelloResponseDto(name, amount);
     		
     		//then
     		assertThat(dto.getName()).isEqualTo(name);	// {1}, {2}
     		assertThat(dto.getAmount()).isEqualTo(amount);
     	}
     }
     ```

   * {1} **assertThat**

     * assertj라는 테스트 검증 라이브러리의 검증 메소드이다.
     * 검증하고 싶은 대상을 메소드 인자로 받는다.
     * 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있다.

   * {2} **isEqualTo**

     * assertj의 동등 비교 메소드이다.
     * assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공이다.

   * 테스트 결과

     ![dtoTestResult](images/dtoTestResult.PNG)

   * 정상적으로 기능을 수행하는 것을 확인해 볼 수 있다. 롬복의 **@Getter**로 **get 메소드**가, **@RequiredArgsConstructor**로 생성자가 자동으로 생성되는 것이 증명되었다.

     

3.  HelloController에도 새로 만든 ResponseDto를 사용하도록 코드를 추가해 준다.

   ```HelloController
   @GetMapping("/hello/dto")
   public HelloResponseDto helloDto(@RequestParam("name") String name,	// {1}
   								 @RequestParam("amount") int amount) {
   								 
   	return new HelloResponseDto(name, amount);
   	
   }
   ```

   * {1} **@RequestParam**

     * 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션이다.
     * 여기서는 외부에서 name (@RequestParam("name")) 이란 이름으로 파라미터를 메소드 파라미터 name(String name)에 저장하게 된다.

   * name과 amount는 API를 호출하는 곳에서 넘겨준 값들이다. 추가된 API를 테스트 하는 코드를 HelloControllerTest에 추가한다,

     ```HelloControllerTest
     import org.junit.jupiter.api.Test;
     import org.junit.jupiter.api.extension.ExtendWith;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
     import org.springframework.test.context.junit.jupiter.SpringExtension;
     import org.springframework.test.web.servlet.MockMvc;
     
     import static org.hamcrest.Matchers.is;
     import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
     import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
     
     @ExtendWith(SpringExtension.class)
     @WebMvcTest(controllers = HelloController.class)
     public class HelloControllerTest {
     
         @Autowired
         private MockMvc mvc;
     
         @Test
         public void hello_to_return() throws Exception {
             String hello = "hello";
     
             mvc.perform(get("/hello"))
                     .andExpect(status().isOk())
                     .andExpect(content().string(hello));
         }
     
         @Test
         public void helloDto가_리던된다() throws Exception {
             String name = "hello";
             int amount = 1000;
     
             mvc.perform(get("/hello/dto")
             		.param("name", name)	// {1}
             		.param("amount", String.valueOf(amount)))
                     .andExpect(status().isOk())
                     .andExpect(jsonPath("$.name", is(name)))	// {2}
                     .andExpect(jsonPath("$.amount", is(amount)));
         }
     }
     ```

   * {1} **param**

     * API 테스트할 때 사용할 요청 파라미터를 설정한다.
     * 단, 값은 String만 허용한다.
     * 그래서 숫자/날짜 드으이 데이터도 등록할 때는 문자열로 변경해야만 가능하다.

   * {2} **jsonPath**

     * JSON 응답값을 필드별로 검증할 수 있는 메소드이다.
     * $를 기준으로 필드명을 명시한다.
     * 여기서는 name과 amount를 검증하니 $.name, $.amount로 검증한다.

   * 테스트 실행 결과 JSON이 리턴되는 API 역시 정상적으로 테스트가 통과하는 것을 확인할 수 있다.

      ![dtoTestResult](images/dtoTestResult.PNG)



---

### 3. 스프링 부트에서 JPA로 데이터베이스 다루기

* 보통 스프링을 배울 때 MyBatis(iBatis)와 같은 SQL Mapper를 이용하여 테이터베이스 쿼리를 작성했다. 그러다 보니 실제로 개발하는 시간보다 SQL을 다루는 시간이 더 많을 경우도 있다.
* 위의 문제를 해결하기 위해 **JPA라는 자바 표준 ORM(Object Relational Mapping)**기술을 사용하게 되었다.
* **ORM**은 **객체를 매핑**하는 것이고, **SQL Mapper(MyBatis, iBatis)**는 **쿼리를 매핑**한다.
* 아직 SI 환경에서는 **Spring & MyBatis**를 많이 사용하지만, 자사 서비스를 개발하는 곳에서는 **SpringBoot & JPA**를 전사 표준으로 사용하고 있다. 기존 프로젝트 환경을 개편하는 곳들도 대부분 JPA를 선택하고 있다.



#### 3.1 JPA란?

* 현대의 웹 애플리케이션에서 **관계형 데이터베이스(RDB, Relational Database)**는 빠질 수 없는 요소이다. **Oracle, MySQL, MSSQL** 등을 쓰지 않는 애플리케이션은 거의 없다. 그러다 보니 **객체를 관계형 데이터베이스에서 관리**하는 것이 무엇보다 중요하다.
* 현업 프로젝트의 대부분이 **애플리케이션 코드보다 SQL**로 가득 차 있다. 이는 관계형 데이터베이스가 SQL만 가능하니 각 테이블마다 기본적인 **CRUD(Create, Read, Update, Delete) SQL**을 매번 생성해야 한다.
* 이러다보니 자바 클래스를 아름답게 설계해도, SQL을 통해서만 데이터베이스에 저장하고, 조회할 수 있다. 결국, 관계형 데이터베이스를 사용해야만 하는 상황에서 **SQL은 피할 수 없다.**
* 단순 반복 작업의 문제 외에도 **패러다임 불이치** 문제가 있다. 관계형 데이터베이스는 **어떻게 데이터를 저장**할지에 초점이 맞춰진 기술이고, 반대로 객체지향 프로그래밍 언어는 메시지를 기반으로 **기능과 속성을 한 곳에서 관리**하는 기술이다. 관계형 데이터베이스와 객체지향 프로그래밍 언어의 패러다임이 서로 다른데, 객체를 데이터베이스에 저장하려고 하니 여러 문제가 발생한다. 이를 **패러다임 불이치**라고 한다.
* **JAP**가 이런 문제점을 해결하기 위해 등장했다. 서로 지향하는 바가 다른 2개 영역을 **중간에서 패러다임 일치**를 시켜주기 위한 기술이다.
* 즉, 개발자는 **객체지향적으로 프로그래밍을 하고**, JPA가 이를 관계형 데이터베이스에 맞게 SQL을 대신 생성해서 실행한다. 개발자는 항상 객체 지향적으로 코드를 표현할 수 있으니 더는 **SQL에 종속적인 개발을 하지 않아도 된다.**



**3.1.1 Spring Data JPA**

* JPA는 인터페이스로서 자바 표준명세서이다. 인터페이스인 JPA를 사용하기 위해서는 구현체가 필요하다. 대표적으로 Hibernate, Eclipse Link 등이 있다. 하지만 Spring에서 JPA를 사용할 때는 이 구현체들을 직접다루지 않는다.
* 구현체들을 좀 더 쉽게 사용하고자 추상화시킨 **Spring Data JPA**라는 모듈을 이용하여 JPA 기술을 다룬다.
  * 관계 JPA <- Hibernate <- Spring Data JPA
* Hibernate를 쓰는 것과 Spring Data JPA를 쓰는 것 사이에는 큰 차이가 없다. 그러나 스프링 진영에서는 Spring Data JPA를 개발했고, 이를 권장하고 있다. 이렇게 한 단계 더 감싸놓은 Spring Data JPA가 등장한 이유는 두 가지가 있다.
  * 구현체 교체의 용의성 - Hibernate 외에 다른 구현체로 쉽게 교체하기 위함이다.
  * 저장소 교체의 용의성 - 관계형 데이터베이스 외의 다른 저장소로 쉽게 교체하기 위함이다.



**3.1.2 실무에서 JPA**

* 실무에서 **높은 러닝 커브** 때문에 JPA를 사용하지 못한다. JPA를 잘 쓰려면 **객체지향 프로그래밍과 관계형 데이터베이스**를 둘 다 이해해야 하기 때문이다.
* JPA를 사용하면 이득이 크다. **CRUD 쿼리를 직접 작성할 필요가 없고, 부모-자식 관계 표현, 1:N 관계 표현, 상태와 행위를 한 곳에서 관리하는 등 객체지향 프로그래밍을 쉽게**할 수 있다.
* JPA에서 여러 성능 이슈 해결책들을 이미 준비해놓은 상태이기 때문에 이를 잘 활용하면 네이티브 쿼리만큼의 퍼포먼스를 낼 수 있다.



#### 3.2 프로젝트에 Spring Data Jpa 적용

* 먼저 build.gradle에 다음과 같이 **org.springframework.boot:spring-boot-starter-jpa**와 **com.h2.database:h2** 의존성들을 등록한다.

  ```build.gradle
  dependencies {
  	implementation('org.springframework.boot:spring-boot-starter-data-jpa')	// {1}
  	implementation('com.h2database:h2')	// {2}
  }
  ```

  * {1} **spring-boot-starter-data-jpa**
    * 스프링 부트용 Spring Data Jpa 추상화 라이브러리이다.
    * 스프링 부트 버전에 맞춰 자동으로 JPA관련 라이브러리들의 버전을 관리해 준다.
  * {2} **h2**
    * 인메모리 관계형 데이터베이스이다.
    * 별도의 설치가 필요 없이 프로젝트 의존성만으로 관리할 수 있다.
    * 메모리에서 실행되기 때문에 애플리케이션을 재시작할 때마다 초기화된다는 점을 이용하여 테스트 용도로 많이 사용된다.
    * 이 프로젝트에서는 JPA의 테스트로 로컬 환경에서의 구동에서 사용할 예정이다.

* 의존성이 등록되었다면, JPA 기능을 사용해 보자. **domain 패키지**를 추가해 준다.

  ![domain](images/domain.PNG)

  * 이 domain 패키지는 **도메인을 담을 패키지**이다. 여기서 도메인이란 **게시글, 댓글, 회원, 정산, 결제 등 소프트웨어에 대한 요구사항 혹은 문제 영역**이라고 생각하면 된다.
  * 기존에 MyBatis와 같은 쿼리 매퍼를 사용했다면 dao 패키지를 떠올리겠지만, dto 패키지와는 조금 결이 다르다고 생각하면 된다. xml에 쿼리를 담고, 클래스는 오직 쿼리의 결과만 담던 일들이 모두 **도메인 클래스라고 불리는 곳에서 해결**된다.

* domain 패키지에 **posts 패키지와 Posts 클래스**를 만들어 준다.

  ![posts](images/posts.PNG)
  * Posts 클래스 코드

  ```Posts
  import lombok.Builder;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  
  import javax.persistence.*;
  
  @Getter	// {6}
  @NoArgsConstructor	// {5}
  @Entity	// {1}
  public class Posts {
  
  	@Id	// {2}
      @GeneratedValue(strategy = GenerationType.IDENTITY)	// {3}
      private Long id;
  
      @Column(length = 500, nullable = false)	// {4}
      private String title;
  
      @Column(columnDefinition = "TEXT", nullable = false)
      private String content;
  
      private String author;
  
      @Builder	// {7}
      public Posts(String title, String content, String author) {
          this.title = title;
          this.content = content;
          this.author = author;
      }
  }
  ```

  *  @Entity는 JPA의 어노테이션이며, @Getter, @NoArgsConstructor는 롬복의 어노테이션이다. 위와 같이 주요 어노테이션인 @Entity 위에 롬복 어노테이션들을 놓았다. 이렇게 하면 이후 **코틀린 등의 새 언어 전환으로 롬복이 더이상 필요 없을 경우** 쉽게 삭제할 수 있다.

  * **Posts 클래스**는 **실제 DB의 테이블과 매칭될 클래스**이며 보통 **Entity 클래스**라고도 한다. JPA를 사용하면 DB 데이터에 작업할 경우 실제 쿼리를 날리기보다는, 이 Entity 클래스의 수정을 통해 작업을 한다.

  * {1} **@Entity (JPA)**

    * 테이블과 링크될 클래스임을 나타낸다.
    * 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블 이름을 매칭한다.
    * ex) SalesManager.java -> sales_manager table

  * {2} **@Id (JPA)**

    * 해당 테이블의 PK 필드를 나타낸다.

  * {3} **@GeneratedValue (JPA)**

    * PK의 생성 규칙을 나타낸다.
    * 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment가 된다.

  * {4} **@Column (JPA)**

    * 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 된다.
    * 사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    * 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용한다.

  * {5} **@NoArgsConstructor (lombok)**

    * 기본 생성사 자동 추가
    * public Posts() {} 와 같은 효과

  * {6} **@Getter (lombok)**

    * 클래스 내 모든 필드의 Getter 메소드를 자동생성

  * {7} **@Builder (lombok)**

    * 해당 클래스의 빌더 패턴 클래스를 생성
    * 생성자 상단에서 선언 시 생성자에 포함된 필드만 빌더에 포함

  * 이 Posts 클래스에는 한 가지 특이점이 있는데, 바로 **Setter 메소드가 없다**는 점이다. 자바빈 규약을 생각하면서 **getter/setter를 무작정 생성**하는 경우가 있다. 이렇게 되면 해당 클래스의 인스턴스 값들이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수 없어, 차후 기능 변경 시 정말 복잡해 진다.

  * 그래서 **Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.** 대신. 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야 한다.

    ex) 주문 취소 메소드

  ```Oder
  // 잘못된 사용 예
  public class Order{
  	public void setStatus(boolean status){
  		this.status = status
  	}
  }
  
  public void 주문서비스의_취소이벤트() {
  	order.setStatus(false);
  }
  --------------------------------------------------------------------------------------
  // 올바른 사용 예
  public class Order{
  	public void cancelOrder() {
  		this.status = false;
  	}
  }
  
  public void 주문서비스의_취소이벤트() {
  	order.cencelOrder();
  }
  ```

  * **Setter가 없는 상황에서 어떻게 값을 채워 DB에 삽입(Inset)해야 할까?** 생성자 대신 **@Builder를 통해 제공되는 빌더 클래스**를 상용한다. 생성자난 빌더나 생성자 시점에 값을 채워주는 역할은 똑같다.

* Posts 클래스 생성이 끝나면, Posts 클래스로 Database를 접근하게 해줄 **JapRepository**를 생성해 준다.

  ![PostsRepository](images/PostsRepository.PNG)

  ```PostsRepository
  import org.springframework.data.jpa.repository.JapRepository;
  
  pulic interface PostsRepository extends JpaRepository<Posts, Long> {
  
  }
  ```

  * 보통 ibatis나 MyBatis 등에서 Dao라고 불리는 DB Layer 접근자이다.
  * JPA에선 **Repository**라고 부르며 **인터페이스**로 생성한다. 인터페이스 생성후, **JpaRepository<Entity 클래스, PK 타입>**를 상송하면 기본적인 **CRUD 메소드가 자동적으로 생성**된다.
  * **@Repository를 추가할 필요도 없다.** 여기서 주의할 점은 **Entity 클래스와 기본 Entity Repository는 함께 위치**해야 한다.



#### 3.3 Spring Data JPA 테스트 코드 작성

* test 디렉토리에 domain.posts 패키지를 생성하고, 테스트 클래스는 PostsRepositoryTest란 이름으로 생성한다.

  ![PostsRepositoryTest](images/PostsRepositoryTest.PNG)

* PostsRepositoryTest에서는 다음과 같이 **save, findAll** 기능을 테스트 한다.

  ```PostsRepositoryTest
  import com.allsser.book.springboot.domain.posts.Posts;
  import com.allsser.book.springboot.domain.posts.PostsRepository;
  import org.junit.jupiter.api.AfterEach;
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.extension.ExtendWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.test.context.junit.jupiter.SpringExtension;
  
  import java.util.List;
  
  import static org.assertj.core.api.Assertions.assertThat;
  
  @ExtendWith(SpringExtension.class)
  @SpringBootTest
  public class PostsRepositoryTest {
  
      @Autowired
      PostsRepository postsRepository;
  
      @AfterEach	// {1}
      public void cleanup() {
          postsRepository.deleteAll();
      }
  
      @Test
      public void 게시글저장_불러오기() {
          // given
          String title = "테스트 게시글";
          String content = "테스트 본문";
  
          postsRepository.save(Posts.builder()	//	{2}
                  .title(title)
                  .content(content)
                  .author("allsser@naver.com")
                  .build());
  
          //  when
          List<Posts> postsList = postsRepository.findAll();	// {3}
  
          // then
          Posts posts =postsList.get(0);
          assertThat(posts.getTitle()).isEqualTo(title);
          assertThat(posts.getContent()).isEqualTo(content);
      }
  }
  ```

  * {1} **@AfterEach**

    * 어노테이션 : @After (JUnit4) -> **@AfterEach (JUnit5)**
    * import 패키지 : org.junit.After (JUnit4) -> **org.junit.jupiter.api.AfterEach (JUnit5)**
    * JUnit에서 단위 테스트가 끝날 떄마다 수행되는 메소드를 지정
    * 보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용한다.
    * 여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다른 테스트 실행 시 테스트가 실패할 수 있다.

  * {2} **postsRepository.save**

    * 테이블 posts에 insert/update 쿼리를 실행한다.
    * id 값이있다면 update가, 없다면 insert 쿼리가 실행된다.

  * {3} **postsRepository.findAll**

    * 테이블 posts에 있는 모든 데이터를 조회해오는 메소드이다.

  * 별다른 설정 없이 **@SpringBootTest**를 사용할 경우 **H2 데이터베이스**를 자동으로 실행해 준다.

    

* 테스트 결과

  ![PostsRepositoryTestResult](images/PostsRepositoryTestResult.PNG)



* 실제로 실행된 쿼리의 형태 확인하기

  * 스프링 부트에서 쿼리 로그를 확인하기 위해 **application.properties, application.yml 등**의 파일로 **한 줄의 코드로 설정**할 수 있도록 지원하고 있다.

  * src/main/resources 디렉토리 아래에 application.properties 파일을 생성한다.

    ![application.properties](images/application.properties.PNG)

  * application.properties에 옵션을 추가해 준다.

    > spring.jpa.show_sql = true

  * 테스트를 추가한 후, 콘솔을 확인해 보면 쿼리 로그를 확인할 수 있다.

    ![logCheck](images/logCheck.PNG)

  * create table 쿼리를 보면 **id bigint generated by default as identiy**라는 옵션으로 생성되어 있다. 이는 **H2의 쿼리 문법**이 적용되었기 때문이다. H2는 **MySQL의 쿼리**를 수행해도 정상적으로 작동하기 때문에 이후 디버깅을 위해서 **출력되는 쿼리 로그를 MySQL 버전**으로 변경한다.

  * application.properties에서 설정이 가능하다.

    > ```
    > spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
    > spring.jpa.properties.hibernate.dialect.storage_engine=innodb
    > spring.datasource.hikari.jdbc-url=jdbc:h2:mem:testdb;MODE=MYSQL
    > spring.datasource.hikari.username=sa
    > ```

    ![logCheckMySQL](images/logCheckMySQL.PNG)

    옵션이 잘 설정된 것을 확인할 수 있다.

  * 만약,  테스트중 오류가 발생하면 [참고 블로그](https://jojoldu.tistory.com/539) 참고한다.



#### 3.4 등록/수정/조회 API 만들기

