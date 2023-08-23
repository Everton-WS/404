
#comando para criar docker
docker buildx build --platform linux/amd64,linux/arm64 -t app_java .


#comando para buildar a aplicação
mvn clean build


#comando para rodar local
JAVA_DB_HOST=XXXX \
JAVA_DB_PORT=3306 \
JAVA_DB_USER=XXXX \
JAVA_DB_PASS=XXXX \
JAVA_DB_SCHEMA=sistema \
mvn spring-boot:run