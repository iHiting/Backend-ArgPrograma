
FROM amazoncorretto:8-alpine-jdk

MAINTAINER gaston
COPY target/Portafolio-0.0.1-SNAPSHOT.jar argprogramagas.jar
ENTRYPOINT ["java", "-jar", "/argprogramagas.jar"] 