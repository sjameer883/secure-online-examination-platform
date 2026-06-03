# System Architecture

## 1. System Overview

The Secure Online Examination Platform (SOEP) follows a three-tier architecture consisting of:

1. Presentation Layer (React Frontend)
2. Business Layer (Spring Boot Backend)
3. Data Layer (PostgreSQL Database)

This architecture promotes scalability, maintainability, security, and separation of concerns. Each layer is independently maintainable and communicates through secure REST APIs.

---

# 2. High-Level Architecture

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

## Frontend Layer (React + TypeScript)

The frontend is responsible for delivering a responsive and user-friendly interface.

### Responsibilities

* Authentication Screens
* Dashboard Views
* Exam Management
* Candidate Management
* Result Visualization
* API Communication
* Form Validation

### Candidate Dashboard

Allows candidates to:

* Login
* View Assigned Exams
* Start Examinations
* Save Progress
* Review Answers
* Submit Exams
* View Results

### Recruiter Dashboard

Allows recruiters to:

* Create Exams
* Manage Question Banks
* Assign Exams
* View Candidate Results
* Track Exam Performance

### Admin Dashboard

Allows administrators to:

* Manage Recruiters
* Manage Candidates
* Manage Roles
* Monitor Platform Activity
* View Audit Logs

---

## Backend Layer (Spring Boot)

The backend contains all business logic and security mechanisms.

### Responsibilities

* Authentication & Authorization
* Exam Management
* Candidate Management
* Recruiter Management
* Result Processing
* Audit Logging
* REST API Services

### Major Modules

* Authentication Module
* User Management Module
* Exam Management Module
* Question Bank Module
* Assignment Module
* Result Module
* Audit Module

---

## Database Layer (PostgreSQL)

The database provides persistent storage for application data.

### Responsibilities

* User Storage
* Role Storage
* Examination Data
* Candidate Responses
* Result Storage
* Audit Log Storage

---

# 3. Backend Architecture

## Backend Layers

### Controller Layer

Handles HTTP requests and responses.

Responsibilities:

* Accept Client Requests
* Validate Input
* Return Responses
* Invoke Service Layer

Examples:

* AuthController
* UserController
* ExamController
* ResultController

---

### Service Layer

Contains business logic and application rules.

Responsibilities:

* Authentication Logic
* Exam Assignment Logic
* Result Calculation
* Candidate Evaluation
* Authorization Checks

Examples:

* AuthService
* UserService
* ExamService
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

Stores application data inside PostgreSQL.

Responsibilities:

* Data Persistence
* Relationship Management
* Transaction Management
* Query Optimization

---

# 4. Package Structure

```text
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
├── validation
├── audit
│
└── SOEPApplication.java
```

### controller

Contains REST API endpoints.

Examples:

* AuthController
* UserController
* ExamController

---

### service

Contains business logic and workflow processing.

Examples:

* AuthService
* UserService
* ExamService
* ResultService

---

### repository

Contains Spring Data JPA repositories.

Examples:

* UserRepository
* ExamRepository
* ResultRepository

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

Contains Data Transfer Objects used between frontend and backend.

Examples:

* LoginRequest
* LoginResponse
* CreateExamRequest
* ExamResponse

---

### mapper

Responsible for converting Entities and DTOs.

Benefits:

* Cleaner Service Layer
* Reduced Boilerplate
* Future MapStruct Integration

Examples:

* UserMapper
* ExamMapper
* ResultMapper

---

### security

Contains authentication and authorization components.

Examples:

* SecurityConfig
* JwtService
* JwtAuthenticationFilter
* CustomUserDetailsService

Responsibilities:

* Token Generation
* Token Validation
* User Authentication
* Access Control

---

### config

Contains application configurations.

Examples:

* CorsConfig
* OpenApiConfig
* ApplicationConfig

---

### exception

Contains custom exceptions and global handlers.

Examples:

* ResourceNotFoundException
* UnauthorizedException
* ValidationException
* GlobalExceptionHandler

---

### util

Contains reusable helper classes.

Examples:

* DateUtil
* Constants
* CommonUtils

---

### validation

Contains custom validation logic.

Examples:

* PasswordValidator
* ExamValidator
* UserValidator

Responsibilities:

* Request Validation
* Business Rule Validation
* Custom Validation Annotations

---

### audit

Contains audit logging functionality.

Examples:

* AuditService
* AuditEvent
* AuditRepository

Responsibilities:

* Login Tracking
* Security Event Logging
* Administrative Action Tracking
* Examination Activity Logging

---

# 5. Authentication Flow

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

## Authentication Process

### Step 1: User Login

The user submits email and password credentials.

### Step 2: Spring Security Processing

Spring Security intercepts the request and validates credentials.

### Step 3: User Authentication

Credentials are verified against stored user records.

### Step 4: JWT Generation

The system generates:

* Access Token
* Refresh Token

### Step 5: Token Response

Tokens are returned to the frontend.

### Step 6: Authenticated Requests

The frontend includes the JWT access token in API requests.

### Step 7: JWT Validation

The JWT filter validates:

* Signature
* Expiration
* User Information

### Step 8: Access Granted

Role-based permissions determine access to resources.

---

# 6. Deployment Architecture

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

## Frontend Deployment

### Vercel

Benefits:

* Fast Deployment
* Global CDN
* Automatic Builds
* SSL Support

---

## Backend Deployment

### Render

Benefits:

* Easy Spring Boot Deployment
* HTTPS Support
* Continuous Deployment
* Environment Variable Management

---

## Database Deployment

### Neon PostgreSQL

Benefits:

* Managed PostgreSQL
* Automatic Backups
* Scalability
* High Availability

---

# 7. Security Architecture

## BCrypt Password Encryption

Passwords are encrypted using BCrypt before storage. Plain-text passwords are never stored in the database.

---

## JWT Authentication

JWT tokens provide stateless authentication between frontend and backend systems.

---

## Role-Based Access Control (RBAC)

Supported Roles:

* ADMIN
* RECRUITER
* CANDIDATE

Each role has access only to authorized resources.

---

## Refresh Tokens

Refresh tokens enable secure generation of new access tokens without requiring repeated logins.

---

## Audit Logging

The platform records critical system events.

Examples:

* Login Attempts
* User Registration
* User Updates
* Exam Creation
* Exam Assignment
* Exam Submission
* Result Generation

---

# Architecture Decisions

## Why Three-Tier Architecture?

* Clear Separation of Concerns
* Easier Maintenance
* Better Scalability
* Independent Development

## Why React + TypeScript?

* Component-Based Design
* Strong Typing
* Better Maintainability
* Modern Frontend Ecosystem

## Why Spring Boot?

* Enterprise-Level Framework
* Strong Security Support
* Rapid Development
* Large Community Support

## Why PostgreSQL?

* ACID Compliance
* High Reliability
* Advanced Query Support
* Excellent Performance

## Why JWT?

* Stateless Authentication
* Scalable Architecture
* Secure API Communication

---

# Deliverable

```bash
git commit -m "Add system architecture documentation"
```
