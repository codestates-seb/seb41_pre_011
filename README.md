# 코드스테이츠 SEB 41기 1석11조

### <img width="15px" src="https://cdn-icons-png.flaticon.com/512/4471/4471714.png"> Getting Started

<details markdown="1">
<summary><strong>Client</strong></summary>

<h4 style="color:#5ad7b7"><strong>npm install</strong></h4>
<p>개발에 필요한 패키지들을 설치합니다.</p>

<h4 style="color:#5ad7b7"><strong>npm run start</strong></h4>
<p>개발 모드로 앱을 실행합니다.
브라우저에서 http://localhost:3000으로 실행됩니다.</p>

<h4 style="color:#5ad7b7"><strong>npm run build</strong></h4>
<p>작업 완료 후 배포를 위한 build폴더가 생성됩니다.</p>
</details>

<details markdown="1">
<summary><strong>Server</strong></summary>
<h4 style="color:#cc6cab"><strong>EC2 서버를 사용하여 서버 배포하기</strong></h4>
<ol>
    <li>EC2 서버 접속 후 bash 쉘로 이동 : bash 입력, 다음 cd ~ 입력</li>
    <li>프로젝트 파일 클론 받아오기 : git clone <주소></li>
    <li>서버 디렉토리로 이동 : cd <폴더명>/server</li>
    <li>빌드 작업 : ./gradlew build</li>
    <li>빌드 완료 후 빌드 파일로 디렉토리 이동 : cd build/libs</li>
    <li>무중단 실행하기 : nohup java -jar seb41_pre_011-0.0.1-SNAPSHOT.jar &</li>
</ol>
</details>

<hr/>

### <img width="15px" src="https://cdn-icons-png.flaticon.com/512/3214/3214679.png"> App url

http://seb41-pre-011.s3-website.ap-northeast-2.amazonaws.com/

<hr/>

### <img width="15px" src="https://cdn-icons-png.flaticon.com/512/476/476863.png"> Team

