FROM gradle:jdk17 as builder
ADD --chown=gradle . /app
WORKDIR /app
RUN gradle build -x test
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar .
EXPOSE 8080
ENTRYPOINT exec java -jar /app/*.jar