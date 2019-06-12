# Spring for Full-Stack Web Apps

## Description
- Setting up a basic webapp utilizing Spring

## API
- @GetMapping("/hello")
    - will display a message
- @GetMapping("/capitalize/{phrase}")
    - will capitalize anything 
- @GetMapping("/reverse")
    - will reverse the word order of a phrase

## Directions
- IntelliJ
    - open SongrApplication.java
    - run SongrApplication.java 
- Terminal
    - ```./gradlew test```
    - build and run ```./gradlew bootRun```

## Routes
- ```localhost:8080/hello```
- ```localhost:8080/capitalize/<any phrase you want to capitalize>```
- ```localhost:8080/reverse?sentence=<whatever phrase you would like to reverse>```
