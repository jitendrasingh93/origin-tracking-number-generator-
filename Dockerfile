FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY target/tracking-number-generator.jar /app/traking-number-generator.jar
ENTRYPOINT ["java","-jar","/traking-number-generator.jar"]

