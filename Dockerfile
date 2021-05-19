FROM adoptopenjdk/openjdk11:alpine-jre
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]


# FROM openjdk:11
# RUN groupadd -S spring 
# RUN useradd -S spring -G spring
# USER spring:spring
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# EXPOSE 8080
# ENTRYPOINT ["java","-jar","/app.jar"]