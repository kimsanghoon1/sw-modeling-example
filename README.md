# sw-modeling-example

## Build and run
### Backend server (Runs on 8080)
```
mvn spring-boot:run
```

### Front-end server (Runs on 8081 or any other port)
```
cd src/main/resources/static
npm install
npm run dev
```

### Go to http://localhost:8081/alltabs.html

### To mashup components, go to http://rawgit.com/TheOpenCloudEngine/metaworks4/master/src/main/resources/static/mashup/test.html

and drag form or grid component to the canvas, and enter the name of class - com.autoinsurance.Customer

## Documentation
https://github.com/TheOpenCloudEngine/micro-service-architecture-vuejs/wiki
https://www.slideshare.net/pongsor/building-multi-tenancy-enterprise-applications


## Frequenctly Asked Questions

### intelli-j
- 붉은색 오류:  Setup SDK 상단 메뉴 클릭해서 jdk1.8잡아줌

- maven import Changes -> yes
- maven menu toolbar --> reimport 버튼

### server configuration / setting
- pom.xml
- WebConfig.java 를 다시 받아 수정.

- 8080 충돌시 -> services.msc 실행 > 오라클 에이젠트 중지
### maven 
- Class Not Found -> .m2/repository all delete
- Repository Not Found -> remove the .m2/setting.xml
