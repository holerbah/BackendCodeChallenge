# BackendCodeChallenge

# Podesavanje baze
Baza: MySQL
Kreiranje baze: 
CREATE DATABASE virtual_power_plant;

U src/main/resources/application.properties podesiti:
spring.datasource.url=jdbc:mysql://localhost:3306/virtual_power_plant?useSSL=false&serverTimezone=UTC
spring.datasource.username=tvoj_korisnik
spring.datasource.password=tvoja_lozinka
spring.jpa.hibernate.ddl-auto=update


# Pokretanje aplikacije
mvn clean spring-boot:run

(Opcionalno) Override podešavanje sortiranja baterija pri pokretanju:

mvn spring-boot:run -Dspring-boot.run.arguments="--batteries.sort-order=desc"

mvn spring-boot:run "-Dspring-boot.run.arguments=--batteries.sort-order=desc"


# API Endpoints

Dodavanje baterija (POST)
URL: http://localhost:8080/api/batteries

Metod: POST

Header: Content-Type: application/json

Body primer (Postman):
[
  {
    "name": "Baterija A",
    "postcode": 11000,
    "wattCapacity": 1500.0
  },
  {
    "name": "Baterija B",
    "postcode": 11010,
    "wattCapacity": 750.5
  }
]


Dobijanje baterija u opsegu poštanskih brojeva (GET)
URL primer:
http://localhost:8080/api/batteries?fromPostcode=11000&toPostcode=11020



# Dokumentacija (Swagger UI)

URL: http://localhost:8080/swagger-ui.html