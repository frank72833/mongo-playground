FROM adoptopenjdk:11-jre-hotspot
ENV SPRING_PROFILES_ACTIVE=local

EXPOSE 8080

COPY target/*.jar /opt/
CMD $JAVA_HOME/bin/java $JAVA_OPTS -jar /opt/*.jar
