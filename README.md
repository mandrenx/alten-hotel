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
### COMMONS
It was been implemented interfaces to simplify some common operations
### MODULES
For communication between 4 modules RESTEasy Reactive and RestClient were used
### guest
- Save or update guest data
- It's possible retrieve them for e-mail or phone number or full name
### bedroom
- When initialize the project some bedrooms are added
- It's possible change the status bedroom between AVAILABLE and UNAVAILABLE
### booking
- Allow search about available bedrooms between two different dates
- To save a reservation it's necessary to make a survey on the available rooms and have the guest and room data
### integration
- Make a link between the another modules
- When has been necessary save 


