# sip-bridge
Sip Bridge is a mock service developed to serve mock endpoints to students during the development of the sip dashboard. After running the application a swagger page is available at the root of the domain `(example: http:localhost:8080)`. The rest api is available at `/sip-bridge (example: http:localhost:8080/sip-bridge)`.

## Requirements

For building and running the application you need:

- [JDK 11](https://adoptium.net/)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run this application on your local machine. One way is to execute the `main` method in the `org.chusj.crhsj.sip_bridge.SipBridge` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
The application will automatically initialize the database with initial data contained in the Excel files within `src/main/resources/db/excel_files`.


## Deploying the application with docker compose

The easiest way to deploy this application is with docker compose.

```shell
docker compose up
```
You can also supply environment variables to the docker compose command.

## Deploying the application with docker 

This application expect a mysql database to be available prior to running the application

```shell
docker build -t example/sip-bridge:0.0.1 .
docker run --name sip-bridge --rm -e PORT=7070 -e SIP_DATASOURCE_URL="jdbc:mysql://localhost:3306/sip_bridge?serverTimezone=Canada/Eastern&createDatabaseIfNotExist=true" -e SIP_DATASOURCE_USERNAME=username -e SIP_DATASOURCE_PASSWORD=password -p 7070:7070 example/sip-bridge:0.0.1
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/codecentric/springboot-sample-app/blob/master/LICENSE) file.