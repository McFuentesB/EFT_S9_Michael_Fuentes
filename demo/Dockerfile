FROM openjdk:22-jdk-slim


WORKDIR /app
COPY target/*.jar app.jar
COPY Wallet_YGLIGTTFH1ZHPFWA /app/oracle_wallet
EXPOSE 8080

CMD [ "java", "-jar", "app.jar" ]