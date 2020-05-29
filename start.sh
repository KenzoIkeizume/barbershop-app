./mvnw clean package
./mvnw build
./mvnw package
java -Dserver.port=$PORT -jar target/barbershop-0.0.1-SNAPSHOT.jar
