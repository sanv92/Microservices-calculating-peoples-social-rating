FROM adoptopenjdk/openjdk12:jdk-12.0.2_10

RUN mkdir /srv/application
COPY ./socialratingcalculator/target/socialratingcalculator-1.0.jar /srv/application/socialratingcalculator-1.0.jar

CMD ["java", "-jar", "-Dspring.profiles.active=production", "/srv/application/socialratingcalculator-1.0.jar"]
