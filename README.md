# SpringBoot&AWS Wab_Service

[이동욱](https://jojoldu.tistory.com/539) 님의 스프링 부트와 "[AWS로 혼자 구현하는 웹 서비스](https://www.google.com/search?q=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%99%80+aws%EB%A1%9C+%ED%98%BC%EC%9E%90+%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94+%EC%9B%B9%EC%84%9C%EB%B9%84%EC%8A%A4&oq=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%99%80+AWS&aqs=chrome.0.0l2j69i57j0l2j69i60.14329j1j7&sourceid=chrome&ie=UTF-8)" 를 보면서 공부하였습니다.

**Version**

* Spring Boot 2.4.1
* Gradle 6.7.1
* IntelliJ IDEA 2020.3
* JUnit 5



## INDEX

1. **[Intellij Springboot start](#1-intellij-springboot-start)**

   1.1 [Gradle 프로젝트를 Spring Boot 프로젝트로 변경하기](#11-gradle-프로젝트를-spring-boot-프로젝트로-변경하기)
   
   2.2 [인텔리제이에서 깃과 깃허브 사용하기](#22-인텔리제이에서-깃과-깃허브-사용하기)
   
2. **[스프링 부트에서 테스트 코드를 작성](#2-스프링-부트에서-테스트-코드를-작성)**

   2.1 [테스트 코드 소개](#21-테스트-코드-소개)
   
   2.2 [Hello Controller 테스트 코드 작성하기](#22-Hello-Controller-테스트-코드-작성하기)
   
   2.3 [롬복 소개 및 설치](#23_롬복_소개_및_설치)
   
   2.4 [HelloController 코드를 롬복으로 전환하기](#24_HelloController_코드를_롬복으로_전환하기)

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
   ```

   

   * {1} **RestController**
     * 컨트롤러를 JSON을 반환하여 컨트롤러로 만들어 준다.
     * 예전에는 @ResponseBody를 각 메소드마다 선언했던 것을 한번에 사용할 수 있게 해준다.
     
   * {2} **GetMapping**

     * HTTP Method인 Get의 요청을 받을 수 있는 API를 만들어 준다.
     * 이 프로젝트는 /hello로 요청이 오면 문자열 hello를 반환하는 기능을 가지게 되었다.

     

6. 테스트 코드를 검증하기 위해 main 디렉토리가 이난 test 디렉토리로 가서 위와 같이 com.allsser.book.springboot를 생성해 준다.

   ![testSpringboot](images/testSpringbook.PNG)

   

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
     * 여기서는 **SpringExtension (JUnit)**라는 스프링 실행자를 사용한다. (SpringRunner (Junit4))
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

