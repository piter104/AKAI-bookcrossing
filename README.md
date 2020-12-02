# Bookcrossing

## How to install with Docker and Intellij Ultimate
1. Download repo
2. Copy file `application.properties.example` and rename it with name `application.properties`
3. Fill the file `application.properties`
4. `docker-compose up` - to set up database
5. Run Configuration BookcrossingApplication (you need Java 11, which you can download by Intellij)
6. Ready. Thing is accessible at localhost:8080.

## How to install only with Docker
1. Download repo and uncomment part about Spring in `docker-compose.yml`
2. Copy file `application.properties.example` and rename it with name `application.properties`
3. Fill the file `application.properties`
4. `docker-compose up` - to set up database
5. `mvn clean install` - if you have installed Maven
6. `mvn spring-boot:run` - if you have installed Maven
7. Ready. Thing is accessible at localhost:8080.

If you don't have installed Maven instead of `mvn` use:
   - `./mvnw` - on Linux
   - `./mvnw.cmd` - on Windows
