![springboot](https://user-images.githubusercontent.com/20155657/131171981-51609bcc-13a5-4108-a658-4687f8ddbdbe.png)
![java](https://user-images.githubusercontent.com/20155657/131172025-09154fcf-3160-4fb2-bb40-2fd2764ae43c.png)
![Kotlin](https://user-images.githubusercontent.com/20155657/131172745-686cd077-0a2d-4535-8e2f-8fa421008d4c.png)


## Starting new service on SpringBoot

## What is Spring Framework?

Java Spring Framework (Spring Framework) is a popular, open source, enterprise-level framework for creating standalone, production-grade applications that run on the Java Virtual Machine (JVM).

Java Spring Boot (Spring Boot) is a tool that makes developing web application and microservices with Spring Framework faster and easier through three core capabilities:
1. Autoconfiguration
2. An opinionated approach to configuration
3. The ability to create standalone applications

## Why Spring Framework?

Spring Framework offers a dependency injection feature that lets objects define their own dependencies that the Spring container later injects into them.This enables developers to create modular applications consisting of loosely coupled components that are ideal for microservices and distributed network applications.

## Why SpringBoot?

As capable and comprehensive as Spring Framework is, it still requires significant time and knowledge to configure, set up, and deploy Spring applications. Spring Boot mitigates this effort with three important capabilities.

## Creating new service

For creating spring boot service use spring initializr: [link](https://start.spring.io)
From spring initializr choose the latest stable version of Spring Boot, add details about the service/project select packaging as jar, and java 17(since java 17 is LTS).

If you wish to use Kotlin the choose language and Kotlin.
Also there is choice to choose between maven or gradle build system.(I prefer gradle.)