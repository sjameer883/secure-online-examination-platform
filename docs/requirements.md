# Software Requirements Specification (SRS)

# Secure Online Examination Platform (SOEP)

Version: 1.0
Prepared By: Shaik Zameer

---

# 1. Introduction

## 1.1 Purpose

The Secure Online Examination Platform (SOEP) is a web-based application that enables organizations to create, manage, and conduct secure online examinations. Recruiters can assign examinations to candidates, monitor assessments, evaluate results, and streamline the candidate screening process. Candidates can participate in assigned examinations through a secure and controlled environment.

---

## 1.2 Scope

The platform provides:

* User Registration and Authentication
* Role-Based Access Control
* Recruiter Management
* Candidate Management
* Question Bank Management
* Examination Creation and Scheduling
* Candidate Exam Assignment
* Online Examination Interface
* Automated Evaluation
* Result Generation
* Audit Logging
* Secure Assessment Environment

---

## 1.3 Intended Users

### Organizations

* IT Companies
* Product-Based Companies
* Startups
* Consulting Firms
* Recruitment Agencies

### Platform Users

#### Admin

Responsible for platform administration and user management.

#### Recruiter

Responsible for creating examinations, managing candidates, and evaluating results.

#### Candidate

Responsible for attending assigned examinations and viewing results.

---

# 2. Overall Description

## 2.1 Product Perspective

SOEP is a cloud-ready web application that allows organizations to conduct secure online examinations for candidate assessment and recruitment processes.

---

## 2.2 User Roles

### Admin

* Manage Recruiters
* Manage Candidates
* Manage System Configuration
* Monitor Platform Activities
* View Audit Logs

### Recruiter

* Create Examinations
* Manage Question Banks
* Assign Exams to Candidates
* Monitor Examination Progress
* Evaluate Results

### Candidate

* Login
* View Assigned Exams
* Attend Examinations
* Review Submission Status
* View Results

---

# 3. Functional Requirements

## FR-1 Authentication & Authorization

### Features

* User Registration
* Login
* Logout
* Password Reset
* JWT Authentication
* Refresh Token Support
* Role-Based Access Control

---

## FR-2 User Management

### Admin Features

* Manage Recruiters
* Manage Candidates
* Activate Accounts
* Deactivate Accounts
* Reset User Credentials

---

## FR-3 Question Bank Management

### Recruiter Features

* Create Questions
* Edit Questions
* Delete Questions
* Categorize Questions
* Import Questions

### Supported Question Types

#### Single Correct Answer

Candidate selects one correct option.

#### Multiple Correct Answers

Candidate selects multiple correct options.

---

## FR-4 Examination Management

### Recruiter Features

* Create Examination
* Edit Examination
* Delete Examination
* Configure Duration
* Configure Passing Marks
* Schedule Examination
* Assign Examination to Candidate
* Publish Examination

---

## FR-5 Examination Module

### Candidate Features

* Start Examination
* Save Progress
* Navigate Between Questions
* Review Questions
* Submit Examination

### System Features

* Auto Save Responses
* Countdown Timer
* Auto Submit on Timeout
* Response Tracking

---

## FR-6 Evaluation Module

### System Features

* Automatic Evaluation
* Score Calculation
* Percentage Calculation
* Pass/Fail Determination
* Result Generation

---

## FR-7 Results Module

### Candidate Features

* View Results
* View Examination History

### Recruiter Features

* View Candidate Results
* Export Results
* Candidate Performance Analysis

---

## FR-8 Audit Logging

### System Features

* User Login Tracking
* User Activity Tracking
* Examination Activity Tracking
* Security Event Logging
* Administrative Action Logging

---

# 4. Non-Functional Requirements

## Performance

* Support 1,000+ Concurrent Users
* Response Time Less Than 3 Seconds
* Auto Save Response Time Less Than 1 Second

---

## Security

* BCrypt Password Encryption
* JWT Authentication
* Refresh Token Support
* HTTPS Communication
* Role-Based Access Control
* Audit Logging
* Secure Session Management

---

## Reliability

* 99.9% Availability
* Automated Backup Mechanism

---

## Scalability

* Cloud Deployment Ready
* Horizontal Scaling Support

---

## Usability

* Responsive User Interface
* Mobile-Friendly Design
* Cross-Browser Compatibility

---

# 5. Database Requirements

## roles

* role_id
* role_name

### Sample Values

* ADMIN
* RECRUITER
* CANDIDATE

---

## users

* user_id
* first_name
* last_name
* email
* password_hash
* role_id
* is_active
* created_at
* updated_at

---

## exams

* exam_id
* title
* description
* duration_minutes
* passing_score
* start_time
* end_time
* created_by
* created_at

---

## questions

* question_id
* exam_id
* question_text
* question_type
* marks
* created_at

---

## options

* option_id
* question_id
* option_text
* is_correct

---

## exam_assignments

* assignment_id
* exam_id
* candidate_id
* assigned_at
* status

---

## candidate_answers

* answer_id
* assignment_id
* question_id
* selected_option_id
* answered_at

---

## results

* result_id
* assignment_id
* score
* percentage
* status
* submitted_at

---

## audit_logs

* log_id
* user_id
* action
* entity_type
* entity_id
* ip_address
* timestamp

---

# 6. Technology Stack

## Frontend

* React.js
* TypeScript
* Tailwind CSS

## Backend

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* Hibernate

## Database

* PostgreSQL

## Build Tool

* Maven

## Authentication

* JWT
* Refresh Tokens

## Version Control

* Git
* GitHub

---

# 7. Future Enhancements

* Coding Assessments
* Online Code Execution Sandbox
* AI-Based Proctoring
* Webcam Monitoring
* Face Verification
* Interview Scheduling
* Live Interview Platform
* Multi-Tenant Organizations
* Advanced Analytics Dashboard

---

# 8. Success Criteria

* Recruiters can create and assign examinations efficiently.
* Candidates can complete examinations securely.
* Results are generated automatically and accurately.
* User activities are fully auditable.
* The platform remains secure, scalable, and reliable under load.
