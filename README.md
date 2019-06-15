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
-  @GetMapping("/albums")
    - shows all the albums added so far
-  @GetMapping("/albums/new")
    - add a new album to the site
- @Getmapping("songs")
    - shows all of the songs
- @Getmapping("songs/new")
    - can add a song to the songs page
- @Getmapping("details")
    - view the songs that are in an album

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
- ```localhost:8080/albums```
- ```localhost:8080/albums/new```
- ```localhost:8080/songs```
- ```localhost:8080/songs/new```
- ```localhost:8080/details```

## Acknowledgments
- I relied heavily on the class repo for the albums portion (https://github.com/codefellows/seattle-java-401d4/tree/master/class-13/demo)