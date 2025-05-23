# Countdown Numbers Solver
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=davidjlynn_countdown-numbers&metric=bugs)](https://sonarcloud.io/summary/new_code?id=davidjlynn_countdown-numbers)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=davidjlynn_countdown-numbers&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=davidjlynn_countdown-numbers)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=davidjlynn_countdown-numbers&metric=coverage)](https://sonarcloud.io/summary/new_code?id=davidjlynn_countdown-numbers)

A simple tool to solve the countdown numbers round.

This tool brute forces calculations with the provided numbers, to try and find a provided target.

## Functionality

- Brute force every calculation combination that equals the target.
- Brute force the first calculation combination that equals the target.

### Issues

Due to the high number of calculations that get generated for 6 numbers (as in countdown) solving for all calculations tends to result in an Out of Memory exception.

This can also occur when solving for the first entry only, however there being no result or the result is so far through the list that we run out of memory.

The is seen as a limitation for now, and may be addressed later.

## Using

This tool is provided as a Spring Shell application, packaged as a Jar, you can run it by command line assuming Java is installed.
Examples of running is provided below.

### Help

You can find documentation on the functions by running:
```bash
java -jar build/libs/coundown-numbers-<VERSION>.jar help
```
Resulting in, for example:
```
AVAILABLE COMMANDS

Built-In Commands
       help: Display help about available commands
       history: Display or save the history of previously run commands
       version: Show version info
       script: Read and execute commands from a file.

Default
       calculate-first-numbers:
       calculate-numbers:
```

### Find first calculation

You can find the first successful calculation using this function.
This will attempt to find the calculation with the least numbers used.

```bash
java -jar build/libs/coundown-numbers-<VERSION>.jar calculate-first-numbers --target 469 --numbers 100 5 6 75 9 10
```
Resulting in, for example:
```
A matching result was found

( ( 100 + ( 5 x 75 ) ) - 6 )
```

## Building

### Prerequisites

Java 21 is required.

### Build

Building is as simple as running:
```bash
./gradlew clean build
```
The library will then be available in `build/libs/countdown-numbers-<VERSION>.jar`.