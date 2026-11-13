# JPMC Midas — Advanced Software Engineering Virtual Experience

This repository contains a Java/Spring-based Midas exercise associated with the **JPMorgan Chase & Co. Advanced Software Engineering Virtual Experience on Forage**. It is a learning and simulation repository, not JPMorgan Chase production software or employment experience.

## Project context

The exercise is organized around a transaction-processing application. The source tree includes Spring Boot application code, persistence-oriented components, transaction and balance domain objects, and task-specific tests that guide the learner through the supplied workflow.

## Repository layout

```text
.
├── pom.xml
├── mvnw / mvnw.cmd
├── application.yml
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

The current checked-in `pom.xml` has an empty dependencies section even though the source and tests import Spring Boot, Kafka, logging, and test APIs. As a result, a clean build may fail until the required dependencies and plugin configuration are restored. This README intentionally does not claim that the repository currently passes a clean Maven build.

Before presenting this as a completed engineering project, verify the dependency set, run the bounded tests separately from the interactive debugger tasks, document the exact JDK/Maven versions, and record a reproducible successful build.

## Attribution

JPMorgan Chase & Co. and Forage are referenced solely to identify the educational virtual-experience context. This repository is an independent learner workspace and is not an official JPMC repository.
