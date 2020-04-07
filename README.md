# Microservices for calculating people's social rating

## Installation
### Clone Repository
```
git clone https://github.com/SanderV1992/microservices-calculating-peoples-social-rating.git
```

### Project build
```
mvn clean install
mvn clean install -DskipTests
```

### Project start (Maven)
```
mvn --projects datacollector spring-boot:run
mvn --projects socialratingcalculator spring-boot:run
mvn --projects datacollector spring-boot:run -Drun.jvmArguments='-Dserver.port=8080'
mvn --projects socialratingcalculator spring-boot:run -Drun.jvmArguments='-Dserver.port=8090'
```

### Project start (Jar files)
```
java -jar ./datacollector/target/datacollector-1.0.jar --spring.config.location=classpath:/application.properties,classpath:/kafka.properties,classpath:/social.properties --social.base-score-rating=100
java -jar ./socialratingcalculator/target/socialratingcalculator-1.0.jar
```

### Project start (Docker Compose)
```
docker-compose -f ./docker/docker-compose-production.yml up
```

---

# Redis
redis-cli -h localhost -p 6379 -n 0 keys *

---

## Api Documentation
| resource                                            | description                                    |
|:----------------------------------------------------|:-----------------------------------------------|
| `http://localhost:8080/api/users/message`           | send message via broker messenger
| `http://localhost:8090/api/users/FirstName`         | return user
