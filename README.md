Spring boot - cucumber - demo
-------
This demo is about putting in place a cucumber scenario in a Spring boot environment with different technologies.


Objective
--
Create a reference implementation which provides the best practices of running integration & component tests in a SpringBoot application.

Technologies
--
Spring Boot Test - Provides the spring boot ecosystem required for the tests.<br>
Cucumber 6.8.0 <br>
TestNg 7.1.0<br>
Java 1.8 <br>
Maven 4.0
H2 for in memory DB

Paths
--
**addresse.feature** : ``src/test/resources/features/adresse.feature`` <br>
**java class representing the models** : ``src/main/java/com/example/demo/model`` <br>
**java class representing the repository** : ``src/main/java/com/example/demo/repositories`` <br>
**java step definitions** : ``src/test/java/com/example/demo/stepDefinition`` <br>
**cucumber runner** : ``src/test/``

Running tests
---
1. Open terminal in the project repo, then execute ``mvn clean install``
2. After running the application, the result is generated in : ``target/site/serenity/index.html``

Struggles
---
not being able to put in place movement changement as described in the specification.

Wire mock implementation
---
wire mock server implementation is being in comment.
check stepDefinition.java file and CucumberRunner.java