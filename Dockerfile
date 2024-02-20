FROM alpine:3.18.3
RUN apk add --no-cache openjdk17
RUN apk add --no-cache tzdata
COPY build/libs/lesson04-1.0.c39299f.jar /app/
COPY gradle.properties /app/gradle.properties
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "/app/lesson04-1.0.c39299f.jar"]
