# Elevate Ed

## Overview 
An education platform that helps learners connect with registered mentors on the app, based on their learner's interests and Mentor's skills.

## Features
- Add new learners (with unique user Id)
- Add new mentors (with unique userId)
- Validate learner using userId and password
- Validate mentor using userId and password
- Retrieve learner details based on userId
- Retrieve mentor details based on userId
- Retrieve mentor recommendations based on a particular skill
- Send message from a learner/mentor to a learner/mentor
- Retrieve all messages sent to a particular userId (can be learner/mentor)

# Technical Details

## About the app
A simple backend application built with Java - SpringBoot. 

Dependencies used: 
- Spring JPA - For DB connectivity and Hibernate ORM
- Jasypt - For Password encryption/validation in DB
- Lombok - To reduce boilerplate and auto-generate Getters, Setters
- H2 Driver - To use the in-house H2 Database
- Starter Web - For Rest API creation

## Running the server
1. Clone the repo
2. Run the maven command - mvn clean install
3. Start the server and the app should run. 
4. Use the Postman collection provided in this repo to start making calls and test out the app. - Elevate-Ed-App.postman_collection.json

