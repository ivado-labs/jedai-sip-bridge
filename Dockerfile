FROM maven:3.9.5-eclipse-temurin-11-alpine as builder
COPY ./src app/src
COPY ./pom.xml app/pom.xml
WORKDIR app
RUN mvn clean package
RUN java -Djarmode=layertools -jar target/sip-bridge.jar extract --destination target/extracted

FROM eclipse-temurin:11-jre
WORKDIR app
COPY --from=builder app/target/extracted/dependencies/ ./
COPY --from=builder app/target/extracted/spring-boot-loader/ ./
COPY --from=builder app/target/extracted/snapshot-dependencies/ ./
COPY --from=builder app/target/extracted/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]