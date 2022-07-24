# alten-hotel Project

This project uses Quarkus, the Supersonic Subatomic Java Framework: https://quarkus.io/ .

## Stacks
- Java 17
- Quarkus 2.10.3.Final
- Maven 3.8.5
- MapStruct
- RESTEasy Reactive
- Hibernate Panache
- Docker | Docker Compose
- RestClient
- Postgres
- Swagger

## For project running
Inside root folder from project:
- docker-compose -f resources/compose.yaml up -d
- mvn compile quarkus:dev

## Components
There is two main packages in the project: commons and modules (guest, bedroom, booking and integration)
### commons
It was been implemented interfaces to simplify some common operations
### modules
For communication between 4 modules RESTEasy Reactive and RestClient were used
### guest
- Save or update guest data
- It's possible retrieve them for e-mail, phone number or full name
### bedroom

### booking

### integration



