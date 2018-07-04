FROM registry.bst-1.cns.bstjpc.com:5000/java:8

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
