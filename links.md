# Spring boot app

### References

### Security
* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.1/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.1/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.1/reference/htmlsingle/#boot-features-jpa-and-spring-data)

***
* [Common application Security properties](https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#security-properties)
* [InMemory Auth](https://www.techiedelight.com/form-based-authentication-in-spring-boot-security/)
* [Java API Examples](https://www.programcreek.com/java-api-examples/)
* [Authentication: @Override vs @Autowired](https://stackoverflow.com/questions/42316643/548473)
* [DelegatingPasswordEncoder](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#authentication-password-storage-dpe)
* [@AuthenticationPrincipal](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#mvc-authentication-principal)

***
* [Authentication with a DB UserDetailsService](https://www.baeldung.com/spring-security-authentication-with-a-database)
* [Authentication with a UserDetailsService](https://www.codeflow.site/ru/article/spring-security-authentication-with-a-database)
* [Spring Security key services](https://ru.wikibooks.org/wiki/Spring_Security/%D0%9A%D0%BB%D1%8E%D1%87%D0%B5%D0%B2%D1%8B%D0%B5_%D1%81%D0%B5%D1%80%D0%B2%D0%B8%D1%81%D1%8B_Spring_Security)
* [Java Based Configuration](https://www.tutorialspoint.com/spring/spring_java_based_configuration.htm)

*** 
* [Security Form Login](https://www.baeldung.com/spring-security-login)
* [Spring Security Expressions](https://www.baeldung.com/spring-security-expressions)
* [Role and GrantedAuthority](https://stackoverflow.com/a/19542316/548473)

***
* [Basic access authentication](https://en.wikipedia.org/wiki/Basic_access_authentication)
* [Decode and Encode Base64](https://decodebase64.com/)
* [Написание HTTP-запросов с помощью Curl (для Windows можно использовать Git Bash)](http://rus-linux.net/lib.php?name=/MyLDP/internet/curlrus.html)
* [Password encoding with Spring Data REST](https://stackoverflow.com/questions/30260582/548473)
* [Access.WRITE_ONLY](https://stackoverflow.com/a/12505165/548473)


* GET http://localhost:8080/api/account
* GET http://localhost:8080/api/users
* curl -s http://localhost:8080/api/account --user user@gmail.com:password
```POST http://localhost:8080/api/users
Content-Type: application/json
Authorization: Basic admin@gmail.com admin

{
"email": "test@test.com",
"firstName": "Test",
"lastName": "Test",
"password": "test",
"roles": [ "USER","ADMIN"]
}
```

### REST. AccountController

* [Understanding REST](http://spring-projects.ru/understanding/rest/)
* [10 Best Practices for Better RESTful API](https://medium.com/@mwaysolutions/10-best-practices-for-better-restful-api-cbe81b06f291)
* [15 тривиальных фактов о правильной работе с протоколом HTTP](https://habr.com/ru/company/yandex/blog/265569/)

```aidl
PUT http://localhost:8080/api/account
Content-Type: application/json
Authorization: Basic user@gmail.com pass

{
  "email": "user@gmail.com",
  "firstName": "New_First",
  "lastName": "New_Last"
}
###

GET http://localhost:8080/api/account
Authorization: Basic user@gmail.com pass
###

POST http://localhost:8080/api/account/register
Content-Type: application/json

{
  "email": "test@test.com",
  "firstName": "Test",
  "lastName": "Test",
  "password": "test"
}
###

GET http://localhost:8080/api/account
Authorization: Basic test@test.com test
```

