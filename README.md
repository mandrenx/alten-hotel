# alten-hotel Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Stacks
- Java 17
- Quarkus 2.10.3.Final
- Maven 3.8.5
- MapStruct
- RESTEasy Reactive
- Hibernate Panache

## For RUN
- docker-compose -f resources/compose.yaml up -d
- mvn compile quarkus:dev -Ddebug=5001

## Propose Solution
There 2 main packages
### commons
Resources used in whole project
### modules
guest, bedroom, booking, integration


## Related Guides

- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A JAX-RS implementation utilizing build time
  processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions
  that depend on it.
