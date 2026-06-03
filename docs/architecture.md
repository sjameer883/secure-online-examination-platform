# System Architecture

## 1. System Overview

The Secure Online Examination Platform (SOEP) follows a three-tier architecture consisting of:

1. Presentation Layer (React Frontend)
2. Business Layer (Spring Boot Backend)
3. Data Layer (PostgreSQL Database)

This architecture promotes scalability, maintainability, security, and clear separation of responsibilities. Each layer operates independently and communicates through well-defined interfaces, making the system easier to develop, test, and maintain.

---

## 2. High-Level Architecture

```text
+-------------------+
|   React Frontend  |
+-------------------+
          |
          | HTTPS / REST API
          v
+-------------------+
| Spring Boot API   |
| Spring Security   |
| JWT Authentication|
+-------------------+
          |
          v
+-------------------+
| PostgreSQL        |
+-------------------+
```

### Frontend Layer (React + TypeScript)

The frontend provides the user interface for all platform users.

Responsibilities:

* User Authentication
* Exam Management Screens
* Candidate Dashboard
* Recruiter Dashboard
* Admin Dashboard
* Result Visualization
* API Communication

#### Candidate Dashboard

Allows candidates to:

* View assigned exams
* Start examinations
* Save progress
* Submit exams
* View results

#### Recruiter Dashboard

Allows recruiters to:

* Create exams
* Manage questions
* Assign exams
* Monitor candidate performance
* View results

#### Admin Dashboard

Allows administrators to:

* Manage recruiters
* Manage candidates
* Monitor platform activity
* View audit logs

---

### Backend Layer (Spring Boot)

The backend contains all business logic and application rules.

Responsibilities:

* Authentication & Authorization
* Exam Processing
* Candidate Management
* Recruiter Management
* Result Generation
* Audit Logging
* REST API Exposure

---

### Database Layer (PostgreSQL)

The database stores all persistent application data.

Responsibilities:

* User Data
* Role Data
* Examination Data
* Question Data
* Candidate Responses
* Results
* Audit Logs

---

## 3. Backend Architecture

### Controller Layer

Handles HTTP requests and responses.

Responsibilities:

* Receive API requests
* Validate request payloads
* Invoke service methods
* Return API responses

Examples:

* AuthController
* ExamController
* CandidateController
* RecruiterController

---

### Service Layer

Contains business logic and validation.

Responsibilities:

* User Authentication
* Exam Assignment
* Result Calculation
* Candidate Evaluation
* Authorization Checks

Examples:

* AuthService
* ExamService
* UserService
* ResultService

---

### Repository Layer

Handles database operations using Spring Data JPA.

Responsibilities:

* CRUD Operations
* Custom Queries
* Data Retrieval

Examples:

* UserRepository
* ExamRepository
* QuestionRepository
* ResultRepository

---

### Database Layer

Stores application data in PostgreSQL.

Responsibilities:

* Data Persistence
* Relationship Management
* Transaction Support
* Query Optimization

---

## 4. Package Structure

```text
com.examportal

├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
├── util
```

### controller

Contains REST API endpoints that expose application functionality.

Examples:

* AuthController
* UserController
* ExamController

---

### service

Contains business logic and validation rules.

Examples:

* AuthService
* ExamService
* ResultService

---

### repository

Contains Spring Data JPA repositories used for database access.

Examples:

* UserRepository
* ExamRepository
* QuestionRepository

---

### entity

Contains JPA entities mapped to database tables.

Examples:

* User
* Role
* Exam
* Question
* Result

---

### dto

Contains Data Transfer Objects used for API communication.

Examples:

* LoginRequest
* LoginResponse
* CreateExamRequest

---

### security

Contains security-related components.

Examples:

* JwtService
* JwtFilter
* SecurityConfig
* CustomUserDetailsService

---

### config

Contains application configuration classes.

Examples:

* OpenApiConfig
* CorsConfig
* AppConfig

---

### exception

Contains custom exception classes and global exception handlers.

Examples:

* ResourceNotFoundException
* UnauthorizedException
* GlobalExceptionHandler

---

### util

Contains reusable helper classes and utility methods.

Examples:

* DateUtil
* ValidationUtil
* Constants

---

## 5. Authentication Flow

```text
User Login
    |
    v
Spring Security
    |
    v
Authenticate User
    |
    v
Generate JWT Token
    |
    v
Return Token to Client
    |
    v
Client Sends JWT in API Requests
    |
    v
JWT Filter Validates Token
    |
    v
Access Granted
```

### Step 1: User Login

The user submits email and password.

### Step 2: Spring Security Processing

Spring Security intercepts the request and validates credentials.

### Step 3: User Authentication

The system verifies user identity using stored credentials.

### Step 4: JWT Generation

A signed JWT Access Token and Refresh Token are generated.

### Step 5: Token Response

Tokens are returned to the frontend.

### Step 6: Authenticated Requests

The frontend includes the JWT token in the Authorization header.

### Step 7: JWT Validation

The JWT filter validates token authenticity and expiration.

### Step 8: Access Granted

Authorized users gain access to protected resources based on assigned roles.

---

## 6. Deployment Architecture

```text
React Frontend
      |
      v
Vercel

Spring Boot Backend
      |
      v
Render

PostgreSQL Database
      |
      v
Neon PostgreSQL
```

### Frontend Hosting

Vercel is used for:

* Fast deployments
* Global CDN
* Automatic builds

### Backend Hosting

Render is used for:

* Spring Boot deployment
* HTTPS support
* Continuous deployment

### Database Hosting

Neon PostgreSQL is used for:

* Managed PostgreSQL
* Automatic backups
* Scalability
* Cloud-native architecture

---

## 7. Security Architecture

### BCrypt Password Encryption

Passwords are never stored in plain text. BCrypt hashing is used before storing passwords in the database.

### JWT Authentication

JWT tokens provide stateless authentication between frontend and backend systems.

### Role-Based Access Control (RBAC)

Access permissions are enforced using roles:

* ADMIN
* RECRUITER
* CANDIDATE

Each role can access only authorized resources.

### Refresh Tokens

Refresh tokens allow secure token renewal without requiring users to log in repeatedly.

### Audit Logging

Critical actions are recorded for monitoring and security purposes.

Examples:

* Login Attempts
* User Creation
* Exam Creation
* Exam Assignment
* Result Publication

---

## Architecture Decisions

### Why Three-Tier Architecture?

* Clear separation of concerns
* Easier maintenance
* Better scalability
* Independent deployment capabilities

### Why React?

* Component-based architecture
* Fast UI rendering
* Strong TypeScript support

### Why Spring Boot?

* Enterprise-grade framework
* Robust security support
* Excellent integration with PostgreSQL

### Why PostgreSQL?

* ACID compliance
* Reliability
* Excellent performance
* Advanced querying capabilities

### Why JWT Authentication?

* Stateless architecture
* Better scalability
* Secure API communication

---

## Deliverable

```bash
git commit -m "Add system architecture documentation"
```
