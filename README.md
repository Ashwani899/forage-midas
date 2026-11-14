# JPMC Midas — Advanced Software Engineering Virtual Experience

This repository contains a Java/Spring-based Midas exercise associated with the **JPMorgan Chase & Co. Advanced Software Engineering Virtual Experience on Forage**. It is a learning and simulation repository, not JPMorgan Chase production software or employment experience.

## Project context

The exercise is organized around a transaction-processing application. The source tree includes Spring Boot application code, persistence-oriented components, transaction and balance domain objects, and task-specific tests that guide the learner through the supplied workflow.

## Repository layout

```text
.
├── pom.xml
├── mvnw / mvnw.cmd
├── src/main/resources/application.yml
├── services/
└── src/
    ├── main/java/com/jpmc/midascore/
    │   ├── component/
    │   ├── entity/
    │   ├── foundation/
    │   └── repository/
    └── test/java/com/jpmc/midascore/
        ├── TaskOneTests.java
        ├── TaskTwoTests.java
        ├── TaskThreeTests.java
        ├── TaskFourTests.java
        ├── TaskFiveTests.java
        └── helper classes
```

## Learning workflow represented by the task tests

| Test | Exercise focus |
|---|---|
| `TaskOneTests` | Verify that the Spring application context starts |
| `TaskTwoTests` | Inspect the incoming transaction flow while debugging |
| `TaskThreeTests` | Trace transaction processing and inspect a user's resulting balance |
| `TaskFourTests` | Continue transaction-flow debugging and inspect another balance |
| `TaskFiveTests` | Query and print balances for a range of user identifiers |

Some supplied task tests are deliberately interactive: they publish test transactions and then wait in a loop so the learner can inspect application state with a debugger. They are not designed to be treated as ordinary, unattended, quick-running unit tests. Follow the task instructions and stop those tests deliberately after collecting the required observation.

## Tooling

- Java 17 is configured in the Maven project descriptor.
- Maven Wrapper scripts are included for repeatable Maven invocation.
- Spring Boot is the application framework in the starter project.
- The task tests use an embedded Kafka broker for transaction-stream exercises.

## Build status and reproducibility

The Maven project now declares the Spring Boot JPA and Web starters, Spring Kafka, H2 for the local database, and the Spring Boot / Kafka test dependencies. The checked-in Maven Wrapper uses Java 17.

Run a bounded build and test the application context:

```bash
./mvnw -B -DskipTests test-compile
./mvnw -B -Dtest=TaskOneTests test
```

The GitHub Actions workflow runs those same checks on pushes and pull requests to the `flow` branch. It deliberately does **not** run TaskTwo through TaskFive: those supplied exercises send transactions and wait in debugger loops by design. Run them manually according to the Forage task instructions and stop them after collecting the required observations.

The CI check verifies compilation and application-context startup. It does not establish that the incomplete transaction-processing exercise is feature-complete or that the external transaction incentive service is available.

## Attribution

JPMorgan Chase & Co. and Forage are referenced solely to identify the educational virtual-experience context. This repository is an independent learner workspace and is not an official JPMC repository.
