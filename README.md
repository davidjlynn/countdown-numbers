# countdown-numbers
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=davidjlynn_countdown-numbers&metric=bugs)](https://sonarcloud.io/summary/new_code?id=davidjlynn_countdown-numbers)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=davidjlynn_countdown-numbers&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=davidjlynn_countdown-numbers)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=davidjlynn_countdown-numbers&metric=coverage)](https://sonarcloud.io/summary/new_code?id=davidjlynn_countdown-numbers)


A simple application to solve the countdown numbers challenge.

## Building

```bash
./gradlew clean build
```

## Running

```bash
java -jar build/libs/coundown-numbers-0.0.1-SNAPSHOT.jar calculate-first-numbers --target 469 --numbers 100 5 6 75 9 10
```