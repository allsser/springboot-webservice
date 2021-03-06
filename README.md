# SpringBoot&AWS Wab_Service
![Springboot](https://user-images.githubusercontent.com/34361309/109689959-31423e80-7bc9-11eb-9a60-c3c125367f35.PNG)

[이동욱](https://jojoldu.tistory.com/539) 님의 스프링 부트와 "[AWS로 혼자 구현하는 웹 서비스](https://www.google.com/search?q=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%99%80+aws%EB%A1%9C+%ED%98%BC%EC%9E%90+%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94+%EC%9B%B9%EC%84%9C%EB%B9%84%EC%8A%A4&oq=%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8%EC%99%80+AWS&aqs=chrome.0.0l2j69i57j0l2j69i60.14329j1j7&sourceid=chrome&ie=UTF-8)" 를 보면서 공부하였습니다.

**Version**

* Spring Boot 2.4.1
* Gradle 6.7.1
* IntelliJ IDEA 2020.3
* JUnit 5
* MariaDB 10.4.8
* java 8



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
   
   3.5 [JPA Auditing으로 생성시간/수정시간 자동화하기](#35-jpa-auditing으로-생성시간수정시간-자동화하기)
   
4. ### [머스테치로 화면 구성하기](#4-머스테치로-화면-구성하기)

   4.1 [서버 템플릿 엔진과 머스테치](#41-서버-템플릿-엔진과-머스테치)

   4.2 [기본 페이지 만들기](#42-기본-페이지-만들기)

   4.3 [게시글 등록 화면 만들기](#43-게시글-등록-화면-만들기)

   4.4 [전체 조회 화면](#44-전체-조회-화면)

   4.5 [게시글 수정, 삭제 화면](#45-게시글-수정-삭제-화면)

5. ### [스프링 시큐리티와 OAuth 2.0으로 로그인 기능 구현](#5-스프링-시큐리티와-oauth-20으로-로그인-기능-구현)

   5.1 [스프링 시큐리티와 스프링 시큐리티 Oauth2 클라이언트](#51-스프링-시큐리티와-스프링-시큐리티-oauth2-클라이언트)

   5.2 [구글 서비스 등록](#52-구글-서비스-등록)

   5.3 [구글 로그인 연동](#53-구글-로그인-연동)
   
   5.4 [어노테이션 기반으로 개선](#54-어노테이션-기반으로-개선)
   
   5.5 [세션 저장소로 데이터베이스 사용](#55-세션-저장소로-데이터베이스-사용)
   
   5.6 [네이버 로그인](#56-네이버-로그인)
   
   5.7 [기존 테스트에 시큐리티 적용](#57-기존-테스트에-시큐리티-적용)
   
6. ### [AWS 서버 환경을 만들기 - AWS EC2](#6-aws-서버-환경을-만들기---aws-ec2)

   6.1 [AWS 회원가입](#61-aws-회원가입)
   
   6.2 [EC2 인스턴스 생성](#62--ec2-인스턴스-생성)
   
   6.3 [EC2 서버에 접속](#63-ec2-서버에-접속)
   
   6.4 [아마존 리눅스 2 서버 생성 시 꼭 해야 할 설정](#64-아마존-리눅스-2-서버-생성-시-꼭-해야-할-설정)
   
7. ### [AWS에 데이터베이스 환경을 만들기 (AWS RDS)](#7-aws에-데이터베이스-환경을-만들기-aws-rds)

   7.1 [RDS 인스턴스 생성하기](#71-rds-인스턴스-생성하기)

   7.2 [RDS 운영환경에 맞는 파라미터 설정하기](#72-rds-운영환경에-맞는-파라미터-설정하기)

   7.3 [내 PC에서 RDS에 접속](#73-내-pc에서-rds에-접속)

   7.4 [EC2에서 RDS에서 접근 확인](#74-ec2에서-rds에서-접근-확인)

8. ### [EC2 서버에 프로젝트를 배포](#8-ec2-서버에-프로젝트를-배포)

   8.1 [EC2에 프로젝트 Clone 받기](#81-ec2에-프로젝트-clone-받기)

   8.2 [배포 스크립트 만들기](#82-배포-스크립트-만들기)

   8.3 [외부 Security 파일 등록](#83-외부-security-파일-등록)

   8.4 [스프링 부트 프로젝트로 RDS 접근하기](#84-스프링-부트-프로젝트로-rds-접근하기)

   8.5 [EC2에서 소셜 로그인하기](#85-ec2에서-소셜-로그인하기)

9. ### [코드가 푸시되면 자동으로 배포 (Travis CI 배포 자동화)](#9-코드가-푸시되면-자동으로-배포travis-ci-배포-자동화)

   9.1 [CI & CD 소개](#91-ci--cd-소개)

   9.2 [Travis CI 연동하기](#92-travis-ci-연동하기)

   9.3 [Travis CI와 AWS S3 연동하기](#93-travis-ci와-aws-s3-연동하기)

   9.4 [Travis CI와 AWS S3, CodeDeploy 연동하기](#94-travis-ci와-aws-s3-codedeploy-연동하기)

   9.5 [배포 자동화 구성]() -- 수정 필요

   9.6 [CodeDeploy 연동하기](#96-codedeploy-로그-확인)

10. ### [24시간 365일 중단 없는 서비스 만들기](#10-24시간-365일-중간-없는-서비스-만들기)

    10.1 [무중단 배포 소개](#101-무중단-배포-소개)

    10.2 [엔진엑스 설치와 스프링 부트 연동하기](#102-엔진엑스-설치와-스프링-부트-연동하기)

    10.3 [무중단 배포 스크립트 만들기](#103-무중단-배포-스크립트-만들기)

    10.4 [무중단 배포 테스트](#104-무중단-배포-테스트)

---

### 1. Intellij Springboot start

#### 1.1 Gradle 프로젝트를 Spring Boot 프로젝트로 변경하기

* [스프링 이니셜라이저](https://start.spring.io/) 를 통해서 진행하면 편하지만, **build.gradle**를 사용하는 이유는 코드의 역할과 이니셜라이저 외에 추가로 의존성을 추가하는 방법을 배우기 위해서이다.

* Gradle5 -> Gradle6 로 바뀌면서 교재와는 달라진 부분이 있다. [참고 블로그](https://jojoldu.tistory.com/539)

* 버전 업데이트를 하기 위해서 CMD에서 기존 프로젝트가 있는 디렉토리로 이동한 후에 아래 명령어 입력

  > * gradlew wrapper --gradle-version 6.7.1
  >
  > * 만약 'gradlew' 설치가 안되있다면 cmd에 들어가 프로젝트 파일에 들어간 후 gradlew build 입력
  

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
   
   @ExtendWith(SpringExtension.class)	// {2}
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

   * {2} **@ExtendWith(SpringExtension.class)**

     * 어노테이션 : @RunWith (Junit4) -> **@ExtendWith(JUnit5)**
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

API를 만들기 위해 총 3개의 클래스가 필요하다.

* Request 데이터를 받을 Dto
* API 요청을 받을 Controller
* 트렌젝션, 도메인 기능 간의 순서를 보장하는 Service 



**Service에서 비즈니스 로직을 처리하는 것이 아니고, 트랜잭션, 도메인 간 순서 보장**의 역할을 한다.

> Spring 웹 계층

![springWebLayer](images/springWebLayer.PNG)

* **Web Layer**
  * 웹 어플리케이션의 최상위에 존재하고 있다.
  * 흔히 사용하는 컨트롤러(@Controller)와 JSP/Freemarket 등의 뷰 템플릿 영역이다.
  * 필터(@Filter), 인터셉트, 컨트롤러 어드바이스(@ControllerAdvice) 등 **외부 요청과 응답**에 대한 전반적인 영역이다.
  * 
* **Service Layer**
  * 트랜잭션에 대한 경계 역할을 하며 어플리케이션과 인프라 서비스 모두 포함하고 있다.
  * @Service에 사용되는 서비스 영역이다.
  * Controller와 Dao의 중간 영역에서 사용된다.
  * @Transactional이 사용되어야 하는 영역이다.
  * 
* **Repository Layer**
  * Database와 같이 데이터 저장소에 접근하는 영역이다.
  * Dao(Data Access Object) 영역으로 이해하면 된다.
  * 
* **DTOs**
  * Dto(Data Transfer Object)는 **계층 간에 데이터 교환을 위한 객체**를 이야기 하며 Dtos는 이들의 영역을 뜻한다.
  * 단순히 데이터를 저장하는 컨테이너며 서로 다른 프로세스와 어플리케이션 계층간에 데이터를 전달하는데 사용한다.
  * 

* **Domain Model**
  * 도메인이라 불리는 개발 대상을 모든 사람이 동일한 관점에서 이해할 수 있고 공유할 수 있도록 단순화시킨 것을 도메인 모델이라고 한다.
  * 이를테면 택시 앱이라고 하면 배차, 탑승, 요금 등이 모두 도메인이 될 수 있다.
  * @Entity를 사용해본 사람들은 @Entity가 사용된 영역 역시 도메인 모델이라고 이해해 주면 된다.
  * 다만, 무조건 데이터베이스의 테이블과 관계가 있어야만 하는것은 아니다.
  * VO(Value Object)처럼 값 객체들도 이 영역에 해당하기 때문이다.
  * 
* **Web, Service, Repository, Dto, Domain**이 5가지 레이어에서 비지니스 처리를 담당해야 할 곳이 바로 **Domain**이다.



**등록, 수정, 삭제 기능을 만들기**

* PostsApiController를 web패키지에, PostsSaveRequestDto를 web.dto 패키지에, PostsService를 service.posts 패키지에 생성한다.

  ![등록,수정,삭제](images/등록,수정,삭제.PNG)

* **PstsApiController**

  ```PostsApiController
  import com.allsser.book.springboot.service.posts.PostsService;
  import com.allsser.book.springboot.web.dto.PostsResponseDto;
  import com.allsser.book.springboot.web.dto.PostsSaveRequesrDto;
  import com.allsser.book.springboot.web.dto.PostsUpdateRequestDto;
  import lombok.RequiredArgsConstructor;
  import org.springframework.web.bind.annotation.*;
  
  @RequiredArgsConstructor
  @RestController
  public class PostsApiController {
  
      private final PostsService postsService;
  
      @PostMapping("/api/v1/posts")
      public Long save(@RequestBody PostsSaveRequesrDto requesrDto) {
          return postsService.save(requesrDto);
      }
  }
  ```

  

* **PostsServer**

  ```PostsServer
  import com.allsser.book.springboot.domain.posts.Posts;
  import com.allsser.book.springboot.domain.posts.PostsRepository;
  import com.allsser.book.springboot.web.dto.PostsResponseDto;
  import com.allsser.book.springboot.web.dto.PostsSaveRequesrDto;
  import com.allsser.book.springboot.web.dto.PostsUpdateRequestDto;
  import lombok.RequiredArgsConstructor;
  import org.springframework.stereotype.Service;
  
  import javax.transaction.Transactional;
  
  @RequiredArgsConstructor
  @Service
  public class PostsService {
  
      private final PostsRepository postsRepository;
  
      @Transactional
      public Long save(PostsSaveRequesrDto requesrDto) {
          return postsRepository.save(requesrDto.toEntity()).getId();
      }
  }
  ```

  * **final이 선언된 모든 필드**를 인자값으로 하는 생성자를 롬복의 **@RequiredArgsConstructor**가 대신 생성해 준다. 
  * 생성자를 직접 안 쓰고 롬복 어노테이션을 사용한 이유는 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결해 주기 때문이다.



* Controller와 Service에서 사용할 Dto 클래스 생성(**PostsSaveRequestDto**)

  ```PostsSaveRequestDto
  import com.allsser.book.springboot.domain.posts.Posts;
  import lombok.Builder;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  
  @Getter
  @NoArgsConstructor
  public class PostsSaveRequesrDto {
      private String title;
      private String content;
      private String author;
      
      @Builder
      public PostsSaveRequesrDto(String title, String content, String author) {
          this.title = title;
          this.content = content;
          this.author = author;
      }
  
      public Posts toEntity() {
          return Posts.builder()
                  .title(title)
                  .content(content)
                  .author(author)
                  .build();
      }
  }
  ```

  * Entity 클래스와 거의 유사한 형태임에도 Dto 클래스를 추가하였다. 하지만, 절대로 **Entity 클래스를 Request/Response 클래스로 사용해서는 안된다.**
  * Entity 클래스는 **데이터베이스와 맞닿은 핵심 클래스**이다. Entity 클래스를 기준으로 테이블이 생성되고, 스키마가 변경된다. 화면 변경은 아주 사소한 기능인데, 이를 위해 테이블과 연결된 Entity 클래스를 변경하는 것은 너무 큰 변경이다.
  * 수많은 서비스 클래스나 비즈니스 로직들이 Entity 클래스를 기준으로 동작하고 있다. Entity 클래스가 변경되면 여러 클래스에 영향을 끼치지만, Request와 Response용 Dto는 View를 위한 클래스라 정말 자주 변경이 필요하다.
  * View Layer와 DB Layer의 역할 분리를 철저하게 하는 것이 좋다.
  * Entity 클래스와 Controller에서 쓸 Dto는 분리해서 사용해야 한다.

  

* 테스트 코드 검증을 위해 테스트 패키지 중 web 패키지에 **PostsApiControllerTest**를 생성한다.

  ```PostsApiControllerTest
  import com.allsser.book.springboot.domain.posts.Posts;
  import com.allsser.book.springboot.domain.posts.PostsRepository;
  import com.allsser.book.springboot.web.dto.PostsSaveRequesrDto;
  import com.allsser.book.springboot.web.dto.PostsUpdateRequestDto;
  import lombok.RequiredArgsConstructor;
  import org.junit.jupiter.api.AfterEach;
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.extension.ExtendWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.boot.test.web.client.TestRestTemplate;
  import org.springframework.boot.web.server.LocalServerPort;
  import org.springframework.http.HttpEntity;
  import org.springframework.http.HttpMethod;
  import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
  import org.springframework.test.context.junit.jupiter.SpringExtension;
  import org.springframework.web.bind.annotation.RestController;
  
  import java.util.List;
  
  import static org.assertj.core.api.Assertions.assertThat;
  
  @ExtendWith(SpringExtension.class)
  @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
  public class PostsApiControllerTest {
  
      @LocalServerPort
      private int port;
  
      @Autowired
      private TestRestTemplate restTemplate;
  
      @Autowired
      private PostsRepository postsRepository;
  
      @AfterEach
      public void tearDown() throws Exception {
          postsRepository.deleteAll();
      }
  
      @Test
      public void Posts_등록된다() throws Exception {
          // given
          String title = "title";
          String content = "content";;
          PostsSaveRequesrDto requesrDto = PostsSaveRequesrDto.builder()
                  .title(title)
                  .content(content)
                  .author("author")
                  .build();
  
          String url = "http://localhost:" + port + "/api/v1/posts";
  
          // when
          ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requesrDto, Long.class);
  
          // then
          assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
          assertThat(responseEntity.getBody()).isGreaterThan(0L);
  
          List<Posts> all = postsRepository.findAll();
          assertThat(all.get(0).getTitle()).isEqualTo(title);
          assertThat(all.get(0).getContent()).isEqualTo(content);
      }
  }
  ```

  * Api Controller를 테스트하는데 HelloController와 달리 @WebMvcTest를 사용하지 않았다. **@WebMvcTest의 경우 JPA 기능이 작동되지 않기** 때문인데, Controller와 ControllerAdvice 등 **외부 연동과 관련된 부분만** 활성화되니 지금과 같이 JPA 기능까지 한번에 테스트할 때는 **@SpringBootTest**와 **@TestRestTemplate**을 사용하면 된다.

  * 테스트 결과

    ![Posts등록Test](images/Posts등록Test.PNG)

  * **WebEnvironment.RANDOM_PORT**로 인한 랜덤 포트 실행과 insert 쿼리가 실행된 것을 모두 확인할 수 있다.

    

* 수정/조회 기능을 만들기

* **PostsApiController**

  ```PostsApiController
  @RequiredArgsConstructor
  @RestController
  public class PostsApiController {
  
  	...
  
      @PutMapping("/api/v1/posts/{id}")
      public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
          return postsService.update(id, requestDto);
      }
  
      @GetMapping("/api/v1/posts/{id}")
      public PostsResponseDto findById (@PathVariable Long id) {
          return postsService.findById(id);
      }
  }
  ```

  

* **PostsResponsDto**

  ```PostsResponsDto
  import com.allsser.book.springboot.domain.posts.Posts;
  import lombok.Getter;
  
  @Getter
  public class PostsResponseDto {
  
      private Long id;
      private String title;
      private String content;
      private String author;
  
      public PostsResponseDto(Posts entity) {
          this.id = entity.getId();
          this.title = entity.getTitle();
          this.content = entity.getContent();
          this.author = entity.getAuthor();
      }
  }
  ```

  * PostsResponseDto는 **Entity의 필드 중 일부만 사용**하므로 생성자로 Entity를 받아 필드 값에 넣는다.
  * 굳이 모든 필드를 가진 생성자가 필요하지 않으므로 Dto는 Entity를 받아 처리한다.

  

* **PostsUpdateRequestDto**

  ```PostsUpdateRequestDto
  import lombok.Builder;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  
  @Getter
  @NoArgsConstructor
  public class PostsUpdateRequestDto {
      private String title;
      private String content;
  
      @Builder
      public PostsUpdateRequestDto(String title, String content) {
          this.title = title;
          this.content = content;
  
      }
  }
  ```

  * update 기능에서 데이터베이스에 **쿼리를 날리는 부분이 없다.** 이게 가능한 이유는 **JPA의 영속성 컨텍스트** 때문이다.

  * 영속성 컨텍스트란, **엔티티를 영구 저장하는 환경**이다. 일종의 논리적 개념이며, JPA의 핵심 내용은 **엔티티가 영속성 컨텍스트에 포함되어 있냐 아니냐**로 갈린다.

  * JPA의 엔티티 매니저가 활성화된 상태로 **트랜잭션 안에서 데이터베이스에서 데이터를 가져오면** 이 데이터는 영속성 컨텍스트가 유지된 상태이다.

  * 이 상태에서 해당 데이터 값을 변경하면 **트랜잭션이 끝나는 시점에서 해당 테이블에 변경분을 반영**한다. 즉, Entity 객체의 값만 변경하면 별도로 **Update 쿼리를 날릴 필요가 없다**는 것이다. 이 개념을 **더티 체킹(dirty checking)**이라 한다.

    

* **Posts**

  ```Posts
  public class Posts {
  
  	...
  	
      public void update(String title, String content) {
          this.title = title;
          this.content = content;
      }
  }
  ```



* **PostsService**

  ```PostsService
  @RequiredArgsConstructor
  @Service
  public class PostsService {
      private final PostsRepository postsRepository;
  
  	...
  
      @Transactional
      public Long update(Long id, PostsUpdateRequestDto requestDto) {
          Posts posts = postsRepository.findById(id).orElseThrow(() ->
                  new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
  
          posts.update(requestDto.getTitle(), requestDto.getContent());
  
          return id;
      }
  
      public PostsResponseDto findById (Long id) {
          Posts entity = postsRepository.findById(id).orElseThrow(() ->
                  new IllegalArgumentException("해당 게시물이 없습니다. id="+ id));
  
          return new PostsResponseDto(entity);
      }
  }
  ```



* 테스트 코드 update 쿼리 수행(**PostsApiControllerTest**)

  ```PostsApiControllerTest
  @ExtendWith(SpringExtension.class)
  @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
  public class PostsApiControllerTest {
  
  	...
  
      @Test
      public void Posts_수정된다() throws Exception {
          // given
          Posts savedPosts = postsRepository.save(Posts.builder()
          .title("title")
          .content("content")
          .author("author")
          .build());
  
          Long updateId = savedPosts.getId();
          String expectedTitle = "title2";
          String expectedContent = "content2";
  
          PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
          .title(expectedTitle)
          .content(expectedContent)
          .build();
  
          String url = "http://localhost:" + port + "/api/v1/posts/" + updateId;
  
          HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
  
          // when
          ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
  
          // then
          assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
          assertThat(responseEntity.getBody()).isGreaterThan(0L);
  
          List<Posts> all = postsRepository.findAll();
          assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
          assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
      }
  }
  ```

  * 결과를 보면 update 쿼리가 수행되는 것을 확인할 수 있다.

  ![PostsApiControllerTestUpdate](images/PostsApiControllerTestUpdate.PNG)

  * MyBatis와는 달리 JPA를 씀으로 **객체지향적으로 코딩할 수 있다.**



* **조회 기능을 실제로 톰캣에서 실행**

  * 로컬 환경에선 데이터베이스로 H2를 사용한다. 메모리에서 실행하기 때문에 **직접 접근하려면 웹 콘솔**을 사용해야 한다.

  * 웹 콘솔 옵션을 활성화 해준다. **application.properties에 다음과 같이 옵션을 추가한다.

    > spring.h2.console.enabled=true

  * 추가한 후에 Application 클래스의 main 메소드를 실행시킨다. 정상적으로 실행되면 톰캣 8080 포트로 실행된다. 웹 브라우저에 **http://localhost:8080/h2-console**로 접속하면 콘솔 화면이 등장한다. 이때 JDBC URL이 **jdbc:h2:mem:testdb**로 되어 있어야 한다.

    ![console](images/console.PNG)

  * Connect 버튼을 클릭하면 H2를 관리할 수 있는 관리 페이지가 나온다. 정상적이라면 **POSTS 테이블**이 노출되어야 한다. 간단한 쿼리를 실행시켜 보자

    > select * from posts;

    ![consolePostsTable](images/consolePostsTable.PNG)

  * 현재는 등록된 데이터가 없다. 간단하게 insert 쿼리를 실행해 보고 API로 조회해 보자

    > insert into posts (author, content, title) values ('author', 'content', 'title');

    ![consoleInsert](images/consoleInsert.PNG)

  * 등록된 데이터 확인후 API를 요청. **http://localhost:8080/api/v1/posts/1**

    ![APITest](images/APITest.PNG)

  * 기본적인 등록/수정/조회 기능을 모두 만들고 테스트 해봤다. 특히 등록/수정은 테스트 코드로 보호해 주고 있으니 이후 변경 사항이 있어도 안전하게 변경이 가능하다.



#### 3.5 JPA Auditing으로 생성시간/수정시간 자동화하기

* 보통 엔티티에 해당 데이터의 생성시간과 수정시간을 포함한다. 언제 만들어졌는지, 언제 수정되었는지 등은 차후 유지보수에 있어 굉장히 중요한 정보이기 때문이다.



* **LocalDate사용**

* domain 패키지에 **BaseTimeEntity 클래스**를 생성한다.

  ![BasetimeEntity](images/BasetimeEntity.PNG)

  **BaseTimeEntity**

  ```BaseTimeEntity
  import lombok.Getter;
  import org.springframework.data.annotation.CreatedDate;
  import org.springframework.data.annotation.LastModifiedDate;
  import org.springframework.data.jpa.domain.support.AuditingEntityListener;
  
  import javax.persistence.EntityListeners;
  import javax.persistence.MappedSuperclass;
  import java.time.LocalDateTime;
  
  @Getter
  @MappedSuperclass	// {1}
  @EntityListeners(AuditingEntityListener.class)	// {2}
  public abstract class BaseTimeEntity {
  
      @CreatedDate	// {3}
      private LocalDateTime createdDate;
  
      @LastModifiedDate	// {4}
      private LocalDateTime modifiedDate;
  }
  ```

  * BaseTimeEntity 클래스는 모든 Entity의 상위 클래스가 되어 **Entity들의 createdDate, modifiedDate를 자동으로 관리하는 역할**이다.
  * {1} **@MappedSuperclass**
    * JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 한다.
  * {2} **@EntityListeners(AuditingEntityListener.class)**
    * BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
  * {3} **@CreatedDate**
    * Entity가 생성되어 저장될 때 시간이 자동 저장된다.
  * {4} **@LastModifiedDate**
    * 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.



* Posts 클래스가 BaseTimeEntity를 상속받도록 변경한다.

  > ...
  >
  > public class Posts extends BaseTimeEntity {
  >
  > ​	...
  >
  > }



* 마지막으로 JPA Auditing 어노테이션들을 모두 활성화할 수 있도록 Application 클래스에서 활성화 어노케이션 하나를 추가해 준다.

  ```Application
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
  
  @EnableJpaAuditing	// {1}
  @SpringBootApplication
  public class Application {
      public static void main(String[] args) {
          SpringApplication.run(Application.class, args);
      }
  }
  ```

  * {1} **@EnableJpaAuditing**
    * JPA Auditing 활성화



**JPA Auditing 테스트 코드 작성**

* PostsRepositoryTest 클래스에서 테스트 메소드드를 하나 더 추가

  ```PostsRepositoryTset
      @Test
      public void BaseTimeEntity_등록() {
          // given
          LocalDateTime now = LocalDateTime.of(2020,6,4,0,0, 0);
          postsRepository.save(Posts.builder()
          .title("title")
          .content("content")
          .author("author")
          .build());
  
          // when
          List<Posts> postsList = postsRepository.findAll();
  
          // then
          Posts posts = postsList.get(0);
  
          System.out.println(">>>>>>>>>>>>>>> createDate=
          "+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
  
          assertThat(posts.getCreatedDate()).isAfter(now);
          assertThat(posts.getModifiedDate()).isAfter(now);
      }
  ```

  * 테스트 실행 결과

    ![JPAAuditingTest](images/JPAAuditingTest.PNG)

  * 앞으로 추가될 엔티티들은 더이상 등록일/수정일로 고민할 필요가 없다. BaseTimeEntity만 상속받으면 자동으로 해결된다.



---

### 4. 머스테치로 화면 구성하기

#### 4.1 서버 템플릿 엔진과 머스테치

* **템플릿 엔진이란?**
  * **지정된 템플릿 데이터를** 합쳐서 HTML 문서를 출력한다.
  * 템플릿 엔진에는 서버 사이드, 클라이언트 사이드 두 가지 종류가 있다. 둘은 작동영역이 다르다.

* **서버 템플릿 엔진이란?**
  * 서버에서 구동되는 템플릿 엔진으로 JSP, Freemarker가 있다.
  * 서버에서 Java 코드로 문자열을 만든 후 서버에서 HTML로 변환하여 브라우저로 전달한다.
* **클라이언트 템플릿 엔진이란?**
  * 브라우저 위에서 작동하며 react, Vue.js 등이 있다.
  * 브라우저에서 화면을 생성하기에 서버에서는 JSON, Xml 형식의 데이터만 전달하고 클라이언트에서 이를 혼합해 화면을 만든다.



* **머스테치란?**
  * [머스테치](http://mustache.github.io/)는 **수많은 언어를 지원하는 가장 심플한 템플릿 엔진**이다.
  * 자바에서 사용될 때는 서버 템플릿 엔진으로, 자바스크립트에서 사용될 때는 클라이언트 템플릿 엔진으로 모두 사용 가능하다.
* **머스테치의 장잠**
  * 문법이 다른 템플릿 엔진보다 심플하다.
  * 로직 코드를 사용할 수 없어 View의 역할과 서버의 역할이 명확하게 분리된다.
  * Mustache.js와 Mustache.java 2가지 다 있어, 하나의 문법으로 클라이언트/서버 템플릿 모두 사용 가능하다.
* **머스테치 설치**
  * 인텔리제이의 플러그인에서 'mustache'를 검색하여 다운 받아 준다.



#### 4.2 기본 페이지 만들기

* **머스테치 스타터 의존성을 build.gradle에 등록한다.**

  > implementation('org.springframework.boot:spring-boot-starter-web')

  * 머스테치는 **스프링 부트에서 공식 지원하는 템플릿 엔진**이다. 의존성 하나만 추가하면 다른 스타터 패키지와 마찬가지로 추가 설정 없이 설치가 끝난다.

* 머스터치의 파일위치는 **src/main/resources/templates**이다. 이 위치에 머스테치 파일을 두면 스프링 부트에서 자동으로 로딩한다.

* 첫 페이지를 담당할 **index.mustache**를 src/main/resources/templates에 생성한다.

  ![templates](images/templates.PNG)

  ```index.templates
  <!DOCTYPE HTML>
  <html>
  <head>
  	<title>스프링부트로 시작하는 웹 서비스><title>
  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  </head>
  <body>
  	<h1>스부링부트로 시작하는 웹 서비스 Ver.2</h1>
  </body>
  </html>
  ```

* 이 머스테치에 **URL을 매핑**한다. URL 매핑은 **Controller**에서 진행한다. web 패키지 안에 IndexController를 생성한다.

  ![IndexController](images/indexController.PNG)

  ```IndexController
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.GetMapping;
  
  @Controller	// {1}
  public class IndexController {
  
  	@GetMapping("/")
  	public String index() {
  		return "index";
  	}
  }
  ```

  * {1} **@Controller**

    * 클래스 타입에 적용한다.
    * @Controller 어노테이션을 붙이면 해당 클래스를 웹 요청을 처리하는 컨트롤러로 사용한다.

  * 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 **앞의 경로와 뒤의 파일 확장자는 자동으로 지정**된다. 앞의 경로는 **src/main/resources/templates**로, 뒤의 파일 확장자는 **.mustache**가 붙는다. 여기서는 **"index"**을 반환하므로, src/main/resources/templates/**index.mustache**로 전환되어 **View Resolver**가 처리하게 된다.

    > View Resolver는 URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자 격으로 볼 수 있다.

* 테스트 코드로 검증. test 패키지에 **IndexControllerTest** 클래스를 생성

  ```IndexControllerTest 
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.extension.ExtendWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.boot.test.web.client.TestRestTemplate;
  import org.springframework.test.context.junit.jupiter.SpringExtension;
  import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
  
  import static org.assertj.core.api.Assertions.assertThat;
  
  @ExtendWith(SpringExtension.class)
  @SpringBootTest(webEnvironment = RANDOM_PORT)
  public class IndexControllerTeset {
  
      @Autowired
      private TestRestTemplate restTemplate;
  
      @Test
      public void 메인페이지_로딩() {
          // when
          String body = this.restTemplate.getForObject("/", String.class);
  
          //then
          assertThat(body).contains("스부링부트로 시작하는 웹 서비스 Ver.2");
      }
  }
  ```

  * 위의 테스트는 실제로 URL 호출 시 페이지의 내용이 제대로 호출되는지에 대한 테스트이다.
  * HTML도 결국은 **규칙이 있는 문자열**이다. TestRestTemplate를 통해 "/"로 호출했을 때 **indext.mustach**에 포함된 코드들이 있느지 확인하면 된다.
  * http://localhost:8080 접속시 잘 뜨는것을 확인할 수 있다

  ![localhostVer.2](images/localhostVer.2.PNG)



#### 4.3 게시글 등록 화면 만들기

* **PostsApiController**로 **API**를 구현해 놓았으니 바로 **게시글 등록 화면**을 개발하면 된다.

* 그냥 HTML만 사용하기에는 멋이 없다. 그래서 오픈 소스인 부트스트랩을 이용하여 화면을 만든다.

  >부트스트랩, 제이쿼리 등 프론트엔드 라이브러리를 사용할 수 있는 방법은 2가지 이다.
  >
  >1. 외부 CDN을 사용 (현재 프로젝트에서 사용)
  >2. 직접 라이브러리를 받아서 사용
  >
  >*실제 서비스에서는 2번째 방법을 사용한다. 이유는 1번째 방법으로 개발하게 되면 외부 서비스에 우리 서비스가 의존하게 되버려서, CDN을 서비스하는 곳에 문제가 생기면 덩달아 같이 문제가 생기기 때문이다.*

* **레이아웃** 방식으로 2개의 라리브러리 **부트스트랩**과 **제이쿼리**를 **index.mustache**에 추가한다. 레이아웃 방식이란 **공통 영역을 별도의 파일로 분리하여 필요한 곳에 가져다 쓰는 방식**이다. 레이아웃 파일들을 만들어 추가한다.

* **src/main/resources/template**  디렉토리에 **layout** 디렉토리를 추가로 생성한다. 그리고 **footer.mustache, header.mustache** 파일을 생성한다.

  ![layout](images/layout.PNG)

  **header.mustache**

  ```header.mustache
  <!DOCTYPE HTML>
  <html>
  <head>
      <title>스프링부트 웹서비스</title>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  </head>
  <body>
  ```

  **footer.mustache**

  ```footer.mustache
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  </body>
  </html>
  ```

  * css와 js의 위치가 서로 다르다. **페이지 로딩속도를 높이기 위해** css는 header에, js는 footer에 두었다. HTML은 위에서부터 코드가 실행되기 때문에 **head가 다 실행되고서야 body가 실행**된다.

    

  * 레이아웃에 header와 footer를 만들어 줬기 때문에 index.mustache에는 **필요한 코드만 남게 된다.**

  **index.mustache**

  ```index.mustache
  {{>layout/header}}	// {1}
  
  <h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>
  
  {{>layout/footer}}
  ```

  * {1} **{{>layout/header}}**

    * {{> }}는 현재 머스테치 파일(index.mustache)을 기준으로 다른 파일을 가져온다.

    

  * index.mustache에 **글 등록 버튼**추가

  ```index.mustache
  {{>layout/header}}
  
  	<h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>
  	<div class="col-md-12">
  		<div class="row">
  			<div class="col-md-6">
  				<a herf="/posts/save" role="button" class="btn btn-primary">글 등록</a>
  			</div>
  		</div>
  	</div>
  {{>layout/footer}}
  ```

  * <a> 태그를 이용해 글 등록 페이지로 이동하는 글 등록 버튼을 생성하였다. 이동할 페이지의 주소는 **/posts/save** 이다.

    

  * 이 주소에 해당하는 컨트롤러를 생성한다. 페이지에 관련된 컨트롤러는 모두 **IndexController**를 사용한다.

  **IndexController**

  ```IndexController
  @RequiredArgsConstructor
  @Controller
  public class IndexController {
  
      private final PostsService postsService;
  	...
  	
      @GetMapping("/posts/save")
      public String postsSave() {
          return "posts-save";
      }
  }
  ```

  * index.mustache와 마찬가지로 /posts/save를 호출하면 posts-save.mustache를 호출하는 메소두가 추가 되었다. 컨트롤러 코드가 생성 되었다면 posts-save.mustache 파일을 생성한다. 파일의 위치는 index.mustache와 같다.

  **index.mustache**

  ```index.mustache
  {{>layout/header}}
  
  <h1>게시글 등록</h1>
  
  <div class="col-md-12">
      <div class="col-md-4">
          <form>
              <div class="form-group">
                  <label for="title">제목</label>
                  <input type="text" class="form-control" id="title" 
                  							placeholder="제목을 입력하세요">
              </div>
              <div class="form-group">
                  <label for="author"> 작성자 </label>
                  <input type="text" class="form-control" id="author" 
                  							placeholder="작성자를 입력하세요">
              </div>
              <div class="form-group">
                  <label for="content"> 내용 </label>
                  <textarea class="form-control" id="content" 
                  							placeholder="내용을 입력하세요"></textarea>
              </div>
          </form>
          <a href="/" role="button" class="btn btn-secondary">취소</a>
          <button type="button" class="btn btn-primary" id="btn-save">등록</button>
      </div>
  </div>
  
  {{>layout/footer}}
  ```

  * http://localhost:8080/ 로 접근하여 '글 등록'이라고 되어있는 버튼을 클릭하면 클 등록 화면으로 이동한다.

  ![localhostSave](images/localhostSave.PNG)

  * 게시글 등록 화면에 **등록 버튼은 기능이 없다.** API를 호출하는 JS가 전혀 없기 때문이다. **src/main/resources**에 **static/js/app** 디렉토리를 생성한다. 여기에 **index.js**를 생성한다.

  ![indexJS](images/indexJS.PNG)

  **index.js**

  ```index.js
  var main = {
      init : function () {
          var _this = this;
          $('#btn-save').on('click', function () {
              _this.save();
          });
      },
      save : function () {
          var data = {
              title: $('#title').val(),
              author: $('#author').val(),
              content: $('#content').val()
          };
  
          $.ajax({
              type: 'POST',
              url: '/api/v1/posts',
              dataType: 'json',
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(data)
          }).done(function() {
              alert('글이 등록되었습니다.');
              window.location.href = '/';	// {1}
          }).fail(function (error) {
              alert(JSON.stringify(error));
          })
      }
      
  main.init();
  ```

  * {1} **window.location.href = '/'**
    
    * 글 등록이 성공하면 메인페이지( / )로 이동한다.
    
    
    
  * 생성된 index.js를 머스테치 파일이 쓸 수 있게 **footer.mustache**에 추가한다.
  
  **footer.mustache**
  
  ```footer.mustache
  <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
  <!--index.js 추가-->
  <script src="/js/app/index.js"></script>
  </body>
  </html>
  ```
  
  * index.js 호출 코드를 보면 **절대 경로( / )**로 바로 시작한다. 스프링 부트는 기본적으로 **src/main/resource/static**에 위치한 자바스크립트, CSS, 이미지 등 정적 파일들을 URL에서 /로 설정된다.
  
    
  
  * 등록 기능을 브라우저에서 직접 테스트 해보면 잘 작동하는 것을 확인할 수 있다. **localhost:8080/h2-console**에 접속하여 실제로 DB에 데이터가 등록되었는지 확인해 보면 잘 등록되어 있는 것도 확인할 수 있다.
  
    

#### 4.4 전체 조회 화면

* 전체 조회를 위해 index.mastache의 UI를 변경

  ```index.mastache
  {{>layout/header}}
  
      <h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>
      <div class="col-md-12">
          <div class="row">
              <div class="col-md-6">
                  <a href="/posts/save" role="button" class="btn btn-primary">글 등록</a>
              </div>
          </div>
          <br>
          <!-- 목록 출력 영역 -->
          <table class="table table-horizontal table-bordered">
              <thead class="thead-strong">
              <tr>
                  <th>게시글번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>최종수정일</th>
              </tr>
              </thead>
              <tbody id="tbody">
              {{#posts}}	// {1}
                  <tr>
                      <td>{{id}}</td>	// {2}
                      <td>{{title}}</td>
                      <td>{{author}}</td>
                      <td>{{modifiedDate}}</td>
                  </tr>
              {{/posts}}
              </tbody>
          </table>
      </div>
  
  {{>layout/footer}}
  ```

  * {1} **{{#posts}}**
    * posts 라는 List를 순회한다.
    * Java의 for문과 동일하게 생각하면 된다.
  * {2} **{{id}} 등의 {{변수명}}**
    * List에서 뽑아낸 객체의 필드를 사용한다. 



* **Controller, Service, Repository** 코드를 작성한다.

  * **Repository**부터 작성

  **PostsRepository**

  ```PostsRepository
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.data.jpa.repository.Query;
  
  import java.util.List;
  
  public interface PostsRepository extends JpaRepository<Posts, Long> {
  
      @Query("SELECT p FROM Posts p ORDER BY p.id DESC")	// {1}
      List<Posts> findAllDesc();
  }
  ```

  * {1} **@Query**
    * **SpringDataJpa**에서 제공하지 않는 메소드는 위처럼 쿼리로 작성해도 된다.
    * 실제로 앞의 코드는 SpringDataJpa에서 제공하는 기본 메소드만으로 해결할 수 있지만, **@Query**가 훨씬 가독성이 좋으니 선택해서 사용하면 된다.



* Repository 다음으로 **PostsService**에 코드를 추가한다.

  * **PostsService**

  ```PostsService
  ...
  import java.util.List;
  import java.util.stream.Collectors;
  
  @RequiredArgsConstructor
  @Service
  public class PostsService {
      private final PostsRepository postsRepository;
  
  	...
  
      @Transactional(readOnly = true)	// {1}
      public List<PostsListResponseDto> findAllDesc() {
          return postsRepository.findAllDesc().stream()
                  .map(PostsListResponseDto::new)	// {2}
                  .collect(Collectors.toList());
      }
  }
  ```

  * {1} **@Transactional(readOnly = true)**

    * **findAllDesc** 메소드의 **@Transactional**에 옵션이 하나 추가되었다. **(readOnly = true)**를 주면 **트랜잭션 범위는 유지**하되, 조회 기능만 남겨두어 **조회 속도가 개선**되기 때문에 등록, 수정, 삭제 기능이 전혀 없는 서비스 메소드에서 사용하는 것을 추천한다.
    * 트랜잭션이란 데이터베이스의 상태를 변경시키는 작업 또는 한번에 수행되어야 하는 연산들을 의미한다. 트랜잭션 작업이 끝나면 Commit 또는 Rollback 되어야 한다.

  * {2} **.map(PostsListResponseDto::new)**

    * 위의 코드는 실제로 다음과 같다.

      > .map(posts -> new PostsListResponseDto(posts))

    * postsRepository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsListRepositoryDto 변환 -> List로 반환하는 메소드이다.

    

  * **PostsListResponseDto** 클래스 생성

  **PostsListResponseDto**

  ```PostsListResponseDto
  import com.allsser.book.springboot.domain.posts.Posts;
  import lombok.Getter;
  
  import java.time.LocalDateTime;
  
  @Getter
  public class PostsListResponseDto {
      private Long id;
      private String title;
      private String author;
      private LocalDateTime modifiedDate;
  
      public PostsListResponseDto(Posts entity) {
          this.id = entity.getId();
          this.title = entity.getTitle();
          this.author = entity.getAuthor();
          this.modifiedDate = entity.getModifiedDate();
      }
  }
  ```

  

  * **Controller**를 변경

  **Index.controller**

  ```Index.controller
  import org.springframework.ui.Model;
  
  @RequiredArgsConstructor
  @Controller
  public class IndexController {
  
      private final PostsService postsService;
  
      @GetMapping("/")
      public String index(Model model) {	// {1}
          model.addAttribute("posts", postsService.findAllDesc());
          return "index";
      }
  }
  ```

  * {1} **Model**

    * 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
    * 여기서는 postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달한다.

    

  * http://localhost:8080/로 접속한 뒤 등록 화면을 이용해 하나의 데이터를 등록해 보면 목록 기능이 정상적으로 작동하는 것을 확인할 수 있다.

    ![조회목록](images/조회목록.PNG)



#### 4.5 게시글 수정, 삭제 화면

* 게시글 수정, 삭제 화면 만들기, 게시글 수정 API는 이미 3.4절에 만들어 두었다. 

* **게시글 수정**

  **PostsApiController**

  ```PostsApiController
  @RequiredArgsConstructor
  @RestController
  public class PostsApiController {
  
  	...
      @PutMapping("/api/v1/posts/{id}")
      public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
          return postsService.update(id, requestDto);
      }
      ...
  
  }
  ```

  * 해당 **API**로 요청하는 화면을 개발

    

  * **게시글 수정** 화면 머스테치 파일을 생성한다.

  **posts-update.mustache**

  ```posts-update.mustache
  {{>layout/header}}
  
  <h1>게시글 수정</h1>
  
  <div class="col-md-12">
      <div class="col-md-4">
          <form>
              <div class="form-group">
                  <label for="id">글 번호</label>
                  <input type="text" class="form-control" 
                  	id="id" value="{{post.id}}" readonly>	// {1}
              </div>
              <div class="form-group">
                  <label for="title">제목</label>
                  <input type="text" class="form-control" 
                  	id="title" value="{{post.title}}">
              </div>
              <div class="form-group">
                  <label for="author"> 작성자 </label>
                  <input type="text" class="form-control" 
                  	id="author" value="{{post.author}}" readonly>	// {2}
              </div>
              <div class="form-group">
                  <label for="content"> 내용 </label>
                  <textarea class="form-control" id="content">{{post.content}}</textarea>
              </div>
          </form>
          <a href="/" role="button" class="btn btn-secondary">취소</a>
          <button type="button" class="btn btn-primary" id="btn-update">수정 완료</button>
          <button type="button" class="btn btn-danger" id="btn-delete">삭제</button>
      </div>
  </div>
  
  {{>layout/footer}}
  ```

  * {1} **{{post.id}}**

    * 머스테치는 객체의 필드 접근 시 점(Dot)으로 구분한다.
    * 즉, Posts 클래스의 id에 대한 접근은 post.id로 사용할 수 있다.

  * {2} **readonly**

    * Input 태그에 읽기 기능만 허용하는 속성이다.
    * id와 author는 수정할 수 없도록 읽기만 허용하도록 추가한다.

    

  * **btn-update** 버튼을  클릭하면 **update** 기능을 호출할 수 있게 **index.js** 파일에도 **update function**을 추가해 준다.

  **index.js**

  ```index.js
  var main = {
      init : function () {
          var _this = this;
          ...
  
          $('#btn-update').on('click', function () {	// {1}
              _this.update();
          })
      },
      save : function () {
  		...
      },
      update : function () {	// {2}
          var data = {
              title: $('#title').val(),
              content: $('#content').val()
          };
  
          var id = $('#id').val();
  
          $.ajax({
              type: 'PUT',	// {3}
              url: '/api/v1/posts/'+id,	// {4}
              dataType: 'json',
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(data)
          }).done(function() {
              alert('글이 수정되었습니다.');
              window.location.href = '/';
          }).fail(function (error) {
              alert(JSON.stringify(error));
          });
      }
  };
  
  main.init();
  ```

  * {1} **$('btn-update').on('click')**

    * btn-update란 id를 가진 HTML 엘리먼트에 click 이벤트가 발생할 때 update function을 실행하도록 이벤트를 등록한다.

  * {2} **update : function () **

    * 신규로 추가될 update function이다.

  * {3} **type: 'PUT'**

    * 여러 HTML Method 중 PUT 메소드를 선택한다.

    * PostsApiController에 있는 API에서 이미 @PutMapping으로 선언했기 때문에 PUT을 사용해야 한다. 참고로 이는 REST 규약에 맞게 설정된 것이다.

    * REST에서 CRUD는 다음과 같이 HTML Method에 매핑된다.

      생성 (Create) - POST

      일기(Read) - GET

      수정(Update) - PUT

      삭제(Delete) - DELETE

  * {4} **url: '/api/v1/posts/'+id**

    * 어느 게시글을 수정할지 URL Path로 수분하기 위해 Path에 id를 추가한다.

    

  * 전체 목록에서 **수정 페이지로 이동할 수  있게** 페이지 이동 기능을 추가한다. index.mustache 코드를 조금 수정해 준다.

  **index.mustache**

  ```index.mustache
  <tbody id="tbody">
  	{{#posts}}
  		<tr>
             <td>{{id}}</td>
             <td><a href="/posts/update/{{id}}">{{title}}</a></td>	// {1}
             <td>{{author}}</td>
             <td>{{modifiedDate}}</td>
           </tr>
      {{/posts}}
  </tbody>
  ```

  * {1} **<a href="/posts/update/{{id}}"></a>**

    * 타이틀(title)에 a tag를 추가한다.
    * 타이틀을 클릭하면 해당 게시글의 수정 화면으로 이동한다.

    

  * 수정 화면을 연결할 Controller 코드를 작업한다. IndexController에 다음과 같이 메소드를 추가한다.

  **IndexController**

  ```IndexController
  public class IndexController {
  	...
  	
      @GetMapping("/posts/update/{id}")
      public String postsUpdate(@PathVariable Long id, Model model) {
          PostsResponseDto dto = postsService.findById(id);
          model.addAttribute("post", dto);
  
          return "posts-update";
      }
  }
  ```

  * 코드를 실행해 보면 타이틀 링크를 클릭할 수 있고, 링크를 클릭하면 수정 페이지로 이동하여 제목과 내용을 수정할 수 있다.



* **게시글 삭제**

  * 삭제 기능을 구현하기 위해서 삭제 버튼을 수정 화면에 추가한다.

  **posts-update.mustache**

  ```posts-update.mustache
  ...
  <div class="col-md-12">
      <div class="col-md-4">
  		...
          <a href="/" role="button" class="btn btn-secondary">취소</a>
          <button type="button" class="btn btn-primary" 
          	id="btn-update">수정 완료</button>
          <button type="button" class="btn btn-danger" 
          	id="btn-delete">삭제</button>	//	{1}
      </div>
  </div>
  ...
  ```

  * {1} **btn-delete**

    * 삭제 버튼을 수정 완료 버튼 옆에 추가한다.
    * 해당 버튼 클릭 시 JS에서 이벤트를 수신할 예정이다.

    

  * 삭제 이벤트를 진행할 JS 코드도 추가해 준다.

  **index.js**

  ```index.js
  var main = {
      init : function () {
      	...
  
          $('#btn-delete').on('click', function () {
              _this.delete();
          })
      },
      ...
      delete : function () {
          var id = $('#id').val();
  
          $.ajax({
              type: 'DELETE',
              url: '/api/v1/posts/'+id,
              dataType: 'json',
              contentType: 'application/json; charset=utf-8'
          }).done(function() {
              alert('글이 삭제되었습니다.');
              window.location.href = '/';
          }).fail(function (error) {
              alert(JSON.stringify(error));
          });
      }
  };
  
  main.init();
  ```

  * type은 **'DELETE'**를 제외하고는 update function과 크게 차이 나진 않는다.

    

  * 삭제 API를 개발, 먼저 서비스 메소드부터 시작

  **PostsService**

  ```PostsService
  ...
  public class PostsService {
  	...
  
      @Transactional
      public void delete (Long id) {
          Posts posts = postsRepository.findById(id).orElseThrow(() ->
                  new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
  
          postsRepository.delete(posts);	//	{1}
      }
  }
  ```

  * {1} **postsRepository.delete(posts)**

    * JpaRepository에서 이미 delete 메소드를 지원하고 있으니 이를 활용한다.
    * 엔티티 파라미터로 삭제할 수도 있고, deleteById 메소드를 이용하면 id로 삭제할 수도 있다.
    * 존재하는 Posts인지 확인을 위해 엔티티 조회 후 그대로 삭제한다.

    

  * 서비스에서 만든 delete 메소드를 컨트롤러가 사용하도록 코드를 추가한다.

  **PostsApiController**

  ```PostsApiController
  ...
  public class PostsApiController {
  	...
  	
      @DeleteMapping("/api/v1/posts/{id}")
      public Long delete(@PathVariable Long id) {
          postsService.delete(id);
          return id;
      }
  }
  ```

  * 컨트롤러까지 생성하여 게시글의 수정 화면에서 삭제 버튼을 클릭하면 삭제 성공 메시지를 확인할 수 있다.

  ![deleteButton](images/deleteButton.PNG)

  ![deleteButtonClick](images/deleteButtonClick.PNG)

**수정/삭제 기능까지 완성되었다.**



---

### 5. 스프링 시큐리티와 OAuth 2.0으로 로그인 기능 구현

* **스프링 시큐리티(Spring Security)**는 막강한 **인증(Authentication)**과 **인가(Authorization 혹은 권한 부여)** 기능을 가진 **프레임워크**이다.
* 스프링 기반의 애플리케이션에서는 **보안을 위한 표준**이다.
* 스프링의 대부분 프로젝트들**(MVC, Data, Batch 등등)**처럼 확장성을 고려한 프레임워크다 보니 다양한 요구사항을 손쉽게 추가하고 변경할 수 있다.



#### 5.1 스프링 시큐리티와 스프링 시큐리티 Oauth2 클라이언트

* 많은 서비스에서 로그인 기능을 id/password 방식보다는 구글, 페이스북, 네이버 로그인과 같은 소셜 로그인 기능을 사용한다. 이유는 직접 구연할 경우 **배보다 배꼽이 커지는 경우**가 많기 때문이다. 
* 직접 구현하면 구현해야 할 것들이 많다.
  * 로그인 시 보안
  * 비밀번호 찾기
  * 비밀번호 변경
  * 회원정보 변경
  * 회원가입 시 이메일 혹은 전화번호 인증
* OAuth 로그인 구현 시 앞선 목록 것들을 모두 구글, 페이스북, 네이버 등에 맡기면 되니 서비스 개발에 집중할 수 있다.

**스프링 부트 2방식**

* 스프링 부트 2 방식의 자료를 찾고 싶을 경우 인터넷 자료들 사이에서 다음 두 가지만 확인하면된다.

  * **spring-security-oauth2-autoconfigure 라이브러리**를 썻는지 확인

  * **application.properties** 혹은 **application.yml 정보**가 다음과 같이 차이가 있는지 비교

    * Spring Boot 1.5

    ```Spring Boot 1.5
    google :
    	client :
    		clientId : 인증정보
    		clientSectret: 인증정보
    		accessTokenUri: https://accounts.google.com/o/oauth2/token
    		userAuthorizationUri: https://accounts.google.com/o/oauth2/auth
    		clientAuthenticationScheme: form
    		scope: email, profile
    	resource:
    		userInfoUri: https://www.googleapis.com/oauth2/v2/userinfo
    ```

    * Spring Boot 2.x

    ```Spring Boot 2.x
    spring:
    	security:
    		oauth2:
    			client:
    				clientId: 인증정보
    				clientSecret: 인정정보
    ```

  * 스프링 부트 1.5 방식에서는 url 주소를 모두 명시해야 하지만, **2.0 방식 에서는 client 인증 정보**만 입력하면 된다. 1.5버전에서 직접 입력했던 값들은 2.0버전으로 오면서 모두 **enum으로 대체되었다.**

  * **CommonOAuth2Provider**라는 enum이 새롭게 추가되어 구글, 깃허브, 페이스북, 옥타의 기본 설정값은 모두 여기에서 제공한다.

  ```CommonOAuth2Provider
  public enum CommonOAuth2Provider {
  	GOOGLE {
  		
  		@Override
  		public Builder getBuilder(String registrationId) {
  			ClientRegistration.Builder builder =
  				getBuilder(registrationId, ClientAuthenticationMethod.BASIC,
  					DEFAULT_REDIRECT_URL);
  					
  			builder.scope("openid", "progile", "email");
  			builder.authorizationUri("https://accounts.google.com/o/oauth2/v2/auth");
  			builder.tokenUri("https://www.googleapis.com/oauth2/v4/token");
  			builder.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs");
  			builder.userInfoUri("https://www.googleapis.con/oauth2/v3/userinfo");
  			builder.userNameAttributeName(IdTokenClaimNames.SUB);
  			builder.clientName("Google");
  			return builder;
  		}
  	},
  	
  	...
  }
  ```

  * 이외에 다른 소셜 로그인(네이버, 카카오 등)을 추가한다면 직접 다 추가해 주어야 한다.



#### 5.2 구글 서비스 등록

* 구글 서비스에 신규 서비스를 생성한다. 여기서 발급된 인증 정보(clientId와 clientSecret)를 통해서 로그인 기능과 소셜 서비스 기능을 사용할 수 있으니 무조건 발급받고 시작해야 한다.

  * 구글 클라우드 플랫폼 주소(https://console.cloud.google.com)으로 이동하여 [프로젝트 선택] 탭을 클릭하여 새 프로젝트를 선택 및 등록될 서비스의 이름을 입력하면 된다.

  ![newGoogle](images/newGoogle.PNG)

  

  * 생성이 완료된 프로젝트를 선택하고 왼쪽 메뉴 탭을 클릭하여 **API 및 서비스** 카테고리로 이동한다. 사이드바 중간에 있는 **[사용자 인증 정보]**를 클릭하고 **[사용자 인증 정보 만들기]** 버튼을 클릭한다. 
  * 사용자 인증 정보에는 여러 메뉴가 있는데 이 중 이번에 구현할 소셜 로그인 OAuth 클라이언트 ID로 구현한다. **[OAuth 클라이언트 ID]** 항목을 클릭한다.

  ![googleID](images/googleID.PNG)

  

  * **OAuth 동의 화면** 탭에서 동의 화면 구성을 끝낸 후 **OAuth 클라이언트 ID 만들기** 화면으로 이동하여 애플리케이션 유형을 **웹 애플리케이션**으로 선택하고 **승인된 리디렉션 URI**의 URI에 **http://localhost:8080/login/oauth2/code/google**을 입력해 준다.

  ![OAuthID만들기](images/OAuthID만들기.PNG)

  * 승인된 리디렉션 URI

    * 서비스에서 파라미터로 인증 정보를 주었을 때 성공하면 구글에서 리다이렉트할 URL이다.
    * 스프링 부트 2 버전의 시큐리티에서는 기본적으로 **{도메인}/login/oauth2/code/{소셜 서비스코드}**로 리다이렉트 URL을 지원하고 있다.
    * 사용자가 별도로 리다이렉트 URL을 지원하는 Controller를 만들 필요가 없다. 시큐리티에서 이미 구현해 놓았다.
    * 현재는 개발 단계이므로 http://localhost:8080/login/oauth2/code/google로만 등록한다.
    * AWS 서버에 배포하게 되면 localhost 외에 추가로 주소를 추가해야하며, 이후 단계에서 진행한다.

    

  * 생성된 OAuth 클라이언트에서 **클라이언트 ID**와 **클라이언트 보안 비밀** 코드를 프로젝트에서 설정한다.

  ![보안코드](images/보안코드.PNG)



* **application-oauth 등록**
  
  * 4장에서 만들었던 application.properties가 있는 src/main/resources/ 디렉토리에 **application-oauth.properties** 파일을 생성한다.
  
  ![oauth.properties](images/oauth.properties.PNG)
  
  * 해당 파일에 **클라이언트 ID(clientid)**와 **클라이언트 보안 비밀(clientSecret)** 코드를 등록한다.
  
  ```application-oauth.properties
  spring.security.oauth2.client.registration.google.client-id=클라이언트 ID
  spring.security.oauth2.client.registration.google.client-secret=클라이언트 보안 비밀
  spring.security.oauth2.client.registration.google.scope=profile, email	// {1}
  ```
  
  * {1} **scope=profile, email**
  
    * 많은 예제에서는 이 scope를 별도로 등록하지 않고 있다.
    * 기본값이 openid, profile, email이기 때문이다.
    * 강제로 profile, email를 등록한 이유는 openid라는 scope가 있으면 Open id Provider로 인식하기 때문이다.
    * 이렇게 되면 OpenId Providr인 서비스(구글)와 그렇지 않은 서비스(네이버/카카오 등)로 나눠서 각각 OAuth2Service를 만들어야 한다.
    * 하나의 OAuth2Service로 사용하기 위해 일부러 openid scope를 빼고 등록한다.
  
    
  
  * 스프링 부트에서는 properties의 이름을 **application-xxx.properties** 로 만들면 xxx라는 이름의 **profile**이 생성되어 이를 통해 관리할 수 있다.
  
  * **profile=xxx**라는 식으로 호출하면 **해당 properties의 설정들을 가져올** 수 있다.
  
  * 호출하는 방식은 여러 방식이 있지만 이 책에서는 스프링 부트의 기본 설정 파일인 application.properties에서 application-oauth.properties를 포함하도록 구성한다.
  
  * **application.properties**에 다음과 같이 추가한다.
  
  > spring.profiles.include=oauth
  
  * 이제 이 설정값 들을 사용할 수 있다.



* **.gitignore 등록**

  * 구글 로그인을 위한 클라이언트 ID와 클라이언트 보안 비밀은 보안이 중요한 정보들이다.
  * 이들이 외부에 노출될 경우 언제든 개인정보를 가져갈 수 있는 취약점이 될 수 있다.
  * 현재 깃헙과 연동되어 있기 때문에 application-oauth.properties 파일이 깃헙에 올라갈 수 있다.
  * 보안을 위해 1장에서 만들었던 **.gitignore**에 다음과 같이 코드를 추가하여 파일이 올라가는 것을 방지한다.

  > application-oauth.properties

  * 커밋 파일 목록에 application-oauth.properties가 나오지 않으면 성공이다.



#### 5.3 구글 로그인 연동

* 구글의 로그인 인증정보를 발급 받았으니 프로젝트 구현을 진행한다.

* 사용자 정보를 담당할 도메인인 **User 클래스를 생성**한다. 패키지는 domain 아래에 user 패키지를 생성한다.

  * **User**

  ```User
  import com.allsser.book.springboot.domain.BaseTimeEntity;
  import lombok.Builder;
  import lombok.Getter;
  import lombok.NoArgsConstructor;
  
  import javax.persistence.*;
  
  @Getter
  @NoArgsConstructor
  @Entity
  public class User extends BaseTimeEntity {
  
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
  
      @Column(nullable = false)
      private String name;
  
      @Column(nullable = false)
      private String email;
  
      @Column
      private String picture;
  
      @Enumerated(EnumType.STRING)	//	{1}
      @Column(nullable = false)
      private Role role;
  
      @Builder
      public User(String name, String email, String picture, Role role) {
  
          this.name = name;
          this.email = email;
          this.picture = picture;
          this.role = role;
      }
  
      public User update(String name, String picture) {
          this.name = name;
          this.picture = picture;
  
          return this;
      }
  
      public String getRoleKey() {
          return this.role.getKey();
      }
  }
  ```

  * {1} **Enumerated(enumType.STRING)**
    * JPA로 데이터베이스로 저장할 때 Enum 값을 어떤 형태로 저장할지를 결정한다.
    * 기본적으로는 int로 된 숫자가 저장된다.
    * 숫자로 저장되면 데이터베이스로 확인할 때 그 값이 무슨 코드를 의미하는지 알 수가 없다.
    * 그래서 문자열 (EnumType.SPRING)로 저장될 수 있도록 선언한다.

  

  * 각 사용자의 권한을 관리할 **Enum 클래스 Role을 생성**한다.
  * .../domain/user/Role

  **Role**

  ```Role
  import lombok.Getter;
  import lombok.RequiredArgsConstructor;
  
  @Getter
  @RequiredArgsConstructor
  public enum Role {
      
      GUEST("ROLE_GUEST", "손님"),
      USER("ROLE_USER", "일반 사용자");
      
      private final String key;
      private final String title;
  }
  ```

  * 스프링 시큐리티에서는 권한 코드에 항상 **ROLE_이 앞에 있어야만** 한다.

  * 코드별 키 값을 **ROLE_GUEST, ROLE_USER** 등으로 지정한다.

    

  * User의 **CRUD**를 책임질 **UserRepository**도 생성한다.

  * .../domain/user/UserRepository

  ```UserRepository
  import org.springframework.data.jpa.repository.JpaRepository;
  
  import java.util.Optional;
  
  public interface UserRepository extends JpaRepository<User, Long> {
      
      Optional<User> findByEmail(String email);	//	{1}
  }
  ```

  * {1}	**findByEmail**
    * 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메소드이다.
  * **User 엔티티** 관련 코드를 모두 작성했으니 본격적으로 시큐리티 설정을 진행한다.



* **스프링 시큐리티 설정**

  * build.gradle에 스프링 시큐리티 관련 의존성을 추가해 준다.

    > implementation('org.springframework.boot:spring-boot-starter-oauth2-client')	//	{1}

  * {1} **spring-boot-starter-oauth2-client**

    * 소셜 로그인 등 클라이언트 입장에서 소셜 기능 구현 시 필요한 의존성이다.
    * spring-security-oauth2-client와 spring-security-oauth2-jose를 기본으로 관리해 준다.

    

  * build.gradle 설정이 끝나면, **OAuth** 라리브러리를 이용한 소셜 로그인 설정 코드를 작성한다.

  * **config.auth** 패키지를 생성한다. 앞으로 **시큐리티 관련 클래스는 모두 이 곳에** 담는다.

  ![config.oauth](images/config.oauth.PNG)

  * **SecurityConfig 클래스**를 생성하고 코드를 작성한다.

  **SecurityConfig**

  ```SecurityConfig
  import com.allsser.book.springboot.domain.user.Role;
  import lombok.RequiredArgsConstructor;
  import org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
  import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
  
  @RequiredArgsConstructor
  @EnableWebSecurity	//	{1}
  public class SecurityConfig extends WebSecurityConfigurerAdapter {
      
      private final CustomOAuth2UserService customOAuth2UserService;
      
      @Override
      protected void configure(HttpSecurity http) throws  Exception {
          http
                  .csrf().disable().headers().frameOptions().disable()	//	{2}
                  .and()
                      .authorizeRequests()	//	{3}
                      .antMatchers("/", "/css/**", "/images/**",	
                      				"/js/**", "/h2-console/**").permitAll()
                      .antMatchers("/api/v1/**").hasRole(Role.USER.name())	//	{4}
                      .anyRequest().authenticated()	//	{5}
                  .and()
                      .logout()
                          .logoutSuccessUrl("/")	//	{6}
                  .and()
                      .oauth2Login()	//	{7}
                          .userInfoEndpoint()	//	{8}
                              .userService(customOAuth2UserService);	//	{9}
      }
  }
  ```
  
* {1} **@EnableWebSecurity**
  
  * Spring Security 설정들을 활성화시켜준다.
  
* {2} **csrf( ).disable( ).headers( ).frameOptions( ).disable( )**
  
  * h2-console 화면을 사용하기 위해 해당 옵션들을 disable 한다.
  
* {3} **authorizeRequests**
  
  * URL별 권한 관리를 설정하는 옵션의 시작점이다.
    * authorizeRequests가 선언되어야만 antMatchers옵션을 사용할 수 있다.
  
* {4} **antMatchers**
  
  * 권한 관리 대상을 지정하는 옵션이다.
    * URL, HTTP 메소드별로 관리가 가능하다.
    * "/" 등 지정된 URL들은 permitAll( ) 옵션을 통해 전체 연람 권한을 주었다.
    * "/api/v1/**" 주소를 가진 API는 USER 권한을 가진 사람만 가능하도록 했다.
  
* {5} **anyRequest**
  
  * 설정된 값들 이외 나머지 URL들을 나타낸다.
    * 여기서는 authenticated( )을 추가하여 나머지 URL들은 모두 인증된 사용자들에게 만 허용하게 한다.
  
* {6} **logout( ).logoutSuccessUrl("/")**
  
  * 로그아웃 기능에 대한 여러 설정의 진입점이다.
    * 로그아웃 성공시 / 주소로 이동한다.
  
* {7} **oauth2Login**
  
  * OAuth 2 로그인 기능에 대한 여러 설정의 진입점이다.
  
* {8} **userInfoEndpoint**
  
  * OAuth 2 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당한다.
  
* {9} **userService**
  
  * 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록한다.
    * 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있다.
  
  
  
* 설정 코드 작성이 끝나면 **CustomOAuth2UserService** 클래스를 생성한다.
  
* 이 클래스에서는 구글 로그인 이후 가져온 사용자의 정보(email, name, picture 등)들을 기반으로 가입 및 정보수정, 세션 저장 등의 기능을 지원한다.
  
* .../config/auth/CustomOAuth2UserService
  

**CustomOAuth2UserService**

```CustomOAuth2UserService
  import com.allsser.book.springboot.domain.user.User;
  import com.allsser.book.springboot.domain.user.UserRepository;
  import lombok.RequiredArgsConstructor;
  import org.springframework.security.core.authority.SimpleGrantedAuthority;
  import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
  import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
  import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
  import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
  import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
  import org.springframework.security.oauth2.core.user.OAuth2User;
  import org.springframework.stereotype.Service;
  
  import javax.servlet.http.HttpSession;
  import java.util.Collections;
  
  @RequiredArgsConstructor
  @Service
  public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
      private final UserRepository userRepository;
      private final HttpSession httpSession;
      
      @Override
      public OAuth2User loadUser(OAuth2UserRequest userRequest) 
      					throws OAuth2AuthenticationException {
          OAuth2UserService<OAuth2UserRequest, OAuth2User> 
          		delegate = new DefaultOAuth2UserService();
          OAuth2User oAuth2User = delegate.loadUser(userRequest);
          
          String registrationId = userRequest.
          	getClientRegistration().getRegistrationId();	//	{1}
          String userNameAttributeName = userRequest.
          	getClientRegistration().getProviderDetails()
              .getUserInfoEndpoint().getUserNameAttributeName();	//	{2}
          
          OAuthAttributes attributes = OAuthAttributes.
          			of(registrationId, userNameAttributeName,
                  	oAuth2User.getAttributes());	//	{3}
          
          User user = saveOrUpdate(attributes);
          
          httpSession.setAttribute("user", new SessionUser(user));	//	{4}
          
          return new DefaultOAuth2User(
                  Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                  attributes.getAttributes(),
                  attributes.getNameAttributeKey());
      }
      
      private User saveOrUpdate(OAuthAttributes attributes) {
          User user = userRepository.findByEmail(attributes.getEmail())
                  .map(entity -> entity.update(attributes.
                  		getName(), attributes.getPicture()))
                  .orElse(attributes.toEntity());
          
          return userRepository.save(user);
      }
  }
```

* {1} **registrationId**
  
  * 현재 로그인 진행 중인 서비스를 구분하는 코드이다.
    * 지금은 구글만 사용하는 불필요한 값이지만, 이후 네이버 로그인 연동 시에 네이버 로그인인지, 구글 로그인인지 구분하기 위해 사용한다.
  
* {2} **userNameAttributeName**
  
  * OAuth2 로그인 진행 시 키가 되는 필드값을 이야기한다. Primary Key와 같은 의미이다.
    * 구글의 경우 기본적으로 코드를 지원하지만, 네이버 카카오 등은 기본 지원하지 않는다. 구글의 기본 코드는 "sub"이다.
    * 네이버 로그인과 구글 로그인을 동시에 지원할 때 사용한다.
  
* {3} **OAuthAttributes**
  
  * OAuth2UserService를 통해 가져온 OAuth2User의 attribute를 담을 클래스이다.
    * 이후 네이버 등 다른 소셜 로그인도 이 클래스를 사용한다.
  
* {4} **SessionUser**
  
  * 세션에 사용자 정보를 저장하기 위한 Dto 클래스이다.
  
  * **왜 User 클래스를 쓰지 않고 새로 만들어서 쓰는지** 설명
  
    > 만약 User 클래스를 그대로 사용했다면 다음과 같은 에러가 발생한다.
      >
      > ---
      >
      > **Failed to convert from type [java.lang.Object] to tyoe [byte[]] for value 'com.allsser.book.sprigboot.domain.user.User@4a43d6'**
      >
      > ---
      >
      > * 이는 세션에 저장하기 위해 User 클래스를 세션에 저장하려고 하니, User 클래스에 **직렬화를 구현하지 않았다**는 의미의 에러이다.
      > * 오류를 해결하기 위해 User 클래스에 직렬화 코드를 넣으면 될까? 많은 생각이 필요하다.
      > * 이유는 **User 클래스가 엔티티**이기 때문이다. 엔티티 클래스에는 언제 다른 엔티티와 관계가 형성될지 모른다.
      > * 예를 들어 **@OneToMany, @ManyToMany** 등 자식 엔티티를 갖고 있다면 직렬화 대상에 자식들까지 포함되니 **성능 이슈, 뷰수 효과**가 발생할 확률이 높다. 그래서 **직렬화 기능을 가진 세션 Dto**를 하나 추가로 만드는 것이 이후 운영 및 유지보수 때 많은 도움이 된다.
  
  
  
* 구글 사용자 정보가 업데이트 되었을 때를 대비하여 **update** 기능도 같이 구현하였다. 사용자의 이름(name)이나 프로필 사진(picture)이 변경되면 **User** 엔티티에도 반영된다.
  
* **OAuthAttributes는 DTO로 보기** 때문에 **config.auth.dto** 패키지를 만들어 **OAuthAttributes** 클래스를 만들어 준다.
  

**OAuthAttributes**

```OAuthAttributes
  import com.allsser.book.springboot.domain.user.Role;
  import com.allsser.book.springboot.domain.user.User;
  import lombok.Builder;
  import lombok.Getter;
  
  import java.util.Map;
  
  @Getter
  public class OAuthAttributes {
      private Map<String, Object> attributes;
      private String nameAttributeKey;
      private String name;
      private String email;
      private String picture;
  
      @Builder
      public OAuthAttributes(Map<String, Object> attributes,
                             String nameAttributeKey, String name,
                             String email, String picture) {
          this.attributes = attributes;
          this.nameAttributeKey = nameAttributeKey;
          this.name = name;
          this.email = email;
          this.picture = picture;
      }
  
  	//	{1}
      public static OAuthAttributes of(String registrationId,
                                       String userNameAttributeName,
                                       Map<String, Object> attributes) {
          return ofGoogle(userNameAttributeName, attributes);
      }
  
      private static OAuthAttributes ofGoogle(String userNameAttributeName,
                                              Map<String, Object> attributes) {
          return OAuthAttributes.builder()
                  .name((String) attributes.get("name"))
                  .email((String) attributes.get("email"))
                  .picture((String) attributes.get("picture"))
                  .attributes(attributes)
                  .nameAttributeKey(userNameAttributeName)
                  .build();
      }
  
  	//	{2}
      public User toEntity() {
          return User.builder()
                  .name(name)
                  .email(email)
                  .picture(picture)
                  .role(Role.GUEST)
                  .build();
      }
  }
```

* {1} **of( )**
  
  * OAuth2User에서 반환하는 사용자 정보는 Map이기 때문에 값 하나하나 변환해야 한다.
  
* {2} **toEntitiy( )**
  
  * User 엔티티를 생성한다.
    * OAuthAttributes에서 엔티티를 생성하는 시점은 처음 가입할 때이다.
    * 가입할 때의 기본 권한을 GUEST로 주기 위해서 role 빌더값에는 Role.GUEST를 사용한다.
    * OAuthAttributes 클래스 생성이 끝났으면 같은 패키지에 SessionUser 클래스를 생성한다.
  
  
  
* config.auth.dto 패키지에 **SessionUser** 클래스를 추가한다.
  

**SessionUser**

```SessionUser
  import com.allsser.book.springboot.domain.user.User;
  import lombok.Getter;
  
  import java.io.Serializable;
  
  @Getter
  public class SessionUser implements Serializable {
      private String name;
      private String email;
      private String picture;
      
      public SessionUser(User user) {
          this.name = user.getName();
          this.email = user.getEmail();
          this.picture = user.getPicture();
      }
  }
```

* SessionUser에는 **인증된 사용자 정보**만 필요하다. 그 외에 필요한 정보들은 없으니  name, email, picture만 필드로 선언한다.



* **로그인 테스트**

  * 스프링 시큐리티가 잘 적용되었는지 확인하기 위해 화면에 로그인 버튼을 추가한다.
  * index.mustache에 로그인 버튼과 로그인 성공 시 사용자 이름을 보여주는 코드이다.

  **index.mustache**

  ```index.mustache
  ...
      <h1>스프링부트로 시작하는 웹 서비스 Ver.2</h1>
      <div class="col-md-12">
          <!-- 로그인 기능 영역 -->
          <div class="row">
              <div class="col-md-6">
                  <a href="/posts/save" role="button" class="btn btn-primary">
                  	글 등록
                  </a>
                  {{#nameUser}}	//	{1}
                      Logged in as: <span id="user">{{nameUser}}</span>
                      <a href="/logout" class="btn btn-info active" role="button">
                      	Logout
                      </a>	//	{2}
                  {{/nameUser}}
                  {{^nameUser}}	//	{3}
                      <a href="/oauth2/authorization/google"	//	{4}
                      			class="btn btn-success active" role="button">
                          Google Login
                      </a>
                  {{/nameUser}}
              </div>
          </div>
          <br>
          <!-- 목록 출력 영역 -->
  		...
  ```

  * {1} **{{#userName}}**
    * 머스테치는 다른 언어와 같은 if문(if userName != null 등)을 제공하지 않는다.
    * true/false 여부만 판단할 뿐이다.
    * 그래서 머스테치에서는 항상 최종값을 넘겨줘야 한다.
    * 여기서도 역시 userName이 있다면 userName을 노출시키도록 구성했다.
  * {2} **a href="/logout"**
    * 스프링 시큐리티에서 기본적으로 제공하는 로그아웃 URL이다.
    * 즉, 개발자가 별도로 저 URL에 해당하는 컨트롤러를 만들 필요가 없다.
    * SecurityConfig 클래스에서 URL을 변경할 순 있지만 기본 URL을 사용해도 충분하니 여기서는 그대로 사용했다.
  * {3} **{{^userName}}**
    * 머스테치에서 해당 값이 존재하지 않는 경우에는 ^ 를 사용한다.
    * 여기서는 userName이 없다면 로그인 버튼을 노출시키도록 구성했다.
  * {4} **a href="/oauth2/authorization/google"**
    * 스프링 시큐리티에서 기본적으로 제공하는 로그인 URL이다.
    * 로그아웃 URL과 마찬가지로 개발자가 별도의 컨트롤러를 생성할 필요가 없다.

  

  * index.mustache에서 userName을 사용할 수 있게 IndexController에서 userName을 model에 저장하는 코드를 추가한다.

  **IndexController**

  ```IndexController
  import javax.servlet.http.HttpSession;
  
  @RequiredArgsConstructor
  @Controller
  public class IndexController {
  
      private final PostsService postsService;
      private final HttpSession httpSession;
  
      @GetMapping("/")
      public String index(Model model) {
          model.addAttribute("posts", postsService.findAllDesc());
          SessionUser user = (SessionUser) httpSession.getAttribute("user");	//	{1}
          
          if (user != null) {	// {2}
              model.addAttribute("nameUser", user.getName());	//	{3}
          }
          
          return "index";
      }
  }
  ```

  * {1} **(SeesionUser) httpSession.getAttribute("user")**

    * 앞서 작성된 CustomOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성했다.
    * 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을  가져올 수 있다.

  * {2} **if (user != null)**

    * 세션에 저장된 값이 있을 때만 model에 userName으로 등록한다.
    * 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보이게 된다.

  * {3} **model.addAttribute("nameUser", user.getName())**

    * 책에서는 "nameUser"가 아닌 "userName"으로 적혀있다. 책대로 진행하니 구글 로그인 시 사용자 이름을 출력하는 것이 아닌 프로젝트를 실행하고 있는 로컬 컴퓨터 로그인 이름이 뜬다.
  * 변수가 "UserName"이나 "Username"과 같이 대소문자 구별없는 "username"문자열이면 이런 이슈가 발생하는거 같다.  윈도우의 환경변수 이슈 때문에 발생한 오류이다.(맥OS는 상관없다.)
    * userName이 아닌 임의로 정해준 nameUser를 입력했더니 구글 로그인 시 사용자 이름을 정상적으로 출력했다.

    
  
  * 프로젝트를 실행시키면 **Google Login 버튼**이 생성되었다.
  
  ![googleLoginButton](images/googleLoginButton.PNG)
  
  * 클릭해 보면 다른 서비스에서 볼 수 있던 것처럼 구글 로그인 화면으로 이동한다.
  
    
  
  * 회원 가입이 잘 되어 있는지 확인해 보기 위해 **http://localhost:8080/h2-console**에 접속해서 **user** 테이블을 확인해 보면 데이터베이스에 정상적으로 회원정보가 들어간 것을 확인할 수 있다.
  
  ![userTable](images/userTable.PNG)
  
  * 현재 사용자의 권한은**GUEST**이다. 이 상태에서는 posts 기능을 전혀 쓸 수 없다. 실제로 글을 등록해 보면 **403(권한 거부)** 에러가 발생하는 것을 볼 수 있다.
  
  ![403에러](images/403에러.PNG)
  
  * h2-console로 가서 권한을 변경하기 위해 사용자의 role를 **USER**로 변경한다.
  
    > update user set role = 'USER';
  
  ![권한변경](images/권한병경.PNG)
  
  * 세션에는 이미 **GUEST**인 정보로 저장되어있으니 로그아웃을한 후 다시 로그인 하여 세션 정보를 최신 정보로 갱신한 후에 글을 등록해 보면 정상적으로 글이 등록되는 것을 확인할 수 있다.



#### 5.4 어노테이션 기반으로 개선

* 일반적으로 프로그래밍에서 개선이 필요한 나쁜 코드에는 어떤 것이 있을까?

  * 가장 대표적으로 **같은 코드가 반복**되는 부분이다. 같은 코드를 계속해서 복사&붙여넣기로 반복하게 만든다면 이후에 수정이 필요할 때 모든 부분을 하나씩 찾아가며 수정해야 한다. 이렇게 될 경우 유지보수성이 떨어지며, 혹시나 수정이 반영되지 않은 반복 코드가 있다면 문제가 발생할 수밖에 없다.

  * 앞서 만든 코드에서 개선할만한 것은 IndexController에서 **세션값을 가져오는 부분**이 있다.

    > SessionUser user = (SessionUser) httpSession.getAttribute("user");

  * index 메소드 외에 다른 컨트롤러와 메소드에서 세션값이 필요하면 그때마다 직접 세션 값을 가져와야 한다. 같은 코드가 계속해서 반복되는 것은 불필요하다. 그래서 이 부분을 **메소드 인자로 세션값을 바로 받을 수 있도록** 변경한다.

  * config.auth 패키지에 **@LoginUser** 어노테이션을 생성한다.

  **LoginUser**

  ```LoginUser
  import java.lang.annotation.ElementType;
  import java.lang.annotation.Retention;
  import java.lang.annotation.RetentionPolicy;
  import java.lang.annotation.Target;
  
  @Target(ElementType.PARAMETER)	//	{1}
  @Retention(RetentionPolicy.RUNTIME)
  public @interface LoginUser {	//	{2}
  }
  ```

  * {1} **@Target(ElementType.PARAMTER)**

    * 이 어노테이션이 생성될 수 있는 위치를 지정한다.
    * PARAMTER로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용할 수 있다.
    * 이 외에도 클래스 선언문에 쓸  수 있는 TYPE 등이 있다.

  * {2} **@interface**

    * 이 파일을 어노테이션 클래스로 지정한다.
    * LoginUser라는 이름을 가진 어노테이션이 생성되었다고 보면 된다.

    

  * 같은 위치에 **LoginUserArgumentResolver**를 생성한다. **LoginUserArgumentResolver**라는 **HandlerMethodArgumentResolver** 인터페이스를 구현한 클래스이다.

  * **HandlerMethodArgumentResolver** 는 한가지 기능을 지원한다. 바로 조건에 맞는 경우 메소드가 있다면 **HandlerMethodArgumentResolver**의 구현체가 지정한 값으로 해당 메소드의 파라미터로 넘길 수 있다.

  **LoginUserArgumentResolver**

  ```LoginUserArgumentResolver
  import lombok.RequiredArgsConstructor;
  import org.springframework.core.MethodParameter;
  import org.springframework.stereotype.Component;
  import org.springframework.web.bind.support.WebDataBinderFactory;
  import org.springframework.web.context.request.NativeWebRequest;
  import org.springframework.web.method.support.HandlerMethodArgumentResolver;
  import org.springframework.web.method.support.ModelAndViewContainer;
  
  import javax.servlet.http.HttpSession;
  
  @RequiredArgsConstructor
  @Component
  public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver{
  
      private final HttpSession httpSession;
  
      @Override
      public boolean supportsParameter(MethodParameter parameter) {	//	{1}
      
          boolean isLoginUserAnnotation = 
          	parameter.getParameterAnnotation(LoginUser.class) != null;
          	
          boolean isUserClass = 
          	SessionUser.class.equals(parameter.getParameterType());
  
          return isLoginUserAnnotation && isUserClass;
      }
  
      @Override
      public Object resolveArgument(MethodParameter parameter,	// {2}
      	ModelAndViewContainer mavContainer,NativeWebRequest webRequest, 
          WebDataBinderFactory binderFactory) throws Exception {
          
          return httpSession.getAttribute("user");
      }
  }
  ```

  * {1} **supportsParameter( )**

    * 컨트롤러 메서드의 특정 파라미터를 지원하는지 판단한다.
    * 여기서는 파라미터에 @LoginUser 어노테이션이 붙어 있고, 파라미터 클래스 타입이 SesscionUser.class인 경우 true를 반환한다.

  * {2} **resolveArgument( )**

    * 파라미터에 전달할 객체를 생성한다.
    * 여기서는 세션에서 객체를 가져온다.

  * **@LoginUser**를 사용하기 위한 환경은 구성되었다

    

  * 이렇게 생성된 LoginUserArgumentResolver가 **스프링에서 인식될 수 있도록** WebMvcConfigurer에 추가해준다.

  * config 패키지에 WebConfig 클래스를 생성하여 다음과 같이 설정을 추가해준다.

  **WebConfig**

  ```WebConfig
  import lombok.RequiredArgsConstructor;
  import org.springframework.context.annotation.Configuration;
  import org.springframework.web.method.support.HandlerMethodArgumentResolver;
  import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
  
  import java.util.List;
  
  @RequiredArgsConstructor
  @Configuration
  public class WebConfig implements WebMvcConfigurer {
      private final LoginUserArgumentResolver loginUserArgumentResolver;
  
      @Override
      public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
          argumentResolvers.add(loginUserArgumentResolver);
      }
  }
  ```

  * **HandlerMethodArgumentResolver**는 항상 **WebMvcConfigurer**의 **addArgumentResolvers( )**를 통해 추가해야 한다.

  * 다른 HandlerMethodArgumentResolver가 필요하다면 같은 방식으로 추가해 주면 된다.

    

  * 모든 설정이 끝났으니 **IndexController**의 코드에서 반복되는 부분들을 묻 **@LoginUser**로 개선한다.

  **IndexController**

  ```IndexController
  ...
  @RequiredArgsConstructor
  @Controller
  public class IndexController {
  
      private final PostsService postsService;
      private final HttpSession httpSession;
  
      @GetMapping("/")
      public String index(Model model, @LoginUser SessionUser user) {	//	{1}
          model.addAttribute("posts", postsService.findAllDesc());
     
          if (user != null) {
              model.addAttribute("nameUser", user.getName());
          }
          return "index";
      }
  ```

  * {1} **@LoginUser SessionUser user**
    * 기존에 (User) httpSession.getAttribute("user")로 가져오던 세션 정보 값이 개선되었다.
    * 이제는 어느 컨트롤러든지 @LoginUser만 사용해서 세션 정보를 가져올 수 있다.



#### 5.5 세션 저장소로 데이터베이스 사용

* 추가로 개선. 현재 프로젝트의 서비스는 **애플리케이션을 재실행**하면 로그인이 풀린다.
  * 이유는 세션이 **내장 톰캣의 메모리에 저장**되기 때문이다. 기본적으로 세션은 실행되는 **WAS(Web Application Server)**의 메모리에서 저장되고 호출된다. 메모리에 저장되다 보니 **내장 톰캣처럼 애플리케이션 실행 시 실행되는 구조에선 항상 초기화**된다. 즉, **배포할 때마다 톰캣이 재시작**되는 것이다.
  * 이 외에도 한 가지 문제가 더 있다. 2대 이상의 서버에서 서비스하고 있다면 **톰캣마다 세션 동기화** 설정을 해야만 한다. 그래서 실제 현업에서는 세션 저장소에 대해 다음의 3가지 중 한가지를 선택한다.
    * (1) 톰캣 세션을  사용한다.
      * 일반적으로 별다른 설정을 하지 않을 때 기본적으로 선택되는 방식이다.
      * 이렇게 될 경우 톰캣(WAS)에 세션이 저장되기 때문에 2대 이상의 WAS가 구동되는 환경에서는 톰캣들 간의 세션 공유를 위한 추가 설정이 필요하다.
    * (2) MySQL과 같은 데이터베이스를 세션 저장소로 사용한다.
      * 여러 WAS 간의 공용 세션을 사용할 수 있는 가장 쉬운 방법이다.
      * 많은 설정이 필요 없지만, 결국 로그인 요청마다 DB IO가 발생하여 성능상 이슈가 발생할 수 있다.
      * 보통 로그인 요청이 많이 없는 백오피스, 사내 시스템 용도에서 사용한다.
    * (3) Redis, Memcached와 같은 메모리 DB를 세션 저장소로 사용한다.
      * B2C 서비스에서 가장 많이 사용하는 방식이다.
      * 실제 서비로 사용하기 위해서는 Embedded Redis와 같은 방식이 아닌 외부 메모리 서버가 필요하다.
  * 이 프로젝트에서는 두 번째 방식인 **데이터베이스를 세션 저장소**로 사용하는 방식을 선택하여 진행한다.
  * 선택한 이유는 **설정이 간단**하고 사용자가 많은 서비스가 아니며 비용 절감을 위해서이다.
  * 이후 AWS에서 이 서비스를 배포하고 운영할 때를 생각하면 레디스와 같은 메모리 DB를 사용하기는 부담그럽다. 왜냐하면, 레디스와 같은 서비스(엘라스틱 캐시)에 별도로 사용료를 지불해야 하기 때문이다.
  * 사용자가 없는 현재 단계에서는 데이터베이스로 모든 기능을 처리하는게 부담이 적다.



* **spring-session-jdbc 등록**

  * build.gradle에 의존성을 등록한다. spring-session-jdbc 역시 현재 상태에선 바로 사용할 수 없다. spring web, spring jpa를 사용했던 것과 마찬가지로 의존성이 추가되어 있어야 사용할 수 있다.

    > implementation('org.springframework.session:spring-session-jdbc')

  * 그리고 **application.properties**에 세션 저장소를 **jdbc**로 선택하도록 코드를 추가한다. 이 외에 설정할 것은 없다.

    > spring.session.store-type=jdbc

    

  * 모두 변경하였으니 다시 애플리케이션을 실행해서 로그인 테스트한 뒤, **h2-console**로 접속한다.
  * h2-console을 보면 세션을 위한 테이블 2개**(SPRING_SESSION, SPRING_SESSION_ATTRIBUTES)**가 생성된 것을 볼 수 있다. **JPA로 인해 세션 테이블이 자동 생성**되었기 때문에 별도로 해야 할 일은 없다.
  * 로그인했기 때문에 한 개의 세션이 등록돼있는 것을 볼 수 있다.

  ![세션](images/세션.PNG)

  * 세션 저장소를 데이터베이스로 교체했다. 
  * 현재는 기존과 동일하게 **스프링을 재시작하면 세션이 풀린다.** 이유는 H2 기반으로 스프링이 재실행될 때 **H2도 재시작되기 때문**이다.
  * 이후 **AWS**로 배포하게 되면 AWS의 데이터베이스 서비스인 **RDS(Relational Database Service)**를 사용하게 되니 이때부터는 세션이 풀리지 않는다.



#### 5.6 네이버 로그인

* **네이버 API 등록**

  * 네이버 오픈 API로 이동한다.

  > https://developers.naver.com/apps/#/register?api=nvlogin

  * 다음과 같이 항목을 채워준다.

  ![naverservice1](images/naverservice1.PNG)

  * 회원이름, 이메일, 프로필 사진은 필수이며 추가 정보는 필요한 경우 선택할 수 있다.

  ![naverservice2](images/naverservice2.PNG)

  * 구글과 마찬가지로 URL을 등록한다.

  * 서비스 URL은 필수이다. 여기서는 **localhost:8080** 으로 등록한다.

  * **Callback URL**은 구글에서 등록한 리디렉션 URL과 같은 역할을 한다. 여기서는 **/login/oauth2/code/naver**로 등록한다.

  * 등록을 완료하면 **ClientID**와 **ClientSecret**가 생성된다.

    

  * 해당 키값들을 **application-oauth.properties**에 등록한다. 네이버에서는 스프링 시큐리티를 공식 지원하지 않기 때문에 그동안 **Common-OAuth2Provider**에서 해주던 값들도 전부 수동으로 입력해야 한다.

  **applicaiton-oauth.properties**

  ```applicaiton-oauth.properties
  # registration
  spring.security.oauth2.client.registration.naver.client-id=5Ns1c8UVpWwRucnjRrNa
  spring.security.oauth2.client.registration.naver.client-secret=MmXjZjttga
  spring.security.oauth2.client.registration.naver.redirect-uri={baseUrl}/{action}/oauth2/code/{registrationId}
  spring.security.oauth2.client.registration.naver.authoriztion_grant_type=authorization_code
  spring.security.oauth2.client.registration.naver.scope=name, email, profile_image
  spring.security.oauth2.client.registration.naver.client-name=Naver
  
  # provider
  spring.security.oauth2.client.provider.naver.authorization_url=https://nid.naver.com/oauth2.0/authorize
  spring.security.oauth2.client.provider.naver.token_uri=https://nid.naver.com/oauth2.0/token
  spring.security.oauth2.client.provider.naver.user-info-uri=https://openapi.naver.com/v1/nid/me
  spring.security.oauth2.client.provider.naver.user_name_attribute=response	//	{1}
  ```

  * {1} **user_name_attribute=response**
    * 기준이 되는 user_name의 이름을 네이버에서는 response로 해야한다.
    * 이유는 네이버의 회원 조회 시 반환되는 JSON 형태 때문이다.
  * 스프링 시큐리티에선 **하위 필드를 명시할 수 없다.** 최상위 필드들만 **user_name**으로 지정 가능하다. 하지만 네이버의 응답값 최상위 필드는 **resultCode, message, response**이다.
  * 이러한 이유로 스프링 시큐리티에서 인식 가능한 필드는 저 3개 중에 골라야 한다. 본문에서 담고 있는 response를 user_name으로 지정하고 이후 **자바 코드로 response의 id를 user_name**으로 지정하겠다.



* **스프링 스큐리티 설정 등록**

  * 구글 로그인을 등록하면서 대부분 코드가 확장성 있게 작성되었다 보니 네이버는 쉽게 등록 가능하다. **OAuthAttributes**에 다음과 같이 **네이버인지 판단하는 코드와 네이버 생성자**만 추가해 주면 된다.

  **OAuthAttributes**

  ```OAuthAtrributes
  @Getter
  public class OAuthAttributes {
  	...
  
      public static OAuthAttributes of(String registrationId,
                                       String userNameAttributeName,
                                       Map<String, Object> attributes) {
          if("naver".equals(registrationId)){
              return ofNaver("id", attributes);
          }
          return ofGoogle(userNameAttributeName, attributes);
      }
      
      ...
      
      private static OAuthAttributes ofNaver(String userNameAttributeName,
                                             Map<String, Object> attributes) {
          Map<String, Object> response = 
          		(Map<String, Object>) attributes.get("response");
          
          return OAuthAttributes.builder()
                  .name((String) response.get("name"))
                  .email((String) response.get("email"))
                  .picture((String) response.get("profile_image"))
                  .attributes(response)
                  .nameAttributeKey(userNameAttributeName)
                  .build();
      }
  	...
  }
  ```

  

  * **index.mustache**에 네이버 로그인 버튼을 추가한다.

  **index.mustache**

  ```index.mustache
  ... 
     ...        
          {{^nameUser}}
              <a href="/oauth2/authorization/google" 
              			class="btn btn-success active" role="button">
                  Google Login
              </a>
          
              <a href="/oauth2/authorization/naver" 
              			class="btn btn-secondary active" role="button">
                  Naver Login
              </a>	//	{1}
          {{/nameUser}}
      </div>
  </div>
  ...
  ```

  * {1} **/oauth2/authorization/naver**
    * 네이버 로그인 URL은 application-oauth.properties에 등록한 redirect-uri 값에 맞춰 자동으로 등록된다.
    * **/oauth2/authorization/** 까지는 고정이고 마지막 Path만 각 소셜 로그인 코드를 사용하면 된다.
    * 여기서는 naver가 마지막 Path가 된다.
    
    
    
  * 메인 화면을 확인해 보면 네이버 버튼이 활성화된 것을 볼 수 있다. 네이버 로그인 버튼을 클릭하면 동의 화면이 등장하고 동의를 하면 로그인이 성공적으로 되는 것을 확인할 수 있다.
  
  ![naverLogin](images/naverLogin.PNG)



#### 5.7 기존 테스트에 시큐리티 적용

* **기존 테스트에 시큐리티 적용으로 문제가 되는 부분**들을 해결한다.

* 문제가 되는 부분들은 대표적으로 다음과 같은 이유이다.

  * 기존에는 **API**를 호출할 수 있어 테스트 코드 역시 바로 API를 호출하도록 구성하였다. 하지만, 시큐리티 옵션이 활성화되면 인증된 사용자만 API를 호출할 수 있다.
  * 기존의 API 테스트 코드들이 모두 인증에 대한 권한을 받지 못하였스므로, 테스트 코드마다 인증한 사용자가 호출한 것처럼 작동하도록 수정한다.
  * 인텔리제이 오른쪽 위에 **[Gradle]** 탭을 클릭한다. **[Tasks -> verification -> test]**를 차례로 선택하여 **전체 테스트를 수행**한다.

  ![GradleTest](images/GradleTest.PNG)

  * test를 실해 보면 롬복을 이용한 테스트 외에 스프링을 이용한 테스트는 모두 실패하는 것을 확인할 수 있다.

    

  * **문제 1. CustomOAuth2UserService을 찾을 수 없음**

    * "hello가_리턴된다"의 메시지를 보면 "No qualifying bean of type 'com.allsser.book.springboot.config.auth.CustomOAuth2UserService' " 라는 메시지가 등장한다.

    ![hello가리턴된다](images/hello가리턴된다.PNG)

    * 이는 CustomOAuth2UserService를 생성하는데 필요한 **소셜 로그인 관련 설정값들이 없기 때문에** 발생한다.
    * **application-oauth.properties에 설정값들을 추가**했는데 왜 설정이 없다고 할까? 이유는 src/main 환경과 src/test 환경의 차이 때문이다. 둘은 본인만의 호환경 구성을 가진다. 다만, src/main/resource/application.properties가 테스트 코드를 수행할 때도 적용되는 이유는 **test에 application.properties가 없으면 main의 설정을 그대로 가져오기 때문**이다. 다만, 자동으로 가져오는 옵션의 범위는 application.properties 파일까지이다. 즉, application-oauth.properties는 **test에 파일이 없다고 가져오는 파일은 아니라는 점**이다.
* 이 문제를 해결하기 위해 테스트 환경을 위한 application.properties를 만든다. 실제로 구글 연동까지 진행할 것이 아니므로 **가짜 설정값**을 등록한다.
  

**src/test/resources/application.properties**
    
    ```application.properties
    spring.jpa.show_sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
    spring.jpa.properties.hibernate.dialect.storage_engine=innodb
    spring.datasource.hikari.jdbc-url=jdbc:h2:mem:testdb;MODE=MYSQL
    spring.datasource.hikari.username=sa
    spring.h2.console.enabled=true
    spring.session.store-type=jdbc


​    
​    # Test OAuth
​    
​    spring.security.oauth2.client.registration.google.client-id=test
​    spring.security.oauth2.client.registration.google.client-secret=test
​    spring.security.oauth2.client.registration.google.scope=profile, email
​    ```
​    
​    * 실패 테스크가 줄어든 것을 확인할 수 있다.

  * **문제 2. 302 Status Code**
  
    * 두 번째로 "Posts_등록된다" 테스트 로그를 확인해 본다.
    * 응답의 결과로 200(정상 응답) Status Code를 원했지만 결과는 302(리다이렉션 응답) Status Code가 와서 실패했다. 이는 스프링 스큐리티 설정 때문에 **인증되지 않은 사용자의 요청은 이동**시키기 때문이다.  그래서 이런 API 요청은 **임의로 인증된 사용자를 추가**하여 API만 테스트해 볼 수 있게 한다.
    * **스프링 시큐리티 테스트를 위한 여러 도구를 지**원하는 spring-security-test를 build.gradle에 추가한다.
    
    > testImplementation("org.springframework.security:spring-security-test")
  
    * 그리고 PostsApiControllerTest에 2개 테스트 메소드에 **임의 사용자 인증을 추가**한다.
    
    

  **PostsApiController**
    
    ```
    @Test
    @WithMockUser(roles="USER")	//	{1}
    pulic void Posts_등록된다( ) throw Exception {
    ...
    
    @Test
    @WithMockUser(roles="USER")
    public void Posts_수정된다() throw Exception {
    ...
  ```
    
  * **@WithMockUser(roles="USER")**
      
      * 인증된 모의(가짜) 사용자를 만들어서 사용한다.
      * roles에 권한을 추가할 수 있다.
    * 즉, 이 어노테이션으로 인해 ROLE_USER 권한을 가진 사용자가 API를 요청하는 것과 동인한 효과를 가지게 된다.
      
    
      
  * 이정도만 하면 테스트가 될 것 같지만, 실제로 작동하진 않는다.
      
  * **@WithMockUser가 MockMvc에서만 작동하기 때문**이다. 현재 PostsApiControllerTset는 @SpringBootTest로만 되어있으며 **MockMvc**를 전혀 사용하지 않는다. 그래서 **@SpringBootTest에서 MockMvc를 사용하는 방법**을 사용한다.
      
  
    **PostsApiControllerTest**
    
    ```PostsApiControllerTest
    import com.allsser.book.springboot.domain.posts.Posts;
    import com.allsser.book.springboot.domain.posts.PostsRepository;
    import com.allsser.book.springboot.web.dto.PostsSaveRequesrDto;
    import com.allsser.book.springboot.web.dto.PostsUpdateRequestDto;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.junit.jupiter.api.AfterEach;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.context.SpringBootTest;
    import org.springframework.boot.test.web.client.TestRestTemplate;
    import org.springframework.boot.web.server.LocalServerPort;
    import org.springframework.http.MediaType;
    import org.springframework.security.test.context.support.WithMockUser;
    
    import org.springframework.test.context.junit.jupiter.SpringExtension;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.test.web.servlet.setup.MockMvcBuilders;
    import org.springframework.web.context.WebApplicationContext;
    
    import java.util.List;
    
    import static org.assertj.core.api.Assertions.assertThat;
    import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
    
    @ExtendWith(SpringExtension.class)
    @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
    public class PostsApiControllerTest {
    	...
        
        @Autowired
        private WebApplicationContext context;
    
        private MockMvc mvc;
    
        @BeforeEach	//	{1}
        public void setup() {
            mvc = MockMvcBuilders
                    .webAppContextSetup(context)
                    .apply(springSecurity())
                    .build();
        }
        
        ...
    
        @Test
        @WithMockUser(roles = "USER")
        public void Posts_등록된다() throws Exception {
            ...
            
            //when
            mvc.perform(post(url)	// {2}
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(new ObjectMapper().writeValueAsString(requestDto)))
                    .andExpect(status().isOk());
    
            // then
            List<Posts> all = postsRepository.findAll();
            assertThat(all.get(0).getTitle()).isEqualTo(title);
            assertThat(all.get(0).getContent()).isEqualTo(content);
        }
    
        @Test
        @WithMockUser(roles = "USER")
        public void Posts_수정된다() throws Exception {
            ...
            
            // when
            mvc.perform(put(url)
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(new ObjectMapper().writeValueAsString(requestDto)))
                    .andExpect(status().isOk());
    
            // then
            List<Posts> all = postsRepository.findAll();
            assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
            assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
        }
  }
  ```

    * {1} **@BeforEach**
      
      * 어노테이션 : @Before (JUnit 4) -> **@BeforeEach (JUnit 5)**
    * import 패키지 : org.junit.Before (JUnit 4) -> **org.junit.jupiter.api.BeforeEach (JUnit 5)**
      * 매번 테스트가 시작되기 전에 **MockMvc** 인스턴스를 생성한다.
    
    * {2} **mvc.perform**
      
    * 생성된 MockMvc를 통해 API를 테스트 한다.
      * 본문(Body) 영역은 문자열로 표현하기 위해 ObjectMapper를 통해 문자열 JSON으로 변환한다.


​    

  * **문제 3 @WebMvcTest에서 CustomOAuth2UserService을 찾을 수 없음**
  
    * 제일 앞에서 발생산 "Hello가 리턴된다" 테스트를 확인해 보면 첫 번째로 해결한 것과 동일한 메시지인 **"No qualifying bean of type 'com.allsser.book.springboot.config.auth.CustomOAuth2UserService'"**가 뜬다.
    * HelloControllerTest는 1번과는 조금 다른점이 있다. 바로 **@WebMvcTest**를 사용한다는 것이다. 1번을 통해 스프링 시큐리티 설정은 잘 작동했지만, **@WebMvcTest**는 **CustomOAuth2UserService를 스캔하지 않기 때문**이다.
    * @WebMvcTest는 WebSecurityConfigurerAdapter, WebMvcConfigurer를 비롯한 @ControllerAdvice, @Controller를 읽는다. 즉, **@Repository, @Service, @Component는 스캔 대상이 아니다.** 그러니 SecurityConfig는 읽었지만, SecurityConfig를 생성하기 위해 필요한 CustomOAuth2UserService는 읽을수가 없어 앞에서와 같이 에러가 발생한 것이다.
    * 문제를 해결하기 위해 **스캔 대상에서 SecurityConfig를 제거한다.**
    
    

  **HelloControllerTest**
    
    ```HelloControllerTest
    @WebMvcTest(controllers = HelloController.class,
            excludeFilters = {
                    @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
                    								classes = SecurityConfig.class)
            }
    )
  ```
    
  * 언제 삭제될지 모르니 사용하지 않는 것을 추천한다.
      
    
      
  * **@WithMockUser**를 사용해서 가짜로 인증된 사용자를 생성한다.
      
  
    **HelloControllerTest**
    
    ```HelloControllerTest
    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception
    	...
    }
    
    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
    	...
  }
  ```

    * 이렇게 한 뒤 다시 테스트를 돌려보면 다음과 같은 추가 에러가 발생한다.
    
    > java.lang.IllegalArgumentException: At least one JPA metamodel must be present!
    
    * 이 에러는 **@EnableJpaAuditing**로 인해 발생한다. @EnableJpaAuditing를 사용하기 위해서는 최소 하나의 **@Entity 클래스가 필요**하다.
    * @WebMvcTest이다 보니 당연히 없다.
  * @EnableJpaAuditing가 @SpringBootApplication와 함께 있다보니 @WebMvcTset에서도 스캔하게 되었다. 그래서 @EnableJpaAuditing과 @SpringBootApplication 둘을 분리한다.
    * **Application.java**에서 @EnableJpaAuditing를 제거한다.
    
    
    **Application.java**
    
    ```Application.java
    // @EnableJpaAuditing가 삭제됨
    @SpringBootApplication
    public class Application {
        public static void main(String[] args) {
    
            SpringApplication.run(Application.class, args);
      }
    }
    ```
  ```
    
  * 그리고 config 패키지에 **JpaConfig**를 생성하여 **@EnableJpaAuditing**를 추가해준다.
      
    
    **.../springboot/config/JpaConfig**
    
    ```JpaConfig
    import org.springframework.context.annotation.Configuration;
    import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
    
  @Configuration
    @EnableJpaAuditing	//	JPA Auditing 활성화
  public class JpaConfig {}
  ```

    * 전체 테스트를 수행해 보면 모든 테스트를 통과하는 것을 확인할 수 있다. 


​    * 앞의 과정을 토대로 스프링 시큐리티 적용으로 깨진 테스트를 적절하게 수정할 수 있게 되었다.



---

### 6. AWS 서버 환경을 만들기 - AWS EC2

* **AWS(Amazon Web Service)**
* 외부에서 본인이 만든 서비스에 접근하려면 **24시간 작동하는 서버**가 필수이다. 24시간 작동하는 서버에는 3가지 선택지가 있다.
  * 집에 PC를 24시간 구동시킨다.
  * 호스팅 서비스(Cafe 24, 코리아호스팅 등)을 이용한다.
  * 클라우드 서비스(AWS, AZURE, GCP 등)을 이용한다.
* 일반적으로 비용은 호스팅 서비스나 집 PC를 이용하는 것이 저렴한다. 만약 특정 시간에만 트래픽이 몰린다면 **유동적으로 사양을 늘릴 수 있는 클라우드가 유리**하다.



* **클라우드** 서비스는 쉽게 말하면 인터넷(클라우드)을 통해 서버, 스토리지(파일 저장소), 데이터베이스, 네트워크, 소프트웨어, 모니터링 등의 컴퓨터 서비스를 제공하는 것이다.
* **AWS**의 **EC2**는 서버 장비를 대여하는 것이지만, 실제로는 그 안의 로그 관리, 모니터링, 하드웨어 교체, 네트워크 관리 등을 기본적으로 지원하고 있다. 개발자가 직접 해야 할 일을 AWS가 전부 지원을 하는 것이다.
* 이런 클라우드에는 몇 가지 형태가 있다.
  * **Infrastructure as a Service(IaaS, 아이아스, 이에스)**
    * 기존 물리 장치를 미들웨어와 함께 묶어둔 추상화 서비스이다.
    * 가상머신, 스토리지, 네트워크, 운영체제 등의 IT 인프라를 대여해 주는 서비스라고 보면 된다.
    * AWS의 EC2, S3 등
  * **Platfrom as a Service (PaaS, 파스)**
    * 앞에서 언급한 IaaS에서 한 번 더 추상화한 서비스이다.
    * 한 번 더 추상화했기 때문에 **많은 시능이 자동화**되어 있다.
    * AWS의 Beanstalk(빈스톡), Heroku(헤로쿠) 등
  * **Software as a Service (SaaS, 사스)**
    * 소프트웨어 서비스를 이야기한다.
    * 구글 드라이브, 드랍박스, 와탭 등



* 여러 클라우드 서비스(AWS, Azure, GCP 등) 중 AWS를 선택한 이유
  * 첫 가입 시 **1년간 대부분 서비스가** 무료이다. 단, 서비스마다 제한이 있는데 이는 각 서비스를 설정할 때 설명하겠다.
  * 클라우드에서는 기본적으로 지원하는 기능(모니터링, 로그관리, 백업, 복구, 클러스터링 등등) 이 많아 개인이나 소규모일 때 개발에 더 집중할 수 있다.
  * 많은 기업이 AWS로  이전 중이기 때문에 이직할 AWS 사용 경험은 도움이 된다. 국내에서는 AWS 점유율이 압도적이다.
  * 사용자가 많아 **국내 자료와 커뮤니티가 활성화**되어 있다.
* 모든 AWS 서비스는 IaaS를 사용한다. AWS의 PaaS 서비스인 빈스톡(Beanstalk)을 사용하면 대부분 작업이 간소화되지만, **프리티어로 무중단 배포가 불가능**하다.
* 배포할 때마다 서비스가 다운되면 제대로 된 서비스를만들 수 없으니 무중단 배포는 필수이고 빈스톡은 사용할 수 없다.



#### 6.1 AWS 회원가입

* AWS 공식 사이트(http://aws.amazon.com/ko/)로 이동한 뒤 **무료 계정 만들기**를 선택한다. 회원 가입 이후 지원 플랜은 무료로 사용하기 위함이니 무료 기본 플랜을 선택한다.

![플랜](images/플랜.PNG)

* 화면에 있는 **콘솔 로그인**버튼을 클릭해서 접속한다.



#### 6.2  EC2 인스턴스 생성

* **EC2(Elastic Compute Cloud)**는 AWS에서 제공하는 성능, 용량 등을 유동적으로 사용할 수 있는 서버이다.
* 보통 "AWS에서 리눅스 서버 혹은 윈도우 서버를 사용한다."라고 하면 이 EC2를 이야기하는 것이다.



* AWS에서 무료로 제공하는 프리티어 플랜에서는 EC2 사용에 다음과 같은 제한이 있다.
  * 사양이 t2.micro만 가능하다.
    * vCPU(가상 CPU) 1 Core, 메모리 1GB 사양이다.
    * 보통 vCPU는 물리 CPU 사양의 절반 정도의 성능을 가진다.
  * 월 750시간의 제한이 있다. 초과하면 비용이 부과된다.
    * 24시간*31일 = 744시간이다.
    * 즉, **1대의 t2.micro만 사용한다면 24시간** 사용할 수 있다.



* 앞의 제한 사항을 주의하면 1년동아 AWS를 써볼수 있다. EC2를 만들기 전에, 본인의 리전을 확인한다.

  > * **리전**이란 AWS의 서비스가 구동될 지역을 이야기한다. AWS는 도시별로 클라우드 센터를 지어 해당 센터에서 구축된 가상머신들을 사용할 수 있다. 이걸 리전이라 한다.
  >
  > * 서울 리전이 생기기 전까지 국내 서비스들은 도쿄 리전을 사용했다. 한국과 가장 가까운 지역이라 가장 네트워크가 빠르기 때문이였다. 현재는 서울 리전이 있어서 국내에서 서비스한다면 무조건 서울 리전을 선택해야 한다.

  * 보통은 처음 리전이 오아이주로 선택되어 있다. **서울로 변경**해준다.

  * 서울로 리전을 변경했다면 화면 중앙에 있는 검색창에서 ec2 를 입력하여 EC2 서비스를 클릭한다.

  * EC2 대시보드가 나오는데, 여기서 중앙에 있는 **[인스턴스 시작]** 버튼을 클릭한다. 인스턴스란 EC2 서비스에 생성된 가상머신을 이야기 한다.

    

  * 인스턴스를 생성하는 첫 단계는 **AMI(Amazon Machine Image, 아마존 머신 이미지)**를 선택하는 것이다. 

  * **AMI**는 EC2 인스턴스를 시작하는데 필요한 정보를 **이미지로 만들어 둔 것**을 이야기 한다. 인스턴스라는 가상 머신에 운영체제 등을 설치할 수 있게 구워 넣은 이미지로 생각하면 된다.

  * **Amazon Linux 2 AMI**을 선택한다. 인스턴스 유형을 선택하는 단계에서 인스턴스는 프리티어로 표기된 **t2.micro**를 선택한다.

    ![AMI](images/AMI.PNG)
    
    * t2는 요금 타입을 이야기하며, micro는 사양을 이야기한다. 
    
    ![T](images/T.PNG)
    
    * t2 이외 t3도 있으며 보통 이들은 **T 시리즈**라고 한다. T 시리즈는 범용 시리즈로 불리기도 한다.
    
    * 이들은 다른 서비스와 달리 **크레딧**이란 일종의 CPU를 사용할 수 있는 포인트 개념이 있다. 인스턴스 크기에 따라 정해진 비율로 **CPU 크레딧을 계속 받게 되며**, 사용하지 않을 때는 크레딧을 축적하고, 사용할 때 이 크레딧을 사용한다.
    
    * 정해진 사용보다 더 높은 트래픽이 오면 크레딧을 좀 더 적극적으로 사용하면서 트래픽을 처리하지만, **크레딧이 모두 사용되면 더이상 EC2를 사용할 수 없다.** 그래서 트래픽이 높은 서비스들은 T 시리즈를 쓰지 않고 다른 시리즈를 사용하기도 한다.
    
      
    
    ![세부정보](images/세부정보.PNG)
    
    * 세부정보 구성은 기업에서 사용할 경우 화면상에 표기된 APC, 서브넷 등을 세세하게 다루지만, 혼자서 1대의 서버만 사용하기 때문에 별다른 설정은 하지 않고 넘어간다.
    
      > * **VPC**와 **서브넷 등**은 **AWS** 서비스의 네트워크 환경을 구성하는 정도로만 이해하면 된다.
      >* 1인 개발 시 혹은 대량의 서버를 사용하지 않는다면 굳이 별도로 구성할 필요가 없기 때문에 기본 생성되는 값을 사용한다.
      > * 좀 더 제대로 된 구성을 해보고 싶으면 AWS만 다루는 서적을 참고하면 된다.
      
      
      
    * 스토리지는 **서버의 용량**을 얼마나 정할지 선택하는 단계이다.
    
    * 설정의 기본값은 **8GB**(기가바이트)이다. **30GB까지 프리티어로 가능**하다. 그 이상의 사이즈는 비용이 청구된다.
    
      
    
    * 태그에는 웹 콘솔에서 표기될 태그인 Name 태그를 등록한다. 태그는 해당 인스턴스를 표현하는 여러 이름으로 사용될 수 있다. EC2의 이름을 붙인다고 생각하면 된다.
    
    * 여러 인스턴스가 있을 경우 이를 태그별로 구분하면 검색이나 그룹 짓기 편하므로 여기서 본인 서비스의 인스턴스를 나타낼 수 있는 값으로 등록한다.
    
    ![태그추가](images/태그추가.PNG)
    
    
    
    * 보안 그룹은 **방화벽**을 이야기한다. **'서버로 80 포트 외에는 허용하지 않는다'는** 역할을 하는 방화벽이 **AWS**에서는 보안 그룹으로 사용된다.
    * 기존에 생성된 보안 그룹이 없으므로 보안 그룹 이름엔 **유의미한 이름**으로 변경한다.
    
    ![보안그룹](images/보안그룹.PNG)
    
    * 유형 항목에서 SSH이면서 포트 항목에서 22인 경우 **AWS EC2에 터미널로 접속**할 때를 이야기한다. pem키가 없으면 접속이 안 되니 전체 오픈(0.0.0.0/0, ::/0)하는 경우가 종종 있다. 이렇게 되면 이후 파일 공유 디렉토리나 깃허브 등에 실수로 pem 키가 노출되는 순간 서버에서 가상화폐가 채굴되는 것을 볼 수 있다.
    
    * 보안을 높이기 위해 pem 키 관리와 **지정된 IP에서만 ssh 접속이 가능**하도록 구성하는 것이 안전하다.
    
    * **내 IP를 선택하면 현재 접속한 장소의 IP**가 자동으로 지정된다. 만약 다른 곳에서 쓸 경우가 있을 경우 **해당 장소의 IP를 다시 SSH 규칙에 추가**하는 것이 좋다.
    
    * 기본 포트인 8080을 추가하고 [검토 및 시작] 버튼을 클릭한다. 검토 화면에서 보안 그룹 경고 하는데, 이는 8080이 전체 오픈이 되어서 발생한다. 8080을 열어 놓는 것은 위험한 일이 아니니 무시하면 된다.
    
      
    
    * 인스턴스로 접근하기 위해서는 pem 키(비밀키)가 필요하다. 그래서 인스턴스 마지막 단계는 할당할 pem 키를 선택하는 것이다.
    
    * 인스턴스는 지정된 pem 키(비밀키)와 매칭되는 공개키를 가지고 있어, 해당 pem 키 외에는 접근을 허용하지 않는다.
    
    * 일종의 **마스터 키**이기 때문에 절대 유출되면 안된다.
    
      
    
    * 생성된 인스턴스를 확인해 보면 IP와 도메인이 할당된 것을 확인할 수 있다.
    
    ![인스턴스](images/인스턴스.PNG)
    
    * 인스턴스도 결국 하나의 서버이기 때문에 IP가 존재한다. 인스턴스 생성 시에 항상 새 IP를 할당하는데, 한 가지 조건이 더 있다. 같은 인스턴스를 중지하고 **다시 시작할 때도 새 IP가 할당 된다.**
    
    * 요금을 아끼지 위해 잠깐 인스턴스를 중지하고 다시 시작하면 IP가 변경되는 것이다. 이렇게 되면 매번 접속해야 하는 IP가 변경되어 PC에서 접근할 때마다 IP 주소를 확인해야 한다. 
    
    * 굉장히 번가로운 일이기 때문에 인스턴스 IP가 **매번 변경되지 않고 고정 IP를 가지게** 해야 한다. 따라서 **고정 IP**를 할당해 준다.
    
      
    
    * **EIP 할당**
    
    * AWS의 고정 IP를 **Elastic IP(EIP, 탄력적 IP)**라고 한다.
    
    * EC2 인스턴스 페이지의 왼쪽 카테고리에서 **탄력적 IP를 눌러 선택**하고 주소가 없으므로 [새 주소 할당] 버튼을 클릭하여 바로 [할당] 버튼을 클릭한다.
    
    * 새 주소가 할당이 완료되면 **탄력적 IP가 발급**된다.
    
    * 생성한 **탄력적 IP**와 생성한 **EC2 주소**를 연결한다. **위에 생성한 탄력적 IP를 확인**하고 , 페이지 위에 있는 [작업] 버튼 -> [탄력적 IP 주소 연결] 메뉴를 선택한다.
    
    ![주소연결](images/주소연결.PNG)
    
    * 주소 연결을 위해 생성한 EC2 이름과 IP를 선택하고 [연결] 버튼을 클릭한다.
    
    ![주소연결2](images/주소연결.PNG)
    
    * 연결이 완료되면 왼쪽 카테고리에 있는 [인스턴스] 탭을 클릭하여 **인스턴스 목록** 페이지로 이동한다.
    * 해당 인스턴스의 **퍼블릭, 탄력적 IP**가 모두 잘 연결되었는지 확인한다.
    
    ![탄력적IP연결](images/탄력적IP연결.PNG)
    
    * EC2 인스턴스 생성 과정이 끝났다. 하지만, 주의할 점이 있다. 방금 생성한 탄력적 IP는 **생성하고 EC2 서버에 연결하지 않으면** 비용이 발생한다. 즉, **생성한 탄력적 IP는 무조건 EC2에 바로 연결하며** 만약 더는 사용할 인스턴스가 없을 때도 탄력적 IP를 삭제해야 한다.



#### 6.3 EC2 서버에 접속

* 운영체제(window, Mac & Linux) 별로EC2 접속 방법이 다르다. 윈도우 버전으로 접속한다.(Mac 접속 방법은 책을 참고한다.)

  * Mac & Linux는 터미널
  * 윈도우는 putty

  > **참고**
  >
  > * 오랜 시간 접속이 안 되거나, 권한이 없어서 안 된다고 메시지가 나온다면 다음과 같이 확인해 보는 것이 좋다.
  >   * HostName 값이 정확히 탄력적 IP로 되어있는지 확인
  >   * EC2 인스턴스가 running 상태인지 확인
  >   * EC2 인스턴스의 보안그룹 -> 인바운드 규칙에서 현재 보인의 IP가 등록되어 있는지 확인

  

* **Window**

  * 윈도우에서는 Mac과 같이 ssh 접속하기엔 불편한 점이 많아 별도의 클라이언트(putty)를 설치한다.
  * 실행 파일은 2가지이다.
    * putty.exe
    * puttygen.exe
  * 두 파일을 모두 다운 후, **puttygen.exe** 파일을 실행시킨다.
  * putty는 pem 키로 사용이 안 되며 pem 키를 ppk 파일로 변환을 해야만 한다. puttygen은이 과정을 진행해 주는 클라이언트이다. puttygen 화면에서 상단 **[Conversions -> Import Key]**를 선택해서 내려받은 pem 키를 선택한다.

  ![puttygen](images/puttygen.PNG)

  * 그럼 다음과 같이 자동으로 변환이 진행된다. **[Save private Key]** 버튼을 클릭하여 ppk 파일을 생성한다. 경고 메시지가 뜨면 [예]를 클릭하고 넘어간다.

  ![puttygen2](images/puttygen2.PNG)

  * ppk 파일이 저장될 위치와 ppk 이름을 등록한다.

  ![ppk](images/ppk.PNG)

  * ppk 파일이 잘 생성되면 **putty.exe 파일**을 실행하여 다음과 같이 각 항목을 등록한다.

  ![putty등록](images/putty등록.PNG)

  * 등록
    * HostName: username@public_Ip 를 등록한다. 생성한 Amazon Linux는 ec2-user가 username이라서 **ec2-user@탄력적 IP 주소**를 등록하면 된다.
    * Port: ssh 접속 포트인 22를 등록한다.
    * Connection type: SSH를 선택한다.
  * 항목들을 채웠으면 왼쪽 사이드바에 있는 **[Connection -> SSH -> Auth]**를 차례로 클릭해서 ppk 파일을 로드할 수 있는 화면으로 이동한다. **[Browse...]** 버튼을 클릭한다.

  ![ppk로드](images/ppk로드.PNG)

  * ppk 파일을 선택해서 정상적으로 불러오면 **[Session]** 탭으로 이동하여 **[Saved Sessons]에 현재 설정들을 저장할 이름**을 등록하고 **[Save]** 버튼을 클릭한다.

  ![sessoin저장](images/session저장.PNG)

  * 저장항 뒤 [open] 버튼을 클릭하면 SSH 접속 알림이 등장한다.

  ![ec2접속](images/ec2접속.PNG)



#### 6.4 아마존 리눅스 2 서버 생성 시 꼭 해야 할 설정

* 아마존 리눅스 2 서버를 처음 받았다면 몇 가지 설정들이 필요하다.
* 이 설정들은 모두 자바 기반의 웹 애플리케이션 (톰캣과 스프링부트)가 작동해야 하는 서버들에선 필수로 해야 하는 설정들이다.
  * **Java 8 설치**: 현재 이 프로젝트의 버전은 Java 8 이다.
  * **타임존 변경**: 기본 서버의 시간은 미국 시간대이다. 한국 시간대가 되어야만 우리가 사용하는 시간이 모두 한국 시간으로 등록되고 사용된다.
  * **호스트네임 변경**: 현재 접속한 서버의 별명을 등록한다. 실무에서는 한 대의 서버가 아닌 수십 대의 서버가 작동되는 데, IP만으로 어떤 서버가 어떤 역할을 하는지 알 수 없다. 이를 구분하기 위해 보통 호스트 네임을 필수로 등록한다.
* EC2에 접속한 뒤에 다음 과정을 진행하면 된다.



**Java 8 설치**

* 자바 8을 기본으로 사용하기 위해 자바 8을 EC2에 설치한다.

  > **sudo yum install -y java-1.8.0-openjdk-devel.x86_64**

* 설치가 완료되면 인스턴스 Java 버전을 8로 변경해준다.

  > **sudo /usr/sbin/alternatives --config java**

* 선택 화면에서 Java 8을 선택한다.(해당 숫자 입력)

* 버전이 변경되었으면 사용하지 않는 Java7을 삭제한다.

  > **sudo yum remove java-1.7.0-openjdk**

* 현재 버전이 Java 8이 되었는지 확인한다.

  > **java -version**



**타임존 변경**

* EC2 서버의 기본 타임존은 UTC이다. 이는 세계 표준 시간으로 한국의 시간대가 아니다. 즉, **한국의 시간과는 9시간 차이**가 발생한다. 이렇게 되면 서버에서 수행되는 Java 애플리케이션에서 생성되는 시간도 모두 9시간씩 차이가 나기 때문에 꼭 수정해야 한다.

* 서버의 타임존을 **한국 시간(KST)**로 변경

  > **sudo rm /etc/localtime**

* 정상적으로 수행되었다면 **date** 명령어로 타임존이 KST로 변경된 것을 확인할 수 있다.



**Hostname 변경**

* 여러 서버를 관리 중일 경우 **IP만으로 어떤 서비스의 서버인지** 확인이 어렵다.

* 각 서버가 **어느 서비스인지 표현**하기 위해 **HOSTNAME**을 변경한다.

* Amazon Linux 2: **hostnamectl** 명령으로 호스트 이름을 설정하여 정규화된 도메인 이름을 반영한다.(ex: springboot2-webservice)

  > **sudo hostnamectl set-hostname springboot2-webservice**

* 인스턴스를 재부팅하여 새 호스트 이름을 적용한다.

  > **sudo reboot**

* 재부팅이 끝나고 나서 다시 접속해 보면 HOSTNAME이 잘 변경된 것을 확인할 수 있다.



* Hostname이 등록되었다면 한 가지 작업을 더 해야 한다.

* 호스트 주소를 찾을 때 가장 먼저 검색해 보는 **/etc/hosts**에 변경한 **hostname**을 등록한다.

  > **sudo vim /etc/hosts**

* 다음과 같은 화면에 방금 등록한 **HOSTNAME**을 등록한다.

  > **127.0.0.1 등록한 HOSTNAME**

  ![hosts](images/hosts.PNG)

* :wq 명령어로 저장하고 종료한 뒤 정상적으로 등록되었는지 확인해 본다.

  > **curl 등록한 호스트 이름**
  
* 잘 등록하였다면 다름과 같이 80 포트로 접근이 안 된다는 에러가 발생한다.

  ![hosts등록](images/hosts등록.PNG)

* 아직 80 포트로 실행된 서비스가 없음을 의미한다. 즉, curl 호스트 이름으로 실행은 잘 되었음을 의미한다.



### 7. AWS에 데이터베이스 환경을 만들기 (AWS RDS)

* 웹 서비스의 백엔드를 다룬다고 했을 때 **애플리케이션 코드를 작성하는 것 만큼 중요한 것이 데이터베이스를 다루는 일**이다.
* 데이터베이스를 구축하고 앞 장에서 만든 **EC2 서버와 연동**을 한다. 다만, **직접 데이터베이스를 설치하지 않는다.**
* 직접 데이터베이스를 설치해서 다루게 되면 모니터링, 알람, 백업, HA 구성 등을 모두 직접 해야한다.
* AWS에서는 앞에서 언급한 작업을 모두 지원하는 **관리형 서비스**인 **RDS(Relational Database Service)**를 제공한다.
* **RDS**는 AWS에서 지원하는 클라우드 기반 관계형 데이터베이스이다. 하드웨어 프로비저닝, 데이터베이스 설정, 패치 및 백업과 같이 잦은 운영 작업을 자동화하여 개발자가 개발에 집중할 수 있게 지원하는 서비스이다.



#### 7.1 RDS 인스턴스 생성하기

* RDS 인스턴스를 생성한다. AWS의 검색창에서 rds를 입력해서 선택하고, RDS 대시보드에서 **[데이터베이스 생성]** 버튼을 클릭한다.

  ![NewDatabase](images/NewDatabase.PNG)

  

* RDS 생성 과정이 진행된다. DB 엔진 선택 화면에서 **MariaDB**를 선택한다.

  > RDS에는 오라클, MSSQL, PostgreSQL 등이 있다.

  

* MariaDB를 선택한 다음 사용 사례 항목이 나온다. 프리티어로 이용하려면 **[프리티어]**를 선택한다.

  > 아이디를 신규 가입하면 1년동안 프리티어로 무료로 사용 가능하다.

  ![프리티어](images/프리티어.PNG)

  

* 상세 설정에서는 다음 그림과 같이 설정한다. DB 인스턴스와 마스터 사용자 정보를 등록할 수 있다.

* 본인만의 DB 인스턴스 이름과 사용자 정보를 등록한다. 여기서 사용된 사용자 정보를 실제 데이터베이스 접근하게 되니 어딘가 메모해 놓는 것이 좋다.

  ![상세설정1](images/상세설정1.PNG)

  

* DB 인스턴스 클래스

  ![db인스턴스클래스](images/db인스턴스클래스.PNG)

  

* 할당된 스토리지

  ![스토리지](images/스토리지.PNG)

  

* 연결 설정**에서 퍼블릭 액서스를 [예]로 변경한다. 이후 보안 그룹에서 지정된 IP만 접근하도록 막을 예정이다.

  ![연결1](images/연결1.PNG)



* 다음과 같이 설정해 준다.

  ![연결2](images/연결2.PNG)

  

* 데이터베이스 옵션에서는 이름을 생성하고, 파라미터 그룹의 변경은 이후에 진행할 예정이니 기본값으로 둔다.

  ![데이터베이스옵션](images/데이터베이스옵션.PNG)

  

* 모든 설정이 끝나서 **[완료]** 버튼을 클릭하면 데이터베이스 생성 과정이 진행된다.

* **[DB 인스턴스 세부 정보 보기]**를 클릭하면 생성 중인 데이터베이스의 상세 페이지로 이동한다.



#### 7.2 RDS 운영환경에 맞는 파라미터 설정하기

* RDS를 처음 생성하면 몇 가지 설정을 필수로 해야 한다. 우선 다음 3개의 설정을 차례로 진행한다.
  * 타임존
  * Character Set
  * Max Connection



* RDS에서 **[파라미터 그룹]** 텝을 클릭해서 이동한다. 이동한 화면의 오른쪽 위에 **[파라미터 그룹 생성]** 버튼을 클릭한다.

* 파라미터 그룹 패밀리에 DB 엔진을 선택하는 항목이 있다. 여기서 **방금 생성한 MariaDB와 같은 버전**을 맟춰야 한다.

* 앞에서 MariaDB 10.4.8 버전으로 생성했기 때문에 같은 버전대인 10.4를 선택해야 한다. 만약 10.3.xx 버전으로 생성하였다면 10.3을 선택해야 한다.

  ![파라미터그룹](images/파라미터그룹.PNG)



* 생성이 완료되면 파라미터 그룹 목록 창에 새로 생성된 그룹을 볼 수 있다. 해당 파라미터 그룹으로 클릭하여 이동한다.

  ![파라미터이동](images/파라미터이동.PNG)



* 클릭해서 이동한 상세 페이지의 오른쪽 위를 보면 **[파라미터 편집]** 버튼이 있다. 해당 버튼을 클릭해 **편집 모드로 전환**한다.

  ![파라미터편집](images/파라미터편집.PNG)



* 편집 모드가 되면 하나씩 설정값들을 변경한다. 먼저 **time_zone**을 검색하여 다음과 같이 **[Asia/Seoul]**을 선택한다.

  ![timezone](images/timezone.PNG)



* 다음으로 **Character Set**을 변경한다. Character Set은 항목이 많다. 아래 8개 항목 중 **charactter 항목**들은 모두 **utf8mb4**로, **collation 항목**들은 **utf8mb4_general_ci**로 변경한다. utf8과 utf8mb4의 차이는 **이모지 저장 가능 여부**이다.
  * character_set_client
  * character_set_connection
  * character_set_database
  * character_set_filesystem
  * character_set_results
  * character_set_server
  * collation_connection
  * collation_server
  
  ![파라미터설정](images/파라미터설정.PNG)
  
  * utf8은 이모지를 저장할 수 없지만, utf8mb4는 이모지를 저장할 수 있으므로 보편적으로 utf8mb4를 많이 사용한다.



* 마지막으로 **Max Connection**을 수정한다. RDS의 Max Connection은 **인스턴스 사양에 따라 자동으로** 정해진다. 현재 프리티어 사양으로는 약 40개의 커넥션만 가능해서 좀 더 넉넉한 값으로 지정한다.

  ![Max](images/Max.PNG)

  * 이후에 RDS 사양을 높이게 된다면 기본값으로 다시 돌려놓으면 된다. 설정이 다 되었다면 오른쪽 위의 **[변경 사항 저장]** 버튼을 클릭해 최종 저장한다.



* 생성된 파라미터 그룹을 데이터베이스에 연결한다,

  ![데이터베이스반영](images/데이터베이스반영.PNG)



* 옵션 항목에서 DB 파라미터 그룹은 default로 되어있다. DB 파라미터 그룹을 방금 생성한 신규 파라미터 그룹으로 변경한다.

  ![파라미터그룹변경](images/파라미터그룹변경.PNG)



* 저장을 누르면 다음과 같이 수정 사항이 요약된 것을 볼 수 있다. 여기서 반영 시점을 **[즉시 적용]**으로 한다.

  ![즉시적용](images/즉시적용.PNG)

  * 예약된 다음 유지 시간으로 하면 지금 하지 않고, 새벽 시간대에 진행하게 된다. 이 수정사항이 변동되는 동안 데이터베이스가 작동되지 않을 수 있으므로 예약 시간을 걸어두라는 의미지만, 지금은 서비스가 오픈되지 않았기 때문에 즉시 적용한다. 
  * 간혹 파라미터 그룹이 제대로 반영되지 않을 때가 있다. 정상 적용을 위해 한 번 더 재부팅을 진행한다.
  * 재부팅까지 성공했다면 이제 로컬 PC에서 RDS에 접속할 수 있다.



#### 7.3 내 PC에서 RDS에 접속

* 로컬 PC에서 RDS로 접근하기 위해서 **RDS의 보안 그룹에 본인 PC의 IP를 추가**한다. RDS의 세부정보 페이지에서 **[보안 그룹]** 항목을 클릭한다.

  ![VPC보안그룹](images/VPC보안그룹.PNG)



* RDS의 보안 그룹 정보를 그대로 두고, 브라우저를 새로 열어 본다. 브라우저 다른 창에서는 보안 그룹 목록 중 **EC2에 사용된 보안 그룹의 그룹 ID**를 복사한다.

  ![EC2보안그룹](images/EC2보안그룹.PNG)



* 복사된 보안 그룹 ID와 본인의 IP를 **RDS 보안 그룹의 인바운드**로 추가한다.

  ![RDS인바운드수정](images/RDS.PNG)



* 인바운드 규칙 유형에서는 **MYSQL/Aurora**를 선택하면 자동으로 **3306 포트**가 선택된다.
  * 보안 그룹 첫 번째 줄 : 현재 내 PC의 IP를 등록한다.
  * 보안 그룹 두 번째 줄 : EC2의 보안 그룹을 추가한다.
    * 이렇게 하면 **EC2와 RDS 간에 접근이 가능**하다.
    * EC2의 경우 이후에 2대 3대가 될 수도 있는데, 매번 IP를 등록할 수 없으니 보편적으로 이렇게 보안 그룹 간에 연동을 진행한다.



* RDS와 개인 PC, EC2 간의 연동 설정은 모두 되었다. 로컬에서 테스트 가능하다.



**Database 플러그인 설치**

* 로컬에서 원격 데이터베이스로 붙을 때 GUI 클라이언트를 많이 사용한다.
* **인텔리제이에 Database 플러그인**을 설치하여 진행한다.



* RDS 정보 페이지에서 **엔드 포인트**를 확인한다. 엔드 포인트가 접근 가능한 URL이므로 메모장 같은 곳에 복사해 둔다.

  ![엔드포인트](images/엔드포인트.PNG)



* 인텔리제이로 이동해서 database 플러그인을 검색하여 **Database Navigator**를 찾아 [Install]을 클릭하여 설치해 준다.

  ![database](images/database.PNG)

  * 설치가 끝나면 인텔리제이 재시작을 한 뒤 Action 검색(Ctrl+Shift+a)으로 **Database Browser**를 실행행한다.



* 프로젝트 왼쪽 사이드바에 **DB Browser**가 노출된다. **New Connection**을 클릭하여 **MySQL** 접속 정보를 연다. MariaDB는 MySQL 기반이므로 MySQL을 사용하면 된다.

* 본인이 생성한 RDS의 정보를 차례로 등록하면 된다.

  ![RDS정보](images/RDS정보.PNG)

  * 마스터 계정명과 비밀번호를 등록한 뒤, 화면 아래의 [Test Connection]을 클릭하여 연결 테스트를 실핼한다.
  * **Connection Successful** 메시지를 보았다면 정상으로 연결이 가능하기 때문에 [Apply] 클릭하여 정보를 저장한다.



* 인텔리제이에 RDS의 스키마가 노출된다. 생성되어 있는 콘솔창에서 SQL을 실행시킨다. 쿼리가 수행될 database를 선택하는 쿼리이다.

  > use AWS RDS 웹 콘솔에서 지정한 데이터베이스명;

  * 만약 본인이 RDS 생성 시 지정한 database 명을 잊었다면 인텔리제이의 Schema 항목을 보면 **MySQL에서 기본으로 생성하는 스키마 외에 다른 스키마**가 1개 추가되어 있으니 이를 확인하면 된다.



* 쿼리를 실행시키기 위해서는 쿼리문을 드래그로 선택한 뒤 화면의 위쪽에 화살표로 된 [Execute Statement] 버튼을 클릭하면 쿼리문이 실행된다.

  ![쿼리실행](images/쿼리실행.PNG)

  * Execute Console에서 SQL statement executed successfully 메시지가 떴다면 쿼리가 정상적으로 수행괸 것이다.

    ![쿼리실행정상](images/쿼리실행정상.PNG)



* 데이터베이스가 선택된 상태에서 **현재의 character_set, collation** 설정을 확인한다.

  > show variables like 'c

  * 쿼리 결과를 확인해 보면 다른 필드들은 모두 utf8mb4가 잘 적용되어 있는데 **character_set_database, collation_connection** 2가지 항목이 latin1로 되어있다.

  * 2개의 항목이 MariaDB에서만 RDS 파라미터 그룹으로는 변경이 안된다. 직접 변경을 해줘야 한다.

    > ALTER DATABASE 데이터베이스명
    >
    > CHARACTER SET = 'utf8mb4'
    >
    > COLLATE = 'utf8mb4_general_ci';

  * 쿼리를 수행하였다면 다시 한번 character set을 확인해 본다.

  ![변경](images/변경.PNG)

  * 성공적으로 모든 항목이 utf8mb4로 변경된 것을 확인할 수 있다.



* **타임존**을 확인해 본다.

  > select @@time_zone, now();

  * RDS 파라미터 그룹이 잘 적용되어 한국 시간(Asia/Seoul)으로 된 것을 확인할 수 있다.



* 마지막으로 한글명이 잘 들어가는지 간단한 테이블 생성과 insert 쿼리를 실행해 본다.

  > 테이블 생성은 인코딩 설정 변경 전에 생성하면 안된다. 만들어질 당시의 설정값을 그대로 유지하고 있어, 자동 변경이 되지 않고 강제로 변경해야만 한다. 웬만하면 테이블은 모든 설정이 끝난 후 생성하는 것이 좋다.

  > CREATE TABLE tset (
  >
  > ​	id bigint(20) NOT NULL AUTO_INCREMENT,
  >
  > ​	content varchar(255) DEFAULT NULL,
  >
  > ​	PRIMARY KEY (id)
  >
  > ) ENGINE=InnoDB;
  >
  > 
  >
  > insert into test(content) values ('테스트');
  >
  >  
  >
  > select * from test;

  * 실행결과 한글 데이터도 잘 등록되는 것을 확인할 수 있다.

    ![쿼리test](images/쿼리test.PNG)



#### 7.4 EC2에서 RDS에서 접근 확인

* EC2에 ssh 접속을 한다. 접속되었가면 MySQL 접근 테스트를 위해 MySQL CLI를 설치한다.

  > sudo yum install mysql

  > 실제 EC2의 MySQL을 설치해서 쓰는게 아닌, 명령어 라인만 쓰기 위한 설치이다.

  

* 설치가 다 되었으면 로컬에서 접근하듯이 계정, 비밀번호, 호스트 주소를 사용해 RDS에 접속한다.

  > mysql -u 계정 -p -h Host주소

  > mysql -u allsser -p -h  springboot2-webservice.ctmjgqvsf9cj.ap-northeast-2.rds.amazonaws.com(엔드포인트)

  

* 패스워드를 입력하라는 메시지가 나오면 패스워드까지 입력한다. 다음과 같이 EC2에서 RDS로 접속되는 것을 확인할 수 있다.

  ![ec2rds](images/ec2rds.PNG)



* RDS에 접속되었면 실제로 생성한 RDS가 맞는지 간단한 쿼리를 실행해 본다.

  > show databases;

  ![showdatabases](images/showdatabases.PNG)

  * 앞서 생성했던 springboot2_webservice라는 데이터베이스가 있는것을 확인할 수 있다.



---

### 8. EC2 서버에 프로젝트를 배포

#### 8.1 EC2에 프로젝트 Clone 받기

* 먼저 깃허브에서 코드를 받을올 수 있게 EC2에 깃을 설치한다. EC2로 접속해서 명령어를 입력한다.

  > sudo yum install git

* 설치가 완료되면 설치 상태를 확인한다.

  > git --version

* 깃이 성공적으로 설치되면 git clone으로 프로젝트를 저장할 디렉토리를 생성한다.

  > mkdir ~/app && mkdir ~/app/step1

* 생성된 디렉토리로 이동한다.

  > cd ~/app/step1

* 본인의 깃허브 웹페이지에서 https 주소를 복사한다. 복사한 https 주소를 통해 git clone을 진행한다.

  > git clone 복사된 주소

* git clone이 끝났으면 클론된 프로젝트로 이동해서 파일들이 잘 복사되있는지 확인한다.

  > cd 프로젝트명
  >
  > ll

  ![ll](images/ll.PNG)

* 코드들이 잘 수행되는지 테스트로 검증한다.

  > ./gradlew tset

* 지금까지 문제가 없다면 정상적으로 테스트를 통과한다.

  ![gradlewtest](images/gradlewtest.PNG)

* 테스트가 실패해서 수정하고 깃허브에 푸시를 했다면 프로젝트 폴더안에서 git pull 명령어를 입력하면 된다.

  > git pull

* 만약 gradlew 실행 권한이 없다는 메시지가 뜬다면 명령어로 실행 권한을 추가한 뒤 다시 테스트를 진행하면 된다.

  > -bash: ./gradlew: Permission denied

  > chmod +x ./gradlew



#### 8.2 배포 스크립트 만들기

* 작성한 코드를 실제 서버에 반영하는 것을 배포라 한다.
* 배포라 하면 다음의 과정을 모두 포괄하는 의미라고 보면 된다.
  * git clone 혹은 git pull을 통해 새 버전의 프로젝트를 받음
  * Gradle이나 Maven을 통해 프로젝트 테스트와 빌드
  * EC2 서버에서 해당 프로젝트 실행 및 재실행



* 앞선 과정을 **배포할 때마다 개발자가 하나하나 명령어를 실행**하는 것은 불편함이 많다. 그래서 이를 쉘 스크립트로 작성해 스크립트만 실행하면 앞의 과정이 차례로 진행되도록 한다.

  > **쉘 스크립트와 빔(vim)은 서로 다른 역할을 한다.**
  >
  > * **쉘 스크립트** : **.sh**라는 파일 확장자를 가진 파일이다. 노드 JS가 .js라는 파일을 통해 서버에서 작동하는 것처럼 쉘 스크립트 역시 리눅스에서 기본적으로 사용할 수 있는 스크립트 파일의 한 종류이다.
  > * **빔(vim)** : 리눅스 환경과 같이 GUI(윈도우와 같이 마우스를 사용할 수 있는 환경)가 아닌 환경에서 사용할 수 있는 편집 도구이다. 리눅스에선 빔 외에도 이맥스(Emacs), 나노(NANO) 등의 도구를 지원한다.

* **~/app/step1/에 deploy.sh** 파일을 하나 생성한다.

  > vim ~/app/step1/deploy.sh

* 생성된 쉘 스크입트 파일에 다음의 코드를 추가한다.

  ```deploy.sh
  #!/bin/bash
  
  REPOSITORY=/home/ec2-user/app/step1		# 1
  PROJECT_NAME=springboot-webservice
  
  cd $REPOSITORY/$PROJECT_NAME/		# 2
  
  echo "> Git Pull"		# 3
  
  git pull
  
  echo "> 프로젝트 Build 시작"
  
  ./gradlew build		# 4
  
  echo "> step1 디렉토리로 이동"
  
  cd $REPOSITORY
  
  echo "> build 파일 복사"
  
  cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/		# 5
  
  echo "> 현재 구동중인 애플리케이션 pid 확인"
  
  CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)		# 6
  
  echo "현재 구동 중인 애플리케이션 pid: $CURRENT_PID"
  
  if [ -z "$CURRENT_PID" ]; then		# 7
  	echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
  else
  	echo "> kill -15 $CURRENT_PID"
  	kill -155 $CURRENT_PID
  	sleep 5
  fi
  
  echo "> 새 애플리케이션 배포"
  
  JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)		# 8
  
  echo "> JAR NAME: $JAR_NAME"
  
  nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &		# 9
  ```

  * {1} **REPOSITORY=/home/ec2-user/app/step1**
    * 프로젝트 디렉토리 주소는 스크립트 내에서 자주 사용되는 값이기 때문에 이를 **변수**로 저장한다.
    * 마찬가지로 **PROJECT__NAME=springboot-webservice**도 동일하게 **변수**로 저장한다.
    * 쉘에서는 **타입 없이** 선언하여 저장한다.
    * 쉘에서는 **$ 변수명**으로 변수를 사용할 수 있다.
  * {2} **cd $REPOSITORY/$PROJECT_NAME/**
    * 제일 처음 git clone 받았던 디렉토리로 이동한다.
    * 바로 위의 쉘 변수 설정에 따라 **/home/ec2-user/app/step1/springboot-webservice** 주소로 이동한다.
  * {3} **git pull**
    * 디렉토리 이동 후, master 브랜치의 최신 내용을 받는다.
  * {4} **./gradlew build**
    * 프로젝트 내부의 gradlew로 build를 수행한다.
  * {5} **cp ./build/libs/*.jar $REPOSITORY/**
    * build의 결과물인 jar 파일을 복사해 jar 파일을 모아둔 위치로 복사한다.
  * {6} **CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)**
    * 기존에 수행 중이던 스프링 부트 애플리케이션을 종료한다.
    * pgrep은 process id만 추출하는 명령어이다.
    * -f 옵션은 프로세스 이름으로 찾는다.
  * {7} **if ~ else ~ fi**
    * 현재 구동 중인 프로세스가 있는지 없는지를 판단해서 기능을 수행한다.
    * process id 값을 보고 프로세스가 있으면 해당 프로세스를 종료한다.
  * {8} **JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)**
    * 새로 실행할 jar 파일명을 찾는다.
    * 여러 jar 파일이 생기기 때문에 tail -n로 가장 나중의 jar 파일(최신파일)을 변수에 저장한다.
  * {9} **nohup java -jar $REPOSITORY/$JAR_NAME 2>&1 &**
    * 찾은 jar 파일명으로 해당 jar 파일을 nohup으로 실행한다.
    * 스프링 부트의 장점으로 특별히 외장 톰캣을 설치할 필요가 없다.
    * 내장 톰캣을 사용해서 jar 파일만 있으면 바로 웹 애플리케이션 서버를 실행할 수 있다.
    * 일반적으로 자바를 실행할 때는 java -jar라는 명령어를 사용하지만, 이렇게 하면 사용자가 터미널 접속을 끊을 때 애플리케이션도 같이 종료된다.
    * 애플리케이션 실핼자가 터미널을 종료해도 애플리케이션은 계속 구동될 수 있도록 nohup 명령어를 사용한다.



* 이렇게 생성한 스크립트에 실행 권한을 추가한다.

  > chmod +x ./deploy.sh



* 확인해 보면 x 권한이 추가된 것을 확인할 수 있다.

  ![x권한](images/x권한.PNG)



* 스크립트를 다음 명령어로 실행한다.

  > ./deploy.sh



* 실행시키면 로그가 출력되며 애플리케이션이 실행된다.

* nohup.out은 실행되는 애플리케이션에서 출력되는 모든 내용을 갖고 있다.

  > vim nohup.out

* nohup.out 제일 아래로 가면 ClientRegistrationRepository를 찾을 수 없다(that could not be found.)는 에러가 발생하면 애플리케이션 실행에 실패 했다는 것을 알 수 있다.



#### 8.3 외부 Security 파일 등록

* 애플리케이션 실행에 실패한 이유는 **ClientRegistrationRepository**를 생성하려면 **ClientId**와 **ClientSecret**가 필요하기 때문에 에러가 뜬는 것이다.
* 로컬 PC에서 실행할 때는 application-oauth.properties가 있기 때문에 문제가 없었다. 하지만 이 파일은 **.gitignore로 git에서 제외 대상**이라 깃허브에는 올라가있지 않았다.
* 애플리케이션을 실행시키기 위해 공개된 저장소에 ClientId와 ClientSecret을 올릴 수 없으니 **서버에서 직접 이 설정들을 가지고 있게** 한다.



* 먼저 step1이 아닌 app 디렉토리에 properties 파일을 생성한다.

  > vim /home/ec2-user/app/application-oauth.properties

  * 로컬에 있는 application-oauth.properties 파일 내용을 그대로 붙여넣기를 한다.



* 방금 생성한 application-oauth.properties을 사용하기 위해 deploy.sh 파일을 수정한다.

  ```deploy.sh
  ...
  nohup java -jar \
  	-Dspring.config.location=classpath:/application.properties,/home/ec2-user/app/application-oauth.properties \
  	$REPOSITORY/$JAR_NAME 2>&1 &
  ```

  * **-Dspring.config.location**
    * 스프링 설정 파일 위치를 지정한다.
    * 기본 옵션들을 담고 있는 application.properties과 OAuth 설정들을 담고 있는 application-oauth.properties의 위치를 지정한다.
    * classpath가 붙으면 jar 안에 있는 resources 디렉토리를 기준으로 경로가 생성된다.
    * application-oauth.properties 은 절대경로를 사용한다. 외부에 파일이 있기 때문이다.



* 수정을 한 후 deploy.sh를 실행시키면 정상적으로 실행되는 것을 확인할 수 있다.



#### 8.4 스프링 부트 프로젝트로 RDS 접근하기

* RDS는 MariaDB를 사용 중이다. MariaDB에서 스프링부트 프로젝트를 실행하기 위해서 몇 가지 작업이 필요하다.
  * **테이블 생성** : H2에서 자동으로 생성해주던 테이블들을 MariaDB에선 직접 쿼리를 이용해 생성한다.
  * **프로젝트 설정** : 자바 프로젝트가 MariaDB에 접근하려면 데이터베이스 드라이버가 필요하다. MariaDB에서 사용 가능한 드라이버를 프로젝트에 추가한다.
  * **EC2(리눅스 서버) 설정** : 데이터베이스의 접속 정보는 중요하게 보호해야 할 정보이다. 공개되면 외부에서 데이터를 모두 가져갈 수 있기 때문이다. 프로젝트 안에 접속 정보를 갖고 있다면 깃허브와 같이 오픈된 공간에선 누구나 해킹할 위험이 있다. EC2 서버 내부에서 접속 정보를 관리하도록 설정해야한다.



**RDS 테이블 생성**

* RDS에 테이블을 생성한다.

* **JPA가 사용될 엔티티 테이블**과 **스프링 세션이 사용될 테이블** 2가지 종류를 생성한다.

* **JPA가 사용할 테이블**

  * 테스트 코드 수행 시 로그로 생성되는 쿼리를 사용하면 된다.
  * 테스트 코드를 수행하면 로그가 발생하는데 **create table**부터 복사하여 RDS에 반영한다.

  ![logtable](images/logtable.PNG)

  >Hibernate: create table posts (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), author varchar(255), content TEXT not null, title varchar(500) not null, primary key (id)) engine=InnoDB
  >Hibernate: create table user (id bigint not null auto_increment, created_date datetime(6), modified_date datetime(6), email varchar(255) not null, name varchar(255) not null, picture varchar(255), role varchar(255) not null, primary key (id)) engine=InnoDB

* **스프링 세션 테이블**

  * 스프링 세션 테이블은 **schema-mysql.sql** 파일에서 확인할 수 있다.
  * File 검색(윈도우/리눅스 Ctrl+Shift+N)으로 찾는다.
  * 해당 파일에는 다음과 같은 세션테이블이 있다.

  ![schema](images/schema.PNG)

  ```schema
  CREATE TABLE SPRING_SESSION (
  	PRIMARY_ID CHAR(36) NOT NULL,
  	SESSION_ID CHAR(36) NOT NULL,
  	CREATION_TIME BIGINT NOT NULL,
  	LAST_ACCESS_TIME BIGINT NOT NULL,
  	MAX_INACTIVE_INTERVAL INT NOT NULL,
  	EXPIRY_TIME BIGINT NOT NULL,
  	PRINCIPAL_NAME VARCHAR(100),
  	CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
  ) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;
  
  CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
  CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
  CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);
  
  CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  	SESSION_PRIMARY_ID CHAR(36) NOT NULL,
  	ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
  	ATTRIBUTE_BYTES BLOB NOT NULL,
  	CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
  	CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION(PRIMARY_ID) ON DELETE CASCADE
  ) ENGINE=InnoDB ROW_FORMAT=DYNAMIC;
  ```



**프로젝트 설정**

* MariaDB 드라이버를 build.gradle에 등록한다.

  > implementation("org.mariadb.jdbc:mariadb-java-client")



* 서버에서 구동될 환경을 하나 구성한다.

  * **src/main/resources/** 에 **application-real.properties** 파일을 추가한다.

  * application-real.properties 로 파일을 만들면 **profile=real**인 환경이 구성된다.

  * 실제 운영될 환경이기 때문에 보안/로그상 이슈가 될 만한 설정들을 모두 제거하며 **RDS 환경 profile** 설정이 추가된다.

    **application-real.properties**

    ```application-real.properties
    spring.profiles.include=oauth,real-db
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
    spring.jpa.properties.hibernate.dialect.storage_engine=innodb
    spring.datasource.hikari.jdbc-url=jdbc:h2:mem:testdb;MODE=MYSQL
    spring.datasource.hikari.username=sa
    
    spring.session.store-type=jdbc
    ```



**EC2 설정**

* **OAuth**와 마찬가지로 RDS 접속 정보도 보호해야 할 정보이니 EC2 서버에 직접 설정 파일을 둔다.

* app 디렉토리에 **application-real-db.properties** 파일을 생성한다.

  > vim ~/app/application-real-db.properties

  ```application-real-db.properties
  spring.jpa.hibernate.ddl-auto=none
  spring.jpa.show_sql=false
  
  spring.datasource.hikari.jdbc-url=jdbc:mariadb://rds주소:포트명(기본 3306)/database이름
  spring.datasource.hikari.username=db계정
  spring.datasource.hikari.password=db계정 비밀번호
  spring.datasource.hikari.driver-class-name=org.mariadb.jdbc.Driver
  ```

  * **spring.jpa.hibernate.ddl-auto=none**
    * JPA로 테이블이 자동 생성되는 옵션을 None(생성하지 않음)으로 지정한다.
    * RDS에는 실제 운영으로 사용될 테이블이니 절대 스프링 부트에서 새로 만들지 않도록 한다.
    * 이 옵션을 선택하지 않으면 테이블이 모두 새로 생성될 수 있다.
    * 주의해야 하는 옵션이다.



* deploy.sh가 **real profile**을 쓸 수 있도록 개선한다.

  **deploy.sh**

  ```deploy.sh
  ...
  nohup java -jar \
      -Dspring.config.location=classpath:/application.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties,classpath:/application-real.properties \
      -Dspring.profiles.active=real \
      $REPOSITORY/$JAR_NAME 2>&1 &
  ```

  * **-Dspring.profiles.active=real**
    * application-real.properties를 활성화 시킨다.
    * application-real.properties의 spring.profiles.include=oauth,real-db 옵션 때문에 real-db 역시 함께 활성화 대상에 포함된다.



* deploy.sh를 실행한 후 nohup.out 파일을 열어 로그를 확인해 보면 성공적으로 수행된 것을 확인할 수 있다.

  > Tomcat started on port(s): 8080 (http) with context path ' '
  >
  > Started Application in ~~ seconds (JVM running for ~~~)



* curl 명령어로 html 코드가 정상적으로 보인다면 성공이다.

  > curl localhost:8080



#### 8.5 EC2에서 소셜 로그인하기

* curl 명령어를 통해 EC2에서 서비스가 잘 배포되는 것을 확인해 볼 수 있다.
* 브라우저로 확인해 보기 전에 몇 가지 작업을 해야 한다.



**AWS 보안 그룹 변경**

* EC2에 스프링 부트 프로젝트가 8080 포트로 배포되었으니, 8080 포트가 보안 그룹에 열려 있는지 확인한다.

  ![보안그룹확인](images/보안그룹확인.PNG)



**AWS EC2 도메인으로 접속**

* 왼쪽 사이드바의 [인스턴스] 메뉴를 클릭한다. 본인이 생성한 EC2 인스턴스를 선택하면 상세 정보에서 **퍼블릭 DNS**를 확인할 수 있다.

  ![탄력적주소](images/탄력적주소.PNG)



* 퍼블릭 DNS의 주소가 EC2에 자동으로 할당된 **도메인**이다. 인터넷이 되는 장소 어디서나 이 주소를 입력하면 배포한 EC2 서버에 접근할 수 있다.

* 도메인 주소에 8080 포트를 붙여 브라우저에 입력한다.

  ![주소](images/주소.PNG)



* 현재 서비스에 **EC2의 도메인을 등록하지 않았기 때문**에 구글과 로그인이 작동하지 않는다.



**구글에 EC2 주소 등록**

* 구글 웹 콘솔(https://console.cloud.google.com/home/dashboard)로 접속하여 본인의 프로젝트로 이동한 다음 **[API 및 서비스 -> 사용자 인증 정보]**로 이동한다.

  ![구글인증정보](images/구글인증정보.PNG)



* [사용자 인증 정보] 탭으 클릭하여 본인이 등록한 서비스의 이름을 클릭한다.

  ![OAuth클라이언트](images/OAuth클라이언트.PNG)



* 퍼블릭 DNS 주소에 **:8080/login/oauth2/code/google** 주소를 추가하여 승인된 리디렉션 URI에 등록한다.

  ![인증정보](images/인증정보.PNG)



* **EC2 DNS** 주소로 이동해서 구글 로그인을 시작하면 로그인이 정상적으로 수행되는 것을 확인할 수 있다.

  ![구글로그인확인](images/구글로그인확인.PNG)



**네이버에 EC2 주소 등록**

* 네이버 개발자 센터(https://developers.naver.com/apps/#/myapps)로 접속해서 본인의 프로젝트로 이동한다.

  ![네이버로그인](images/네이버로그인.png)



* 아래로 내리면 **PC 웹** 항목이 있는데 여기서 **서비스 URL과 Callback URL 2개**를 수정한다.

  ![네이버로그인설정](images/네이버로그인설정.png)

  * **서비스 URL**
    * 로그인을 시도하는 서비스가 네이버에 등록된 서비스인지 판단하기 위한 항목이다.
    * 8080 포트는 제외하고 실제 도메인 주소만 입력한다.
    * 네이버에서 아직 지원되지 않아 하나만 등록 가능하다.
    * EC2의 주소를 등록하면 localhost가 안 된다.
    * 개발 단계에서는 등록하지 않는 것을 추천한다.
    * localhost도 테스트하고 싶으면 네이버 서비스를 하나 더 생성해서 키를 발급받으면 된다.
  * **Callback URL**
    * 전체 주소를 등록한다(EC2 퍼블릭 DNS:8080/login/oauth2/code/naver).



* 2개 항목을 모두 수정/추가하였다면 구글과 마찬가지로 네이버 로그인을 시도한다. 문제가 없다면 정상적으로 수행되는 것을 확인할 수 있다.



* 스크립트를 작성해서 간편하게 빌드와 배포를 진행했다. **하지만, 현재 방식은 몇 가지 문제**가 있다.
  * **수동 실행되는 Test**
    * 본인이 짠 코드가 다른 개발자의 코드에 영향을 끼치지 않는지 확인하기 위해 전체 테스트를 수행해야만 한다.
    * 현재 상태에선 항상 개발자가 작업을 진행할 때마다 수동으로 전체 테스트를 수행해야만 한다.
  * **수동 Build**
    * 다른 사람이 작성한 브랜치와 본인이 작성한 브랜치가 합쳐졌을 때(Merge) 이상이 없는지는 Build를 수행해야만 알 수 있다.
    * 이를 매번 개발자가 직접 실행해야만 한다.

* 위의 문제를 해결하기 위해 다음 장에서 수동 Test & Build를 **자동화시키는 작업**을 진행한다.
* **깃허브에 푸시를 하면 자동으로 Test & Build & Deploy**가 진행되도록 개선하는 작업이다.



---

### 9. 코드가 푸시되면 자동으로 배포(Travis CI 배포 자동화)

* 24시간 365일 운영되는 서비스에서 배포 환경 구축은 필수이다. 여러 개발자의 코드가 **실시간으로** 병합되고, 테스트가 수행되는 환경, master 브랜치가 푸시되면 배포가 자동으로 이루어지는 환경을 구축하지 않으면 실수할 여지가 너무 많다.
* 이런  배포 환경을 구성하는 것이 중요하다.



#### 9.1 CI & CD 소개

* 일반적으로 CI만 구축되지 있지는 않고, CD도 함께 구축된 경우가 대부분이다.

* **CI(Continuous Integration - 지속적 통합)**
  * 코드 버전 관리를 하는 VCS 시스템(Git, SVN 등)에 PUSH가 되면 자동으로 테스트와 빌드가 수행되어 **안정적인 배포 파일을 만드는 과정**이다.
* **CD(Continuous Deployment - 지속적인 배포)**
  * 위의 빌드 결과를 자동으로 운영 서버에 무중단 배포까지 진행괴는 과정이다.



* 주의할 점은 단순히 **CI 도구를 도입했다고 해서 CI를 하고 있는 것이 아니다.** CI에 대해 4가지 규칙이 있다.
  * 모든 소스 코드가 살아 있고(현재 실행되고) 누구든 현재의 소스에 접근할 수 있는 단일 지점을 유지
  * 빌드 프로세스를 자동화해서 누구든 소스로부터 시스템을 빌드하는 단일 명령어를 사용할 수 있게 할 것
  * 테스팅을 자동화해서 단일 명령어로 언제든지 시스템에 대한 건전한 테스트 수트를 실행할 수 있게 할 것
  * 누구나 현재 실행 파일을 얻으면  지금까지 가장 완전한 실행 파일을 얻었다는 확신을 하게 할 것
* 여기서 특히나 중요한 것은 **테스팅 자동화**이다.
* 지속적으로 통합하기 위해서는 무엇보다 이 프로젝트가 **완전한 상태임을 보장**하기 위해 테스트 코드가 구현되어 있어야만 한다.



#### 9.2 Travis CI 연동하기

* Travis CI는 깃허브에서 제공하는 무료 CI 서비스이다.

* 젠킨스와 같은 CI 도구도 있지만, 젠킨스는 설치형이기 때문에 이를 위한 EC2 인스턴스가 하나 더 필요하다.

* 이제 시작하는 서비스에서 배포를 위한 EC2 인스턴스는 부담스럽기 때문에 오픈소스 웹 서비스인 Travis CI를 사용한다.

  > AWS에서 Travis CI와 같은 도구로 CodeBuild를 제공한다. 하지만 빌드 시간만큼 요금이 부과되는 구조라 초기에 사용하기에는 부담스럽다. 실제 서비스되는 EC2, RDS, S3 외에는 비용 부분을 최소화하는 것이 좋다.



**Travis CI 웹 서비스 설정**

* https://travis-ci.com/ 에서 깃허브 계정으로 로그인을 한 뒤, 오른쪽 위에 [계정명 -> Settings]를 클릭한다.

* 설정 페이지 아래쪽을 보면 깃허브 저장소 검색창이 있다. 여기서 저장소 이름을 입력해서 찾은 다음, 오른쪽의 상태바를 활성화시킨다.

  ![저장소활성화](images/저장소활성화.PNG)



* 활성화한 저장소를 클릭하면 다음과 같이 저장소 빌드 히스토리 페이지로 이동한다.

  ![저장소빌드목록](images/저장소빌드목록.PNG)



* Travis CI 웹사이트에서 설정은 이것이 끝이다. 상세한 설정은 **프로젝트의 yml 파일로** 진행해야 한다.



**프로젝트 설정**

* Travis CI의 상세한 설정은 프로젝트에 존재하는 **.travis.yml** 파일로 할 수 있다.

  > * **.yml 파일** 확장자를 **YAML(야믈)**이라고 한다.
  > * YAML은 쉽게 말해 JSON에서 괄호를 제거한 것이다. "기계에서 파싱하기 쉽게, 사람이 다루기 쉽게"
  > * 현재 많은 프로젝트와 서비스들이 YAML을 적극적으로 사용 중이다. Travis CI 역시 설정을 YAML을 통해서 하고 있다.




* Travis CI 설정을 진행하기 위해 프로젝트의 **build.gradle**과 같은 위치에서 **.travis.yml**을 생성한 후 코드를 추가해 준다.

  ```.travis.yml
  language: java
  jdk: 
    - openjdk8
      
  branches:		# 1
    only:
      - master
        
  # Travis CI 서버의 Home
  cache:			# 2
    directories:
      - '$HOME/.m2/repository'
      - '$HOME/.gradle'
        
  script: "./gradlew clean build"		# 3
  
  # CI 실행 완료 시 메일로 알람
  notifications:		# 4
    email:
      recipients: 
        - 본인 메일 주소
  ```

  * {1} **branches**
    * Travis CI를 어느 브런치가 푸시될 때 수행할지 지정한다.
    * 현재 옵션은 오직 **master 브치에 push될 때만** 수행한다.
  * {2} **cache**
    * 그레이들을 통해 의존성을 받게 되면 이를 해당 디렉토리에 캐시하여, **같은 의존성은 다음 배포 때부터 다시 받지 않도록** 설정한다.
  * {3} **script**
    * master 브랜치에 푸시되었을 때 수행하는 명령어이다.
    * 여기서는 프로젝트 내부에 둔 gradlew을 통해 clean & build를 수행한다.
  * {4} **notifications**
    * Travis CI 실행 완료 시 자동으로 알람이 가도록 설정한다.



* 코드를 작성했다면, master 브랜치에 커밋과 푸시를 하고, 좀 전의 Travis CI 저장소 페이지를 확인한다.

  ![TravisCI자동싷행](images/TravisCI자동실행.png)



* 빌드가 성공한 것이 확인되면 .travis.yml에 등록한 이메일을 확인한다.

  ![TravisEmail](images/TravisEmail.PNG)

  * 빌드가 성공했다는 것을 메일로 잘 받은것을 확인할 수 있다.



#### 9.3 Travis CI와 AWS S3 연동하기

* S3란 AWS에서 제공하는 **일종의 파일 서버**이다.
* 이미지 파일을 비롯한 정적 파일들을 관리하거나 지금 진행하는 것처럼 배포 파일들을 관리 하는 등의 기능을 지원
* 보통 이미지 업로드를 구현한다면 S3를 이용하여 구현하는 경우가 많다.



* 첫 번째 단계로 Travis CI와 S3를 연동한다. 

  * 실제 배포는 **AWS CodeDeploy**라는 서비스를 이용한다. 하지만, S3 연동이 필요한 이유는 **Jar 파일을 전달하기 위해서** 이다.

  * CodeDeploy는 저장 기능이 없다. 그래서 Travis CI가 빌드한 결과물을 받아서 CodeDeploy가 가져갈 수 있도록 보관할 수 있는 공간이 필요하다. 보통은 이럴 때 **AWS S3**를 이용한다.

    > * CodeDeploy가 빌도도 하고 배포도 할 수 있다. CodeDeploy에서는 깃허브 코드를 가져오는 기능을 지원하기 때문이다. 하지만 이렇게 할 때 빌드 없이 배포할 때 대응하기 어렵다.
    > * 빌드와 배포가 분리되어 있으면 예전에 빌드되어 만들어진 Jar를 재사용하면 되지만, CodeDeploy가 모든 것을 하게 될 땐 항상 빌드를 하게 되니 확장성이 많이 떨어진다. 그래서 웬만하면 빌드와 배포는 분리하는 것이 좋다.



* Travis CI와 AWS S3 연동 진행



**AWS Key 발급**

* 일반적으로 AWS 서비스에 **외부 서비스가 접근할 수 없다**. 그러므로 **접근 가능한 권한을 가진 Key**를 생성해서 사용해야 한다.

* AWS서는 이러한 인증 관련된 기능을 제공하는 서비스로 **IAM(Identity and Access Management)**이 있다.

* IAM은 AWS에서 제공하는 서비스의 접근 방식과 권한을 관리한다.  이 IAM을 통해 Travis CI가 AWS S3와 CodeDeploy에 접근할 수 있게 한다.

* IAM 페이지 왼쪽 사이드바에서 **[사용자 -> 사용자 추가]** 버튼을 차례로 클릭한다.

  ![IAM사용자추가](images/IAM사용자추가.PNG)



* 생성할 사용자의 이름과 엑세스 유형을 선택한다. 엑세스 유형은 **프로그래밍 방식 엑세스**이다.

  ![엑세스유형](images/엑세스유형.PNG)



* 권한 설정 방식은 3개 중 **[기존 정책 직접 연결]**을 선택한다.

  ![사용자권한설정](images/사용자권한설정.PNG)

  * 화면 아래 정책 검색 화면에서 **s3full**로 검색하여 체크하고 다음 권한으로 **CodeDeployFull**을 검색하여 체크한다.

    ![s3full](images/s3full.png)

    ![codedeployfull](images/codedeployfull.png)

  * 실제 서비스 회사에서는 권한도 **S3와 CodeDeploy를 분리해서 관리**하기도 하지만, 여기서는 간단하게 둘을 합쳐서 관리한다.



* 태그는 Name 값을 지정하는데, 본인이 인지 가능한 정도의 이름으로 만든다.

  ![태그등록](images/태그등록.PNG)



* 마지막으로 본인이 생성한 권한 설정 항목을 확인한다.

  ![권한최종확인](images/권한최종확인.png)



* 최종 생성 완료되면 다음과 같이 엑세스 키와 비밀 엑세스 키가 생성된다. 이 두 값이 **Travis CI에서 사용될 키**이다.

  ![엑세스키확인](images/엑세스키확인.png)



**Travis CI에 키 등록**

* 먼저 Travis CI의 설정 화면으로 이동한다.

* 설정 화면을 아래로 내리면 **Environment Variables** 항목이 있다.

  ![Travis환경변수](images/Travis환경변수.PNG)

  * 여기에 **AWS_ACCESS_KEY, AWS_SECRET_KEY**를 변수로 해서 IAM 사용자에서 발급받은 키 값들을 등록한다.

    * AWS_ACCESS_KEY : 엑세스 키 ID
    * AWS_SECRET_KEY : 비밀 엑세스 키

    ![환경변수등록](images/환경변수등록.PNG)

  * 여기에 등록된 값들은 이제 .travis.yml 에서 **$AWS_ACCESS_KEY, $AWS_SECRET_KEY** 란 이름으로 사용할 수 있다.



**S3 버킷 생성**

* **S3(Simple Storage Service)**에 관해 설정을 한다. AWS의 S3서비스는 일종의 **파일 서버**이다. 순수하게 파일들을 저장하고 접근 권한을 관리, 검색 등을 지원하는 파일 서버의 역할을 한다.

* S3는 보통 게시글을 쓸 때 나오는 첨부파일 등록을 구현할 때 많이 이용한다. 파일 서버의 역할을 하기 때문인데, Travis CI에서 생성된 **Build 파일을 저장**하도록 구성한다.

* S3에 저장된 Build 파일은 이후 AWS의 CodeDeploy에서 배포할 파일로 가져갇도록 구성할 예정이다. 

* AWS서비스에서 S3를 검색하여 이동하고 버킷을 생성한다.

  ![버킷만들기](images/버킷만들기.PNG)



* 원하는  버킷명을 작성한다. 이 버켓에 **배포할 Zip 파일이 모여있는 장소**임을 의미하도록 짓는 것을 추천한다.

  ![버킷이름](images/버킷이름.PNG)



* 퍼블릭 액세스를 **모든 차단**을 해야 한다. 현재 프로젝트는 이미 깃허브에 오픈소스로 풀려있으니 문제없지만, 실제 서비스에서 할 때는 Jar 파일이 퍼블릭일 경우 누구나 내려받을 수 있어 코드나 설정값, 주요 키값들이 다 탈취될 수 있다.

* 퍼블릭이 아니더라도 IAM 사용자로 발급받은 키를 사용하니 접근 가능하다. 그러므로 모든 액세스를 차단하는 설정에 체크한다.

  ![퍼블릭엑세스](images/퍼블릭엑세스.png)



* 버킷이 생성되면 다음과 같이 버킷 목록에서 확인할 수 있다.

  ![버킷생성](images/버킷생성.PNG)



* S3가 생성되었으니 이제 이 S3로 배포 파일을 전달한다.



**.travis.yml 추가**

* Travis CI에서 빌드하여 만든 Jar 파일을 S3에 올릴 수 있도록 .travis.yml에 코드를 추가한다.

  ```.travis.yml
  ...
  before_deploy:
    - zip -r springboot2-webservice *
    - mkdir -p deploy
    - mv springboot2-webservice.zip deploy/springboot2-webservice.zip
  
  deploy:
    - provider: s3
      access_key_id: $AWS_ACCESS_KEY # Travis repo settings에 설정된 값
      secret_access_key: $AWS_SECRET_KEY # Travis repo settings에 설정된 값
      bucket: allsser-springboot-build # S3 버킷
      region: ap-northeast-2
      skip_cleanup: true
      acl: private # zip 파일 접근을 private으로
      local_dir: deploy # before_deploy에서 생성된 디렉토리
      wait-until-deployed: true
  ...
  ```

  * 전체 코드는 다음과 같다. Travis CI Settings 항목에서 등록한 **$AWS_ACCESS_KEY, $AWS_SECRET_KEY**가 변수로 사용된다.

  ```.travis.yml
  language: java
  jdk:
    - openjdk8
  
  branches:
    only:
      - master
  
  # Travis CI 서버의 Home
  cache:
    directories:
      - '$HOME/.m2/repository'
      - '$HOME/.gradle'
  
  script: "./gradlew clean build"
  
  before_deploy:		# 1
    - zip -r springboot2-webservice *		# 2
    - mkdir -p deploy		# 3
    - mv springboot2-webservice.zip deploy/springboot2-webservice.zip		# 4
  
  deploy:		# 5
    - provider: s3
      access_key_id: $AWS_ACCESS_KEY # Travis repo settings에 설정된 값
      secret_access_key: $AWS_SECRET_KEY # Travis repo settings에 설정된 값
      bucket: allsser-springboot-build # S3 버킷
      region: ap-northeast-2
      skip_cleanup: true
      acl: private # zip 파일 접근을 private으로
      local_dir: deploy # before_deploy에서 생성된 디렉토리		# 6
      wait-until-deployed: true
  
  # CI 실행 완료 시 메일로 알람
  notifications:
    email:
      recipients:
        - 본인 메일 주소
  ```

  * {1} **before_deploy**
    * deploy 명령어가 실행되기 전에 수행된다.
    * CodeDeploy는 **Jar 파일은 인식하지 못하므로** Jar+기타 설정 파일들을 모아 압축(zip)한다.
  * {2} **zip -r springboot2-webservice**
    * 현재 위치의 모든 파일을 springboot2-webservice 이름으로 압축(zip)한다.
    * 명령어의 마지막 위치는 본인의 프로젝트 이름이어야 한다.
  * {3} **mkdir -p deploy**
    * deploy라는 디렉토리를 Travis CI가 실행 중인 위치에서 생성한다.
  * {4} **mv springboot2-webservice.zip deploy/springboot2-webserivce.zip**
    * springboot2-webserivce.zip 파일을 deploy/springboot2-webservice.zip으로 이동시킨다.
  * {5} **deploy**
    * S3로 파일 업로드 혹은 CodeDeploy로 배포 등 **외부 서비스와 연동될 행위들을 선언**한다.
  * {6} **local_dir: deploy**
    * 앞에서 생성한 deploy 디렉토리를 지정한다.
    * **해당 위치의 파일들만** S3로 전송한다.



* 설정이 다 되었으면 **깃허브로 푸시**한다. Travis CI에서 자동으로 빌드가 진행되는 것을 확인하고, 모든 빌드가 성공하는지 확인한다.

* 다름 로그가 나온다면 Travis CI의 빌드가 성공한 것이다.

  > ```
  > Installing deploy dependencies
  > 1301Logging in with Access Key: ****************YTXP
  > Beginning upload of 1 files with 5 threads.
  > Preparing deploy
  > Deploying application
  > Done. Your build exited with 0.
  > ```



*  S3 버킷을 가보면 업로드가 성공한 것을 확인할 수 있다.

  ![S3업로드](images/S3업로드.PNG)



* Travis CI를 통해 자동으로 파일이 올려진 것을 확인할 수 있다.
* Travis CI와 S3 연동되었다. 이제 CodeDeploy로 배포까지 완료해 본다.



#### 9.4 Travis CI와 AWS S3, CodeDeploy 연동하기

* AWS의 배포 시스템인 CodeDeploy를 이용하기 전에 배포 대상인 **EC2가 CodeDeploy를 연동 받을 수 있게 IAM** 역할을 하나 생성한다.



**EC2에 IAM 역할 추가하기**

* S3와 마찬가지로 IAM을 검색하고, [역할] 탭을 클릭해서 이동한다. [역할 -> 역할 만들기] 버튼을 차례로 클릭한다.

  ![역할만들기](images/역할만들기.png)

  * 앞에서 만들었던 **IAM의** 사용자와 역할은 어떤 차이가 있는가?
    * 역할
      * AWS 서비스에만 할당할 수 있는 권한
      * EC2, CodeDeploy, SQL 등
    * 사용자
      * **AWS 서비스 외**에 사용할 수 있는 권한
      * 로컬 PC, IDC 서버 등



* 지금 만들 권한은 **EC2에서 사용할 것**이기 때문에 사용자가 아닌 역할로 처리한다.

* 서비스 서택에서는 [AWS 서비스 -> EC2]를 차례로 선택한다.

  ![서비스선택](images/서비스선택.png)



* 정책에선 **EC2RoleForA**를 검색하여 **AmazoneEC2RoleforAWS-CodeDeploy**를 선택한다.

  ![정책선택](images/정책선택.png)



* 태그는 본인이 원하는 이름으로 짓는다.

  ![태그등록role](images/태그등록role.png)



* 마지막으로 역할의 이름을 등록하고 나머지 등록 정보를 최종적으로 확인한다.

  ![최종확인](images/최종확인.png)



* 이렇게 만든 역할을 EC2 서비스에 등록한다.

* EC2 인스턴스 목록으로 이동한 뒤, 본인의 인스턴스를 마우스 버튼으로 눌러 [보안 -> IAM 역할 수정]를 차례로 선택한다.

  ![IAM역할변경](images/IAM역할변경.png)



* 방금 생성한 역할을 선택한다.

  ![IAM역할선택](images/IAM역할선택.png)



* 역할 선택이 완료되면 해당 EC2 인스턴스를 재부팅한다. 재부팅을 해야만 역할이 정상적으로 적용되니 꼭 한 번은 재부팅해준다.

  ![인스턴스재부팅](images/인스턴스재부팅.png)



* 재부팅이 완료되면 CodeDeploy의 요청을 받을 수 있게 에이전트를 하나 설치한다.



**CodeDeploy 에이전트 설치**

* EC2에 접속해서 명령어를 입력한다.

  > aws s3 cp s3://aws-codedeploy-ap-northeast-2/latest/install . --region ap-northeast-2

* 내려받기가 성공했다면 다음과 같은 메시지가 콘솔에 출력된다.

  > download: s3://aws-codedeploy-ap-northeast-2/latest/install to ./install

* install 파일에 실행 권한이 없으니 실행 권한을 추가한다.

  > chmod +x ./install

* install 파일로 설치를 진행한다.

  > sudo ./install auto
  
  * 만약 설치 중에 다음과 같은 에러가 발생한다면 루비라는 언어가 설치가 안 된 상태라서 그렇다.
  * /usr/bin/env:ruby:No such file or directory
  * 이럴 경우 yum install 로 루비를 설치하면 된다.
  * **sudo yum install ruby**
  
* 설치가 끝났으면 **Agent**가 정상적으로 실행되고 있는지 상태를 검사를 한다.

  > sudo service codedeploy-agent status

* 다음과 같이 running 메시지가 출력되면 정상이다.

  > The AWS CodeDeploy agent is running as PID xxx



**CodeDeploy를 위한 권한 생성**

* CodeDeploy에서 EC2에 접근하려면 마찬가지로 권한이 필요하다.

* WAS의 서비스이니 IAM 역할을 생성한다.

* 서비스는 [AWS 서비스 -> CodeDeploy]를 차례로 선택한다.

  * 앞에서 [EC2에 IAM 역할 추가하기](#EC2에 IAM 역할 추가하기) 했던 것처럼 IAM에서 역할 만들기로 추가해 준다.

  ![codedeploy서비스선택](images/codedeploy서비스선택.png)



* CodeDeploy는 권한이 하나뿐이라서 선택 없이 바로 다음으로 넘어가면 된다.

  ![codedeploy권한선택](images/codedeploy권한선택.png)



* 태그는 원하는 이름으로 짓는다.

  ![codedeploy태그등록](images/codedeploy태그등록.png)



* CodeDeploy를 위한 역할 이름과 선택 항목들을 확인한 뒤 생성 완료를 한다.

  ![codedeploy생성완료](images/codedeploy생성완료.png)



**CodeDeploy 생성**

* CodeDeploy는 AWS의 배포 삼형제 중 하나이다. 배포 삼형제에 대하 간단하게 소개하면 다음과 같다.
  * **Code Commit**
    * 깃허브와 같은 코드 저장소의 역할을 한다.
    * 프라이빗 기능을 지원한다는 강점이 있지만, 현재 **깃허브에서 무료로 프라이빗 지원**을 하고 있어서 거의 사용하지 않는다.
  * **Code Build**
    * Travis CI와 마찬가지로 **빌드용 서비스**이다.
    * 멀티 모듈을 배포해야 하는 경우 사용해 볼만하지만, 규모가 있는 서비스에서는 대부분 **젠킨스/팀시티 등을 이용**하니 이것 역시 사용할 일이 거의 없다.
  * **CodeDeploy**
    * AWS의 배포 서비스이다.
    * 앞에서 언급한 다른 서비스들은 대체재가 있고, 딱히 대체재보다 나은 점이 없지만, CodeDeploy는 **대체재가 없다.**
    * 오토 스케일링 그룹 배포, 블루 그린 배포, 롤링 배포, EC2 단독 배포 등 많은 기능을 지원한다.

* 이 중에서 현재 진행 중인 프로젝트에서는 Code Commit의 역할은 **깃허브**가, Code Build의 역할은 **Travis CI**가 하고 있다. 그래서 추가로 사용할 서비스는 CodeDeploy이다.



* CodeDeploy 서비스로 이동해서 화면 중앙에 있는 [애플리케이션 생성] 버튼을 클릭한다.

  ![codedeploy생성버튼](images/codedeploy생성버튼.png)



* 생성할 CodeDeploy의 이름과 컴퓨팅 플랫폼을 선택한다. 컴퓨팅 플랫폼에선 [EC2/온프레미스]를 선택하면 된다.

  ![codedeploy구성선택](images/codedeploy구성선택.png)



* 생성이 완료되면 배포 그룹을 생성하라는 메시지를 볼 수 있다. 화면 중앙의 [배포 그룹 생성] 버튼을 클릭한다.

  ![배포그룹생성](images/배포그룹생성.png)



* 배포 그룹 이름과 서비스 역할을 등록한다. 서비스 역할은 좀 전에 생성한 CodeDeploy용 IAM 역할을 선택하면 된다.

  ![권한선택](images/권한선택.png)



* 배포 유형에서는 **현재 위치**를 선택한다.

* 본인이 배포할 서비스가 2대 이상이라면 **블루/그린**을 선택하면 된다. 현재는 1대의 EC2에만 배포하므로 선택하지 않는다.

  ![배포이름](images/배포이름.png)



* 환경 구성에서는 [Amazone EC2 인스턴스]에 체크한다.

  ![환경구성](images/환경구성.png)



* 다음과 같이 배포 구성을 선택하고 로드밸런싱은 체크 해제한다.

  ![배포설정](images/배포설정.png)

  * **배포 구성**이란 한번 배포할 때 몇대의 서버에 배포할지를 결정한다. 2대 이상이라면 1대씩 배포할지, 30% 혹은 50%로 나눠서 배포할지 등등 여러 옵션을 선택하겠지만, 1대 서버다 보니 전체 배포하는 옵션으로 선택하면 된다.
    * CodeDeployDefault.AllAtOnce는 한 번에 배포하는 것을 의미한다.



**Travis CI, S3, CodeDeploy 연동**

* 먼저 S3에서 넘겨줄 zip 파일을 저장할 디렉토리를 하나 생성한다. EC2 서버에 접속해서 다음과 같이 디렉토리를 생성한다.

  > mkdir ~/app/step2 && mkdir ~/app/step2/zip

  * && 옵션이 있으면 연속해서 명령어를 사용할 수 있다.



* Travis CI의 Build가 끝나면 S3에 zip 파일이 전송되고, 이 zip 파일은 **/home/ec2-user/app/step2/zip**로 복사되어 풀 예정이다.

* Travis CI로 설정은 **.travis.yml로 진행**했다.

* AWS CodeDeploy의 설정은 **appspec.yml로 진행**한다.

  ![appspec](images/appspec.png)

  * 코드는 다음과 같다.

  **appspec.yml**

  ```appspec.yml
  version: 0.0	# {1}
  os: linux
  files:
    - source: /	# {2}
      destination: /home/ec2-user/app/step2/zip/	# {3}
      overwrite: yes	# {4}
  ```

  * {1} **version: 0.0**
    * **CodeDeploy 버전**을 이야기 한다.
    * 프로젝트 버전이 아니므로 0.0 외에 다른 버전을 사용하면 오류가 발생한다.
  * {2} **source**
    * CodeDeploy에서 전달해 준 파일 중 destination으로 이동시킬 대상을 지정한다.
    * 루트 경로( / )를 지정하면 전체 파일을 이야기한다.
  * {3} **destination**
    * source에서 지정한 파일을 받을 위치이다.
    * 이후 Jar를 실행하는 등은 destination에서 옮긴 파일들로 진행된다.
  * {4} **overwrite**
    * 기존에 파일들이 있으면 덮어쓸지를 결정한다.
    * 현재 yes라고 했으니 파일들을 덮어쓰게 된다.



* **.travis.yml**에도 CodeDeploy 내용을 추가해준다. deploy 항목에 다음 코드를 추가한다.

  **.travis.yml**

  ```.travis.yml
deploy:
  	...
  	
    - provider: codedeploy
      access_key_id: $AWS_ACCESS_KEY # Travis repo settings에 설정된 값
      secret_access_key: $AWS_SECRET_KEY # Travis repo settings에 설정된 값
      bucket: allsser-springboot-build # S3 버킷
      key: springboot2-webservice.zip # 빌드 파일을 압축해서 전달
      bundle_type: zip # 압축 확장자
      application: allsser-springboot2-webservice # 웹 콘솔에서 등록한 CodeDeploy 애플리케이션
      deployment_group: allsser-springboot2-webservice # 웹 콘솔에서 등록한 CodeDeploy 배포 그룹
      region: ap-northeast-2
      wait-until-deployed: true
  ```
  
* S3 옵션과 유사하다. 다른 부분은 CodeDeploy의 애플리케이션 이름과 배포 그룹명을 지정하는 것이다.



* 모든 내용을 작성했다면 프로젝트를 커밋하고 푸시한다. 깃허브로 푸시가 되면 Travis CI가 자동으로 시작된다.

* Travis CI가 끝나면 CodeDeploy 화면 아래에서 배포가 수행되는 것을 확인할 수 있다.

  ![codedeploy진행중](images/codedeploy진행중.png)



* 배포가 끝났다면 다음 명령어로 파일들이 잘 도착했는지 확인한다.

  > cd /home/ec2-user/app/step2/zip

* 파일 목록을 확인해 보면 프로젝트 파일들이 잘 도착한 것을 확인할 수 있다.

  ![zip](images/zip.png)



* Travis CI와 S3, CodeDeploy가 연동이 완료되었다.



#### 9.5 배포 자동화 구성

* 앞의 과정으로 **Travis CI, S3, CodeDeploy 연동**까지 구현되었다.
* 이제 이것을 기반으로 실제 **Jar를 배포하여 실행까지** 한다.



**deploy.sh 파일 추가**

* step2 환경에서 실행될 deploy.sh를 생성한다. **scripts 디렉토리**를 생성해서 여기에 스크립트를 생성한다.

  ![deploy위치](images/deploy위치.png)

  ```deploy.sh
  #!/bin/bash
  
  REPOSITORY=/home/ec2-user/app/step2
  PROJECT_NAME=SpringBoot		# {1}
  
  echo "> Build 파일 복사"
  
  cp $REPOSITORY/zip/*.jar $REPOSITORY/
  
  echo "> 현재 구동 중인 애플리케이션 pid 확인"
  
  CURRENT_PID=$(pgrep -fl ${PROJECT_NAME} | grep java | awk '{print $1}')		# {2}
  
  echo "> 현재 구동 중인 애플리케이션 pid: $CURRENT_PID"
  
  if [ -z "$CURRENT_PID" ]; then
    echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
  else
    echo "> kill -15 $CURRENT_PID"
    kill -15 $CURRENT_PID
    sleep 5
  fi
  
  echo "> 새 애플리케이션 배포"
  
  JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
  
  echo "> JAR_NAME: $JAR_NAME"
  
  echo "> $JAR_NAME 에 실행권한 추가"
  
  chmod +x $JAR_NAME		# {3}
  
  echo "> $JAR_NAME 실행"
  
  nohup java -jar \
    -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
    -Dspring.profiles.active=real \
    $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &		# {4}
  ```

  * {1} **PROJECT_NAME=SpringBoot**

    * 처음 파일명을 **SpringBoot&AWS** 지정하였더니 PORJECT_NAME 인식을 **SpringBoot** 로 인식한다.

    * 파일명인 SpringBoot&AWS로 인식하는 것이 아닌 SpringBoot로 인식하는 이유는 리눅스에서 특수 문자인 **&** 를 인식하지 못하여 특수 문자 앞에 까지만 인식하기 때문에 **SpringBoot** 로 지정된다.

      > 리눅스에서 파일명에 특수 문자가 들어가 있는 경우 특수 문자를 인식하기 위해서 ' ' 처리를 해준다.
      >
      > **SpringBoot'&'AWS** 를 입력하면 특수 문자까지 인식하여 SpringBoot&AWS 로 인식한다.

  * {2} **CURRENT_PID**
    * 현재 수행 중인 스프링 부트 애플리케이션의 프로세스 ID를 찾는다.
    * 실행 중이면 종료하기 위해서이다.
    * 스프링 부트 애플리케이션 이름(SpringBoot)으로 된 다른 프로그램들이 있을 수 있어 SpringBoot로 된 jar(pgrep -fl SpringBoot | grep java) 프로세스를 찾은 뒤 ID를 찾는다.( **| awk '{print $1}'** )
    * CURRENT_PID의 프로세스 ID를 저장 못시켜 줄 경우 배포를 했을 때 기존의 프로세스를 종료시켜 주지 못하여 제대로 배포가 안된다. 8080 포트가 계속 쓰이고 있어서 배포 불가능 -> 오류 발생
  * {3} **chmod +x $JAR_NAME**
    * Jar 파일은 실행 권한이 없는 상태이다.
    * nohup으로 실행할 수 있게 실행 권한을 부여한다.
  * {4} **$JAR_NAME > $REPOSITORY/nohup.out 2>&1 &**
    * nohup 실행 시 CodeDeploy는 **무한 대기 한다.**
    * 이 이슈를 해결하기 위해 nohup.out 파일을 표준 입출용으로 별도로 사용한다.
    * 이렇게 하지 않으면 nohup.out 파일이 생기지 않고, **CodeDeploy 로그에 표준 입출력이 출력된다.**
    * nohup이 끝나기 전까지 CodeDeploy도 끝나지 않으니 꼭 이렇게 해야 한다.



* step1에서 작성된 deploy.sh와 크게 다르지 않다.
* **git pull**을 통해 **직접 빌드했던 부분을 제거**했다. 그리고 Jar를 실행하는 단계에서 몇가지 코드가 추가되었다.
  * 플러그인 중 BashSupport를 설치하면 .sh파일 편집 시 도움을 받을 수 있다.



**.tarvis.yml 파일 수정**

* 현재 프로젝트의 모든 파일은 zip 파일로 만드는데, 실제로 필요한 파일들은 **Jar, appspec.yml, 배포를 위한 스크립트**들이다. 이 외 나머지는 배포에 필요하지 않으니 포함하지 않는다.

* 그렇기 때문에 **.travis.yml** 파일의 **before_deploy**를 수정한다.

  > .travis.yml 파일은 Travis CI에서만 필요하지 CodeDeploy에서 필요하진 않는다.

  **.travis.yml**

  ```.travis.yml
  before_deploy:
    - mkdir -p before-deploy # zip에 포함시킬 파일들을 담을 디렉토리 생성 	# {1}
    - cp scripts/*.sh before-deploy/ 	# {2}
    - cp appspec.yml before-deploy/
    - cp build/libs/*.jar before-deploy/
    - cd before-deploy && zip -r before-deploy * # before-deploy로 이동 후 전체 압축	#{3}
    - cd ../ && mkdir -p deploy # 상위 디렉토리로 이동 후 deploy 디렉토리 생성
    - mv before-deploy/before-deploy.zip deploy/springboot-webservice.zip # deploy로 zip파일 이동
  ```

  * {1} **Travis CI는 S3로 특정 파일만 업로드가 안된다.**
    * 디렉토리 단위로만 업로드할 수 있기 때문에 before-deploy 디렉토리는 항상 생성한다.
  * {2} **before-deploy에는 zip 파일에 포함시킬 파일들을 저장한다.**
  * {3} **zip -r 명령어를 통해 before-deploy 디렉토리 전체 파일을 압축한다.**



* CodeDeploy의 명령을 담당할 appspec.yml 파일을 수정한다.



**appspec.yml 파일 수정**

* appspec.yml 파일에 다음 코드를 추가한다. 

* location, timeout, runas의 들쓰기를 주의해야 한다. 들여쓰기가 잘못된 경우 배포가 실패한다.

  **appspec.yml**

  ```appspec.yml
  permissions:	# {1}
    - object: /
      pattern: "**"
      owner: ec2-user
      group: ec2-user
      
  hooks:		# {2}
    ApplicationStart:
      - location: deploy.sh
        timeout: 60
        runas: ec2-user
  ```

  * {1} **permissions**
    * CodeDeploy에서 EC2 서버로 넘겨준 파일들을 모두 ec2-user 권한을 갖도록 한다.
  * {2} **hooks**
    * CodeDeploy 배포 단계에서 실행할 명령어를 지정한다.
    * ApplicationStart라는 단계에서 deploy.sh를 ec2-user 권한으로 실행하게 한다.
    * timeout: 60 으로 스크립트 실행 60초 이상 수행되면 실패가 된다.(무한정 기다릴 수 없으니 시간 제한을 둔다.)



* 모든 설정이 완료되었으니 깃허브로 커밋과 푸시를 한다. Travis CI에서 성공 메시지를 확인하고 CodeDeploy에서도 배포가 성공한 것을 확인한다.



**실제 배포 과정**

* Build.gradle에서 프로젝트 버전을 변경한다.

  > Version '1.0.2-SNAPSHOT'

* 변경된 내용을 알 수 있게 src/main/resources/templates/**index.mustache** 내용에 텍스트 수정을 해준다.

  ```index.mustache
  ...
  <h1>스프링 부트로 시작하는 웹 서비스 Ver.12</h1>
  ...
  ```

* 위에서 배포 전에 코드를 테스트하여 에러가 있는지 확인할 수 있다. 테스트 코드가 에러가 있는 상태에서 배포를 하면 배포가 안된다. 테스트 코드까지 통과를 시켜준 후에 배포를 해준다.

* 깃허브로 커밋과 푸시를 한다. 그럼 **변경된 코드가 배포** 된 것을 확인할 수 있다.

  ![배포완료](images/배포완료.png)

  * 신규 버전이 정상적으로 배포되는 것을 확인할 수 있다.



#### 9.6 CodeDeploy 로그 확인

* CodeDeployd와 같이 AWS가 지원하는 서비스에서 오류가 발생 했을때 배포가 실패한 오류를 보기 위해서 로그를 확인한다.

* CodeDeploy에 관한 대부분의 내용은 **/opt/codedeploy-agent/deployment-root** 에 있다. 해당 디렉토리로 이동(cd /opt/codedeploy-agent/deployment-root)한 뒤 목록을 확인해 보면 다음과 같은 내용을 확인할 수 있다. 

  ![deployment-root](images/deployment-root.png)

  * **최상단의 영문과 대시( - )가 있는 디렉토리명은 CodeDeploy ID 이다.**
    * 사용자마다 고유한 ID가 생성되어 각자 다른 ID가 발급되니 본인의 서버에는 다른 코드로 되어있다.
    * 해당 디렉토리로 들어가 보면 **배포한 단위별로 배포 파일들이** 있다.
  * **/opt/codedeploy-agent/deployment-root/deployment-logs/codedeploy-agent-deployments.log**
    * CodeDeploy 로그 파일이다.
    * CodeDeploy로 이루어지는 배포 내용 중 표준 입/출력 내용은 모두 여기에 담겨 있다.
    * 작성한 echo 내용도 모두 표기된다.



* 테스트, 빌드, 배포까지 전부 자동화되었다.
* 작업이 끝난 내용을 **Master 브랜치에 푸시만 하면 자동으로 EC2에 배포** 가 된다.
* 문제는 **배포하는 동안** 스프링 부트 프로젝트는 종료 상태가 되어 **서비스를 이용할 수 없다** 는 것이다.



----

### 10. 24시간 365일 중간 없는 서비스 만들기

* 배포하는 동안 애플리케이션이 종료된다는 문제가 있다.

* **새로운 Jar가 실행되기 전까지 기존 Jar를 종료시켜 놓기 때문에** 서비스가 중단된다.



#### 10.1 무중단 배포 소개

* 서비스를 정지하지 않고 배포하는 것을 **무중단 배포** 라고 한다. 무중단 배포 방식에는 몇가지 방식이 있다.
  * AWS에서 블루 그린(Blue-Green) 무중단 배포
  * 도커를 이용한 웹 서비스 무중단 배포
  * **L4 스위치** 를 이용한 무중단 배포 방법도 있지만, L4가 워낙 고가의 장비이다 보니 대형 인터넷 기업 외에는 쓸 일이 거의 없다.



* **엔진엑스(Nginx)** 를 이용한 무중단 배포를 한다.
  * 엔진엑스는 웹 서버, 리버스 프록시, 캐싱, 로드 밸런싱, 미디어 스트리밍 등을 위한 오픈소스 소프트웨어이다.
  * 이전에 아파치가 대세였던 자리를 완전히 빼앗은 가장 유명한 웹서버이자 오픈소스이다. 고성능 웹서버이기 때문에 대부분의 서비스들이 현재는 엔진엑스를 사용하고 있다.
* 엔진엑스가 가지고 있는 여러 기능 중 **리버스 프록시** 가 있다.
  * 리버스 프록시란 엔진엑스가 **외부의 요청을 받아 백엔드 서버로 요청하는 전달** 하는 행위를 뜻한다.
  * 리버스 프록시 서버(엔진엑스)는 요청을 전달하고, 실제 요청에 대한 처리는 뒷단의 웹 애플리케이션 서버들이 처리한다.



* 리버스 프록시를 통해 무중단 배포 환경을 구축한다. 엔진엑스를 이용한 무중단 배포를 하는 이유는 **가장 저렴하기 때문이다.**
  * 사내 비용 지원이 많다면 번거롭게 구축할 필요 없이 AWS 블루 그린 배포 방식을 선택하면 된다.



* 기존에 쓰던 EC2에 그대로 적용하면 되므로 배포를 위해 AWS EC2 인스턴스가 하나 더 필요하지 않다.
* 구조는 간단하다. 하나의 EC2 혹은 리눅스 서버에 엔진엑스 1대와 **스프링 부트 Jar를 2대** 를 사용하는 것이다.
  * 엔진엑스는 80(http), 443(https) 포트를 할당한다.
  * 스프링 부트1은 8081 포트로 실행한다.
  * 스프링 부트2는 8082 포트로 실행한다.




**실제 배포 과정**

* Build.gradle에서 프로젝트 버전을 변경한다.

  > Version '1.0.2-SNAPSHOT'

* 변경된 내용을 알 수 있게 src/main/resources/templates/**index.mustache** 내용에 텍스트 수정을 해준다.

  ```index.mustache
  ...
  <h1>스프링 부트로 시작하는 웹 서비스 Ver.12</h1>
  ...
  ```

* 위에서 배포 전에 코드를 테스트하여 에러가 있는지 확인할 수 있다. 테스트 코드가 에러가 있는 상태에서 배포를 하면 배포가 안된다. 테스트 코드까지 통과를 시켜준 후에 배포를 해준다.

* 깃허브로 커밋과 푸시를 한다. 그럼 **변경된 코드가 배포** 된 것을 확인할 수 있다.

  ![배포완료](images/배포완료.png)

  * 신규 버전이 정상적으로 배포되는 것을 확인할 수 있다.
  
    

----

### 10. 24시간 365일 중단 없는 서비스 만들기

* 배포하는 동안 애플리케이션이 종료된다는 문제가 있다.

* **새로운 Jar가 실행되기 전까지 기존 Jar를 종료시켜 놓기 때문에** 서비스가 중단된다.



#### 10.1 무중단 배포 소개

* 서비스를 정지하지 않고 배포하는 것을 **무중단 배포** 라고 한다. 무중단 배포 방식에는 몇가지 방식이 있다.
  * AWS에서 블루 그린(Blue-Green) 무중단 배포
  * 도커를 이용한 웹 서비스 무중단 배포
  * **L4 스위치** 를 이용한 무중단 배포 방법도 있지만, L4가 워낙 고가의 장비이다 보니 대형 인터넷 기업 외에는 쓸 일이 거의 없다.



* **엔진엑스(Nginx)** 를 이용한 무중단 배포를 한다.
  * 엔진엑스는 웹 서버, 리버스 프록시, 캐싱, 로드 밸런싱, 미디어 스트리밍 등을 위한 오픈소스 소프트웨어이다.
  * 이전에 아파치가 대세였던 자리를 완전히 빼앗은 가장 유명한 웹서버이자 오픈소스이다. 고성능 웹서버이기 때문에 대부분의 서비스들이 현재는 엔진엑스를 사용하고 있다.
* 엔진엑스가 가지고 있는 여러 기능 중 **리버스 프록시** 가 있다.
  * 리버스 프록시란 엔진엑스가 **외부의 요청을 받아 백엔드 서버로 요청하는 전달** 하는 행위를 뜻한다.
  * 리버스 프록시 서버(엔진엑스)는 요청을 전달하고, 실제 요청에 대한 처리는 뒷단의 웹 애플리케이션 서버들이 처리한다.



* 리버스 프록시를 통해 무중단 배포 환경을 구축한다. 엔진엑스를 이용한 무중단 배포를 하는 이유는 **가장 저렴하기 때문이다.**
  * 사내 비용 지원이 많다면 번거롭게 구축할 필요 없이 AWS 블루 그린 배포 방식을 선택하면 된다.



* 기존에 쓰던 EC2에 그대로 적용하면 되므로 배포를 위해 AWS EC2 인스턴스가 하나 더 필요하지 않다.
* 구조는 간단하다. 하나의 EC2 혹은 리눅스 서버에 엔진엑스 1대와 **스프링 부트 Jar를 2대** 를 사용하는 것이다.
  * 엔진엑스는 80(http), 443(https) 포트를 할당한다.
  * 스프링 부트1은 8081 포트로 실행한다.
  * 스프링 부트2는 8082 포트로 실행한다.

* 기존에 배포한 서버를 켜놓고 새롭게 배포 할 것을 다른 서버에 배포하여 배포가 끝나면 배포한 서버로 연결한다.



#### 10.2 엔진엑스 설치와 스프링 부트 연동하기

* 가장 먼저 EC2에 엔진엑스를 설치한다.



**엔진엑스 설치**

* EC2에 접속해서 명령어를 입력하여 엔진엑스를 설치한다.

  > sudo amazon-linux-extras install nginx1

* 설치가 완료되면 명령어로 엔진엑스를 실행한다.

  > sudo service nginx start

* 엔진엑스가 잘 실행되는 것을 확인해 보기 위해 다음 명령어를 입력한다.

  > systemmctl is-active nginx

  * 실행중이라면 active가 뜬다.

* 엔진엑스를 종료하는 명령어는

  > sudo service nginx stop

* 실행중인 엔진엑스의 프로세스를 확인하는 명령어

  > ps -ef | grep nginx



**보안 그룹 추가**

* 엔진엑스의 포트번호를 보안 그룹에 추가한다. 엔진엑스의 포트번호는 기본적으로 **80**이다.

* 해당 포트 번호가 보안 그룹에 없으니 **[EC2 -> 보안 그룹 -> EC 보안 그룹 선택 -> 인바운드 편집]** 으로 차례로 이동해서 변경한다.

  ![80보안추가](images/80보안추가.png)



**리디렉션 추가**

* 8080이 아닌 80포트로 주소가 변경되니 구글과 네이버 로그인에도 변경된 주소를 등록해야 한다.

* 기존에 등록된 리디렉션 주소에서 8080부분을 제거하여 추가 등록한다.

  **구글 승인된 리디렉션 URI 추가**

  ![구글리디렉션](images/구글리디렉션.png)

  **네이버 승인된 리디렉션 URI 추가**

  ![네이버리디렉션](images/네이버리디렉션.png)

* 추가한 후 EC2의 도메인으로 접근하되, **8080 포트를 제거하고** 접근한다.

* 포트번호 없이 도메인만 입력하여 접근하면 엔진엑스 웹페이지를 볼 수 있다.

  ![80포트접속](images/80포트접속.png)



**엔진엑스와 스프링 부트 연동**

* 엔진엑스가 현재 실행 중인 스프링 부트 프로젝트를 바라볼 수 있도록 프록시 설정을 한다.

* 엔진엑스 설정 파일을 연다.

  > sudo vim /etc/nginx/nginx.conf

  * 설정 내용 중 server 아래의 location / 부분을 찾아서 다음과 같이 추가해 준다.

  ![설정추가](images/설정추가.png)

  **nginx.conf**

  ```nginx
  location / {
      proxy_pass http://localhost:8080;	//	{1}
      proxy_set_header X-Real-IP $remote_addr;
      proxy_set_header X-Forwarded $proxy_add_x_forwarded_for;	//	{2}
      proxy_set_header Host $http_host;
  }
  ```

  * {1} **proxy_pass**
    * 엔진엑스로 요청이 오면 http://localhost:8080 로 전달한다.
  * {2} **proxy_set_header XXX**
    * 실제 요청 데이터를 header의 각 항목에 할당한다.
    * 예) proxy_set_header X-Real-IP $remote_addr: Request Header의 X-Real-IP에 요청자의 IP를 저장한다.



* 수정이 끝나면 엔진엑스를 재시작 한다.

  > sudo service nginx restart

* 엔진엑스가 스프링 부트 프로젝트를 프록시하는 것을 확인할 수 있다.



#### 10.3 무중단 배포 스크립트 만들기

* 무중단 배포 스크립트 작업 전에 API를 하나 추가한다. 이 API는 이후 배포 시에 8081 을 쓸지, 8082를 쓸 지 판단하는 기준이 된다.



**Profile API 추가**

* ProfileController를 만들어 다음과 같이 간단한 API 코드를 추가한다.

  **src/main/java/com/allsser/book/springboot/web/ProfileController**

  ```ProfileController
  import lombok.RequiredArgsConstructor;
  import org.springframework.core.env.Environment;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RestController;
  
  import java.util.Arrays;
  import java.util.List;
  
  @RequiredArgsConstructor
  @RestController
  public class ProfileController {
      private final Environment env;
  
      @GetMapping("/profile")
      public String profile() {
          List<String> profiles = Arrays.asList(env.getActiveProfiles());					// {1}
          List<String> realProfiles = Arrays.asList("real", "real1", "real2");
          String defaultProfile = profiles.isEmpty()? "default" : "profiles.get(0)";
  
          return profiles.stream()
                  .filter(realProfiles::contains)
                  .findAny()
                  .orElse(defaultProfile);
      }
  }
  ```

  * {1} **env.getActiveProfiles( )**
    * 현재 실행 중인 ActiveProfile을 모두 가져온다.
    * 즉, real, oauth, real-db 등이 활성화되어 있다면(active) 3개가 모두 담겨 있다.
    * 여기서 real, real1, real2는 모두 배포에 사용될 profile이라 이 중 하나라도 있으면 그 값을 반환하도록 한다.
    * 실제로 이번 무중단 배포에서는 real1과 real2만 사용되지만, step2를 다시 사용해 볼 수도 있으니 real도 남겨둔다.



* 이 코드가 잘 작동하는지 테스트 코드를 작성해 본다.

* 해당 컨트롤러는 특별히 **스프링 환경이 필요하지 않는다.** 그래서 **@SpringBootTest** 없이 테스트 코드를 작성한다.

  **src/test/java/com/allser/book/springboot/web/ProfileControllerUnitTest**

  ```ProfileControllerUnitTest
  import org.junit.jupiter.api.Test;
  import org.springframework.mock.env.MockEnvironment;
  
  import static org.assertj.core.api.Assertions.assertThat;
  
  public class ProfileControllerUnitTest {
      
      @Test
      public void real_profile이_조회된다() {
          //given
          String expectedProfile = "real";
          MockEnvironment env = new MockEnvironment();
          env.addActiveProfile(expectedProfile);
          env.addActiveProfile("oauth");
          env.addActiveProfile("real-db");
          
          ProfileController controller = new ProfileController(env);
          
          //when
          String profile = controller.profile();
          
          //then
          assertThat(profile).isEqualTo(expectedProfile);
      }
      
      @Test
      public void active_profile이_없으면_default가_조회된다() {
          //given
          String expectedProfile = "default";
          MockEnvironment env = new MockEnvironment();
          ProfileController controller = new ProfileController(env);
          
          //when
          String profile = controller.profile();
          
          //then
          assertThat(profile).isEqualTo(expectedProfile);
      }
  }
  ```

  * ProfileController나 Environment 모두 **자바 클래스(인터페이스)** 이기 때문에 쉽게 테스트 할 수 있다.
  * Environment는 인터페이스라 가짜 구현 체인 **MockEnvironment(스프링에서 제공)** 를 사용해서 테스트하면 된다.
    * 이렇게 해보면 **생성자 DI가 얼마나 유용한지** 알 수 있다.
    * 만약 Environment를 @Autowired로 DI 받았다면 **이런 테스트 코드를 작성하지 못한다.** 항상 스프링 테스트를 해야 한다.



* **/profile** 이 **인증 없이도 호출될 수 있게** SecurityConfig 클래스에 제외 코드를 추가한다. 

  **~/springboot/config/auth/SecurityConfig**

  ```SecurityConfig
  .antMatchers("/", "/css/**", "/images/**",  "/js/**", "/h2-console/**", "/profile").permitAll()
  ```

  * permitAll 마지막에 "/profile"이 추가된다.



* SecurityConfig 설정이 잘 되었는지 테스트 코드로 검증한다.

* 이 검증은 스프링 시큐리티 설정을 불러와야 하니 **@SpringBootTest** 를 사용하는 테스트 클래스(ProfileControllerTest)를 하나 더 추가한다.

  **src/test/java/com/allser/book/springboot/web/ProfileControllerTest**

  ```ProfileControllerTest
  import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.extension.ExtendWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.boot.test.web.client.TestRestTemplate;
  import org.springframework.boot.web.server.LocalServerPort;
  import org.springframework.http.HttpStatus;
  import org.springframework.http.ResponseEntity;
  import org.springframework.test.context.junit.jupiter.SpringExtension;
  
  import static org.assertj.core.api.Assertions.assertThat;
  
  @ExtendWith(SpringExtension.class)
  @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
  public class ProfileControllerTest {
  
      @LocalServerPort
      private int port;
  
      @Autowired
      private TestRestTemplate restTemplate;
  
      @Test
      public void profile은_인증없이_호출된다() throws Exception {
          String expected = "default";
  
          ResponseEntity<String> response = restTemplate.getForEntity("/profile", String.class);
          assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
          assertThat(response.getBody()).isEqualTo(expected);
      }
  }
  ```



* 모든 테스트가 성공했다면 깃허브로 푸시하여 배포 한다.
* 배포가 끝나면 브라우저에서 /profile로 접속하서 profile이 잘 나오는지 확인한다.
  * 브라우저에 real 이 뜨는것을 확인할 수 있다.



**real1, real2 profile 생성**

* 현재 EC2 환경에서 실행되는 profile은 real 밖에 없다.

* 해당 profile은 **Travis CI 배포 자동화를 위한** profile이니 무중단 배포를 위한 profile 2개(real, real2)를 src/main/resources 아래에 추가한다.

  **src/main/resources/application-real1.properties**

  ```application-real1.properties
  server.port=8081
  spring.profiles.include=oauth,real-db
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
  spring.jpa.properties.hibernate.dialect.storage_engine=innodb
  spring.datasource.hikari.jdbc-url=jdbc:h2:mem:testdb;MODE=MYSQL
  spring.datasource.hikari.username=sa
  
  spring.session.store-type=jdbc
  ```

  **src/main/resources/application-real2.properties**

  ```application-real1.properties
  server.port=8082
  spring.profiles.include=oauth,real-db
  spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
  spring.jpa.properties.hibernate.dialect.storage_engine=innodb
  spring.datasource.hikari.jdbc-url=jdbc:h2:mem:testdb;MODE=MYSQL
  spring.datasource.hikari.username=sa
  
  spring.session.store-type=jdbc
  ```

  * 2개의 profile은 real profile과 크게 다른 점은 없지만, 한 가지가 다르다.
  * Server.port가 8080이 아닌 **8081/8082**로 되어 있다. 이부분만 주의해서 생성하고 생성한 후 깃허브로 푸시한다.



**엔진엑스 설정 수정**

* 무중단 배포의 핵심은 **엔진엑스 설정** 이다.

* 프록시 설정(스프링 부트로 요청을 흘려보내는)이 순식간에 교체된다. 여기서 프록시 설정이 교체될 수 있도록 설정을 추가한다.

* 엔진엑스 설정이 모여있는 **/etc/nginx/conf.d** 에 **service-url.inc** 라는 파일을 하나 생성한다.

  > sudo vim /etc/nginx/conf.d/service-url.inc

* 그리고 다음 코드를 입력한다.

  > set $service_url http://127.0.0.1:8080;

* 해당 파일을 엔진엑스가 사용할 수 있게 설정한다. nginx.conf 파일을 연다.

  > sudo vim /etc/nginx/nginx.conf

  ![service_url추가](images/service_url추가.png)

* 저장하고 종료한 뒤에 재시작한다.

  > sudo service nginx restart

  * **에러?** 현재 엔진엑스 재시작 했을 때 배포한 서비스가 자동으로 꺼진다.



**배포 스크립트들 작성**

* 먼저 step2와 중복되지 않기 위해 EC2에 step3 디렉토리를 생성한다.

  > mkdir ~/app/step3 && mkdir ~/app/step3/zip

* 무중단 배포는 앞으로 step3를 사용한다. 그래서 appspec.yml 역시 step3 로 배포되도록 수정한다.

  **appspec.yml**

  ```appspec
  version: 0.0
  os: linux
  files:
    - source: /
      destination: /home/ec2-user/app/step3/zip/
      overwrite: yes
  ```

* 무중단 배포를 진행할 스크립트들은 총 5개이다
  * **stop.sh** : 기존 엔진엑스에 연결되어 있진 않지만, 실행 중이던 스프링 부트 종료
  * **start.sh** : 배포할 신규 버전 스프링 부트 프로젝트를 stop.sh로 종료한 'profile' 로 실행
  * **health.sh** : 'start.sh' 로 실행시킨 프로젝트가 정상적으로 실행됐는지 체크
  * **switch.sh** : 엔진엑스가 바라보는 스프링 부트를 최신 버전을 변경
  * **profile.sh** : 앞선 4개 스크립트 파일에서 공용으로 사용할 'profile' 과 포트 체크 로직



* appspec.yml에 앞선 스크립트를 사용하도록 설정한다.

  ```appspec
  hooks:
    AfterInstall:
      - location: stop.sh # 엔진엑스와 연결되어 있지 않은 스프링 부트를 종료한다.
        timeout: 60
        runas: ec2-user
        
    ApplicationStart:
      - location: start.sh # 엔진엑스와 연결되어 있지 않은 port로 새 버전의 스프링 부트를 시작한다.
        timeout: 60
        runas: ec2-user
      
    ValidateService:
      - location: health.sh # 새 스프링 부트가 정상적으로 실행됐는지 확인한다.
        timeout: 60
        runras: ec2-user
  ```

  * Jar 파일이 복사된 이후부터 차례로 앞선 스크립트들이 실행된다고 보면 된다.



* 다음은 각 스크립트이다. 이 스크립트들 역시 scripts 디렉토리에 추가한다.

  **~/scripts/profile.sh**

  ```profile.sh
  #!/usr/bin/env bash
  
  # 쉬고 있는 profile 찾기: real1이 사용 중이면 real2가 쉬고 있고, 반대면 real1이 쉬고 있음
  
  function find_idle_profile() {
    RESPONSE_CODE=$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)	# {1}
    if [ ${RESPONSE_CODE} -ge 400 ] # 400 보다 크면(즉, 40x/50x 에러 모두 포함)
    then
      CURRENT_PROFILE=real2
    else
      CURRENT_PROFILE=$(curl -s http://localhost/profile)
    fi 
      
    if [ ${CURRENT_PROFILE} == real1 ]
    then
      IDLE_PROFILE=real2		# {2}
    else
      IDLE_PROFILE=real1
    fi 
      
    echo "${IDLE_PROFILE}"		# {3}
  }
  
  # 쉬고 있는 profile의 port 찾기
  function find_idle_port() {
    IDLE_PROFILE=$(find_idle_profile)
    
    if [ ${IDLE_PROFILE} == real1 ]
    then
      echo "8081"
    else
      echo "8082"
    fi
  }
  ```

  * {1} **$(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)**
    * 현재 엔진엑스가 바라보고 있는 스프링 부트가 정상적으로 수행 중인지 확인한다.
    * 응답값을 HttpStatus로 받는다.
    * 정상이면 200, 오류가 발생한다면 400~503 사이로 발생하니 400 이상은 모두 예외로 보고 real2를 **현재 profile로 사용**한다.
  * {2} **IDLE_PROFILE**
    * 엔진엑스와 연결되지 않은 profile이다.
    * 스프링 부트 프로젝트를 이 profile로 연결하기 위해 반환한다.
  * {3} **echo "${IDLE_PROFILE}"**
    * bash라는 스크립트는 **값을 반환하는 기능이 없다.**
    * 그래서 **제일 마지막 줄에 echo로 결과를 출력** 후, 클라이언트에서 그 값을 잡아서 ($(find_idle_profile)) 사용한다.
    * 중간에 echo를 사용해선 안된다.

  **~/scripts/stop.sh**

  ```stop.sh
  #!/usr/bin/env bash
  
  ABSPATH=$(readlink -f $0)
  ABSDIR=$(dirname $ABSPATH)		# {1}
  source ${ABSDIR}/profile.sh		# {2}
  
  IDLE_PORT=$(find_idle_port)
  
  echo "> $IDLE_PORT 에서 구동 중인 애플리케이션 pid 확인"
  IDLE_PID=$(lsof -ti tcp:${IDLE_PORT})
  
  if [ -z ${IDLE_PORT} ]
  then
    echo "> 현재 구동 중인 애플리케이션이 없으므로 종료하지 않습니다."
  else
    echo "> kill -15 $IDLE_PID"
    kill -15 ${IDLE_PID}
    sleep 5
  fi
  ```

  * {1} **ABSDIR=$(dirname $ABSPATH)**
    * 현재 stop.sh가 속해 있는 경로를 찾는다.
    * 하단의 코드와 같이 profile.sh의 결로를 찾기 위해 사용된다.
  * {2} **source ${ABSDIR}/profile.sh**
    * 자바로 보면 일종의 import 구문이다.
    * 해당 코드로 인해 stop.sh에서도 profile.sh의 여러 function을 사용할 수 있게 된다.

  **~/scripts/start.sh**

  ```start.sh
  #!/usr/bin/env bash
  
  ABSPATH=$(readlink -f $0)
  ABSDIR=$(dirname $ABSPATH)
  source ${ABSDIR}/profile.sh
  
  REPOSITORY=/home/ec2-user/app/step3
  PROJECT_NAME=SpringBoot
  
  echo "> Build 파일 복사"
  echo "> cp $REPOSITORY/zip/*.jar $REPOSITORY/"
  
  cp $REPOSITORY/zip/*.jar $REPOSITORY/
  
  echo "> 새 애플리케이션 배포"
  JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
  
  echo "> $JAR_NAME: $JAR_NAME"
  
  echo "> $JAR_NAME 에 실행권한 추가"
  
  chmod +x $JAR_NAME
  
  echo "> $JAR_NAME 실행"
  
  IDLE_PROFILE=$(find_idle_profile)
  
  echo "> $JAR_NAME 를 profile=$IDLE_PROFILE 로 실행한다."
  nohup java -jar \
      -Dspring.config.location=classpath:/application.properties,classpath:/application-$IDLE_PROFILE.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
      -Dspring.profiles.active=$IDLE_PROFILE \
      $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &
  ```

  * **기본적인 스크립트는 step2의 deploy.sh와 유사하다.**
  * **다른 점이라면 IDLE_PROFILE을 통해 properties 파일을 가져오고(application-$IDLE_PROFILE.properties), active profile을 지정하는 것(-Dspring.profiles.active=$IDLE_PROFILE)뿐이다.**
  * **여기서도 IDLE_PROFILE을 사용하니 profile.sh을 가져와야 한다.**

  **~/scripts/health.sh**

  ```health.sh
  #!/usr/bin/env bash
  
  ABSPATH=$(readlink -f $0)
  ABSDIR=$(dirname $ABSPATH)
  source ${ABSDIR}/profile.sh
  source ${ABSDIR}/switch.sh
  
  IDLE_PORT=$(find_idle_port)
  
  echo "> Health Check Start!"
  echo "> IDLE_PORT: $IDLE_PORT"
  echo "> curl -s http://localhost:$IDLE_PORT/profile"
  sleep 10
  
  for RETRY_COUNT in {1..10}
  do
    RESPONSE=$(curl -s http://localhost:${IDLE_PORT}/profile)
    UP_COUNT=$(echo ${RESPONSE} | grep 'real' | wc -l)
  
    if [ ${UP_COUNT} -ge 1 ]
    then # $up_count >= 1 ("real" 문자열이 있는지 검증)
      echo "> Health check 성공"
      switch_proxy
      break
    else
      echo "> Health check의 응답을 알 수 없거나 혹은 실행 상태가 아니다."
      echo "> Health check: ${RESPONSE}"
    fi
  
    if [ ${RETRY_COUNT} -eq 10 ]
    then
      echo "> Health check 실패."
      echo "> 엔진엑스에 연결하지 않고 배포를 종료한다."
      exit 1
  fi
  
    echo "> Health check 연결 실패. 재시도..."
    sleep 10
done
  ```

  * **엔진엑스와 연결되지 않은 포트로 스프링 부트가 잘 수행되었는지 체크한다.**
  * **잘 떴는지 확인되어야 엔진엑스 프록시 설정을 변경(switch_proxy)한다.**
  * **엔진엑스 프록시 설정 변경은 switch.sh에서 수행한다.**
  
  **~/scripts/switch.sh**
  
  ```switch.sh
  #!/usr/bin/env bash
  
  ABSPATH=$(readlink -f $0)
  ABSDIR=$(dirname $ABSPATH)
  source ${ABSDIR}/profile.sh
  
  function switch_proxy() {
      IDLE_PORT=$(find_idle_port)
      
      echo "> 전환일 Port: $IDLE_PORT"
    echo "> Port 전환"
      echo "Set \$service_url http://127.0.0.1:{IDLE_PORT};" | sudo tee /etc/nginx/conf.d/service-url.inc
      echo "> 엔진엑스 Reload"
      sudo service nginx reload
  }
  ```
  
  * **echo "set \ $service_url http://127.0.0.1:${IDLE_PROT};"**
    * 하나의 문장을 만들어 파이프라인( | )으로 넘겨주기 위해 echo를 사용한다.
    * 엔진엑스가 변경할 프록시 주소를 생성한다.
    * 쌍따옴표( " )를 사용해야 한다.
    * 사용하지 않으면 $service_url을 그대로 인식하지 못하고 변수를 찾게 된다.
  * **|sudo tee/etc/nginx/conf.d/service-url.inc**
    * 앞에서 넘겨준 문장을 service-url.inc에 덮어쓴다.
  * **sudo service nginx reload**
    * 엔진엑스 설정을 다시 불러온다.
    * restart와는 다르다.
    * restart는 잠시 끊기는 현상이 있지만, reload는 끊김 없이 다시 불러온다.
    * 다만, 중요한 설정들은 반영되지 않으므로 restart를 사용해야 한다.
    * 여기선 외부의 설정 파일인 service-url을 다시 불러오는 거라 reload로 가능하다.



#### 10.4 무중단 배포 테스트

* 잦은 배포로 Jar 파일명이 겹칠 수 있다. 

* 매번 자동으로 버전값을 변경될 수 있도록 조치한다.

  **build.gradle**

  ```build.gradle
  version '1.0.1-SNAPSHOT-'+new Date().format("yyyMMddHHmmss")
  ```

  * **build.gradle을 Groovy 기반의 빌드툴이다.**
  * **당연히 Groovy 언어의 여러 문법을 사용할 수 있는데, 여기서는 new Date( )로 빌드 할 때마다 그 시간이 버전에 추가되도록 구성한다.**



* 깃허브로  푸시한다. 배포가 자동으로 진행되면 CodeDeploy 로그로 잘 진행되는지 확인해 본다.

  > tail -f /opt/codedeploy-agent/deployment-root/deployment-logs/codedeploy-agent-deployments.log
  
  * 정상적으로 배포가 되었다면 실행 과정의 로그나 나온다.
  
* 스프링 부트 로그도 보고 싶다면 다음 명령어로 확인할 수 있다.

  > vim ~/app/step3/nohup.out

  * 스프링 부트 실행 로그를 직접 볼 수 있다.

* 한 번 더 배포하면 그때는 **step2**로 배포된다. 이 과정에서 브라우저 새로고침을 해보면 전혀 중단 없는 것을 확인할 수 있다.

* 2번 배포를 진행한 뒤에 다음과 같이 자바 애플리케이션 실행 여부를 확인한다.

  > ps -ef | grep java

  * 다음과 같이 2개의 애플리케이션이 실행되고 있음을 알 수 있다.

  ![실행여부](images/실행여부.png)



* 이제 이 시스템은 마스터 브랜치에 푸시가 발생하면 자동으로 서버 배포가 진행되고, 서버 중단 역시 전혀 없는 시스템이 되었다.
