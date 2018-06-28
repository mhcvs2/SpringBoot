FROM registry.bst-1.cns.bstjpc.com:5000/openjdk:8

COPY . workdir/

WORKDIR workdir

RUN GRADLE_USER_HOME=cache ./gradlew build

CMD ["java", "-jar", "build/libs/gradle_springBoot-1.0-SNAPSHOT.jar"]
