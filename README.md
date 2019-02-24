# spring-boot-app

#### Environment:
java --version
java 11.0.2 2019-01-15 LTS

#### mvn --version
Apache Maven 3.6.0


### To run:
- mvn clean install (all 9 tests should be passing)
- mvn spring-boot:run

#### Database info
H2 in-memory db  console - http://localhost:8080/h2-console  
jdbc url - jdbc:h2:mem:testdb  

#### Sample endpoints
- http://localhost:8080/users/10001/accounts
- http://localhost:8080/users/10002/accounts
- http://localhost:8080/accounts/20001/transactions
- http://localhost:8080/accounts/20002/transactions
- http://localhost:8080/accounts/20003/transactions