|                                                                                                                                                                                                                                                                                                    [👑김경배](https://github.com/codemodel6)                                                                                                                                                                                                                                                                                                    |                                                                                                                                                                                                                                                                                                                                    [김은수](https://github.com/noah-eunsoo)                                                                                                                                                                                                                                                                                                                                     |                                                                                                                                                                                                                                              [김철현](https://github.com/lisia004)                                                                                                                                                                                                                                              |                                                                                                                                                                                                                                             [옥건](https://github.com/TheWildSwan)                                                                                                                                                                                                                                              |                                                                                                                                                                                                                                                          [한규현](https://github.com/Gyuddi)                                                                                                                                                                                                                                                          |
| :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|                                                                                                                                                                                                                                                                                                                      FE                                                                                                                                                                                                                                                                                                                       |                                                                                                                                                                                                                                                                                                                                                       FE                                                                                                                                                                                                                                                                                                                                                        |                                                                                                                                                                                                                                                               BE                                                                                                                                                                                                                                                                |                                                                                                                                                                                                                                                               BE                                                                                                                                                                                                                                                                |                                                                                                                                                                                                                                                                          BE                                                                                                                                                                                                                                                                           |
| <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/917c2b7e-23d6-412e-ac13-668aed51ad68/%EA%B9%80%EA%B2%BD%EB%B0%B0_%EC%85%80%EC%B9%B4.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221219%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221219T080811Z&X-Amz-Expires=86400&X-Amz-Signature=49f60529d1218cd35cfea44013180e70c4076d15c5f9bff3c83973ccc451de99&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EA%25B9%2580%25EA%25B2%25BD%25EB%25B0%25B0%2520%25EC%2585%2580%25EC%25B9%25B4.jpg%22&x-id=GetObject" width=100> | <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/b0d2e2bd-8810-4828-a34a-0357ff86a8cb/%E1%84%80%E1%85%B5%E1%86%B7%E1%84%8B%E1%85%B3%E1%86%AB%E1%84%89%E1%85%AE.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221219%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221219T080832Z&X-Amz-Expires=86400&X-Amz-Signature=479a5307bc81edb1e2034f3ff96da2ffcefb677b4faede948d6903779f6c05eb&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25E1%2584%2580%25E1%2585%25B5%25E1%2586%25B7%25E1%2584%258B%25E1%2585%25B3%25E1%2586%25AB%25E1%2584%2589%25E1%2585%25AE.png%22&x-id=GetObject" width=100> | <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/fae17faf-47fb-4f2a-9ce1-6b64175e548f/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221219%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221219T080853Z&X-Amz-Expires=86400&X-Amz-Signature=cc7295706d0a379da111aba2d33e4f94ca7acfbe2fca14e2370852a9ad56d59b&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22Untitled.png%22&x-id=GetObject" width=100> | <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/4b057695-614d-4062-af18-d27bab9a4035/IMG_5239.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230102%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230102T140737Z&X-Amz-Expires=86400&X-Amz-Signature=3fed02e51a566a9a8a14af8f9365ec8b72a59000aa9061c6c33fcd0e2d97b4ff&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22IMG_5239.jpg%22&x-id=GetObject" width=100> | <img src="https://s3.us-west-2.amazonaws.com/secure.notion-static.com/64aa0b85-124b-4cc2-8ba4-bc94cb38b760/캡처.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20221219%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20221219T080922Z&X-Amz-Expires=86400&X-Amz-Signature=825550268a32baf4f991ae6af2a4445025fc319297a35acf318b313d1bb5d7e2&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22%25EC%25BA%25A1%25EC%25B2%2598.PNG.png%22&x-id=GetObject" width=100> |

---

<h3 align='center'>📚 STACKS</h3>
<h4 align='center'>Common</h4>

<div align='center'>
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"> 
</div>

<h4 align='center'>Client</h4>
<div align='center'> 
  <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=white"> 
  <img src="https://img.shields.io/badge/redux-764ABC?style=for-the-badge&logo=redux&logoColor=white">
  <img src="https://img.shields.io/badge/styled-components-DB7093?style=for-the-badge&logo=styled-components&logoColor=white"> 
  <br>
  <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
  <img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white"> 
  <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  <img src="https://img.shields.io/badge/axios-5A29E4?style=for-the-badge&logo=axios&logoColor=white">
   <img src="https://img.shields.io/badge/eslint-4B32C3?style=for-the-badge&logo=eslint&logoColor=white">
</div>

<h4 align='center'>Back</h4>

<div align='center'>
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=Spring%20Boot&logoColor=white"> 
  <img src="https://img.shields.io/badge/Spring%20Security-6DB33F?style=for-the-badge&logo=Spring%20Security&logoColor=white"> 
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/apache tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=white">
</div>

<hr/>

### <img width="15px" src="https://cdn-icons-png.flaticon.com/512/888/888034.png"> Documents

#### 요구사항 정의서

https://docs.google.com/spreadsheets/d/1evjuNT9ahCoCgXXqyenYofUyK6BY8_sRsaJAfbgqlQo/edit#gid=1161341563

#### E-R diagram

<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059483159105896498/92250a07ff872706.jpg"/>

#### Pages

##### 홈

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491374086488106/111.png"/>
</p>

##### 회원가입

<small>
이메일 : 다른 유저와 중복될 수 없습니다.<br>
비밀번호 : 10글자 이상, 영어 대문자, 소문자, 숫자, 특수 문자를 각 1개 이상씩 포함하여야 합니다.
</small>
<br>
<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491406827241573/222.png"/>
</p>

##### 로그인

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491461760041071/2.png"/>
</p>

##### 마이페이지

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491515090600036/3.png"/>
</p>

##### 질문 리스트

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491584388903023/4.png"/>
</p>

##### 질문 상세, 답변 작성

<small>
제목 : 제목은 공백일 수 없습니다.<br/>
내용 : 내용은 공백일 수 없습니다.<br/>
태그 : 태그는 입력하지 않아도 글을 쓸 수 있습니다.
댓글 : 댓글은 공백일 수 없습니다.
</small>
<br>
<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491717675483226/7.png"/>
</p>

##### 질문 수정

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491835980034109/6.png"/>
</p>

##### 답변 수정

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491890677956608/8.png"/>
</p>

##### 태그

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059491949565980814/9.png"/>
</p>

##### 유저

<p>
<img src="https://cdn.discordapp.com/attachments/1052811868462399490/1059492356652540025/image.png"/>
</p>

<hr/>

### <img width="15px" src="https://cdn-icons-png.flaticon.com/512/3281/3281313.png"> git & github guide

<details markdown="1">
<summary><strong>branch</strong></summary>
<ul>
  <li>
    strategy
    <ul>
      <li>main브랜치에서 dev브랜치를 생성합니다. dev브랜치에서 feat브랜치를 생성 후 작업합니다.</li>
      <li>작업이 완료된 feat브랜치들은 dev브랜치에만 merge할 수 있습니다.</li>
      <li>배포 전 개발 완료된 dev브랜치를 main브랜치에 merge후 main브랜치를 배포합니다.</li>
    </ul>
  </li>
  <li>
    branch types
    <ul>
      <li>main : 배포 브랜치</li>
      <li>dev : 개발 브랜치</li>
      <li>feat/branchname : 기능 브랜치</li>
      <li>hotfix : 오류 또는 긴급 수정 브랜치</li>
    </ul>
  </li>
  <li>
    feat브랜치 name style
    <ul>
      <li>
        basic : 기능별로 브랜치를 생성하고, 1개의 브랜치는 1명의 사용자가 담당합니다.
        <pre>
feat/개발영역/기능명
feat/front/login
feat/back/login</pre>
      </li>
      <li>
        sub : 예외상황으로 1개의 브랜치에서 여러명이 작업할 경우 sub브랜치 생성 후 작업합니다.
        <pre>
feat/개발영역/기능명_sub_세부기능
feat/front/login_sub_sns
feat/back/login_sub_sns</pre>
       </li>
    </ul>
  </li>
</ul>
</details>

<details markdown="1">
<summary><strong>commit</strong></summary>
<ul>
  <li>
    structure
    <pre>
타입 - #이슈번호 : 제목
(공백줄)
상세 설명</pre>
  </li>
  <li>
    type
    <ul>
      <li>feat: A new feature</li>
      <li>fix: A bug fix</li>
      <li>docs: Changes to documentation</li>
      <li>style: Formatting, missing semi colons, etc; no code change</li>
      <li>refactor: Refactoring production code</li>
      <li>test: Adding tests, refactoring test; no production code change</li>
      <li>chore: Updating build tasks, package manager configs, etc; no production code change</li>
    </ul>
  </li>
  <li>
    example
    <pre>
feat - #1 : 로그인 html,css 완료
<br/>
공통 인풋 텍스트, 버튼 컴포넌트 적용</pre>
  </li>
</ul>
</details>
    
<details markdown="1">
<summary><strong>merge</strong></summary>
<ul>
  <li>github pull request를 사용해 merge합니다.</li>
  <li>front개발은 최소 front 1명을 리뷰어로, back개발은 최소 back 1명을 리뷰어로 pull request 합니다.</li>
  <li>front, back 같이 진행하는 개발은 최소 front,back 각 1명을 리뷰어로 pull request 합니다.</li>
</ul>
</details>
