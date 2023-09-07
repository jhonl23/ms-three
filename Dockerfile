FROM openjdk
ADD ./target/ms-three-0.0.1-SNAPSHOT.jar msthree.jar
ENTRYPOINT ["java", "-jar", "msthree.jar"]