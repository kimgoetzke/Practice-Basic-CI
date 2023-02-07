FROM eclipse-temurin:17-jre-alpine

EXPOSE 8080

COPY ./build/libs/Main-0.1.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "Main-0.1.jar"]