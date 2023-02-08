FROM eclipse-temurin:17-jre-alpine

EXPOSE 8080

COPY ./build/libs/Main.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "Main.jar"]