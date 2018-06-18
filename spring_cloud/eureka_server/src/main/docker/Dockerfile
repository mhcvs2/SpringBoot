FROM registry.bst-1.cns.bstjpc.com:5000/frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
ADD eureka_server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]