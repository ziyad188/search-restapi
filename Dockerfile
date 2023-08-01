FROM eclipse-temurin:17

LABEL mentainer="mohdziyadk@gmail.com"

WORKDIR /app

COPY target/springboot-search-restapi-0.0.1-SNAPSHOT.jar /app/springboot-search-webservices.jar

ENTRYPOINT ["java", "-jar", "springboot-search-webservices.jar"]