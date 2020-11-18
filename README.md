# Bookcrossing

## How to install with Docker and Intellij Ultimate
1. Download repo
2. Run `docker-compose up` in it
3. Run Configuration BookcrossingApplication (you need Java 14, which you can download by Intellij)
4. Ready. Thing is accessible at localhost:8080.

## How to install only with Docker
1. Download repo and uncomment part about Spring in `docker-compose.yml`
2. `./mvnw clean install`
3. `docker-compose up --build`
4. Ready. Thing is accessible at localhost:8080.
In this case, stopping and starting containers again results in reseting database content.
