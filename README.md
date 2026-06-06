# secure-online-examination-platform
Production-ready Online Examination Platform built with Java 21, Spring Boot, Spring Security, JWT, PostgreSQL, React, and Docker. Supports secure online assessments, role-based access control, exam management, candidate evaluation, and result generation.
# Secure Online Examination Platform (SOEP)

## Project Overview

The Secure Online Examination Platform (SOEP) is a web-based system designed to conduct secure online examinations with role-based access control, candidate management, exam scheduling, question management, and result processing.

## Technology Stack

### Backend
- Java 17
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- PostgreSQL 17
- Maven

### Tools
- VS Code
- Git & GitHub
- pgAdmin 4

## Project Structure

secure-online-examination-platform
│
├── backend
├── frontend
└── docs

## Backend Package Structure

com.examportal
│
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── security
├── config
├── exception
├── util
└── validation

## Database

Database Name:

soep_db

Current Tables:

- roles
- users

## Implemented Features

### Sprint 2 - Day 1
- Spring Boot project setup
- Maven configuration
- Package structure creation
- Application startup verification

### Sprint 2 - Day 2
- PostgreSQL integration
- Database configuration
- RoleType enum creation
- Role entity creation
- User entity creation
- Repository layer implementation
- Hibernate automatic table generation

## Entities

### Role
- id
- roleName

### User
- id
- firstName
- lastName
- email
- passwordHash
- isActive
- createdAt
- updatedAt
- role

## Future Development

- DTO Layer
- Service Layer
- Authentication APIs
- JWT Security
- User Registration
- Login APIs
- Exam Management
- Question Management
- Result Processing
- Frontend Development

## Current Status

✅ Sprint 2 Day 1 Completed

✅ Sprint 2 Day 2 Completed

🚧 Sprint 2 Day 3 In Progress
